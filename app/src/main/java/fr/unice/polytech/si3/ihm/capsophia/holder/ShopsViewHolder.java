package fr.unice.polytech.si3.ihm.capsophia.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.unice.polytech.si3.ihm.capsophia.R;

public class ShopsViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView shortDescription;
    private ImageView thumbnail;

    public ShopsViewHolder(View itemView) {
        super(itemView);
        this.name = (TextView)itemView.findViewById(R.id.shopName);
        this.shortDescription = (TextView)itemView.findViewById(R.id.shopShortDescription);
        this.thumbnail = (ImageView)itemView.findViewById(R.id.shopThumbnail);
    }

    public TextView getName() {
        return name;
    }

    public TextView getShortDescription() {
        return shortDescription;
    }

    public ImageView getThumbnail() {
        return thumbnail;
    }
}
