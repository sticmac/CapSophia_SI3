package fr.unice.polytech.si3.ihm.capsophia.model.media;

import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

import fr.unice.polytech.si3.ihm.capsophia.async.DownloadImage;

public class Video extends Media {
    public Video(String url) {
        super(url);
    }

    @Override
    public void downloadThumbnailIn(ImageView imageView) {
        DownloadImage downloadImage = new DownloadImage(imageView);
        try {
            downloadImage.execute(new URL("http://img.youtube.com/vi/"+url.getPath().split("=")[1]+"/default.jpg"));
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
