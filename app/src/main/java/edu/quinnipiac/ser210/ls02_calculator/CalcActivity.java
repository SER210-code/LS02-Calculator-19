package edu.quinnipiac.ser210.ls02_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
                    performOp('+');

                }
            }
        });
        Spinner opSpinner = (Spinner) findViewById(R.id.spinner);
        opSpinner.setSelection(0,false);
        opSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String operation = (String) adapterView.getItemAtPosition(i);
                if (operation.equals("*")){
                    performOp('*');
                }
                if (operation.equals("/")) {
                    performOp('/');
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    // handling event subtract as defined in activity_calc.xml
    public void subtract(View v){
        performOp('-');
    }
    private void performOp(char op){
        if ((input1.getText() != null) && (input2.getText() != null) ) {

            // read from input1 and input2
            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());

            double res = 0;

            // peform operation the two values

            switch (op) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;

            }
            //update the value of text in the result textView
            result.setText(Double.toString(res));
        }
    }
}
