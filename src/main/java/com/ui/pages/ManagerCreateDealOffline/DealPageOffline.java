package com.ui.pages.ManagerCreateDealOffline;

import com.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DealPageOffline extends BasePage {
    private final By attachContractInput = By.xpath("//body/div[@id='app']/div[36]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]");
    private final By partnerLinkInput = By.xpath("//input[@aria-label='Partner link']");
    private final By contractNameInput = By.xpath("//input[@aria-label='Contract name']");
    private final By addFormatButton = By.xpath("//button/div[contains(.,' Ad format ')]");
    private final By startDateInput = By.xpath("//input[@aria-label='Start date']");
    private final By endDateInput = By.xpath("//input[@aria-label='End date']");
    private final By selectPlaceInput = By.xpath("//input[@aria-label='Select place']");
    private final By volumePerMonthInput = By.xpath("//input[@aria-label='Volume per month']");
    private final By numbersInput = By.xpath("//input[@aria-label='Numbers']");
    private final By totalVolumeInput = By.xpath("//input[@aria-label='Total volume']");
    private final By costInput = By.xpath("//input[@aria-label='Cost']");
    private final By saveFormatButton = By.xpath("//button/div[contains(.,'Save')]");
    private final By contractResultsInput = By.xpath("//span[contains(text(),'Browse')]");
    private final By saveResultsButton = By.xpath("//button/div[contains(.,'Save results')]");
    private final By newPaymentButton = By.xpath("//button/div[contains(.,' New payment ')]");
    private final By selectContractIdInput = By.xpath("//input[@aria-label='Select contract id']");
    private final By selectBookkeepingTypeInput = By.xpath("//input[@aria-label='Select bookkeeping type']");
    private final By walletNameInput = By.xpath("//input[@aria-label='Wallet name']");
    private final By savePaymentButton = By.xpath("//button/div[contains(.,'Save payment')]");
    private final By saveDealButton = By.xpath("//button/div[contains(.,'save')]");
    private final By sendOnReviewButton = By.xpath("//button/div/span[contains(.,'send on review')]");
    private final By profileButton = By.xpath("//button[@id='profile_btn']");
    private final By exitButton = By.xpath("//a[@id='exit_btn']");

    public DealPageOffline(WebDriver webDriver) {
        super(webDriver);
    }

    public DealPageOffline inputAttachContract(String contract) {
        findElement(webDriver, attachContractInput).sendKeys("C:\\Users\\aberz\\Downloads\\contract.txt");
        return this;
    }

    public DealPageOffline inputPartnerLink(String link) {
        findElement(webDriver, partnerLinkInput).sendKeys("https://fluffy.com");
        return this;
    }

    public DealPageOffline inputContractName(String name) {
        findElement(webDriver, contractNameInput).sendKeys("fluffy");
        return this;
    }

    public DealPageOffline clickOnAddFormatButton() {
        findElement(webDriver, addFormatButton).click();
        return this;
    }

    public DealPageOffline inputStartDate(String date) {
        findElement(webDriver, startDateInput).sendKeys("2022-01-01");
        return this;
    }

    public DealPageOffline inputEndDate(String date) {
        findElement(webDriver,endDateInput).sendKeys("2022-02-01" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputSelectPlace(String place) {
        findElement(webDriver, selectPlaceInput).sendKeys("Print" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputVolumePerMonth(String volume) {
        findElement(webDriver, volumePerMonthInput).sendKeys("12345");
        return this;
    }

    public DealPageOffline inputNumbers(String numbers) {
        findElement(webDriver, numbersInput).sendKeys("100");
        return this;
    }

    public DealPageOffline inputTotalVolume(String volume) {
        findElement(webDriver, totalVolumeInput).sendKeys("100000");
        return this;
    }

    public DealPageOffline inputCost(String cost) {
        findElement(webDriver, costInput).sendKeys("10");
        return this;
    }

    public DealPageOffline clickOnSaveFormatButton() {
        findElement(webDriver, saveFormatButton).click();
        return this;
    }

    public DealPageOffline inputContractResults(String results) {
        findElement(webDriver, contractResultsInput)
                .sendKeys("C:\\\\Users\\\\aberz\\\\Downloads\\\\contract.txt\"");
        return this;
    }

    public DealPageOffline clickOnSaveResultsButton() {
        findElement(webDriver, saveResultsButton).click();
        return this;
    }

    public DealPageOffline clickOnNewPaymentButton() {
        findElement(webDriver, newPaymentButton).click();
        return this;
    }

    public DealPageOffline inputContractId(String id) {
        findElement(webDriver, selectContractIdInput).sendKeys("" + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputBookkeepingType(String type) {
        findElement(webDriver, selectBookkeepingTypeInput).sendKeys("client" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputStartDatePayment(String date) {
        findElement(webDriver, startDateInput).sendKeys("2022-01-01" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputEndDatePayment(String date) {
        findElement(webDriver, endDateInput).sendKeys("2022-02-01" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputWalletName(String wallet) {
        findElement(webDriver, walletNameInput).sendKeys("in" + Keys.ENTER);
        return this;
    }

    public DealPageOffline inputCostPayment(String cost) {
        findElement(webDriver, costInput).sendKeys("100");
        return this;
    }

    public DealPageOffline clickOnSavePaymentButton() {
        findElement(webDriver, savePaymentButton).click();
        return this;
    }

    public DealPageOffline clickOnSaveDealButton() {
        findElement(webDriver, saveDealButton).click();
        return this;
    }

    public DealPageOffline clickOnSendOnReviewButton() {
        findElement(webDriver, sendOnReviewButton).click();
        return this;
    }

    public DealPageOffline clickOnProfileButton() {
        findElement(webDriver, profileButton).click();
        return this;
    }

    public DealPageOffline clickOnExitButton() {
        findElement(webDriver, exitButton).click();
        return this;
    }
}
