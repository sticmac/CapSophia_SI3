package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.ShopsAdapter;
import fr.unice.polytech.si3.ihm.capsophia.model.Shop;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Image;
import fr.unice.polytech.si3.ihm.capsophia.model.media.Video;

public class ShopsFragment extends Fragment {
    public ShopsFragment(){}

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        View rootView = layoutInflater.inflate(R.layout.fragment_shops, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.shops);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstance) {
        super.onActivityCreated(onSavedInstance);

        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop("To Be or to Have", "MMiaouMiaouMiaouMiaouMiaouMiaouiaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));
        shopList.add(new Shop("To Be or to Have", "Miaou", "Nyan", new Image("https://pbs.twimg.com/profile_images/792875481662128128/KJjZCj0Q_400x400.jpg")));

        FloatingActionButton fab = (FloatingActionButton) this.getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ShopsAdapter adapter = new ShopsAdapter(shopList);

        RecyclerView recyclerView = (RecyclerView) this.getView().findViewById(R.id.shops);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
    }
}
