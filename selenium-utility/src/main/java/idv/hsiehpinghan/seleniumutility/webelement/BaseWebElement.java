package idv.hsiehpinghan.seleniumutility.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseWebElement {
    private WebDriver webDriver;
    private By by;

    protected BaseWebElement(WebDriver webDriver, By by) {
    	super();
        this.webDriver = webDriver;
        this.by = by;
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected By getBy() {
        return by;
    }
}
