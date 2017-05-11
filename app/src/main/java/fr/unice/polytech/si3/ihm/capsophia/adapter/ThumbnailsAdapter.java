package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.holder.ThumbnailViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;

public abstract class ThumbnailsAdapter extends RecyclerView.Adapter<ThumbnailViewHolder> {
    List<LogicalElement> logicalElements;

    public ThumbnailsAdapter(List<LogicalElement> list) {
        this.logicalElements = list;
    }

    @Override
    public ThumbnailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ThumbnailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        LogicalElement logicalElement = logicalElements.get(position);

        holder.getName().setText(logicalElement.getName());
        holder.getCategory().setText(logicalElement.getCategory().getNameId());

        logicalElement.getMedia().downloadThumbnailIn(holder.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return logicalElements.size();
    }
}
