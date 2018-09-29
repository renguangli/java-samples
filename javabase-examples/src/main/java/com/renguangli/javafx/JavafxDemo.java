/*
package com.renguangli.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

*/
/**
 * JavafxDemo
 *
 * @author renguangli 2018/9/26 15:09
 * @since JDK 1.8
 *//*

public class JavafxDemo extends Application {

    public static void main(String[] ar*/
/**//*
gs) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 500);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        borderPane.setTop(menuBar);
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        newMenuItem.setOnAction(actionEvent -> {
            System.out.println("caonidae");
        });

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,new SeparatorMenuItem(), exitMenuItem);
        menuBar.getMenus().addAll(fileMenu);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx-demo");
        primaryStage.show();
    }
}
*/
