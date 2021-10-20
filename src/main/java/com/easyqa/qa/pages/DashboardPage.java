package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(id = "user-menu")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='/project/DEMO']")
    public SelenideElement myProjectsLink;

    @Step
    public void checkUserAuthorized() {
        profileLink.shouldBe(Condition.appear);
    }
    @Step
    public ProjectDashboardPage openMyProjects(){
        myProjectsLink.click();
        return Selenide.page(ProjectDashboardPage.class);
    }
}
