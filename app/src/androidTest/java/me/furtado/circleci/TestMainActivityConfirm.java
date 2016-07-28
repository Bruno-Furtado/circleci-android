package me.furtado.circleci;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.robotium.solo.Solo;

/**
 * Created by bfurtado on 28/07/16.
 */
public class TestMainActivityConfirm extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo mSolo;

    public TestMainActivityConfirm() throws Exception {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mSolo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        mSolo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRun() {
        assertTrue("MainActivity not found", mSolo.waitForActivity(MainActivity.class));

        View button = mSolo.getView(R.id.button);
        String confirmText = mSolo.getString(R.string.confirm);

        mSolo.clickOnView(button);
        mSolo.clickOnText(confirmText);

        assertTrue(mSolo.waitForText(confirmText));
    }
}
