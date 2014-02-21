package ca.mcgill.amt;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Julien Guerinet
 * Test Activity to test MainActivity in the ca.mcgill.amt packages
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;
    private TextView mInputATitle, mInputBTitle, mInputCTitle;
    private EditText mInputA, mInputB, mInputC;

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
        mInputATitle = (TextView)activity.findViewById(R.id.inputA_title);

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
     */
    public void testInputBTextViewExistence(){
        mInputBTitle = (TextView)activity.findViewById(R.id.inputB_title);
        assertNotNull(mInputBTitle);
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
     */
    public void testInputCTextViewExistence(){
        mInputCTitle = (TextView)activity.findViewById(R.id.inputC_title);
        assertNotNull(mInputCTitle);
    }

    /**
     * Test 6
     * Test to see if the EditText for input C exists
     */
    public void testInputCEditTextExistence(){
        mInputC = (EditText)activity.findViewById(R.id.inputC);
        assertNotNull(mInputC);
    }
}