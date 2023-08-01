package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btn_regresar = findViewById(R.id.regresar);
        Button btn_liquidar = findViewById(R.id.btn_liquidar);

        EditText nombres = findViewById(R.id.nombresLiq);
        EditText apellidos = findViewById(R.id.apellidos);
        EditText cargo = findViewById(R.id.cargo);
        EditText sueldo = findViewById(R.id.sueldoB);
        EditText diasLab = findViewById(R.id.diasLab);

        CheckBox salud = findViewById(R.id.saludCheck);
        CheckBox pension = findViewById(R.id.pensionCheck);
        CheckBox descuento = findViewById(R.id.descuentoCheck);

        Intent RegresarMain = new Intent(this, MainActivity.class);
        Intent Liquidar = new Intent(this, Liquidacion.class);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RegresarMain);
            }
        });

        btn_liquidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados
                String sueldoIngresado = sueldo.getText().toString();
                String diasIngresados = diasLab.getText().toString();

                // Validar entrada
                if (sueldoIngresado.isEmpty() || diasIngresados.isEmpty()) {
                    // Mostrar mensaje de error al usuario
                    Toast.makeText(Formulario.this, "Por favor, ingrese todos los valores.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double sueldoBase = Double.parseDouble(sueldoIngresado);
                int diasLaborados = Integer.parseInt(diasIngresados);

                // Calcular descuentos
                double montoDescontado = 0;
                if (descuento.isChecked()) {
                    montoDescontado += (sueldoBase * 3) / 100;
                }
                if (salud.isChecked()) {
                    montoDescontado += (sueldoBase * 4) / 100;
                }
                if (pension.isChecked()) {
                    montoDescontado += (sueldoBase * 4) / 100;
                }

                // Calcular liquidación y sueldo por día
                double Liquidacion = sueldoBase - montoDescontado;
                double SueldoxDia = (diasLaborados != 0) ? Liquidacion / diasLaborados : 0;

                // Colocar los datos en el intent y mostrar la actividad Liquidacion
                Liquidar.putExtra("nombres", nombres.getText().toString());
                Liquidar.putExtra("apellidos", apellidos.getText().toString());
                Liquidar.putExtra("Cargo", cargo.getText().toString());
                Liquidar.putExtra("Base", sueldoBase);
                Liquidar.putExtra("Dias", diasLab.getText().toString());

                Liquidar.putExtra("SueldoNeto", Liquidacion);
                Liquidar.putExtra("SueldoXdia", SueldoxDia);
                startActivity(Liquidar);
            }
        });


    }
}