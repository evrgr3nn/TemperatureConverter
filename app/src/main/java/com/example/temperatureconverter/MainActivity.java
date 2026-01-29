package com.example.temperatureconverter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.temperatureconverter.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // View Binding setup
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Convert button click
            binding.button.setOnClickListener(view -> convertTemperature());
        }

        private void convertTemperature() {

            String fText = binding.fahEntry.getText().toString();
            String cText = binding.celEntry.getText().toString();

            Double fValue = parseDoubleOrNull(fText);
            Double cValue = parseDoubleOrNull(cText);

            // If both fields have numbers
            if (fValue != null && cValue != null) {
                double result = (fValue - 32) * 5 / 9;
                binding.celEntry.setText(String.valueOf(result));
            }
            // Only Fahrenheit filled
            else if (fValue != null) {
                double result = (fValue - 32) * 5 / 9;
                binding.celEntry.setText(String.valueOf(result));
            }
            // Only Celsius filled
            else if (cValue != null) {
                double result = (cValue * 9 / 5) + 32;
                binding.fahEntry.setText(String.valueOf(result));
            }
        }

        private Double parseDoubleOrNull(String value) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }
