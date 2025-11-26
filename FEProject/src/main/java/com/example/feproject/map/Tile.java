package com.example.feproject.map;

public interface Tile {

    /*
     * Used as Template for obj files
     */

    static int numbOfFiles = 0;

    Tile getNeighborByIndex(int index);
    void removeNeighborByIndex(int index);

    int getMove();
    void SetMov(int mov);

}