package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView displayTextView;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize views
        displayTextView = findViewById(R.id.displayTextView);

        // Initialize SQLite database
        db = openOrCreateDatabase("DepartmentDB", MODE_PRIVATE, null);

        // Display entered details
        displayDetails();
    }

    private void displayDetails() {
        Cursor cursor = db.rawQuery("SELECT * FROM departments;", null);
        StringBuilder details = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String location = cursor.getString(2);

                details.append("Department ID: ").append(id).append("\n");
                details.append("Department Name: ").append(name).append("\n");
                details.append("Department Location: ").append(location).append("\n\n");
            } while (cursor.moveToNext());
        }

        cursor.close();
        displayTextView.setText(details.toString());
    }
}
