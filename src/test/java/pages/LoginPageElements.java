package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

public  class LoginPageElements extends BaseClass {

    @FindBy(id="txtUsername")
    public WebElement userNametextBox;

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement passwordTextBox;

    @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "divLogo")
    public WebElement syntaxLogo;

    @FindBy(xpath = "//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']")
    public WebElement SyntaxLogo;

    @FindBy (id = "spanMessage")
    public WebElement spanMessage;

    @FindBy(id = "logInPanelHeading")
    public WebElement LoglogInPanelHeading;

    public LoginPageElements(){
        PageFactory.initElements(driver, this);
    }
}
