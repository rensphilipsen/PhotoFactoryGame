package com.photofactory.photofactorygame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

/**
 * Created by Mike on 13-Oct-16.
 */

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button)findViewById(R.id.btnLogin);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnLogin) {
            signIn();
        }
    }

    private void signIn() {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                ProgressDialog.STYLE_HORIZONTAL);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        TextView email = (TextView) findViewById(R.id.signin_email);
        TextView password = (TextView) findViewById(R.id.signin_password);

        // Check if the two fields are not empty
        if (TextUtils.isEmpty(email.getText())
                || TextUtils.isEmpty(password.getText()))
        {
            Toast.makeText(LoginActivity.this, getString(R.string.signin_empty_fields), Toast.LENGTH_SHORT).show();

            return;
        }

        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getString(R.string.signin_dialog));

        firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.show();
                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            progressDialog.dismiss();

                                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                                            finish();
                                        }
                                    }, 3000);
                        } else {
                            Toast.makeText(LoginActivity.this, getString(R.string.signin_error), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
