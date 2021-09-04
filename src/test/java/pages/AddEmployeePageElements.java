package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass{
    //menu_pim_viewPimModule
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement menu_pim_viewPimModule;
    //menu_pim_addEmployee
    @FindBy(id="menu_pim_addEmployee")
    public WebElement menu_pim_addEmployee;
    //firstName
    @FindBy(id="firstName")
    public WebElement firstName;
    //lastName
    @FindBy(id="lastName")
    public WebElement lastName;

    //chkLogin
    @FindBy(id="chkLogin")
    public WebElement chkLogin;

    //user_name
    @FindBy(id="user_name")
    public WebElement user_name;

    //user_password
    @FindBy(id="user_password")
    public WebElement user_password;
    //re_password
    @FindBy(id="re_password")
    public WebElement re_password;
    //btnSave
    @FindBy(id="btnSave")
    public WebElement btnSave;

    //profile-pic
    @FindBy(id="profile-pic")
    public WebElement profilePic;

    //menu_pim_viewEmployeeList
    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeList;

    //empsearch_employee_name_empName
    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearch;

    //empsearch_id
    @FindBy(id="empsearch_id")
    public WebElement empsearch_id;

    //searchBtn
    @FindBy(id="searchBtn")
    public WebElement searchBtn;


    public AddEmployeePageElements(){
        PageFactory.initElements(driver, this);
    }
}
