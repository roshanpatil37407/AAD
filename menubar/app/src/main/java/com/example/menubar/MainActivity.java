package com.example.menubar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView; // Declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout FIRST

        textView = findViewById(R.id.textView); // Find the TextView in your layout
    }

    // Inflate the menu (this is how we load the menu into the ActionBar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // Get the MenuInflater to inflate the menu
        inflater.inflate(R.menu.menu_main, menu);  // Inflate the menu
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_settings) {
            textView.setText("Settings selected");
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_about) {
            textView.setText("About selected");
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_exit) {
            finish(); // Exit the app
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
