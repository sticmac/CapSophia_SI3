package fr.unice.polytech.si3.ihm.capsophia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;

public class StringPairAdapter extends ArrayAdapter<Pair<String, String>> {
    private List<Pair<String, String>> objects;

    public StringPairAdapter(@NonNull Context context, int resource, List<Pair<String, String>> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_pair_string_item, null);
        }

        Pair<String, String> pair = objects.get(position);

        ((TextView)convertView.findViewById(R.id.pairName)).setText(pair.first);
        ((TextView)convertView.findViewById(R.id.pairValue)).setText(pair.second);

        return convertView;

    }
}
