package com.example.mygrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtNome, notaP1, notaP2, qtdeFaltas;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.ed_nome);
        notaP1 = findViewById(R.id.ed_NotaP1);
        notaP2 = findViewById(R.id.ed_NotaP2);
        qtdeFaltas = findViewById(R.id.ed_QtdFaltas);

        btnIniciar = findViewById(R.id.btn_Iniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultGrade.class);

                String nomeAluno = edtNome.getText().toString();
                String str_notap1 = notaP1.getText().toString();
                String str_notap2 = notaP2.getText().toString();
                String str_qtdefalta = qtdeFaltas.getText().toString();

                intent.putExtra("str_notap1", str_notap1);
                intent.putExtra("str_notap2", str_notap2);
                intent.putExtra("str_qtdefalta", str_qtdefalta);
                intent.putExtra("nomeAluno", nomeAluno);

                startActivity(intent);
            }
        });
    }
}