package com.example.feproject.map;

import com.example.feproject.map.Tile;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareTile implements Tile {

    private Rectangle mesh;

    private SquareTile[] neighbors;

    private int neighborNum = -1, mov, tileSize;

    private int[] xy; // Tile id

    public SquareTile() {

        tileSize = 16;
        mesh = new Rectangle(tileSize,tileSize);
        neighbors = new SquareTile[4];
        xy = new int[2];

        // set rectangle color properties
        mesh.setStroke(Color.gray(.5));
        mesh.setStrokeWidth(3);

    }

    public SquareTile(int mov, int tileSize, int x, int y) {

        mesh = new Rectangle();
        mesh.setHeight(tileSize);
        mesh.setWidth(tileSize);

        this.tileSize = tileSize;

        xy = new int[2];
        xy[0] = x;
        xy[1] = y;

        neighbors = new SquareTile[4];

        // set rectangle color properties
        mesh.setStroke(Color.gray(.5));
        mesh.setStrokeWidth(3);

    }

    public void getXY(int x, int y) {

        this.xy[0] = x;
        this.xy[1] = y;

    }

    @Override
    public Tile getNeighborByIndex(int index) {
        return null;
    }

    @Override
    public void removeNeighborByIndex(int index) {

    }

    @Override
    public int getMove() {
        return 0;
    }

    @Override
    public void SetMov(int mov) {

    }


    public Rectangle getMesh() {

        return mesh;

    }

    public void addNeighbor(SquareTile squareTile) {
    }

}