package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList <Pair<Integer , Integer>> coordinates;
    ArrayList <Integer> snakeLadderPosition;

    public Board()
    {
        coordinates = new ArrayList<>();
        populateCoordinates();
        populateSnakeLadder();
    }

    private void populateCoordinates()
    {
        coordinates.add(new Pair<>(0 , 0));

        for (int i = 0 ; i < SnakeLadder.height ; i++)
        {
            for (int j = 0 ; j < SnakeLadder.width ; j++)
            {
                int xCoordinates;
                if(i % 2 == 0)
                    xCoordinates = (j * SnakeLadder.tileSize + SnakeLadder.tileSize / 2) + 10;
                else
                    xCoordinates = (SnakeLadder.tileSize * SnakeLadder.height - (j * SnakeLadder.tileSize) - SnakeLadder.tileSize / 2) + 10;

                int yCoordinates = (SnakeLadder.tileSize * SnakeLadder.height - (i * SnakeLadder.tileSize) - SnakeLadder.tileSize / 2) - 3;

                coordinates.add(new Pair<>(xCoordinates , yCoordinates));
            }
        }
    }

    private void populateSnakeLadder()
    {
        snakeLadderPosition = new ArrayList <>();
        for (int i = 0 ; i < 101 ; i++)
        {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.add(3 , 21);
        snakeLadderPosition.add(8 , 30);
        snakeLadderPosition.add(17 , 13);
        snakeLadderPosition.add(28 , 84);
        snakeLadderPosition.add(52 , 29);
        snakeLadderPosition.add(57 , 40);
        snakeLadderPosition.add(58 , 77);
        snakeLadderPosition.add(62 , 22);
        snakeLadderPosition.add(75 , 86);
        snakeLadderPosition.add(80 , 100);
        snakeLadderPosition.add(88 , 18);
        snakeLadderPosition.add(90 , 91);
        snakeLadderPosition.add(95 , 51);
        snakeLadderPosition.add(97 , 79);
    }

    public int getNewPosition(int currentPosition)
    {
        if(currentPosition > 0 && currentPosition <= 100)
            return snakeLadderPosition.get(currentPosition);
        return -1;
    }
    int getXCoordinate(int position)
    {
        if(position >= 1 && position <= 100)
            return coordinates.get(position).getKey();
        return -1;
    }
    int getYCoordinate(int position)
    {
        if(position >= 1 && position <= 100)
            return coordinates.get(position).getValue();
        return -1;
    }
}