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
    	PuntenModel punten = new PuntenModel();
        punten.setPunten(0);
        
        Stage stage = new Stage();
        stage.setTitle("Klikker");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 320, 150);
        Label rules = new Label();
        setTopAnchor(rules, 30.0);
        setLeftAnchor(rules, 30.0);
        rules.setText("Aantal punten: " + punten.getPunten());
        
        //klik knop
        Button klikknop = new Button("KLIK VOOR PUNTEN");
        klikknop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	//code
            	punten.addPunten(1);
            	rules.setText("Aantal punten: " + punten.getPunten());
            }
        });
        klikknop.setStyle("-fx-base: #ffffff;");
        klikknop.setPrefHeight(30.0);
        klikknop.setPrefWidth(260.0);
        
        setTopAnchor(klikknop, 100.0);
        setLeftAnchor(klikknop, 30.0);
        welcomeScreen.getChildren().addAll(rules, klikknop);
        stage.setScene(scene);
        stage.show();
    }
}
