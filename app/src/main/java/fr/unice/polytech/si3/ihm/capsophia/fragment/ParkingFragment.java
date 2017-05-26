package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.adapter.StringPairAdapter;
import fr.unice.polytech.si3.ihm.capsophia.database.parking.ParkingInformationDBHelper;

public class ParkingFragment extends Fragment {

    public ParkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_parking, container, false);

        List<Pair<String, String>> informationList = new ArrayList<>();

        try {
            ParkingInformationDBHelper parkingInformationDBHelper = new ParkingInformationDBHelper(getContext());
            parkingInformationDBHelper.createDataBase();
            parkingInformationDBHelper.openDataBase();
            informationList.addAll(parkingInformationDBHelper.getAllInformation());
            parkingInformationDBHelper.close();
        } catch (IOException | SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(1);
        }

        ListView information = (ListView)v.findViewById(R.id.parking_information);
        information.setAdapter(new StringPairAdapter(getContext(), 0, informationList));

        return v;
    }

}
