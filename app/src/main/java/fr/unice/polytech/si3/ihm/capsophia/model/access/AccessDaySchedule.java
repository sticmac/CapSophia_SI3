package fr.unice.polytech.si3.ihm.capsophia.model.access;

import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import fr.unice.polytech.si3.ihm.capsophia.R;
import fr.unice.polytech.si3.ihm.capsophia.model.day.Day;
import fr.unice.polytech.si3.ihm.capsophia.model.day.PeriodOfDay;

public class AccessDaySchedule {

    private Day dayOfTheWeek;
    private Map<PeriodOfDay, AccessDifficulty> access;

    public AccessDaySchedule(Day dayOfTheWeek, AccessDifficulty morning, AccessDifficulty noon, AccessDifficulty afternoon, AccessDifficulty evening) {
        this.dayOfTheWeek = dayOfTheWeek;
        access= new HashMap<>();
        access.put(PeriodOfDay.MORNING, morning);
        access.put(PeriodOfDay.NOON, noon);
        access.put(PeriodOfDay.AFTERNOON, afternoon);
        access.put(PeriodOfDay.EVENING, evening);
    }

    public void formatImageView(ImageView morningView, ImageView noonView, ImageView afternoonView, ImageView eveningView) {
        morningView.setImageResource(access.get(PeriodOfDay.MORNING).getColor());
        noonView.setImageResource(access.get(PeriodOfDay.NOON).getColor());
        afternoonView.setImageResource(access.get(PeriodOfDay.AFTERNOON).getColor());
        eveningView.setImageResource(access.get(PeriodOfDay.EVENING).getColor());
    }
}
