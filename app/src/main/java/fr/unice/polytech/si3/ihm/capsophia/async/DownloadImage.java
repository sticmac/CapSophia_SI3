package fr.unice.polytech.si3.ihm.capsophia.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadImage extends AsyncTask<URL, Void, Bitmap> {
    private ImageView imageView;

    public DownloadImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public Bitmap doInBackground(URL... params) {
        try {
            InputStream inputStream = params[0].openStream();
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }

    @Override
    public void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}

