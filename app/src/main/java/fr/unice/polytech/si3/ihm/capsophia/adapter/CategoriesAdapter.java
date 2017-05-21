package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.Set;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class CategoriesAdapter extends ArrayAdapter<Category> {
    private Set<String> selected;
    private Category[] objects;

    public CategoriesAdapter(@NonNull Context context, @NonNull Category[] objects, Set<String> selected) {
        super(context, 0, objects);
        this.objects = objects;
        this.selected = selected;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.category_item, null);
        }

        Category category = getItem(position);

        CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.box);
        checkBox.setText(getContext().getString(category.getNameId())); // category name (in understandable language) as checkbox name
        checkBox.setBackgroundColor(category.getColor()); //category color as background color
        checkBox.setTextColor(ColorStateList.valueOf(0xFF000000));
        checkBox.setChecked(selected.contains(category.name())); // if checkbox has been cheched before, it has to be cheched again
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String name = buttonView.getText().toString();
                for (Category c : objects) {
                    if (getContext().getString(c.getNameId()).equals(name)) {
                        if (isChecked && !selected.contains(c.name()))
                            selected.add(c.name());
                        else if (!isChecked && selected.contains(c.name()))
                            selected.remove(c.name());
                    }
                }
            }
        });



        return convertView;
    }
}
