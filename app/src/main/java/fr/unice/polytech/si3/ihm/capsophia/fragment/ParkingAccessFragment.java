package fr.unice.polytech.si3.ihm.capsophia.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.IOException;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.database.parking.ParkingAccessDBHelper;
import fr.unice.polytech.si3.ihm.capsophia.model.access.AccessDaySchedule;
import fr.unice.polytech.si3.ihm.capsophia.model.day.Day;

public class ParkingAccessFragment extends Fragment {
    private ParkingAccessDBHelper parkingAccessDBHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parkingAccessDBHelper = new ParkingAccessDBHelper(context);
        try {
            parkingAccessDBHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_parking_access, container, false);

        Spinner spinner = (Spinner)v.findViewById(R.id.days_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSchedule(v, Day.values()[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Let's do nothing, for once
            }
        });

        updateSchedule(v, Day.MONDAY);

        return v;
    }

    private void updateSchedule(View v, Day day) {
        AccessDaySchedule accessDaySchedule = parkingAccessDBHelper.getAccessDayScheduleForDay(day);
        accessDaySchedule.formatImageView((ImageView)v.findViewById(R.id.access_morning),
                (ImageView)v.findViewById(R.id.access_noon),
                (ImageView)v.findViewById(R.id.access_afternoon),
                (ImageView)v.findViewById(R.id.access_evening));
    }
}
