package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        EditText nameField = findViewById(R.id.name_textview);
        EditText statusField = findViewById(R.id.status_textview);
        String savedName = preferences.getString("name", "");
        String savedStatus = preferences.getString("status", "");
        nameField.setText(savedName);
        statusField.setText(savedStatus);
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        EditText nameField = findViewById(R.id.name_textview);
        EditText statusField = findViewById(R.id.status_textview);
        editor.putString("name", nameField.getText().toString());
        editor.putString("status", statusField.getText().toString());

        editor.apply();
    }

    public void onExitClicked(View view) {
        finish();
    }
}