package com.photofactory.photofactorygame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ContestActivity extends AppCompatActivity {

    Button b1;
    Bitmap bitmap;
    ImageView imageView;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);

        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            tableLayout = (TableLayout) findViewById(R.id.tableLayout);
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            bitmap = getIntent().getParcelableExtra("image");
            RelativeLayout relativeLayout = new RelativeLayout(this);

            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            imageView.setId(R.id.newImageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            row.addView(relativeLayout);

            tableLayout.addView(row);

            relativeLayout.addView(imageView);

            ImageView NewImage = (ImageView) findViewById(R.id.newImageView);
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics();
            display.getMetrics(outMetrics);
            float scWidth = outMetrics.widthPixels;
            NewImage.getLayoutParams().width = (int) scWidth;
            NewImage.getLayoutParams().height = (int) (scWidth * 0.6f);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b = (Bitmap) data.getExtras().get("data");

        Intent intent = new Intent(this, UploadActivity.class);
        intent.putExtra("image",b);
        startActivity(intent);
    }
}
