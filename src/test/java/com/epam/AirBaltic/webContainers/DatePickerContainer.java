package com.epam.AirBaltic.webContainers;

import org.openqa.selenium.*;

public final class DatePickerContainer {

    private static final By SK_CONTROLLER = By.xpath("/a[@class='needsclick soft-keyboard-controller']");
    private static final By FIELD_INPUT_DATE = By.xpath("/input[@id='flt_returning_on']");
    private static final By DD_DATE_PICKER = By.xpath("/div[contains(@class, 'input-group')]");

    private WebElement element;
    private WebElement fieldInputDate;
    private WebElement skController;
    private WebElement ddDatePicker;
    //private

    public DatePickerContainer(WebElement ele) {
        this.element = ele;
        this.skController = ele.findElement(SK_CONTROLLER);
        this.fieldInputDate = ele.findElement(FIELD_INPUT_DATE);
        this.ddDatePicker = ele.findElement(DD_DATE_PICKER);
    }

    public String getValue() {
        return element.getAttribute("value").toString();
    }

    public void setValue(String val) {
        this.fieldInputDate.clear();
        this.fieldInputDate.sendKeys(val);
    }

    public void clickSKController () {
        this.skController.click();
    }

    public boolean isDatePickerDisplayed() {
        return ddDatePicker.isDisplayed();
    }


    public void click() {
        fieldInputDate.click();
    }

    public void submit() {
        fieldInputDate.submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        fieldInputDate.sendKeys(charSequences);
    }

    public void clear() {
        fieldInputDate.clear();
    }

    public String getAttribute(String s) {
        return fieldInputDate.getAttribute(s);
    }

    public boolean isEnabled() {
        return fieldInputDate.isEnabled();
    }

    public String getText() {
        return fieldInputDate.getText();
    }

    public Dimension getSize() {
        return fieldInputDate.getSize();
    }

    public Rectangle getRect() {
        return fieldInputDate.getRect();
    }


}
