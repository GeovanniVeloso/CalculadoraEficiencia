package com.example.calculadoraeficiencia;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText tndConsumo;
    private EditText tndCapacidade;
    private Button btCalc;
    private TextView tvRes;

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

        tndConsumo = findViewById(R.id.tndCosumo);
        tndConsumo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tndCapacidade = findViewById(R.id.tndCapacidade);
        tndCapacidade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btCalc = findViewById(R.id.btCalc);
        tvRes = findViewById(R.id.tvRes);

        btCalc.setOnClickListener(op -> calc());

    }

    private void calc() {

        float consumo = Float.parseFloat(tndConsumo.getText().toString())*1000;
        float capacidade = Float.parseFloat(tndCapacidade.getText().toString());

        float autonomia = (capacidade * consumo)/1000;

        String res = "O carro tem capacidade de "+autonomia+"km com o combustível atual.";

        tvRes.setText(res);

        tndConsumo.setText("");
        tndCapacidade.setText("");

    }
}