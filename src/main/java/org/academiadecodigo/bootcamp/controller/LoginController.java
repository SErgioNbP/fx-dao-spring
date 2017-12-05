package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the login view
 */
public class LoginController implements Controller {

    private static final String NAME = "login";

    @FXML
    GridPane gridPane;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    TextField emailField;

    @FXML
    Label emailLabel;

    @FXML
    Button loginButton;

    @FXML
    Label registerLabel;

    @FXML
    Label errorLabel;

    private UserService userService;

    private boolean login = true;

    public static String getName() {
        return NAME;
    }

    public void initialize() {

        userService = (UserService) ServiceRegistry.getServiceRegistry().getService(UserService.class.getSimpleName());
        showLogin();

    }

    private void showLogin() {

        login = true;

        errorLabel.setVisible(false);

        gridPane.getChildren().remove(emailField);
        gridPane.getChildren().remove(emailLabel);

        loginButton.setText("Login");
        registerLabel.setText("Register");

    }

    private void showRegister() {

        login = false;

        errorLabel.setVisible(false);

        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);

        loginButton.setText("Submit");
        registerLabel.setText("Cancel");

    }

    private void doLogin() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (!userService.authenticate(usernameField.getText(), passwordField.getText())) {
            showConsoleText("authentication failed");
            return;
        }

        showConsoleText("login accepted");
        Navigation.getInstance().loadScreen(MainController.getName());

    }

    private void doRegister() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (emailField.getText().isEmpty()) {
            showConsoleText("email missing");
            return;
        }

        if (userService.findByName(usernameField.getText()) != null) {
            showConsoleText("username taken");
            return;
        }

        User user = new User();
        user.setUsername(usernameField.getText());
        user.setPassword(Security.getHash(passwordField.getText()));
        user.setEmail(emailField.getText());
        userService.addUser(user);

        if (userService.findByName(usernameField.getText()) == null) {
            showConsoleText("registration failed");
            return;
        }

        showLogin();
        showConsoleText("registration successful");

    }

    private void showConsoleText(String text) {

        errorLabel.setText("console.log(\"" + text + "\");");
        errorLabel.setVisible(true);

    }

    public void onButton(ActionEvent event) {

        if (login) {
            doLogin();
        } else {
            doRegister();
        }

    }

    public void onLink(MouseEvent event) {

        if (login) {
            showRegister();
        } else {
            showLogin();
        }

    }

}
