package com.example.snakeladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private final Circle coin;
    private int currentPosition;
    private static final Board gameBoard = new Board();
    public Player(int tileSize , Color coinColor)
    {
        coin = new Circle((double) tileSize / 2 - 9);
        coin.setFill(coinColor);
        currentPosition = 0;
        movePlayer(1);
    }

    public void movePlayer(int diceValue)
    {

//        int x = gameBoard.getXCoordinate(currentPosition);
//        int y = gameBoard.getYCoordinate(currentPosition);
//
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);

//        SnakeLadder.
        if(currentPosition + diceValue <= 100)
        {
            currentPosition += diceValue;

            TranslateTransition firstMove = translateAnimation(diceValue);
            TranslateTransition secondMove = null;

            int newPosition = gameBoard.getNewPosition(currentPosition);
            if(newPosition != currentPosition && newPosition != -1)
            {
                currentPosition = newPosition;
                secondMove = translateAnimation(6);
            }

            if(secondMove == null)
            {
                firstMove.play();
            }
            else
            {
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove ,new PauseTransition(Duration.millis(500)) , secondMove);
                sequentialTransition.setAutoReverse(false);
                sequentialTransition.play();
            }
        }
    }
    private TranslateTransition translateAnimation(int diceValue)
    {
        TranslateTransition animate = new TranslateTransition(Duration.millis(200 * diceValue) , coin);
        animate.setToX(gameBoard.getXCoordinate(currentPosition));
        animate.setToY(gameBoard.getYCoordinate(currentPosition));
        animate.setAutoReverse(false);
//        animate.play();
        return animate;
    }
    public Circle getCoin() {
        return coin;
    }

}