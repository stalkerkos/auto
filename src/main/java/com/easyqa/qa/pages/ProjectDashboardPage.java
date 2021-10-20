package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProjectDashboardPage {

    @FindBy(id = "project-avatar-container")
    public SelenideElement projectOverwiew;

    @FindBy(xpath = "//span[@class='submenu-item-text']")
    public SelenideElement issuesLink;

    @Step
    public void checkProjectDashboardPage(){
        projectOverwiew.shouldBe(Condition.appear);
    }

    @Step
    public IssuesPage openIssues(){
        issuesLink.click();
        return page(IssuesPage.class);
    }


}
