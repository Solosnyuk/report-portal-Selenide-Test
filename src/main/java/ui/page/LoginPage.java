package ui.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    SelenideElement usernameField = $(".inputOutside__input--Ad7Xu");
    SelenideElement passwordField = $("input[placeholder='Password']");
    SelenideElement loginButton = $x("//button[text()='Login' and @type='submit']");

    public void setLogin(String login) {
        usernameField.clear();
        usernameField.setValue(login);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.setValue(password);
    }

    public void clickSetSignInButton() {
        loginButton.click();
    }

    public LaunchesPage login(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickSetSignInButton();

        return new LaunchesPage();
    }
}
