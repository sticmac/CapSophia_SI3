package fr.unice.polytech.si3.ihm.capsophia.adapter;

import java.util.List;

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
        holder.getCategory().setBackgroundColor(logicalElement.getCategory().getColor());
    }
}
