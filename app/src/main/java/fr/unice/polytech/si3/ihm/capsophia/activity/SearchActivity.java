package fr.unice.polytech.si3.ihm.capsophia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SearchView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.CategoriesAdapter;
import fr.unice.polytech.si3.ihm.capsophia.model.event.EventCategory;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class SearchActivity extends AppCompatActivity {
    private ArrayList<String> selected;
    private String categories;

    public SearchActivity() {
        selected = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ((SearchView)findViewById(R.id.search)).setIconified(false);

        ((Button)findViewById(R.id.searchButton)).setText(getString(R.string.research));

        categories = getIntent().getStringExtra("categories");
        ListView listView = (ListView) findViewById(R.id.boxes);
        if (categories.equals("shop")) {
            listView.setAdapter(new CategoriesAdapter(getApplicationContext(), ShopCategory.values(), selected));
        } else {
            listView.setAdapter(new CategoriesAdapter(getApplicationContext(), EventCategory.values(), selected));
        }
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putStringArrayListExtra("selected_categories", selected);
        intent.putExtra("search_query", ((SearchView)findViewById(R.id.search)).getQuery());
        intent.putExtra("categories", categories);
        startActivity(intent);
    }
}
