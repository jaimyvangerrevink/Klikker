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

public class KnopView extends PuntenModel{
	// het maken van het help scherm.
    public void knopScherm() {
    	PuntenModel punten=new PuntenModel();
        punten.setPunten(666);
        
        Stage stage = new Stage();
        stage.setTitle("Klikker - Knop");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 580, 640);
        Label rules = new Label();
        setTopAnchor(rules, 30.0);
        setLeftAnchor(rules, 30.0);
        rules.setText("Aantal punten: " + punten.getPunten());
        rules.setStyle("-fx-font: 30 trebutchet;");
        
        //Uitleg knop
        Button spelspelenknop = new Button("Klik voor punten");
        spelspelenknop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	punten.addPunten(1);
            	rules.setText("Aantal punten: " + punten.getPunten());
            }
        });
        spelspelenknop.setStyle("-fx-base: #ffffff;");
        spelspelenknop.setPrefHeight(520.0);
        spelspelenknop.setPrefWidth(520.0);
        
        setTopAnchor(spelspelenknop, 90.0);
        setLeftAnchor(spelspelenknop, 30.0);
        
        welcomeScreen.getChildren().addAll(rules, spelspelenknop);
        stage.setScene(scene);
        stage.show();
    }
}
