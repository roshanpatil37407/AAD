package com.example.intent;



import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvMessage = findViewById(R.id.tvMessage);

        // Retrieve the data from Intent
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvMessage.setText("Welcome, " + username + "!");
        } else {
            tvMessage.setText("Welcome, Guest!");
        }
    }
}

