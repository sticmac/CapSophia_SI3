package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.ThumbnailsAdapter;
import fr.unice.polytech.si3.ihm.capsophia.database.EventsDBHelper;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;

public class EventsFragment extends Fragment {
    private ThumbnailsAdapter adapter;

    public EventsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_events, viewGroup, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstance) {
        super.onActivityCreated(onSavedInstance);

        List<LogicalElement> eventsList = new ArrayList<>();

        try {
            EventsDBHelper eventsDBHelper = new EventsDBHelper(getContext());
            eventsDBHelper.createDataBase();
            eventsDBHelper.openDataBase();
            eventsList.addAll(eventsDBHelper.getAllEvents());
            eventsDBHelper.close();
        } catch (IOException | SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(1);
        }

        FloatingActionButton fab = (FloatingActionButton) this.getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // open search fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment prev = fragmentManager.findFragmentByTag("search");
                if (prev != null) {
                    fragmentTransaction.remove(prev);
                }
                fragmentTransaction.addToBackStack(null);

                DialogFragment newFragment = SearchFragment.newInstance(SearchFragment.EVENTS);
                newFragment.show(fragmentTransaction, "dialog");
            }
        });

        adapter = new ThumbnailsAdapter(eventsList);

        RecyclerView recyclerView = (RecyclerView) this.getView().findViewById(R.id.events);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Categories", 0);
        Set<String> selected = sharedPreferences.getStringSet("event_categories", new HashSet<>());

        adapter.setSelectedCategories(selected);
        adapter.getFilter().filter(sharedPreferences.getString("event_query", ""));
    }
}
