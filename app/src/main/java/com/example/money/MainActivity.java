package com.example.money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button Start;

    EditText EdText;

    TextView Text1;
    TextView Text2;
    TextView Text3;
    TextView Text4;

    Spinner Sp0;
    Spinner Sp1;
    Spinner Sp2;
    Spinner Sp3;
    Spinner Sp4;

    final double RUB = 1.0, EUR = 74.57, USD = 65.96, BTC = 260646.0, GBR = 86.83;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = (Button) findViewById(R.id.ButtonID);

        EdText = (EditText) findViewById(R.id.editText);

        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);
        Text3 = (TextView) findViewById(R.id.Text3);
        Text4 = (TextView) findViewById(R.id.Text4);

        Sp0 = (Spinner) findViewById(R.id.Spin0);
        Sp1 = (Spinner) findViewById(R.id.Spin1);
        Sp2 = (Spinner) findViewById(R.id.Spin2);
        Sp3 = (Spinner) findViewById(R.id.Spin3);
        Sp4 = (Spinner) findViewById(R.id.Spin4);


        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //получаем количесвто валюты, которую надо перевести
                Double EditSum = 0.0;
                try {
                    EditSum = new Double(EdText.getText().toString());
                } catch (NumberFormatException e) {

                }
                //форула такая: (валюта из которой переводим/валюту в которую переводим)*количесвто валюты

                //расписваем первую валюту:
                Text1.setText(Itog(Sp0.getSelectedItemPosition(), Sp1.getSelectedItemPosition(), EditSum));
                //расписваем вторую валюту:
                Text2.setText(Itog(Sp0.getSelectedItemPosition(), Sp2.getSelectedItemPosition(), EditSum));
                //расписваем третью валюту:
                Text3.setText(Itog(Sp0.getSelectedItemPosition(), Sp3.getSelectedItemPosition(), EditSum));
                //расписваем четвертую валюту:
                Text4.setText(Itog(Sp0.getSelectedItemPosition(), Sp4.getSelectedItemPosition(), EditSum));
            }
        });

    }

    String Itog(int a, int b, double c) {
        double aD = 1.0, bD = 1.0, result = 1.0;
        //узнаем базовую валюту
        switch (a) {
            case 0:
                aD = RUB;
                break;
            case 1:
                aD = EUR;
                break;
            case 2:
                aD = USD;
                break;
            case 3:
                aD = BTC;
                break;
            case 4:
                aD = GBR;
                break;
        }
        //узнаем валюту конвертации
        switch (b) {
            case 0:
                bD = RUB;
                break;
            case 1:
                bD = EUR;
                break;
            case 2:
                bD = USD;
                break;
            case 3:
                bD = BTC;
                break;
            case 4:
                bD = GBR;
                break;
        }
        //вычисляем:
        if (bD != 0.0) {
            result = (aD / bD) * c;
        }
        String res = new DecimalFormat("#0.00").format(result);
        return res;
    }
}
