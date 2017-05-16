package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.holder.ThumbnailViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.Shop;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class ShopsAdapter extends ThumbnailsAdapter implements Filterable {

    public ShopsAdapter(List<LogicalElement> shopList) {
        super(shopList);
    }

    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Shop logicalElement = (Shop) originalData.get(position);
        holder.getCategory().setBackgroundColor(logicalElement.getCategory().getColor());
    }

    @Override
    public Filter getFilter() {
       return new Filter() {
           @Override
           protected FilterResults performFiltering(CharSequence constraint) {
               FilterResults results = new FilterResults();

               if (constraint == null || constraint.length() == 0 || selectedCategories == null || selectedCategories.isEmpty()) { //nothing to filter on
                    results.values = originalData;
                    results.count = originalData.size();
               } else {
                    ArrayList<LogicalElement> filterResultsData = new ArrayList<>();

                    for(LogicalElement data : originalData) {
                        //In this loop, you'll filter through originalData and compare each item to charSequence.
                        //If you find a match, add it to your new ArrayList
                        //I'm not sure how you're going to do comparison, so you'll need to fill out this conditional
                        if(selectedCategories.contains(((ShopCategory)data.getCategory()).name())) {
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
}
