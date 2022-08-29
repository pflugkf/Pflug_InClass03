/*
 * Assignment #: InClass 03
 * File Name: Pflug_InClass03 --- ProfileDisplayActivity.java
 * Full Name: Kristin Pflug
 */

package com.example.pflug_inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileDisplayActivity extends AppCompatActivity {

    TextView profileName;
    TextView profileEmail;
    TextView profileId;
    TextView profileDeptName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);
        setTitle("Profile");

        profileName = findViewById(R.id.profile_name_text);
        profileEmail = findViewById(R.id.profile_email_text);
        profileId = findViewById(R.id.profile_id_text);
        profileDeptName = findViewById(R.id.profile_dept_text);

        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(RegistrationActivity.USER_KEY)){
            User user = (User) getIntent().getSerializableExtra(RegistrationActivity.USER_KEY);

            profileName.setText(user.name);
            profileEmail.setText(user.email);
            profileId.setText(String.valueOf(user.id));
            profileDeptName.setText(user.department);
        }
    }
}