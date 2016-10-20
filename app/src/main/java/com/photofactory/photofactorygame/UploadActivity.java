package com.photofactory.photofactorygame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Mike on 13-Oct-16.
 */

public class UploadActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        imageView=(ImageView)findViewById(R.id.imageView2);
        Bitmap bitmap = getIntent().getParcelableExtra("image");
        imageView.setImageBitmap(bitmap);
    }
}
