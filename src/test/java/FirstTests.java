import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.BagPriority;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class FirstTests {

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
       /* SelenideLogger.addListener("AllureSelenide", new AllureSelenide());*/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        Configuration.browser="chrome";
        Configuration.browserSize="1600x1000";
    }

  @Test
    public void loginAsRegisteredUser() throws Exception {
        LoginPage loginPage = open("https://app.qase.io/login",LoginPage.class);
        loginPage.enterLogin("artur@artfriday.ru");
        loginPage.enterPassword("qwerty123");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }
    @Test
    public void openProjects(){
        LoginPage loginPage = open("https://app.qase.io/login",LoginPage.class);
        loginPage.enterLogin("artur@artfriday.ru");
        loginPage.enterPassword("qwerty123");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = dashboardPage.openMyProjects();
        projectDashboardPage.checkProjectDashboardPage();
    }


    @Test
    public void createCard(){
        CardData issue = new CardData("test2","test description");
        UserData login = new UserData("artur@artfriday.ru","qwerty123");
        LoginPage loginPage = open("https://app.qase.io/login",LoginPage.class);
        loginPage.enterLogin(login.getUserName());
        loginPage.enterPassword(login.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectDashboardPage projectDashboardPage = dashboardPage.openMyProjects();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.clickAddNewIssue();
        issuesPage.checkIssuesPage();
        issuesPage.AddNewIssue(issue.getCardName(), issue.getCardDescription());
        issuesPage.checkIssueAdded(issue.getCardName());

    }


    @AfterMethod
    public void tearDown() throws Exception {
       close();

    }


}
