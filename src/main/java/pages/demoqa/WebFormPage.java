package pages.demoqa;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class WebFormPage extends BasePage {

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_WEB_FORM_PAGE = "https://www.selenium.dev/selenium/web/web-form.html";

    private static final String TEXT_INPUT = "//input[@name='my-text']";
    private static final String PASSWORD = "//input[@name='my-password']";
    private static final String TEXTAREA = "//html/body/main/div/form/div/div[1]/label[3]/textarea";
    private static final String DROPDOWN_SELECT = "//select[@name='my-select']";
    private static final String DROPDOWN_DATALIST = "//input[@name='my-datalist']";
    private static final String CHECKED_CHECK_BOX = "//input[@id='my-check-1']";
    private static final String DEFAULT_CHECK_BOX = "//input[@id='my-check-2']";
    private static final String RADIO_BUTTON = "//input[@id='my-radio-2']";
    private static final String DROPDOWN_SECOND_SELECT = "//select[@name='my-select']/option[. = 'Two']";
    private static final String SUBMIT_BUTTON = "//button[@type='submit']";
    private static final String SUCCESS_HEADER = "//h1[text()='Form submitted']";
    private static final String RESULT_PARAGRAPH = "//p[@id='message' and text()='Received!']";


    public void openWebFormPage() {
        openUrl(URL_WEB_FORM_PAGE);
    }

    public void TextInput(String text) {
        sendKeys(By.xpath(TEXT_INPUT), text);
    }

    public void TextArea1(String text) {
        sendKeys(By.xpath(TEXTAREA), text);
    }

    public void Password(String text) {
        sendKeys(By.xpath(PASSWORD), text);
    }

    public boolean isTextInputDisplayed() {
        return isElementDisplay(By.xpath(TEXT_INPUT));
    }

    public boolean isTextAreaDisplayed() {
        return isElementDisplay(By.xpath(TEXTAREA));
    }

    public boolean isPasswordDisplayed() {
        return isElementDisplay(By.xpath(PASSWORD));
    }

    public void setSecondDropdown(){
        click(By.xpath(DROPDOWN_SECOND_SELECT));
    }

    public void setDatalistValue(String text) {
        sendKeys(By.xpath(DROPDOWN_DATALIST), text);
    }

    public boolean getCheckBox(By checkBoxLocator) {
        return findElement(checkBoxLocator).isSelected();
    }

    public void setCheckBox(By checkBoxLocator, boolean state) {
        if (getCheckBox(checkBoxLocator) != state) {
            click(checkBoxLocator);
        }
    }

    public void setCheckboxesTrue() {
        setCheckBox(By.xpath(CHECKED_CHECK_BOX), true);
        setCheckBox(By.xpath(DEFAULT_CHECK_BOX), true);
    }

    public boolean areCheckboxesChecked() {
        return getCheckBox(By.xpath(CHECKED_CHECK_BOX)) &&
                getCheckBox(By.xpath(DEFAULT_CHECK_BOX));
    }

    public void selectRadioButton() {
        click(By.xpath(RADIO_BUTTON));
    }

    public boolean getRadioButton(String RadioButton){
        return findElement(By.xpath(String.format(RADIO_BUTTON, RadioButton))).isSelected();
    }

    public void clickSubmit() {
        click(By.xpath(SUBMIT_BUTTON));
    }

    public String getSuccessHeaderText() {
        return getText(By.xpath(SUCCESS_HEADER));
    }

    public String getResultParagraphText() {
        return getText(By.xpath(RESULT_PARAGRAPH));
    }
}
