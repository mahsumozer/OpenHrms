package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

public class DashboardPageElements extends BaseClass {

    @FindBy(xpath="(//li[@class = 'main-menu-first-level-list-item'])[1]")
    public WebElement Db_Admin;

    @FindBy(id = "menu_admin_UserManagement")
    public WebElement Db_Admin_User_Management;

    @FindBy(id="menu_admin_viewSystemUsers")
    public WebElement Db_Admin_User_Management_Users;
    //id="welcome"
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    public WebElement welcome;
    public DashboardPageElements(){
        PageFactory.initElements(driver, this);
    }
}
