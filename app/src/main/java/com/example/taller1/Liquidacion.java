package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Liquidacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidacion);

        Intent Datos = getIntent();

        TextView TxtNombres = findViewById(R.id.nombresLiq);
        TextView TxtsueldoNeto = findViewById(R.id.SubLiq);
        TextView Txtcargo = findViewById(R.id.cargosLiq);
        TextView Txtdias = findViewById(R.id.diasLiq);
        TextView TxtdiaV = findViewById(R.id.VDiaLiq);

        String nombres = Datos.getStringExtra("nombres");
        String apellidos = Datos.getStringExtra("apellidos");
        String NombreCompleto = nombres + ' ' + apellidos;
        TxtNombres.setText(NombreCompleto);

        String cargo = Datos.getStringExtra("cargo");
        Txtcargo.setText(cargo);

        String dias = Datos.getStringExtra("Dias");
        Txtdias.setText(dias);

        Integer sueldoDia = Datos.getIntExtra("SueldoXdia", 0);
        TxtsueldoNeto.setText(String.valueOf(sueldoDia));

        double sueldoNeto = Datos.getDoubleExtra("SueldoNeto", 0);
        TxtsueldoNeto.setText(String.valueOf(sueldoNeto));
    }
}