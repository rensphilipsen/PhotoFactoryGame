package com.photofactory.photofactorygame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
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
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.like.LikeButton;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ContestActivity extends AppCompatActivity {

    Button b1;
    Bitmap bitmap;
    ImageView imageView;
    TableLayout tableLayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);

        b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            tableLayout = (TableLayout) findViewById(R.id.tableLayout);
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            bitmap = getIntent().getParcelableExtra("image");
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setId(R.id.newRelativeLayout);

            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            lp2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lp2.addRule(RelativeLayout.CENTER_HORIZONTAL);


            RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            lp3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lp3.addRule(RelativeLayout.ALIGN_RIGHT);
            lp3.addRule(RelativeLayout.ALIGN_END);

            TextView textView = new TextView(this);
            textView.setText("1 likes");
            textView.setId(R.id.newTextView);
            textView.setBackgroundColor(Color.parseColor("#cccccc"));
            textView.setTextSize(17);
            textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            textView.setPadding(30, 15, 0, 0);

            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            imageView.setId(R.id.newImageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            row.addView(relativeLayout);

            LikeButton likeButton = new LikeButton(this);
            likeButton.setIconSizePx(40);
            likeButton.setPadding(800,120,0,0);
            likeButton.setLiked(true);

            tableLayout.addView(row);

            relativeLayout.addView(imageView);
            relativeLayout.addView(textView, lp2);
            relativeLayout.addView(likeButton, lp3);

            ImageView NewImage = (ImageView) findViewById(R.id.newImageView);
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics();
            display.getMetrics(outMetrics);
            float scWidth = outMetrics.widthPixels;
            NewImage.getLayoutParams().width = (int) scWidth;
            NewImage.getLayoutParams().height = (int) (scWidth * 0.643f);

            RelativeLayout newRelativeLayout = (RelativeLayout) findViewById(R.id.newRelativeLayout);

            TextView newTextView = (TextView) findViewById(R.id.newTextView);
            newTextView.getLayoutParams().width = (int) scWidth - 156;
            newTextView.getLayoutParams().height = 100;

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b = (Bitmap) data.getExtras().get("data");

        Intent intent = new Intent(this, UploadActivity.class);
        intent.putExtra("image", b);
        startActivity(intent);
    }
}
