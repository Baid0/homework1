package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    public static SelenideElement FirstName = $x("//input[@id='firstName']");
    public SelenideElement LastName = $x("//input[@id='lastName']");
    public SelenideElement Gender =$x("//label[normalize-space()='Female']");
    public SelenideElement MobileNumber =$x("//input[@id='userNumber']");
    public SelenideElement Submit = $x("//div[@class='text-right col-md-2 col-sm-12']//button");

}
