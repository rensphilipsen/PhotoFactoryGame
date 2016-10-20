package com.photofactory.photofactorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableRow;

/**
 * Created by Mike on 13-Oct-16.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TableRow tableRow = (TableRow) findViewById(R.id.tableRow);

        tableRow.setClickable(true);
        tableRow.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener= new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(HomeActivity.this, ContestActivity.class));
        }
    };
}
