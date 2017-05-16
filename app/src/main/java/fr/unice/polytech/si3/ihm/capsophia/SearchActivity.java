package fr.unice.polytech.si3.ihm.capsophia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.adapter.CategoriesAdapter;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class SearchActivity extends AppCompatActivity {
    private ArrayList<String> selected;

    public SearchActivity() {
        selected = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView listView = (ListView) findViewById(R.id.boxes);
        listView.setAdapter(new CategoriesAdapter(getApplicationContext(), ShopCategory.values(), selected));
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putStringArrayListExtra("selected_categories", selected);
        startActivity(intent);
    }
}
