package ca.mcgill.amt;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText mInputA;
    private TextView mResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputA = (EditText)findViewById(R.id.inputA);
        mResult = (TextView)findViewById(R.id.result);
    }

    public void calculate(View v){
        if(TextUtils.isEmpty(mInputA.getText().toString().trim())){
            mResult.setText("Error: Please input a value for side A");
        }
        else{
            mResult.setText("Error: Please input a value for side B");
        }

    }
}
