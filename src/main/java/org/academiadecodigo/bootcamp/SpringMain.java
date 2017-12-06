package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by codecadet on 05/12/2017.
 */
public class SpringMain extends Application {

    private ApplicationContext applicationContext;

    private Navigation navigation;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        applicationContext = new ClassPathXmlApplicationContext("/spring-config.xml");

        // Bean instantiation using a constuctor with no arguments
        navigation = applicationContext.getBean("navigation", Navigation.class);

        navigation.setStage(primaryStage);

        navigation.loadScreen(LoginController.getName());

        primaryStage.setTitle("Academia Código");
        primaryStage.show();
    }
}
