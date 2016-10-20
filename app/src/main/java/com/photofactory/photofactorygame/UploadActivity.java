package com.photofactory.photofactorygame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Mike on 13-Oct-16.
 */

public class UploadActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnSubmitImage;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        imageView=(ImageView)findViewById(R.id.imageView2);
        bitmap = getIntent().getParcelableExtra("image");
        imageView.setImageBitmap(bitmap);
        btnSubmitImage = (Button)findViewById(R.id.btnSubmitImage);
        btnSubmitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this, ContestActivity.class);
                intent.putExtra("image",bitmap);
                startActivity(intent);
            }
        });
    }

}
