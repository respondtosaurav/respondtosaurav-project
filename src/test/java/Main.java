import java.io.IOException;

import com.webpage.Login;

public class Main {
    public static void main(String[] args) throws IOException {
        //GenricUtil genricUtil = new GenricUtil();
        // String userDir = System.getProperty("user.dir");
        // System.out.println(userDir);
        //genricUtil.openBrowser();
        //genricUtil.login();
        //genricUtil.closeBrowser();

        Login login = new  Login();
        login.clickonloginbutton("loginButton");
        login.selectUserType("selectUserType");
        login.selectUserType("b2bUser");
    }
}
