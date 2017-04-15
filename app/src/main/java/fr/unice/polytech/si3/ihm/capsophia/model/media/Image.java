package fr.unice.polytech.si3.ihm.capsophia.model.media;

import android.widget.ImageView;

import fr.unice.polytech.si3.ihm.capsophia.async.DownloadImage;

public class Image extends Media {
    public Image(String url) {
        super(url);
    }

    @Override
    public void downloadThumbnailIn(ImageView imageView) {
        DownloadImage downloadImage = new DownloadImage(imageView);
        downloadImage.execute(url);
    }
}
