package klikker;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KnopView {
	// het maken van het help scherm.
    public void knopScherm() {
        Stage stage = new Stage();
        stage.setTitle("Klikker");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 320, 150);
        Label rules = new Label();
        setTopAnchor(rules, 30.0);
        setLeftAnchor(rules, 30.0);
        rules.setText("Welkom bij Klikker. \n"
        		+ "gemaakt door Damian, Daniël & Jaimy.");
        
        //Uitleg knop
        Button spelspelenknop = new Button("SPEL SPELEN");
        spelspelenknop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
//            	knopScherm();

            }
        });
        spelspelenknop.setStyle("-fx-base: #ffffff;");
        spelspelenknop.setPrefHeight(30.0);
        spelspelenknop.setPrefWidth(260.0);
        
        setTopAnchor(spelspelenknop, 100.0);
        setLeftAnchor(spelspelenknop, 30.0);
        welcomeScreen.getChildren().addAll(rules, spelspelenknop);
        stage.setScene(scene);
        stage.show();


    }
}
