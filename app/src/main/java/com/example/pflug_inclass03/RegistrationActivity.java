/*
* Assignment #: InClass 03
* File Name: Pflug_InClass03 --- RegistrationActivity.java
* Full Name: Kristin Pflug
*/

package com.example.pflug_inclass03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText nameEntered;
    EditText emailEntered;
    EditText idEntered;
    TextView deptNameSelected;
    final static public String USER_KEY = "USER";


    ActivityResultLauncher<Intent> deptResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode() == RESULT_OK){
                if(result.getData() != null && result.getData().getStringExtra(DepartmentSelectActivity.KEY_NAME) != null){
                    deptNameSelected.setText(result.getData().getStringExtra(DepartmentSelectActivity.KEY_NAME));
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");

        nameEntered = findViewById(R.id.reg_name_textbox);
        emailEntered = findViewById(R.id.reg_email_textbox);
        idEntered = findViewById(R.id.reg_id_textbox);
        deptNameSelected = findViewById(R.id.reg_dept_text);

        findViewById(R.id.reg_dept_select_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, DepartmentSelectActivity.class);
                deptResult.launch(intent);
            }
        });

        findViewById(R.id.reg_submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String userName;
                    String userEmail;
                    int userId;
                    String userDept;

                    if(nameEntered.getText().toString().equals("") || emailEntered.getText().toString().equals("")) {
                        Toast.makeText(RegistrationActivity.this, getString(R.string.empty_field_error_text), Toast.LENGTH_SHORT).show();
                    } else {

                        userName = nameEntered.getText().toString();
                        userEmail = emailEntered.getText().toString();
                        userId = Integer.parseInt(String.valueOf(idEntered.getText()));

                        if(!String.valueOf(deptNameSelected.getText()).equals("")) {
                            userDept = String.valueOf(deptNameSelected.getText());
                            Intent intent = new Intent(RegistrationActivity.this, ProfileDisplayActivity.class);
                            intent.putExtra(USER_KEY, new User(userName, userEmail, userId, userDept));
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegistrationActivity.this, getString(R.string.empty_department_error_text), Toast.LENGTH_SHORT).show();
                        }


                    }

                } catch (NumberFormatException nfe) {
                    Toast.makeText(RegistrationActivity.this, getString(R.string.number_format_exception_error_text), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}