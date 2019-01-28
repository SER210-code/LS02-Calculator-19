package edu.quinnipiac.ser210.ls02_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView result;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        add = (Button) findViewById(R.id.add);
        result = (TextView) findViewById(R.id.result);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input1.getText() != null && input2.getText() != null){
                     double num1 = Double.valueOf(input1.getText().toString());
                    double num2 = Double.valueOf(input2.getText().toString());
                    double res = num1 + num2;
                    result.setText(Double.toString(res));

                }
            }
        });

    }
    public void subtract(View view){

    }
}
