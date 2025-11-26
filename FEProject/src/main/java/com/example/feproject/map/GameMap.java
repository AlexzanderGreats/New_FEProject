package com.example.feproject.map;

/*
 * Map Controller
 *
 * Creates Map w/ Tiles given height and width
 *
 */

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GameMap {

    int h, w, tileSize;
    GridPane grid_p;
    ArrayList<ArrayList<SquareTile>> grid_a;

    public GameMap(int h, int w, int tileSize) {

        this.w = w;
        this.h = h;
        this.tileSize = tileSize;
        grid_p = new GridPane();
        grid_a = new ArrayList<>();

    }

    public void populationMap(){

        for (int i = 0; i < w * tileSize; i += tileSize) {

            grid_a.add(new ArrayList<>());

            for (int j = 0; j < h * tileSize; j += tileSize) {

                SquareTile t0 = new SquareTile();
                t0.getXY(i / tileSize, j / tileSize);
                grid_a.get(i / tileSize).add(t0);
                grid_p.add(grid_a.get(i / tileSize).getLast().getMesh(), i, j);

            }

        }

    }

    public GridPane getGrid(){

        return this.grid_p;

    }

    public void setNeighborhoods(){

        for (int i = 0; i < grid_a.size(); i++) {
            for (int j = 0; j < grid_a.get(i).size(); j++) {

                /*
                 * For the square tiles, the adjacency list is stored as follows:
                 * Look up [0] (i, j - 1)
                 * look down [1] (i, j + 1)
                 * look left [2] (i - 1, j)
                 * look right [3] (i + 1, j)
                 * */

                // look up
                // ensure that the coordinates are within bounds
                // ensure that the tile isn't null
                if (j - 1 >= 0 && grid_a.get(i).get(j - 1) != null){

                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i).get(j - 1));

                }

                // look down
                if (j + 1 <= (grid_a.get(i).size() - 2) && grid_a.get(i).get(j + 1) != null){

                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i).get(j + 1));

                }

                // look left
                if (i - 1 >= 0 && grid_a.get(i - 1).get(j) != null){

                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i - 1).get(j));

                }

                // look right
                if (i + 1 <= grid_a.size() - 2 && grid_a.get(i + 1).get(j) != null){

                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i + 1).get(j));

                }

            }

        }

    }

}