package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.holder.ShopsViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.Shop;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsViewHolder> {
    private List<Shop> shops;

    public ShopsAdapter(List<Shop> shopList) {
        this.shops = shopList;
    }

    @Override
    public ShopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ShopsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopsViewHolder holder, int position) {
        Shop shop = shops.get(position);

        holder.getName().setText(shop.getName());
        holder.getName().setBackgroundColor(shop.getShopCategory().getColor());
        holder.getShortDescription().setText(shop.getShortDescription());
        holder.getShortDescription().setBackgroundColor(shop.getShopCategory().getColor());

        shop.getMedia().downloadThumbnailIn(holder.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }
}
