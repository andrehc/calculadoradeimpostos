package com.example.calcularsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bdl = getIntent().getExtras();
        double salario = bdl.getDouble("salario");
        double parcelaIRPF = 0;
        double aliquotaIRPF = 0;
        double aliquotaINSS = 0;
        double taxaINSS = 0;
        double salarioLiquido = 0;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);


        if(salario <= 1045.00) {
            aliquotaINSS = salario * (7.5 / 100);
        } else if (salario >= 1045.01 || salario <= 2089.60) {
            aliquotaINSS = salario * 9 / 100;
        } else if (salario >= 2089.61 || salario <= 3134.40) {
            aliquotaINSS = salario * 12 / 100;
        } else if (salario >= 3134.41 || salario <= 6101.06) {
            aliquotaINSS = salario * 14 / 100;
        } else if (salario >= 6101.07 || salario <= 10448.00){
            aliquotaINSS = salario * 14.5 / 100;
        } else if (salario >= 10448.01 || salario <= 20896.00){
            aliquotaINSS = salario * 16.5 / 100;
        } else if (salario >= 20896.01 || salario <= 40747.20){
            aliquotaINSS = salario * 19 / 100;
        } else if (salario > 40747.20){
            aliquotaINSS = salario * 22 / 100;
        }
        if(salario >= 1903.99 && salario <= 2826.65) {
            aliquotaIRPF = salario * (7.5 / 100);
            parcelaIRPF = aliquotaIRPF - 142.8;
        } else if (salario >= 2826.66 && salario <= 3751.05) {
            aliquotaIRPF = salario * (15 / 100);
            parcelaIRPF = aliquotaIRPF - 354.8;
        } else if (salario >= 3751.06  && salario <= 4664.68) {
            aliquotaIRPF = salario * (22.5 / 100);
            parcelaIRPF = aliquotaIRPF - 636.13;
        } else if (salario >= 4664.68) {
            aliquotaIRPF = salario * (27.5 / 100);
            parcelaIRPF = aliquotaIRPF - 869.36;
        }

        taxaINSS = aliquotaINSS;
        salarioLiquido = salario - (parcelaIRPF + taxaINSS);

        TextView resultado = (TextView) findViewById(R.id.resultado);
        StringBuilder sb = new StringBuilder();

        sb.append("Salario Bruto R$      " + decimalFormat.format(salario));
        sb.append("\n");
        sb.append("\nDESCONTOS: ");
        sb.append("\n");
        sb.append("Imposto de Renda\n\n" + "Aliquota: " + decimalFormat.format(aliquotaIRPF) + "\nParcela IRPF: " + decimalFormat.format(parcelaIRPF));
        sb.append("\n");
        sb.append("\n");
        sb.append("INSS     "   + decimalFormat.format(aliquotaINSS) +   "\nTaxa   " + decimalFormat.format(taxaINSS));
        sb.append("\n");
        sb.append("\n");
        sb.append("Salario Liquido:     " + decimalFormat.format(salarioLiquido));
        resultado.setText(sb.toString());
    }
}