package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.holder.ThumbnailViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;

public class ThumbnailsAdapter extends RecyclerView.Adapter<ThumbnailViewHolder> implements Filterable {
    private List<LogicalElement> originalData;
    private List<LogicalElement> filteredData;
    private Set<String> selectedCategories;

    public ThumbnailsAdapter(List<LogicalElement> list) {
        this.originalData = list;
        this.filteredData = this.originalData;
        this.selectedCategories = new HashSet<>();
    }

    @Override
    public ThumbnailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_thumbnail, parent, false);
        return new ThumbnailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        LogicalElement logicalElement = filteredData.get(position);

        holder.getThumbnail().setImageResource(R.mipmap.placeholder);
        holder.getName().setText(logicalElement.getName());
        holder.getCategory().setText(logicalElement.getCategory().getNameId());
        holder.getCategory().setBackgroundColor(logicalElement.getCategory().getColor());

        logicalElement.getMedia().downloadThumbnailIn(holder.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return filteredData.size();
    }

    @Override
    public Filter getFilter() {
       return new Filter() {
           @Override
           protected FilterResults performFiltering(CharSequence constraint) {
               FilterResults results = new FilterResults();

               if ((constraint == null || constraint.length() == 0 ) && (selectedCategories == null || selectedCategories.isEmpty())) { //nothing to filter on
                    results.values = originalData;
                    results.count = originalData.size();
               } else {
                   ArrayList<LogicalElement> filterResultsData = new ArrayList<>();

                   Predicate<LogicalElement> predicate = null;

                   if (constraint == null || constraint.length() == 0) { // No search query
                       predicate = logicalElement -> selectedCategories.contains(logicalElement.getCategory().name());
                   } else if (selectedCategories == null || selectedCategories.isEmpty()) { // No category selected
                       predicate = logicalElement -> logicalElement.getName().toLowerCase().contains(constraint.toString().toLowerCase());
                   } else { // Everything
                       predicate = logicalElement -> selectedCategories.contains(logicalElement.getCategory().name())
                               && logicalElement.getName().toLowerCase().contains(constraint.toString().toLowerCase());
                   }

                   for (LogicalElement data : originalData) { // filter on original data
                       if (predicate.test(data)) {
                           filterResultsData.add(data);
                       }
                   }

                   results.values = filterResultsData;
                   results.count = filterResultsData.size();
               }

               return results;
           }

           @Override
           protected void publishResults(CharSequence constraint, FilterResults results) {
               filteredData = (ArrayList<LogicalElement>)results.values;
               notifyDataSetChanged();
           }
       };
    }

    public void setSelectedCategories(Set<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public Set<String> getSelectedCategories() {
        return this.selectedCategories;
    }
}
