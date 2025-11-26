package com.example.feproject;

import com.example.feproject.inventory.Item;
import com.example.feproject.map.GameMap;
import com.example.feproject.map.SquareTile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/


        Item i1 = new Item();

        Item i2 = new Item();

        Scanner in = new Scanner(System.in);
        System.out.print("[Enter Height]: ");
        int h = in.nextInt();

        System.out.print("[Enter Width]: ");
        int w = in.nextInt();

        GameMap gameMap = new GameMap(h, w, 32);
        gameMap.populationMap();

        Scene scene = new Scene(gameMap.getGrid(), 960, 420);


















        /*SquareTile tile = new SquareTile();

        GridPane grid = new GridPane();
        grid.add(tile.getMesh(), 0, 0);

        Scene scene = new Scene(grid, 500, 500);
        */
        stage.setScene(scene);
        stage.setTitle("Version 1.0.0");
        stage.show();
    }
}