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

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.Category;
import fr.unice.polytech.si3.ihm.capsophia.model.shop.ShopCategory;

public class CategoriesAdapter extends ArrayAdapter<Category> {
    public ArrayList<String> selected;

    public CategoriesAdapter(@NonNull Context context, @NonNull Category[] objects, ArrayList<String> selected) {
        super(context, 0, objects);
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
        checkBox.setText(getContext().getString(category.getNameId()));
        checkBox.setBackgroundColor(category.getColor());
        checkBox.setTextColor(ColorStateList.valueOf(0xFF000000));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String name = buttonView.getText().toString();
                for (ShopCategory c : ShopCategory.values()) {
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
