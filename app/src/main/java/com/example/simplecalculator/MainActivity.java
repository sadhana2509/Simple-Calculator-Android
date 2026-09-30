package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button addBtn, subBtn, mulBtn, divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        addBtn.setOnClickListener(v -> calculate('+'));
        subBtn.setOnClickListener(v -> calculate('-'));
        mulBtn.setOnClickListener(v -> calculate('*'));
        divBtn.setOnClickListener(v -> calculate('/'));
    }

    @SuppressLint("SetTextI18n")
    private void calculate(char operator) {

        if (num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());

        double answer;

        switch (operator) {
            case '+':
                answer = a + b;
                break;

            case '-':
                answer = a - b;
                break;

            case '*':
                answer = a * b;
                break;

            case '/':
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                answer = a / b;
                break;

            default:
                return;
        }

        result.setText("Result: " + answer);
    }
}
