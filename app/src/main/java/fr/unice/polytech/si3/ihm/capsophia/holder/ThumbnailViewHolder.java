package fr.unice.polytech.si3.ihm.capsophia.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.unice.polytech.si3.ihm.capsophia.R;

public class ThumbnailViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView category;
    private ImageView thumbnail;

    public ThumbnailViewHolder(View itemView) {
        super(itemView);
        this.name = (TextView)itemView.findViewById(R.id.name);
        this.category = (TextView)itemView.findViewById(R.id.shortDescription);
        this.thumbnail = (ImageView)itemView.findViewById(R.id.thumbnailImage);
    }

    public TextView getName() {
        return name;
    }

    public TextView getCategory() {
        return category;
    }

    public ImageView getThumbnail() {
        return thumbnail;
    }
}
