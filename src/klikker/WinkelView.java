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

public class WinkelView {
	
	// het maken van het help scherm.
    public void winkelScherm() {
    	PuntenModel punten = new PuntenModel();
        punten.setPunten(0);
        
        Stage stage = new Stage();
        stage.setTitle("Klikker");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 320, 150);
        
        Label upgradeTitelLabel = new Label();
        setTopAnchor(upgradeTitelLabel, 30.0);
        setLeftAnchor(upgradeTitelLabel, 30.0);
        upgradeTitelLabel.setText("perKlik upgrade");
        
      //winkel knop
        Button upgradeKoopKnop = new Button("KOOP");
        upgradeKoopKnop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	//code
            }
        });
        upgradeKoopKnop.setStyle("-fx-base: #ffffff;");
        upgradeKoopKnop.setPrefHeight(30.0);
        upgradeKoopKnop.setPrefWidth(100.0);
        
        setTopAnchor(upgradeKoopKnop, 30.0);
        setLeftAnchor(upgradeKoopKnop, 190.0);
        
        
        
        Label upgradeTitelLabel2 = new Label();
        setTopAnchor(upgradeTitelLabel2, 90.0);
        setLeftAnchor(upgradeTitelLabel2, 30.0);
        upgradeTitelLabel2.setText("AutoKlik upgrade");
        
      //winkel knop
        Button upgradeKoopKnop2 = new Button("KOOP");
        upgradeKoopKnop2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	//code
            }
        });
        upgradeKoopKnop2.setStyle("-fx-base: #ffffff;");
        upgradeKoopKnop2.setPrefHeight(30.0);
        upgradeKoopKnop2.setPrefWidth(100.0);
        
        setTopAnchor(upgradeKoopKnop2, 90.0);
        setLeftAnchor(upgradeKoopKnop2, 190.0);
        
        
        
        
        welcomeScreen.getChildren().addAll(upgradeTitelLabel, upgradeKoopKnop, upgradeTitelLabel2, upgradeKoopKnop2);
        stage.setScene(scene);
        stage.show();
    }
}
