package com.example.sprawdzian;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button OblButton = findViewById(R.id.oblButton);




        OblButton.setOnClickListener((View v) -> {

            TextView aI = findViewById(R.id.InputA);
            TextView bI = findViewById(R.id.InputB);
            TextView cI = findViewById(R.id.inputC);

            double a = Double.parseDouble(aI.getText().toString());
            double b = Double.parseDouble(bI.getText().toString());
            double c = Double.parseDouble(cI.getText().toString());

            Double Delta = Math.pow(b, 2) - 4 * a * c;
            Double x = ((b*-1)+Math.sqrt(Delta))/2*a;

            TextView Output = findViewById(R.id.Output);
            if(Delta <= 0) {
                Output.setText("Brak rozwiazań");
                return;
            }

            Double y = a * Math.pow(x, 2) + b*x + c;

            Output.setText("y = " + y);
            return;
        });
    }
}