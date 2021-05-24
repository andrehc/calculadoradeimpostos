package com.example.calcularsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.calcularsalario.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnCalcular);
        EditText texto = (EditText) findViewById(R.id.input);


        btn.setOnClickListener(v -> {
            double salario = Double.parseDouble(texto.getText().toString());
            Intent intent = new Intent(getApplicationContext(), Resultado.class);
            intent.putExtra("salario", salario);
            startActivity(intent);
        });
    }
}
