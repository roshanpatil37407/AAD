package com.example.progessbar;



import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarIndeterminate, progressBarDeterminate;
    private TextView tvProgress;
    private Button btnStart;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarIndeterminate = findViewById(R.id.progressBarIndeterminate);
        progressBarDeterminate = findViewById(R.id.progressBarDeterminate);
        tvProgress = findViewById(R.id.tvProgress);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });
    }

    private void startProgress() {
        btnStart.setEnabled(false); // Disable button during progress
        progressBarIndeterminate.setVisibility(View.VISIBLE); // Show Indeterminate Progress Bar
        progressBarDeterminate.setVisibility(View.VISIBLE);
        tvProgress.setVisibility(View.VISIBLE);

        progressStatus = 0;

        // Simulate progress in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 5; // Increase progress
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBarDeterminate.setProgress(progressStatus);
                            tvProgress.setText("Progress: " + progressStatus + "%");
                        }
                    });
                    try {
                        Thread.sleep(500); // Delay to simulate work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Hide Indeterminate Progress Bar when completed
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBarIndeterminate.setVisibility(View.GONE);
                        btnStart.setEnabled(true); // Enable button again
                    }
                });
            }
        }).start();
    }
}
