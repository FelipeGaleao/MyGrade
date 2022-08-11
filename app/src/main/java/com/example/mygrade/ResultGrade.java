package com.example.mygrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultGrade extends AppCompatActivity {
    private TextView txtNome, txtMedia, txtResultado;
    private Button btnCalcularResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_grade);
        txtNome = findViewById(R.id.edtNome);
        txtMedia = findViewById(R.id.Media2);
        txtResultado = findViewById(R.id.resultado);
        btnCalcularResultado = findViewById(R.id.btnCalcularResultado);
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nomeAluno");

        txtNome.setText(nome);

        btnCalcularResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double media_nota = Double.parseDouble(intent.getStringExtra("str_notap1")) + Double.parseDouble(intent.getStringExtra("str_notap2"))/2;
                    double qtde_faltas = Integer.parseInt(intent.getStringExtra("str_qtdefalta"));
                    double porcentagem = 1-((qtde_faltas)/68.0);
                    if(porcentagem < 0.75){
                        txtResultado.setText("Aluno reprovado por falta");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}