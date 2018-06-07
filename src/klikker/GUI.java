package klikker;

import static javafx.scene.layout.AnchorPane.setLeftAnchor;
import static javafx.scene.layout.AnchorPane.setTopAnchor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class GUI {

    public int[] nums;//the corresponding indeces of the colors chosen
    int index;      //required to set vertical location for corresponding guess circles
    int guessNum;   //this is to display the number of the current guess
    Game game;
    int[] code;     //to store the secret code in integer form (i.e. converting colors to their indeces)

    GUI() {
        nums = new int[] {-1, -1, -1, -1}; //These have to be -1 because in my changeColor function,
                                           //I update the color index and then display the color
        index = 13; //this is 13 only because it worked well with the spacing
        game = new Game();
        code = game.codeToInts(game.generateSecretCode());
        guessNum = 1;
    }
    /**
     * Creates and displays welcome screen. This screen will show the rules of the game
     * and will have a "Start game" button so the user can start playing.
     * It will also have an "Exit" button so the user can quit instead
     */
    public void createWelcomeScreen() {
        Stage stage = new Stage();
        stage.setTitle("Welcome");
        AnchorPane welcomeScreen = new AnchorPane();
        Scene scene = new Scene(welcomeScreen, 320, 150);
        Label rules = new Label();
        setTopAnchor(rules, 30.0);
        setLeftAnchor(rules, 30.0);
        rules.setText("Welkom bij Mastermind. \ngemaakt door Jaimy & Ijen.");
        welcomeScreen.getChildren().add(rules);

        /*Buttons */
        Button play = new Button("Spel starten");
        setTopAnchor(play, 90.0);
        setLeftAnchor(play, 30.0);
        play.setPrefHeight(30.0);
        play.setPrefWidth(100.0);
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                createGameScreen();

            }
        });
        Button quit = new Button("Afsluiten");
        setTopAnchor(quit, 90.0);
        setLeftAnchor(quit, 190.0);
        quit.setPrefWidth(100.0);
        quit.setPrefHeight(30.0);
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                System.exit(0);
            }
        });
        welcomeScreen.getChildren().addAll(play,quit);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates and displays game screen
     */
    public void createGameScreen() {
        Stage stage = new Stage();
        stage.setTitle("Mastermind");
        AnchorPane gameScreen = new AnchorPane();
        Scene scene = new Scene(gameScreen, 450, 600);

        /*
        This part of the code creates the circles which the player will use to select their guess
         */
        HBox options = new HBox();
        options.setSpacing(15.0);

        for (int i=0; i < 4; i++) {
            int x = i; //just a dummy variable. I cannot use i because if I access it
                       //from within inner class, i needs to be final or effectively final.
                       //this is an adequate workaround
            Rectangle r = new Rectangle(30.0, 30.0);
            options.getChildren().add(r);
            r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    toggleColor(r, x);
                }
            });
        }
        setTopAnchor(options, 30.0);
        setLeftAnchor(options, 30.0);

        /*
        This part of the code creates the "Submit Guess" and "Exit" buttons
         */
        Button submit = new Button("Raad");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (index>3) { //this will ensure that player only has 10 guesses
                                  /*
                                  This is an ugly way to do this. I might work on this later
                                   */
                    createGuessCircles(gameScreen, stage);
                }
                else {
                    playAgainScreen(false, stage); //first argument is false means that player has lost the game
                    /*
                    For debugging purposes. Will replace this with playAgainScreen displaying code
                     */
                    for (int i=0; i < 4; i++) {
                        System.out.print(code[i]);
                    }
                }

            }
        });
        submit.setPrefHeight(30.0);
        submit.setPrefWidth(95.0);
        setTopAnchor(submit, 30.0);
        setLeftAnchor(submit, 210.0);

        Button exit = new Button("Afsluiten");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        exit.setPrefHeight(30.0);
        exit.setPrefWidth(100.0);
        setTopAnchor(exit, 30.0);
        setLeftAnchor(exit, 320.0);

        gameScreen.getChildren().addAll(options, submit, exit);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * This function is responsible for the different colors that the guess circles can have.
     * Calls changeColor within which is the function actually responsible for assigning colors to circles
     * @param r Circle whose color needs to be changed
     * @param index denotes which color the circle currently has. Order of colors corresponds
     *              to order in colors[] array
     *              i.e. 0-Blue, 1-Green, 2-Orange, 3-Purple, 4-Red, 5-Yellow
     */
    public void toggleColor(Rectangle r, int index) {
        if (nums[index]==3) { //there are only 6 color options
            nums[index]=0;
        }
        else {
            nums[index]++;
        }
        changeColor(r, index);
    }

    /**
     * Assigns colors to each circle
     * @param c shape object whose color needs to be changed
     * @param index denotes which color the shape currently has. Order of colors corresponds
     *              to order in colors[] array
     *              i.e. 0-Blue, 1-Green, 2-Orange, 3-Purple, 4-Red, 5-Yellow
     */
    public void changeColor(Shape r, int index)  {
        switch (nums[index]) {
            case 0: {
                r.setFill(Color.RED); break;
            }
            case 1: {
                r.setFill(Color.BLUE); break;
            }
            case 2: {
                r.setFill(Color.GREEN); break;
            }
            case 3: {
                r.setFill(Color.YELLOW); break;
            }
        }
    }

    /**
     * Creates row of circles and feedback squares for each guess
     * @param a the AnchorPane created in createGameScreen to which I need to add the guess circles and squares
     * @param stage the stage created in createGameScreen. This is required only to pass
     *              to playAgainScreen() as that may need to close the game screen stage
     */
    public void createGuessCircles(AnchorPane a, Stage stage) {
        HBox guess = new HBox();
        guess.setSpacing(15.0);
        Label whichGuess = new Label();
        whichGuess.setText("" + guessNum);
        guessNum++;


        for (int i=0; i<4; i++) {
        	Rectangle r = new Rectangle(30.0, 30.0);
            changeColor(r, i);
            guess.getChildren().add(r);
        }
        
//        Separator s = new Separator();
//        s.setOrientation(Orientation.VERTICAL);
//        guess.getChildren().add(s);

        int[] feedback = game.getFeedback(code, nums);
        /*
        Now, feedback[0] = number of black pegs
        feedback[1] = number of white pegs
         */
        for (int i=0; i < 1; i++) {
        Rectangle r = new Rectangle(30.0, 30.0);
        guess.getChildren().add(r);
        r.setFill(Color.TRANSPARENT);
        }
        
        if (feedback[0]==4) { //if player has won
            playAgainScreen(true, stage); //first argument is true means that player has won
        }
        for (int i=0; i < 4; i++) {
            Rectangle r = new Rectangle(30.0, 30.0);
            guess.getChildren().add(r);
            if (feedback[0] > 0) {  //first filling in any black feedback pegs
                r.setFill(Color.BLACK);
                feedback[0]--;
            }
            else if (feedback[1] > 0) {//then filling in any white feedback pegs
                r.setFill(Color.WHITE);
                feedback[1]--;
            }
            else {
                r.setFill(Color.LIGHTGRAY);
            }
        }

        if (guessNum!=11) { //This if-else block is purely for sake of alignment
                            //The 10th and final guess was not aligning with the previous guesses
            setLeftAnchor(guess, 30.0);
        }
        else {
            setLeftAnchor(guess, 30.0);
        }

        index--; //I want the first guess to be at the bottom of the page
                    //and later guesses to move upwards
        setTopAnchor(guess, (index * 45.0));

        a.getChildren().add(guess);

    }

    /**
     * Creates the screen after the player either wins or loses the game.
     * If player has lost the game, screen will display what the code was for that game
     * @param won true if player has won. false if player has lost. Useful to modify text, title, etc.. to situation
     * @param s if player chooses to play again, I want to close the current gameScreen. Need this stage for that
     */
    public void playAgainScreen(boolean won, Stage s) {
        Stage stage = new Stage();
        AnchorPane playAgain = new AnchorPane();
        Scene scene = new Scene(playAgain, 320, 150);

        Label message = new Label();
        setTopAnchor(message, 30.0);
        setLeftAnchor(message, 30.0);
        Label showCode = new Label(); //only used if player has lost
        showCode.setVisible(false);
        if (won) {
            stage.setTitle("Gewonnen :D");
            message.setText("Je hebt gewonnen.");
        }
        else {
            stage.setTitle("Verloren :C");
            message.setText("Je kansen zijn op, hebt verloren.");
            showCode.setText("De juiste code is " + game.codeForPlayAgain(code));
            showCode.setVisible(true);
            setTopAnchor(showCode, 60.0);
            setLeftAnchor(showCode, 30.0);

        }
        Button play = new Button("Speel opnieuw");
        setTopAnchor(play, 90.0);
        setLeftAnchor(play, 30.0);
        play.setPrefHeight(30.0);
        play.setPrefWidth(150.0);
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                s.close();
                stage.close();
                (new GUI()).createGameScreen();
            }
        });

        Button quit = new Button("Afsluiten");
        setTopAnchor(quit, 90.0);
        setLeftAnchor(quit, 195.0);
        quit.setPrefHeight(30.0);
        quit.setPrefWidth(100.0);
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        playAgain.getChildren().addAll(message, showCode, play, quit);

        stage.setScene(scene);
        stage.show();
    }
}
