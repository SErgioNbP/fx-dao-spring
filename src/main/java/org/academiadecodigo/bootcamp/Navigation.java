package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Navigation {

    public final static int MIN_WIDTH = 1024;
    public final static int MIN_HEIGHT = 768;

    public final static String VIEW_PATH = "/view";
    private LinkedList<Scene> scenes = new LinkedList<>();
    private Map<String, Controller> controllers = new HashMap<>();
    private Stage stage;
    //private List scenes;
    //private Map controllers;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Controller getController(String view) {
        return controllers.get(view);
    }

    public void loadScreen(String view) {

        // Instantiate the view and the controller
        Parent root = loadView(view);

        // Create a new scene and add it to the stack
        Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
        scenes.push(scene);

        // Put the scene on the stage
        setScene(scene);

    }

    public Parent loadView(String view) {

        Parent root = null;

        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            fxmlLoader.setController(controllers.get(view));

            root = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }

        return root;

    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();

        // load a new scene from the top of the stack
        setScene(scenes.peek());

    }

    private void setScene(Scene scene) {

        // set the scene
        stage.setScene(scene);

        // show the stage
        stage.show();
    }

    public void close() {

        stage.close();

    }

    public void setControllers(Map controllers) {
        this.controllers = controllers;
    }

    public Map getControllers() {
        return controllers;
    }

}

