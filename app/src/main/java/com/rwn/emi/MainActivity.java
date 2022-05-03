package com.rwn.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1, e2, e3;
    TextView result;
    Button total, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.amount);
        e2 = findViewById(R.id.rate);
        e3 = findViewById(R.id.month);
        result = findViewById(R.id.result);
        total = findViewById(R.id.b1);
        reset = findViewById(R.id.reset);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float p = Float.parseFloat(e1.getText().toString());
                float r = Float.parseFloat(e2.getText().toString());
                float n = Float.parseFloat(e3.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                result.setText(" Amount With intrest : "+(f_ans+p)+"\n\n"+" Intrest : "+f_ans);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
            }
        });
    }
}
