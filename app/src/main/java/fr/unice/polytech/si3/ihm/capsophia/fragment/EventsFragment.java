package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.EventsAdapter;
import fr.unice.polytech.si3.ihm.capsophia.database.EventsDBHelper;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;

public class EventsFragment extends Fragment {
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
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        EventsAdapter adapter = new EventsAdapter(eventsList);

        RecyclerView recyclerView = (RecyclerView) this.getView().findViewById(R.id.events);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}
