package com.javafxmysql.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button cancelBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Label loginMessage;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private ImageView mainImageView;
    @FXML
    private ImageView padlockImageView;



    // Interface Initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File mainImageFile = new File("src/main/resources/com/javafxmysql/login/mobilePic.png"); // Path to pic
        Image mainImage = new Image(mainImageFile.toURI().toString()); // Assign pic URI to this Image
        mainImageView.setImage(mainImage); // Apply to main image view

        File padlockImageFile = new File("src/main/resources/com/javafxmysql/login/padlock.png"); // Do same for padlock pic view
        Image padlockImage = new Image(padlockImageFile.toURI().toString());
        padlockImageView.setImage(padlockImage);

    }

    // Login button method, prompts sufficient or insufficient user input
    public void loginBtnAction(ActionEvent e) {
        // If login textfields are not blank change label
        if (!usernameTextfield.getText().isBlank() && !passwordTextfield.getText().isBlank()) {
            loginMessage.setText("Login attempt...");
            loginValidation();
        } else {
            loginMessage.setText("Please type in username and password");
        }

    }

    // Validate
    public void loginValidation(){
        // Create object from DBconnection class
        DatabaseConnection connect = new DatabaseConnection();
        // Get dbLink from DBconnection class method
        Connection connectDB = connect.getConnection();

        // Use user input to finish the query
        String loginVerification = "select count(*) from account where username = \"" + usernameTextfield.getText() +
                "\" and password = \"" + passwordTextfield.getText() + "\";";

        try {
            // Use the queries in the connected DB, i.e. accessing values in records & columns in tables
            Statement statement = connectDB.createStatement(); // Set up statement
            // Execute statement (query); ResultSet stores returned queries
            ResultSet queryResult = statement.executeQuery(loginVerification);

            while (queryResult.next()) {
                // If returned hit is 1, i.e. a user/password exist in account table
                if (queryResult.getInt(1) == 1) {
                    loginMessage.setText("Successful login");
                    // Possible improvement: present another fxml page to logged-in user
                } else {
                    loginMessage.setText("Failed login");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    // Cancel method, applied to cancel button, closes stage
    public void cancelBtnAction(ActionEvent e) {
    Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
}

}