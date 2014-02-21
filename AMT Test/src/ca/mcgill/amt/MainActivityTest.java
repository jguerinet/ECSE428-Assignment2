package ca.mcgill.amt;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Julien Guerinet
 * Test Activity to test MainActivity in the ca.mcgill.amt packages
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;
    private EditText mInputA, mInputB, mInputC;
    private Button mCalculate;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    /**
     * Test 1
     * Test to see if the TextView for input A exists
     * Test 7
     * Test to see if the TextView for input A has the right text
     */
    public void testInputATextView(){
        TextView mInputATitle = (TextView)activity.findViewById(R.id.inputA_title);

        //Test 1
        assertNotNull(mInputATitle);

        //Test 7
        assertEquals("Side A Length:", mInputATitle.getText().toString());
    }

    /**
     * Test 2
     * Test to see if the EditText for input A exists
     */
    public void testInputAEditTextExistence(){
        mInputA = (EditText)activity.findViewById(R.id.inputA);
        assertNotNull(mInputA);
    }

    /**
     * Test 3
     * Test to see if the TextView for input B exists
     * Test 8
     * Test to see if the TextView for input B has the right text
     */
    public void testInputBTextView(){
        TextView mInputBTitle = (TextView)activity.findViewById(R.id.inputB_title);

        //Test 3
        assertNotNull(mInputBTitle);

        //Test 8
        assertEquals("Side B Length:", mInputBTitle.getText().toString());
    }

    /**
     * Test 4
     * Test to see if the EditText for input B exists
     */
    public void testInputBEditTextExistence(){
        mInputB = (EditText)activity.findViewById(R.id.inputB);
        assertNotNull(mInputB);
    }

    /**
     * Test 5
     * Test to see if the TextView for Input C exists
     * Test 9
     * Test to see if the TextView for input C has the right text
     */
    public void testInputCTextView(){
        TextView mInputCTitle = (TextView)activity.findViewById(R.id.inputC_title);

        //Test 5
        assertNotNull(mInputCTitle);

        //Test 9
        assertEquals("Side C Length:", mInputCTitle.getText().toString());
    }

    /**
     * Test 6
     * Test to see if the EditText for input C exists
     */
    public void testInputCEditTextExistence(){
        mInputC = (EditText)activity.findViewById(R.id.inputC);
        assertNotNull(mInputC);
    }

    /**
     * Test 10
     * Test to see if the "Calculate" Button
     * Test 11
     * Test to see if the "Calculate" button has the right text
     */
    public void testCalculateButton(){
        mCalculate = (Button)activity.findViewById(R.id.calculate);

        //Test 10
        assertNotNull(mCalculate);

        //Test 11
        assertEquals("Calculate", mCalculate.getText().toString());
    }

    /**
     * Test 12
     * Test to see if TextView for result exists
     * Test 13
     * Test to see if the TextView for result has the right text
     */
    public void testResultTextView(){
        TextView mResultTextView = (TextView)activity.findViewById(R.id.result_title);

        //Test 12
        assertNotNull(mResultTextView);

        //Test 13
        assertEquals("Result:", mResultTextView.getText().toString());
    }
}