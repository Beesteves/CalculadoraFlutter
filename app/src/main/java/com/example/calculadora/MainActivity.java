package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        private TextView resultTextView;
        private String currentNumber = "";
        private String operator = "";
        private double firstNumber = 0;
        private double secondNumber = 0;
        private double result = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            resultTextView = findViewById(R.id.textView);
        }

        public void onNumberClick(View view) {
            Button button = (Button) view;
            currentNumber += button.getText().toString();
            resultTextView.setText(currentNumber);
        }

        public void onOperatorClick(View view) {
            if (!currentNumber.isEmpty()) {
                if (!operator.isEmpty()) {
                    calculateResult();
                    operator = "";
                }
                firstNumber = Double.parseDouble(currentNumber);
                currentNumber = "";
                operator = ((Button) view).getText().toString();
            }
        }

        public void onEqualsClick(View view) {
            if (!currentNumber.isEmpty() && !operator.isEmpty()) {
                secondNumber = Double.parseDouble(currentNumber);
                calculateResult();
                operator = "";
            }
        }

        public void onClearClick(View view) {
            currentNumber = "";
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
            result = 0;
            resultTextView.setText("");
        }

        private void calculateResult() {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
            }
            resultTextView.setText(String.valueOf(result));
            firstNumber = result;
            currentNumber = "";
        }
    }