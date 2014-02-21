package ca.mcgill.amt;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

/**
 * Author: Julien Guerinet
 * Test Activity to test MainActivity in the ca.mcgill.amt packages
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;
    private TextView mInputATitle;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    /**
     * Test to see if the TextView for input A exists
     */
    public void testInputATextViewExistence(){
        mInputATitle = (TextView)activity.findViewById(R.id.inputA_title);
        assertNotNull(mInputATitle);
    }
}