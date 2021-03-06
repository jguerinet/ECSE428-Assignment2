package ca.mcgill.amt;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Julien Guerinet
 * Test Activity to test MainActivity in the ca.mcgill.amt packages
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mActivity;
    private EditText mInputA, mInputB, mInputC;
    private Button mCalculate;
    private TextView mResult;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();

        //Set up the needed TextViews, Buttons, and EditTexts
        mInputA = (EditText) mActivity.findViewById(R.id.inputA);
        mInputB = (EditText) mActivity.findViewById(R.id.inputB);
        mInputC = (EditText) mActivity.findViewById(R.id.inputC);
        mCalculate = (Button) mActivity.findViewById(R.id.calculate);
        mResult = (TextView) mActivity.findViewById(R.id.result);
    }

    /**
     * Test 1
     * Test to see if the TextView for input A exists
     * Test 7
     * Test to see if the TextView for input A has the right text
     */
    public void testInputATextView(){
        TextView mInputATitle = (TextView) mActivity.findViewById(R.id.inputA_title);

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
        assertNotNull(mInputA);
    }

    /**
     * Test 3
     * Test to see if the TextView for input B exists
     * Test 8
     * Test to see if the TextView for input B has the right text
     */
    public void testInputBTextView(){
        TextView mInputBTitle = (TextView) mActivity.findViewById(R.id.inputB_title);

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
        assertNotNull(mInputB);
    }

    /**
     * Test 5
     * Test to see if the TextView for Input C exists
     * Test 9
     * Test to see if the TextView for input C has the right text
     */
    public void testInputCTextView(){
        TextView mInputCTitle = (TextView) mActivity.findViewById(R.id.inputC_title);

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
        assertNotNull(mInputC);
    }

    /**
     * Test 10
     * Test to see if the "Calculate" Button
     * Test 11
     * Test to see if the "Calculate" button has the right text
     */
    public void testCalculateButton(){
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
        TextView mResultTextView = (TextView) mActivity.findViewById(R.id.result_title);

        //Test 12
        assertNotNull(mResultTextView);

        //Test 13
        assertEquals("Result:", mResultTextView.getText().toString());
    }

    /**
     * Test 14
     * Test to see if the TextView for the calculated result exists
     */
    public void testResultExistence(){
        assertNotNull(mResult);
    }

    /**
     * Test 15
     * Test to see the result output when no value is inputted for side A
     */
    @UiThreadTest
    public void testNoAValue(){
        //Click on the Calculate button
        mCalculate.performClick();

        assertEquals("Error: Please input a value for side A", mResult.getText().toString());
    }

    /**
     * Test 16
     * Test to see the result output when no value is inputted for side B
     */
    @UiThreadTest
    public void testNoBValue(){
        //Set a value for A
        mInputA.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Please input a value for side B", mResult.getText().toString());
    }

    /**
     * Test 17
     * Test to see the result output when no value is inputted for side C
     */
    @UiThreadTest
    public void testNoCValue(){
        //Set values for A and B
        mInputA.setText("2");
        mInputB.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Please input a value for side C", mResult.getText().toString());
    }

    /**
     * Test 18
     * Test to see the result output when one of the values is not a number.
     */
    @UiThreadTest
    public void testInvalidInputType(){
        //Set an invalid input type for A
        mInputA.setText("Invalid");
        mInputB.setText("2");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Please input whole numbers only", mResult.getText().toString());

        //Set an invalid input type for B
        mInputA.setText("2");
        mInputB.setText("D");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Please input whole numbers only", mResult.getText().toString());

        //Set an invalid input type for C
        mInputA.setText("2");
        mInputB.setText("2");
        mInputC.setText(".");
        mCalculate.performClick();

        assertEquals("Error: Please input whole numbers only", mResult.getText().toString());
    }

    /**
     * Test 19
     * Test to see the result output when 0 or a negative number is inputted
     */
    @UiThreadTest
    public void testLowerBound(){
        //Set A to a negative number
        mInputA.setText("-3");
        mInputB.setText("2");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 1 or larger", mResult.getText().toString());

        //Set B to 0
        mInputA.setText("2");
        mInputB.setText("0");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 1 or larger", mResult.getText().toString());

        //Set C to negative number
        mInputA.setText("2");
        mInputB.setText("2");
        mInputC.setText("-134");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 1 or larger", mResult.getText().toString());
    }

    /**
     * Test 20
     * Test to see the result output when numbers bigger than 100 are inputted
     */
    @UiThreadTest
    public void testUpperBound(){
        //Set A to a number bigger than 100
        mInputA.setText("101");
        mInputB.setText("2");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 100 or smaller", mResult.getText().toString());

        //Set B to a number bigger than 100
        mInputA.setText("2");
        mInputB.setText("10000");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 100 or smaller", mResult.getText().toString());

        //Set C to a number bigger than 100
        mInputA.setText("2");
        mInputB.setText("2");
        mInputC.setText("134");
        mCalculate.performClick();

        assertEquals("Error: Numbers need to be 100 or smaller", mResult.getText().toString());
    }

    /**
     * Test 21
     * Test to see the ouput when the numbers given does not form a triangle
     */
    @UiThreadTest
    public void testTriangleExistence(){
        //Set A to be more than the sum of the other 2 sides
        mInputA.setText("100");
        mInputB.setText("2");
        mInputC.setText("5");
        mCalculate.performClick();

        assertEquals("Error: Numbers inputted do not form a triangle", mResult.getText().toString());

        //Set B to be more than the sum of the other 2 sides
        mInputA.setText("50");
        mInputB.setText("56");
        mInputC.setText("5");
        mCalculate.performClick();

        assertEquals("Error: Numbers inputted do not form a triangle", mResult.getText().toString());

        //Set A to be more than the sum of the other 2 sides
        mInputA.setText("1");
        mInputB.setText("1");
        mInputC.setText("3");
        mCalculate.performClick();

        assertEquals("Error: Numbers inputted do not form a triangle", mResult.getText().toString());
    }

    /**
     * Test 22
     * Test to see the output for a scalene triangle input
     */
    @UiThreadTest
    public void testScaleneTriangle(){
        //Set A, B, and C to be different numbers
        mInputA.setText("2");
        mInputB.setText("3");
        mInputC.setText("4");
        mCalculate.performClick();

        assertEquals("Scalene Triangle", mResult.getText().toString());
    }

    /**
     * Test 23
     * Test to see the output for an equilateral triangle
     */
    @UiThreadTest
    public void testEquilateralTriangle(){
        //Set A, B, and C to the same number
        mInputA.setText("2");
        mInputB.setText("2");
        mInputC.setText("2");
        mCalculate.performClick();

        assertEquals("Equilateral Triangle", mResult.getText().toString());
    }

    /**
     * Test 24
     * Test to see the output for a isosceles triangle
     */
    @UiThreadTest
    public void testIsoscelesTriangle(){
        //Set A and B to the same number
        mInputA.setText("2");
        mInputB.setText("2");
        mInputC.setText("3");
        mCalculate.performClick();

        assertEquals("Isosceles Triangle", mResult.getText().toString());

        //Set C and B to the same number
        mInputA.setText("5");
        mInputB.setText("6");
        mInputC.setText("6");
        mCalculate.performClick();

        assertEquals("Isosceles Triangle", mResult.getText().toString());

        //Set A and B to the same number
        mInputA.setText("7");
        mInputB.setText("10");
        mInputC.setText("7");
        mCalculate.performClick();

        assertEquals("Isosceles Triangle", mResult.getText().toString());
    }
}