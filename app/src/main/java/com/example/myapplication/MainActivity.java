package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRes;
    Spinner op;
    EditText n1,n2;
    Button calc;

    String selectedOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRes = findViewById(R.id.tvRes);
        op = findViewById(R.id.spActions);
        n1 = findViewById(R.id.etNum1);
        n2 = findViewById(R.id.etNum2);
        calc = findViewById(R.id.btnCalc);

        calc.setOnClickListener(this);
        op.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOp = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        try {
            Double res = 0.0, num1, num2;
            num1 = Double.parseDouble(n1.getText().toString().trim());
            num2 = Double.parseDouble(n2.getText().toString().trim());

            switch(selectedOp){
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
                case "^":
                    res = Math.pow(num1,num2);
                    break;
            }

            tvRes.setText(String.format(res.toString()));
        }
        catch(Error E){
            Toast.makeText(this,"Error: "+E,Toast.LENGTH_LONG).show();
        }
    }
}