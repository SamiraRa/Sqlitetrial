package com.example.sqlitetrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameET,ageET;
    private Button enterBtn;
    private DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        insertData();
    }

    private void insertData() {
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String age = ageET.getText().toString();

                long id = helper.insertData(name,age);
                Toast.makeText(MainActivity.this, "ID is " +id, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void init() {
        nameET = findViewById(R.id.nameET);
        ageET = findViewById(R.id.ageET);
        enterBtn = findViewById(R.id.enterBtn);
        helper = new DatabaseHelper(this);
    }


    public void showUser(View view) {
        startActivity(new Intent(MainActivity.this,ShowDataActivity.class));
    }
}
