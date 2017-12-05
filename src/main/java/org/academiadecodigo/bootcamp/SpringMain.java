package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by codecadet on 05/12/2017.
 */
public class SpringMain extends Application {

    private ApplicationContext applicationContext;

    private Navigation navigation;

    public static void main(String[] args) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        applicationContext = new ClassPathXmlApplicationContext("/spring-config.xml");
    }
}
