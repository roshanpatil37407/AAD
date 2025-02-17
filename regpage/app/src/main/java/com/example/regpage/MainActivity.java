package com.example.regpage;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    RadioGroup radioGroup;
    RadioButton rbMale, rbFemale;
    Spinner spinnerCourse;
    CheckBox cbTerms;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        radioGroup = findViewById(R.id.radioGroup);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        cbTerms = findViewById(R.id.cbTerms);
        btnRegister = findViewById(R.id.btnRegister);

        // Set options for Spinner
        String[] courses = {"Select Course", "Android Development", "Web Development", "Data Science"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courses);
        spinnerCourse.setAdapter(adapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show(); // Debug message

                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String gender = "";
                if (rbMale.isChecked()) gender = "Male";
                if (rbFemale.isChecked()) gender = "Female";
                String course = spinnerCourse.getSelectedItem().toString();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty() || course.equals("Select Course")) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!cbTerms.isChecked()) {
                    Toast.makeText(MainActivity.this, "Accept terms and conditions", Toast.LENGTH_SHORT).show();
                } else {
                    String message = "Registered Successfully!\n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phone + "\n" +
                            "Gender: " + gender + "\n" +
                            "Course: " + course;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
