/*
package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.time.LocalDate;

public class listener implements ITestListener {
    public void onTestSuccess(ITestResult result){
        CommonMethods.takeScreenShot("passed/"+result.getTestName()+"-"+LocalDate.now() +".png");
    }

    public void onTestFailure(ITestResult result){
        CommonMethods.takeScreenShot("failed\\"+result.getName());
    }
}*/
//ec2-54-88-118-39.compute-1.amazonaws.com
package utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.time.LocalDateTime;
public class listener extends TestListenerAdapter {

    public void onTestSuccess(ITestResult result){
        CommonMethods.takeScreenShot("passed/"+ CommonMethods.getTime() +"--"+ result.getName()+".png");
    }

    public void onTestFailure(ITestResult result){
        CommonMethods.takeScreenShot("failed/"+LocalDateTime.now() +"--"+ result.getName()+".png");
    }


}