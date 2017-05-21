package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.HashSet;
import java.util.Set;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.CategoriesAdapter;
import fr.unice.polytech.si3.ihm.capsophia.model.event.EventCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class SearchFragment extends DialogFragment {
    private Set<String> selected;
    private SharedPreferences sharedPreferences;

    public static int SHOPS = 0;
    public static int EVENTS = 1;

    public SearchFragment() {
        selected = new HashSet<>();
    }

    static SearchFragment newInstance(int type) {
        SearchFragment f = new SearchFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("type", type);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int theme = 0;

        setStyle(DialogFragment.STYLE_NORMAL, theme);
        sharedPreferences = getContext().getSharedPreferences("Categories", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container);

        SearchView searchView = (SearchView)v.findViewById(R.id.search);
        Button searchButton = (Button)v.findViewById(R.id.searchButton);

        searchView.setIconified(false);

        searchButton.setText(getString(R.string.research));
        searchButton.setOnClickListener(this::onClickButton);

        ListView listView = (ListView) v.findViewById(R.id.boxes);
        if (this.getArguments().getInt("type") == SHOPS) {
            selected = sharedPreferences.getStringSet("shop_categories", new HashSet<>());
            listView.setAdapter(new CategoriesAdapter(getContext(), ShopCategory.values(), selected));
            searchView.setQuery(sharedPreferences.getString("shop_query", ""), false);
        } else {
            selected = sharedPreferences.getStringSet("event_categories", new HashSet<>());
            listView.setAdapter(new CategoriesAdapter(getContext(), EventCategory.values(), selected));
            searchView.setQuery(sharedPreferences.getString("event_query", ""), false);
        }

        return v;
    }

    public void onClickButton(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        FragmentManager fragmentManager = getFragmentManager();
        if (this.getArguments().getInt("type") == SHOPS) {
            editor.putString("shop_query", ((SearchView)getView().findViewById(R.id.search)).getQuery().toString());
            editor.putStringSet("shop_categories", selected);
            editor.apply();
            fragmentManager.findFragmentByTag("shop").onResume();
        } else {
            editor.putString("event_query", ((SearchView)getView().findViewById(R.id.search)).getQuery().toString());
            editor.putStringSet("event_categories", selected);
            editor.apply();
            fragmentManager.findFragmentByTag("event").onResume();
        }
        getFragmentManager().popBackStack();
    }
}
