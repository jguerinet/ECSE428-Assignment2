package ca.mcgill.amt;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Author: Julien Guerinet
 * Test Activity to test MainActivity in the ca.mcgill.amt packages
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }
}