package br.edu.iff.pooa20181.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnBotao;
    private EditText etPeso, etAltura;
    private TextView tvSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        btnBotao = (Button) findViewById(R.id.btCalcular);
        tvSaida = (TextView) findViewById(R.id.tvSaida);

        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(etPeso.getText().toString());
                double altura = Double.parseDouble(etAltura.getText().toString());
                double calculo = calcular(peso, altura);
                String msg = "";
                if(calculo >= 40.0) msg = "Obesidade III";
                else if (calculo >= 35.0) msg = "Obesidade II";
                else if (calculo >= 30.0) msg = "Obesidade I";
                else if (calculo >= 25.0) msg = "Acima do peso";
                else {
                    if (calculo >= 18.5)
                        msg = "Peso normal";
                    else msg = "Muito abaixo do peso";
                }
                tvSaida.setText(msg);
            }
        });
    }
    public double calcular(double peso, double altura){
        return peso/(altura*altura);
    }
}
