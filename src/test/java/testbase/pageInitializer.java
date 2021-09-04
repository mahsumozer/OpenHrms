package testbase;

import pages.AddEmployeePageElements;
import pages.DashboardPageElements;
import pages.LoginPageElements;
import utils.CommonMethods;

public class pageInitializer extends BaseClass {
    protected static LoginPageElements login;
    protected static DashboardPageElements dash;
    protected static AddEmployeePageElements addEmp;

        public static void initializePageObjects(){
            login=new LoginPageElements();
            dash=new DashboardPageElements();
            addEmp=new AddEmployeePageElements();

        }
}
