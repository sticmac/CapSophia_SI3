package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.holder.ThumbnailViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.Shop;

public class ShopsAdapter extends ThumbnailsAdapter {
    public ShopsAdapter(List<LogicalElement> shopList) {
        super(shopList);
    }

    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Shop logicalElement = (Shop)logicalElements.get(position);
        holder.getName().setBackgroundColor(logicalElement.getShopCategory().getColor());
        holder.getShortDescription().setBackgroundColor(logicalElement.getShopCategory().getColor());
    }
}
