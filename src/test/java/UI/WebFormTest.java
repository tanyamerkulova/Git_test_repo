package UI;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.demoqa.WebFormPage;

public class WebFormTest extends BaseTest {

    private WebFormPage webFormPage;


    @BeforeClass
    public void setup() {
        webFormPage = new WebFormPage(driver);
    }

    @Test(description = "Открыть страницу")
    public void step_01() {
        webFormPage.openWebFormPage();
    }

    @Test(description = "Text input")
    public void step_02() {
        String fullName = "Меркулова Татьяна Сергеевна";
        webFormPage.TextInput(fullName);
        Assert.assertTrue(webFormPage.isTextInputDisplayed(), "Текстовое поле не отображается");
    }

    @Test(description = "TextArea")
    public void step_03() {
        String companyName = "компания";
        webFormPage.TextArea1(companyName);
    }

    @Test(description = "Password")
    public void step_04() {
        String password = "Password";
        webFormPage.Password(password);
        Assert.assertTrue(webFormPage.isPasswordDisplayed(), "Поле для пароля не отображается");
    }

    @Test(description = "Значение two в выпадающем списке")
    public void step_05() {
        webFormPage.setSecondDropdown();
    }

    @Test(description = "Dropdown (datalist) = 'Seattle'")
    public void step_06() {
        String datalistValue = "Seattle";
        webFormPage.setDatalistValue(datalistValue);
    }

    @Test(description = "оба чекбокса - true")
    public void step_07() {
        webFormPage.setCheckboxesTrue();
        Assert.assertTrue(webFormPage.areCheckboxesChecked(), "Чекбоксы не установлены в true");
    }

    @Test(description = "Default radio")
    public void step_08() {
        webFormPage.selectRadioButton();
        Assert.assertTrue(webFormPage.getRadioButton("Default radio"), "Радиокнопка не выбрана");
    }

    @Test(description = "Submit и проверить результат")
    public void step_09() {
        webFormPage.clickSubmit();
        Assert.assertEquals(webFormPage.getSuccessHeaderText(), "Form submitted", "Заголовок не совпадает");
        Assert.assertEquals(webFormPage.getResultParagraphText(), "Received!", "Сообщение не совпадает");
    }



}
