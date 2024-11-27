package com.example.bredufateczlsoex03.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bredufateczlsoex03.R;
import com.example.bredufateczlsoex03.controller.NumeroController;

public class MainActivity extends AppCompatActivity {

    protected Button exibirPrimosButton;
    protected EditText AValor;
    protected EditText BValor;
    protected TextView ResultadoText;

    private final NumeroController numeroController = new NumeroController();

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

        exibirPrimosButton = findViewById(R.id.exibirPrimosButton);
        AValor = findViewById(R.id.AValor);
        BValor = findViewById(R.id.BValor);
        ResultadoText = findViewById(R.id.ResultadoText);

        addActionListeners();
    }

    @SuppressLint("SetTextI18n")
    private void addActionListeners() {
        exibirPrimosButton.setOnClickListener((View v) -> {
            int a = Integer.parseInt(AValor.getText().toString());
            int b = Integer.parseInt(BValor.getText().toString());

            if (Math.min(a, b) < 0 || Math.max(a, b) > 50) {
                ResultadoText.setText("O menor valor deve ser > 0, e o maior < 50.");
                AValor.setText("");
                BValor.setText("");
                return;
            }

            String resultado = numeroController.primos(Math.min(a, b), Math.max(a, b));
            ResultadoText.setVisibility(View.VISIBLE);
            ResultadoText.setText(resultado);
        });

    }
}