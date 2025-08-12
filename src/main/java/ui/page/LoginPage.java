package ui.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    static SelenideElement usernameField = $(".inputOutside__input--Ad7Xu");
    static SelenideElement passwordField = $("input[placeholder='Password']");
    static SelenideElement loginButton = $x("//button[text()='Login' and @type='submit']");

    public static void setLogin(String login) {
        usernameField.clear();
        usernameField.setValue(login);
    }

    public static void setPassword(String password) {
        passwordField.clear();
        passwordField.setValue(password);
    }

    public static void clickSetSignInButton() {
        loginButton.click();
    }

    public static void login(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickSetSignInButton();
    }
}
