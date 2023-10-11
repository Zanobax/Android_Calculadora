package com.elrick.calculadorapro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double primernumero;
    String operacion,funcion;

    TextView resultado,solucion;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado=findViewById(R.id.resultado);
        solucion=findViewById(R.id.solucion);

        MaterialButton borradoretroceso=findViewById(R.id.borrado_retroceso),
                porcentaje=findViewById(R.id.porcentaje),
                potencia=findViewById(R.id.potencia),
                division=findViewById(R.id.division),
                suma=findViewById(R.id.suma),
                resta=findViewById(R.id.resta),
                multiplicacion=findViewById(R.id.multiplicacion),
                igual=findViewById(R.id.igual),
                boton1=findViewById(R.id.boton1),
                boton2=findViewById(R.id.boton2),
                boton3=findViewById(R.id.boton3),
                boton4=findViewById(R.id.boton4),
                boton5=findViewById(R.id.boton5),
                boton6=findViewById(R.id.boton6),
                boton7=findViewById(R.id.boton7),
                boton8=findViewById(R.id.boton8),
                boton9=findViewById(R.id.boton9),
                boton_allclean=findViewById(R.id.boton_allclean),
                boton0=findViewById(R.id.boton0),
                boton_punto=findViewById(R.id.boton_punto);

        ArrayList<MaterialButton>numeros= new ArrayList<>();
        numeros.add(boton0);
        numeros.add(boton1);
        numeros.add(boton2);
        numeros.add(boton3);
        numeros.add(boton4);
        numeros.add(boton5);
        numeros.add(boton6);
        numeros.add(boton7);
        numeros.add(boton8);
        numeros.add(boton9);
//        Que se muestren los numeros en la pantalla
        for (Button b :numeros){
            b.setOnClickListener(view -> {
                if (!resultado.getText().toString().equals("0")){
                    resultado.setText(resultado.getText().toString()+b.getText().toString());
                }else {
                    resultado.setText(b.getText().toString());
                }
            });
        }

        ArrayList<MaterialButton>operadores= new ArrayList<>();
        operadores.add(division);
        operadores.add(multiplicacion);
        operadores.add(suma);
        operadores.add(resta);
        operadores.add(potencia);
        for (Button b :operadores){
            b.setOnClickListener(view -> {
                primernumero=Double.parseDouble(resultado.getText().toString());
                operacion=b.getText().toString();
               funcion=primernumero+operacion;
               solucion.setText(funcion);
                resultado.setText("0");
            });
        }
        borradoretroceso.setOnClickListener(view -> {
            String numero=resultado.getText().toString();
            if (numero.length()>1){
                resultado.setText(numero.substring(0,numero.length()-1));
            }else if (numero.length()==1 && !numero.equals("0")){
                resultado.setText("0");
            }
        });

        boton_punto.setOnClickListener(view -> {
            if (!resultado.getText().toString().contains(".")){
                resultado.setText(resultado.getText().toString()+".");
            }
        });

        igual.setOnClickListener(view ->{
            double segundonumero=Double.parseDouble(resultado.getText().toString());
            double res;
            switch (operacion){
                case "+":
                    res=primernumero+segundonumero;
                    break;
                case "-":
                    res=primernumero-segundonumero;
                    break;
                case "x":
                    res=primernumero*segundonumero;
                    break;
                case "/":
                    res=primernumero/segundonumero;
                    break;
                case "p":
                    res=Math.pow(primernumero,segundonumero);
                    break;
                default:
                    res=primernumero+segundonumero;
            }
            resultado.setText(String.valueOf(res));
            funcion+=segundonumero;
            solucion.setText(funcion);
            primernumero=res;
        });

        porcentaje.setOnClickListener(view ->
        {
            double perce=primernumero/100;
            resultado.setText(String.valueOf(perce));
        });




        boton_allclean.setOnClickListener(view ->
        {
            primernumero=0;
            resultado.setText("0");
            solucion.setText("");
            funcion="";
        });
    }


}