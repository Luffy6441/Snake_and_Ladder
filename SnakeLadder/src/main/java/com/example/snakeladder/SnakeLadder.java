package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.util.Random;

public class SnakeLadder extends Application {
    public static final int tileSize = 40;
    public static final int width = 10;
    public static final int height = 10;
    public static final int buttonLine = height * tileSize + 25;
    public static final int infoLine = buttonLine - 15;
    private Player player1;
    private Player player2;
    private boolean turn1 = false;
    private boolean turn2 = false;
    private final ImageView diceImage1 = new ImageView();
    private final ImageView diceImage2 = new ImageView();
    private static Label gameStatus;
    private Pane createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize , height * tileSize + 65);

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }
        }

//        Setting-Up the board and the Background Image

        Image img = new Image("C:\\Users\\Chirag\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\SnakeLadderImage.png");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height * tileSize + 10);
        board.setFitWidth(width * tileSize + 10);

//        Initializing the Buttons

        Button button1 = new EditableButton("Player One");
        Button button2 = new EditableButton("Player Two");
        Button startButton = new Button("Start");

//        Setting Button's bounds or location

        button1.setTranslateX(15);                          //Button1 (Player - 1)
        button1.setTranslateY(buttonLine + 5);

        button2.setTranslateX(315);                         //Button2 (Player - 2)
        button2.setTranslateY(buttonLine + 5);

        startButton.setTranslateX(185);                     //Start Button
        startButton.setTranslateY(buttonLine - 235);

        gameStatus = new Label("Press Start");
        gameStatus.setTranslateX(180);
        gameStatus.setTranslateY(buttonLine - 255);

        Label label1 = new Label("Your Turn !");
        label1.setVisible(false);
        label1.setTranslateX(22);
        label1.setTranslateY(infoLine + 5);

        Label label2 = new Label("Your Turn !");
        label2.setVisible(false);
        label2.setTranslateX(322);
        label2.setTranslateY(infoLine + 5);

        player1 = new Player(tileSize - 5 , Color.RED);
        player2 = new Player(tileSize - 5 , Color.BLUE);

        // Action Performed

        startButton.setOnAction(actionEvent -> {
            startButton.setDisable(true);
            startButton.setVisible(false);
            gameStatus.setTranslateX(197);
            gameStatus.setTranslateY(buttonLine - 6);
            gameStatus.setText("");
            gameStatus.setVisible(false);
            label1.setVisible(true);
            turn1 = true;
            button1.setVisible(true);
            button2.setVisible(false);
        });

        button1.setOnAction(actionEvent -> {
            Random random = new Random();
            int diceValue = random.nextInt(6) + 1;
            diceImage2.setVisible(false);
            if (turn1) {
                label1.setVisible(true);
/*
                Thread thread = new Thread(){
                    public void run(){
                        try {
                            for (int i = 0; i < 15; i++) {
                                File file = new File("C:\\Users\\Chirag\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\DiceImg\\dice" + String.valueOf(diceValue) +".png");
                                Image image = new Image(file.toURI().toString());
                                diceImage1.setImage(image);
                                diceImage1.setTranslateX(185);
                                diceImage1.setTranslateY(buttonLine + 5);
                                diceImage1.setVisible(true);
                                Thread.sleep(50);
                            }
                            button1.setDisable(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
*/
                File file = new File("C:\\Users\\Chirag\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\DiceImg\\dice" + diceValue + ".png");
                Image image = new Image(file.toURI().toString());
                diceImage1.setImage(image);
                diceImage1.setTranslateX(185);
                diceImage1.setTranslateY(buttonLine + 5);
                diceImage1.setVisible(true);
                gameStatus.setText(String.valueOf(diceValue));
                player1.movePlayer(diceValue);
                if (diceValue != 6) {
                    turn1 = false;
                    label1.setVisible(false);
                    turn2 = true;
                    label2.setVisible(true);
                    button1.setVisible(false);
                    button2.setVisible(true);
                }
            }
        });

        button2.setOnAction(actionEvent -> {
            Random random = new Random();
            int diceValue = random.nextInt(6) + 1;
            diceImage1.setVisible(false);
            if (turn2) {
/*
                Thread thread = new Thread(){
                    public void run(){
                        try {
                            for (int i = 0; i < 8; i++) {
                                File file = new File("C:\\Users\\Chirag\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\DiceImg\\dice" + String.valueOf(diceValue) +".png");
                                Image image = new Image(file.toURI().toString());
                                diceImage2.setImage(image);
                                diceImage2.setTranslateX(185);
                                diceImage2.setTranslateY(buttonLine + 5);
                                diceImage2.setVisible(true);
                                Thread.sleep(50);
                            }
                            button2.setDisable(false);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
*/
                File file = new File("C:\\Users\\Chirag\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\DiceImg\\dice" + diceValue + ".png");
                Image image = new Image(file.toURI().toString());
                diceImage2.setImage(image);
                diceImage2.setTranslateX(185);
                diceImage2.setTranslateY(buttonLine + 5);
                diceImage2.setVisible(true);
                gameStatus.setText(String.valueOf(diceValue));
                player2.movePlayer(diceValue);
                if (diceValue != 6) {
                    turn1 = true;
                    label1.setVisible(true);
                    turn2 = false;
                    label2.setVisible(false);
                    button1.setVisible(true);
                    button2.setVisible(false);
                }
            }
        });

        root.getChildren().addAll( board , button1 , button2 ,
                startButton , gameStatus , diceImage1 , diceImage2 ,
                label1 , label2 , player1.getCoin() , player2.getCoin());
        return root;
    }
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    static class EditableButton extends Button {
        TextField tf = new TextField();

        public EditableButton(String text) {
            setText(text);
            setOnMouseClicked(e -> {
//                Double-Clicking Changes Player's Name

                if(e.getClickCount() == 2)
                {
                    tf.setText(getText());
                    setText("");
                    setGraphic(tf);
                }
            });

            tf.setOnAction(ae -> {
//              this if condition is for validating the text

//              if (validateText(tf.getText()))
//                {
                setText(tf.getText());
                setGraphic(null);
//                }
            });
        }
    }
}