package GlobalFiles;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportCustomization implements ITestListener {
	@Override

    public void onStart(ITestContext test) {

         System.out.println("Start Of Execution(TEST)->"+test.getName());

    }

    @Override

    public void onTestStart(ITestResult test) {

        System.out.println("Test Started->"+test.getName());

    }

    @Override

    public void onTestSuccess(ITestResult test) {

        System.out.println("Test Pass->"+test.getName());
        try
        {
        	CommonFunctions.TakeScreenShot(test.getName());
        }
        catch(Exception e)
        {
        	
        }
        

    }

    @Override

    public void onTestFailure(ITestResult test) {

        System.out.println("Test Failed->"+test.getName());
        try
        {
        	CommonFunctions.TakeScreenShot(test.getName());
        	String exceptionMessage = "";
    		exceptionMessage = test.getThrowable().getClass().toString();
    		System.out.println(exceptionMessage);
        }
        catch(Exception e)
        {
        	
        }

    }

    @Override

    public void onTestSkipped(ITestResult test) {

        System.out.println("Test Skipped->"+test.getName());
        try
        {
        	CommonFunctions.TakeScreenShot(test.getName());
        }
        catch(Exception e)
        {
        	
        }

    }

    @Override

    public void onFinish(ITestContext test) {

System.out.println("END Of Execution(TEST)->"+test.getName());

    }

    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {

        // TODO Auto-generated method stub

        

    }



}
