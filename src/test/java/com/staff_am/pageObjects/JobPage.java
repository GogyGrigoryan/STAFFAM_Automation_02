package com.staff_am.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobPage {
    WebDriver driver;

    public JobPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Jobs')]")
    @CacheLookup
    WebElement jobs_btn;

    @FindBy(id = "jobsfilter-key_word")
    @CacheLookup
    WebElement searchInput;

    @FindBy(id = "btn_search_keyword")
    @CacheLookup
    WebElement searchBtn;

    @FindBy(className = "font_bold")
    @CacheLookup
    List<WebElement> jobTitles;

    @FindBy(xpath = "//a[@href='/en/users/registration/logout']")
    @CacheLookup
    WebElement logOut;


//_________________________________________________________

    @FindBy(linkText = "View more")
    @CacheLookup
    List<WebElement> viewMoreBtns;

    @FindBy(xpath = "//span[@class='my-filter bg-cyan']")
    @CacheLookup
    WebElement filterSenior;



    @FindBy(xpath = "//label[contains(text(),'Yerevan')]")
    @CacheLookup
    WebElement filterCityYerevan;







    public void jobBtnClick() {
        jobs_btn.click();
    }

    public void searchField(String searchTerm) {
        searchInput.sendKeys(searchTerm);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }


    public void clickViewMore() {
        viewMoreBtns.get(0).click();
    }

    public void clickSeniorBtn() {
        Actions actions = new Actions(driver);
        actions.click(filterSenior).perform();

    }

    public void clickFilterYerevan() {
        if (filterCityYerevan.isSelected()) {
            System.out.println("Filter already exist");
        } else {
            filterCityYerevan.click();
        }
    }

    public List<WebElement> getTitles() {
        return jobTitles;
    }

    public void clickLogOut() {
        logOut.click();
    }



}
