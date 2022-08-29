/*
 * Assignment #: InClass 03
 * File Name: Pflug_InClass03 --- DepartmentSelectActivity.java
 * Full Name: Kristin Pflug
 */

package com.example.pflug_inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DepartmentSelectActivity extends AppCompatActivity {
    public static final String KEY_NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_select);
        setTitle("Department");

        findViewById(R.id.dept_cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.dept_submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup deptList = findViewById(R.id.dept_list);
                int chosenDept = deptList.getCheckedRadioButtonId();
                String deptName = "";

                if(chosenDept != -1) {
                    if (chosenDept == R.id.dept_comp_sci_radio) {
                        deptName = "Computer Science";
                    } else if (chosenDept == R.id.dept_software_info_sys_radio) {
                        deptName = "Software Info. Systems";
                    } else if (chosenDept == R.id.dept_bioinformatics_radio) {
                        deptName = "Bio Informatics";
                    } else if (chosenDept == R.id.dept_data_science_radio) {
                        deptName = "Data Science";
                    }

                    Intent intent = new Intent(DepartmentSelectActivity.this, RegistrationActivity.class);
                    intent.putExtra(KEY_NAME, deptName);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(DepartmentSelectActivity.this, getString(R.string.no_department_selected_error_text), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}