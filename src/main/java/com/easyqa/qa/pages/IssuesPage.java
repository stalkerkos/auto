package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.easyqa.qa.pages.util.BagPriority;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {
    @FindBy(id = "menu-link-test-defects") //dashboard btn
    public SelenideElement issuesDfctBtn;

    @FindBy(xpath = "//a[@href='/defect/DEMO/create']")
    public SelenideElement addNewIssuesBtn;

    @FindBy(id = "title")
    public SelenideElement issueTitle;

    @FindBy(xpath = "//div[@id='undefinedGroup']/div/div/div/div[2]/div/div[2]/div/div/p")
    public SelenideElement issueResult;

    @FindBy(xpath = "//div[@id='severityGroup']/div/div/div[2]/div")
    public SelenideElement issuePrioritySelector;

    @FindBy(id = "react-select-3-option-3")
    public SelenideElement issuePriorityMajor;

    @FindBy(xpath = "//button[@type='submit']")
    public SelenideElement issueCreateBtn;

    @FindBy(className = "defect-title")
    public SelenideElement issueCard;

    @Step
    public void checkIssuesPage() {
        addNewIssuesBtn.shouldBe(Condition.appear);
    }

    @Step
    public void clickAddNewIssue() {
        issuesDfctBtn.click();
    }

    @Step
    public void setIssuePriorityMajor() {
        issuePrioritySelector.click();
        issuePriorityMajor.click();
    }

    @Step
    public void AddNewIssue(String issueName, String issueDesc){
        addNewIssuesBtn.click();
        issueTitle.click();
        issueTitle.sendKeys(issueName);

        issueResult.click();
        issueResult.sendKeys(issueDesc);
        setIssuePriorityMajor();

        issueCreateBtn.click();
    }

    @Step
    public void checkIssueAdded(String issueName){
        issueCard.shouldBe(Condition.text(issueName));
    }


 /*  @Step
    public void setPriority(BagPriority priority){

        switch(priority){
            case LOW:
                issuePrioritySelector.click();
                issuePriorityLow.click();
                break;
            case MEDIUM:
                issuePrioritySelector.click();
                issuePriorityMedium.click();
                break;
            case HIGH:
                issuePrioritySelector.click();
                issuePriorityHigh.click();
            break;
            case CRITICAL:
                issuePrioritySelector.click();
                issuePriorityCritical.click();
            break;
        }

    }
*/
}





