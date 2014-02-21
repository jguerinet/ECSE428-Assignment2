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
    private TextView mInputATitle, mInputBTitle;
    private EditText mInputA;

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
     */
    public void testInputATextViewExistence(){
        mInputATitle = (TextView)activity.findViewById(R.id.inputA_title);
        assertNotNull(mInputATitle);
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
}