package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Liquidacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidacion);
        //Obtencion de Datos
        Intent Datos = getIntent();
        //Regresar
        Intent Volver = new Intent(this, MainActivity.class);

        Button btn_volver = findViewById(R.id.regresarLiq);

        TextView TxtNombres = findViewById(R.id.nombresLiq);
        TextView TxtsueldoNeto = findViewById(R.id.SubLiq);
        TextView Txtcargo = findViewById(R.id.cargosLiq);
        TextView Txtdias = findViewById(R.id.diasLiq);
        TextView TxtdiaV = findViewById(R.id.VDiaLiq);
        TextView Txtbase = findViewById(R.id.sueldoBaseLiq);

        String nombres = Datos.getStringExtra("nombres");
        String apellidos = Datos.getStringExtra("apellidos");
        String NombreCompleto = nombres + ' ' + apellidos;
        int sueldoBase = Datos.getIntExtra("Base", 0);
        int sueldoDia = Datos.getIntExtra("SueldoXdia", 0);
        int sueldoNeto = Datos.getIntExtra("SueldoNeto", 0);
        TxtNombres.setText(NombreCompleto);

        String cargo = Datos.getStringExtra("Cargo");
        Txtcargo.setText(cargo);

        String dias = Datos.getStringExtra("Dias");
        Txtdias.setText(dias);

        DecimalFormat formatoDosDecimales = new DecimalFormat("#.##");

        // Formatear los valores sueldoBase, sueldoDia y sueldoNeto a dos decimales
        String sueldoBaseFormateado = formatoDosDecimales.format(sueldoBase);
        String sueldoDiaFormateado = formatoDosDecimales.format(sueldoDia);
        String sueldoNetoFormateado = formatoDosDecimales.format(sueldoNeto);

        // Actualizar las TextViews con los valores formateados
        Txtbase.setText(sueldoBaseFormateado);
        TxtdiaV.setText(sueldoDiaFormateado);
        TxtsueldoNeto.setText(sueldoNetoFormateado);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Volver);
            }
        });
    }
}