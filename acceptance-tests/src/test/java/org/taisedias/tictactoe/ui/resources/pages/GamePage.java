package org.taisedias.tictactoe.ui.resources.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GamePage {
    public static final String HOME_URL = "http://localhost:3000/tic-tac-toe";
    private WebDriver driver = new FirefoxDriver();

    public void access() {
        driver.get(HOME_URL);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
