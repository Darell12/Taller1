package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_navegacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_navegacion = findViewById(R.id.btn_navegacion);

        // Declarar la intención dentro del método onCreate
        Intent SegundaAct = new Intent(this, Formulario.class);

        btn_navegacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad Formulario al hacer clic en el botón
                startActivity(SegundaAct);
            }
        });
    }
}
