package fr.unice.polytech.si3.ihm.capsophia.adapter;

import java.util.List;

import fr.unice.polytech.si3.ihm.capsophia.holder.ThumbnailViewHolder;
import fr.unice.polytech.si3.ihm.capsophia.model.LogicalElement;
import fr.unice.polytech.si3.ihm.capsophia.model.event.Event;

public class EventsAdapter extends ThumbnailsAdapter {
    public EventsAdapter(List<LogicalElement> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Event logicalElement = (Event) originalData.get(position);
        holder.getCategory().setBackgroundColor(logicalElement.getCategory().getColor());
    }
}
