package testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigsReader;
import utils.Constants;
import utils.excelUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginTest extends CommonMethods {

    @Test(groups = "SmokeTest")
    public void validLogin() {
        sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
        sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
        click(login.loginBtn);
        Assert.assertTrue(dash.welcome.isDisplayed());
    }

    @Test(groups = "regression", dataProvider = "getData") // Negative Test
    public void invalidLogin(String username, String password, String errorMsg) {
        sendText(login.userNametextBox, username);
        sendText(login.passwordTextBox, password);
        click(login.loginBtn);
        System.out.println(login.spanMessage.getText());
        Assert.assertEquals(login.spanMessage.getText(), errorMsg);
    }

    @DataProvider
    public Object[] getData() {
        Object[][] data = {
                {"", "admin123", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "admin122", "Invalid credentials"}
        };
        return data;
    }

    @Test(groups = "add", dataProvider = "setData")
    public void addLogin(String firstName, String lastName, String str3) throws InterruptedException {
        // Login
        sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
        sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
        click(login.loginBtn);
        // PIM - addEmployee - fill out form - save
        click(addEmp.menu_pim_viewPimModule);
        click(addEmp.menu_pim_addEmployee);
        sendText(addEmp.firstName, firstName);
        sendText(addEmp.lastName, lastName);
        String emploID = driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println(emploID);
        click(addEmp.chkLogin);
Thread.sleep(10000);
        sendText(addEmp.user_name, firstName + "-" + lastName);
        sendText(addEmp.user_password, str3);
        sendText(addEmp.re_password, str3);
        Thread.sleep(10000);
        click(addEmp.btnSave);
        //    Assert.assertEquals(addEmp.profilePic.getText(),str1+" "+str2);
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();

        sendText(addEmp.empsearch_id, emploID);
        click(addEmp.searchBtn);

        driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[1]")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("screenshot/succesfully.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[] setData() {
        Object[][] data = {
                {"davaca", "mouse", "DDdawdwawd2123cc212"},
        };
        return data;
    }

    @Test(groups = "hello")
    public void addMultipleEmployee() {
        sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
        sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
        click(login.loginBtn);

        addEmp.menu_pim_viewPimModule.click();
        addEmp.menu_pim_addEmployee.click();
        System.out.println("merhabaaa");
        List<Map<String, String>> empList = excelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, "addEmp");

        for (Map<String, String> map : empList) {
            addEmp.menu_pim_addEmployee.click();
            System.out.println("merhbaaa");
            String firstName = map.get("FirstName");
            String lastName = map.get("LastName");
            System.out.println(firstName);
            System.out.println(lastName);
            sendText(addEmp.firstName, "dawdawd");
            sendText(addEmp.lastName, lastName);
            click(addEmp.btnSave);
        }
    }

}
