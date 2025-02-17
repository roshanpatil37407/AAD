package com.example.calculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        // Set up number button listeners
        setNumberClickListener(R.id.btn0, "0");
        setNumberClickListener(R.id.btn1, "1");
        setNumberClickListener(R.id.btn2, "2");
        setNumberClickListener(R.id.btn3, "3");
        setNumberClickListener(R.id.btn4, "4");
        setNumberClickListener(R.id.btn5, "5");
        setNumberClickListener(R.id.btn6, "6");
        setNumberClickListener(R.id.btn7, "7");
        setNumberClickListener(R.id.btn8, "8");
        setNumberClickListener(R.id.btn9, "9");

        // Set up operator button listeners
        setOperatorClickListener(R.id.btnPlus, "+");
        setOperatorClickListener(R.id.btnMinus, "-");
        setOperatorClickListener(R.id.btnMultiply, "×");
        setOperatorClickListener(R.id.btnDivide, "÷");

        // Set clear button listener
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentInput = "";
            operator = "";
            firstNumber = 0;
            tvResult.setText("0");
        });

        // Set equals button listener
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());
    }

    private void setNumberClickListener(int buttonId, String number) {
        findViewById(buttonId).setOnClickListener(v -> {
            currentInput += number;
            tvResult.setText(currentInput);
        });
    }

    private void setOperatorClickListener(int buttonId, String op) {
        findViewById(buttonId).setOnClickListener(v -> {
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                operator = op;
                currentInput = "";
                tvResult.setText(op);
            }
        });
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "÷":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        tvResult.setText("Error");
                        return;
                    }
                    break;
            }

            tvResult.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }
}
