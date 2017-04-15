package fr.unice.polytech.si3.ihm.capsophia.model.media;

import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

import fr.unice.polytech.si3.ihm.capsophia.async.DownloadImage;

public abstract class Media {
    URL url;

    public Media(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public abstract void downloadThumbnailIn(ImageView imageView);
}
