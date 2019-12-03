import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.print.attribute.standard.OrientationRequested;

public class Bank extends Application{

    static AccountSet accounts = new AccountSet();

    public void start(Stage stage){
        stage.setTitle("Bank");

        Scene welcome = makeWelcomeScene(stage);

        // intialize

        stage.setScene(welcome);
        stage.show();
    }

    public static Scene makeWelcomeScene(Stage stage){
        //scene 1

        GridPane welcomePane = new GridPane();
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.setHgap(12);
        welcomePane.setVgap(10);

        // upper

        VBox welcomeUpper = new VBox();

        Label welcomeText = new Label("Welcome!");
        welcomeText.setStyle("-fx-font-size: 15pt;");

        Hyperlink createAccount = new Hyperlink("Create Account");

        createAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(makeAccountInfo(stage));
            }
        });

        welcomeUpper.getChildren().addAll(welcomeText, createAccount);

        Label userText = new Label("Username: ");
        TextField userField = new TextField();

        Label pinText = new Label("PIN: ");
        PasswordField pinField = new PasswordField();

        // info fields
        GridPane infoFields = new GridPane();

        infoFields.add(userText, 1, 1);
        infoFields.add(userField, 2, 1);
        infoFields.add(pinText, 1, 2);
        infoFields.add(pinField, 2, 2);

        welcomePane.add(welcomeUpper, 1, 0);
        welcomePane.add(infoFields, 1, 1);

        welcomePane.setHalignment(welcomeText, HPos.CENTER);

        // error message

        Text errorMessage = new Text("");
        errorMessage.setFill(Color.RED);
        welcomePane.add(errorMessage, 1, 2);

        // buttons

        Button logIn = new Button("Log in");

        logIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = userField.getText();
                String pin = pinField.getText();

                String message = accounts.testLoinInfo(username, pin);

                if (message.equals("Valid information")){
                    Account user = accounts.getAccount(username);

                    stage.setScene(makeMainScreen(stage, user));
                }

                else{
                    errorMessage.setText(message);
                }
            }
        });

        welcomePane.add(logIn, 2, 2);

        Scene welcome = new Scene(welcomePane, 500, 300);

        return welcome;
    }

    public static Scene makeAccountInfo(Stage stage){
        GridPane infoPane = new GridPane();
        infoPane.setAlignment(Pos.CENTER);
        infoPane.setHgap(12);
        infoPane.setVgap(10);

        Label userText = new Label("Username: ");
        Label pin1Text = new Label("PIN");
        Label pin2Text = new Label("Confirm PIN");
        Label questionText = new Label("Security Question: ");
        Label answer1Text = new Label("Answer: ");
        Label answer2Text = new Label("Confirm Answer: ");

        TextField userField = new TextField();
        PasswordField pin1Field = new PasswordField();
        PasswordField pin2Field = new PasswordField();
        TextField questionField = new TextField();
        PasswordField answer1Field = new PasswordField();
        PasswordField answer2Field = new PasswordField();

        HBox userBox = new HBox();
        HBox pin1Box = new HBox();
        HBox pin2Box = new HBox();
        HBox questionBox = new HBox();
        HBox answer1Box = new HBox();
        HBox answer2Box = new HBox();

        userBox.getChildren().addAll(userText, userField);
        pin1Box.getChildren().addAll(pin1Text, pin1Field);
        pin2Box.getChildren().addAll(pin2Text, pin2Field);
        questionBox.getChildren().addAll(questionText, questionField);
        answer1Box.getChildren().addAll(answer1Text, answer1Field);
        answer2Box.getChildren().addAll(answer2Text, answer2Field);

        VBox info = new VBox();
        info.getChildren().addAll(userBox, pin1Box, pin2Box, questionBox, answer1Box, answer2Box);

        Text errorMessage = new Text("");
        errorMessage.setFill(Color.RED);
        infoPane.add(errorMessage, 1, 2);

        infoPane.add(info, 1, 1);

        // create account button

        Button createAccount = new Button("Create Account");

        createAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = userField.getText();
                String pin1 = pin1Field.getText();
                String pin2 = pin2Field.getText();
                String question = questionField.getText();
                String answer1 = answer1Field.getText();
                String answer2 = answer2Field.getText();

                String message = accounts.testAccountInfo(username, pin1, pin2, question, answer1, answer2);

                if (message.equals("Account Created!")){
                    Account temp = new Account(username, pin1, question, answer1);
                    accounts.addAccount(temp);

                    stage.setScene(makeWelcomeScene(stage));
                }

                else{
                    errorMessage.setText(message);
                }
            }
        });

        infoPane.add(createAccount, 2, 2);

        Button cancel = new Button("Cancel");

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(makeWelcomeScene(stage));
            }
        });

        infoPane.add(cancel, 0, 2);

        Scene accountInfo = new Scene(infoPane, 500, 300);

        return accountInfo;
    }

    public static Scene makeMainScreen(Stage stage, Account user){
        BorderPane mainPane = new BorderPane();

        Scene mainScreen = new Scene(mainPane, 500, 300);

        return mainScreen;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
