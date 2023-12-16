package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText departmentIdEditText, locationEditText;
    private Spinner departmentNameSpinner;
    private Button saveButton;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize views
        departmentIdEditText = findViewById(R.id.departmentIdEditText);
        departmentNameSpinner = findViewById(R.id.departmentNameSpinner);
        locationEditText = findViewById(R.id.locationEditText);
        saveButton = findViewById(R.id.saveButton);

        //departmentIdEditText.setEnabled(false);

        // Initialize SQLite database
        db = openOrCreateDatabase("DepartmentDB", MODE_PRIVATE, null);
        createTable();

        // Set up the spinner with department names
        List<String> departmentNames = new ArrayList<>();
        departmentNames.add("Select Department");
        departmentNames.add("MCA");
        departmentNames.add("CS");
        departmentNames.add("EC");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departmentNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentNameSpinner.setAdapter(adapter);

        // Save button click event
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void createTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS departments (id INTEGER PRIMARY KEY, name TEXT, location TEXT);");
    }

    private void saveData() {
        String departmentId = departmentIdEditText.getText().toString();
        String departmentName = departmentNameSpinner.getSelectedItem().toString();
        String location = locationEditText.getText().toString();

        if (!departmentId.isEmpty() && !departmentName.equals("Select Department") && !location.isEmpty()) {
            // Insert data into the SQLite database
            db.execSQL("INSERT INTO departments (id, name, location) VALUES ('" + departmentId + "', '" + departmentName + "', '" + location + "');");

            // Clear input fields
            departmentIdEditText.setText("");
            departmentNameSpinner.setSelection(0);
            locationEditText.setText("");

            // Start the DisplayActivity to show the entered details
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
}