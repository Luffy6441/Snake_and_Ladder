package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int tileSize)
    {
        setWidth(tileSize - 1);
        setHeight(tileSize - 1);
        setArcHeight(25);
        setArcWidth(25);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);
    }
}