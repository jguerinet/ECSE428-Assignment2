package ca.mcgill.amt;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText mInputA, mInputB, mInputC;
    private TextView mResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputA = (EditText)findViewById(R.id.inputA);
        mInputB = (EditText)findViewById(R.id.inputB);
        mInputC = (EditText)findViewById(R.id.inputC);
        mResult = (TextView)findViewById(R.id.result);
    }

    public void calculate(View v){
        String inputA = mInputA.getText().toString().trim();
        String inputB = mInputB.getText().toString().trim();
        String inputC = mInputC.getText().toString().trim();

        if(TextUtils.isEmpty(inputA)){
            mResult.setText("Error: Please input a value for side A");
        }
        else if(TextUtils.isEmpty(inputB)){
            mResult.setText("Error: Please input a value for side B");
        }
        else if(TextUtils.isEmpty(inputC)){
            mResult.setText("Error: Please input a value for side C");
        }
        else{
            //Parse the numbers
            int a, b, c;
            try{
                a = Integer.parseInt(inputA);
                b = Integer.parseInt(inputB);
                c = Integer.parseInt(inputC);
            } catch (NumberFormatException e){
                mResult.setText("Error: Please input whole numbers only");
                return;
            }

            //Too small
            if(a < 1 || b < 1 || c < 1){
                mResult.setText("Error: Numbers need to be 1 or larger");
                return;
            }
            //Too big
            else if(a > 100 || b > 100 || c > 100){
                mResult.setText("Error: Numbers need to be 100 or smaller");
                return;
            }
            //Not a triangle
            else if(a + b < c || b + c < a || a + c < b){
                mResult.setText("Error: Numbers inputted do not form a triangle");
                return;
            }

            mResult.setText("Scalene Triangle");
        }
    }
}
