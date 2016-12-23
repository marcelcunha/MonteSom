/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Marcel
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Controle de estoque");
        
        /*mostra um alert de confirmação quando usuário clica no botão sair*/
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
               Alert a = new Alert(Alert.AlertType.CONFIRMATION);
               a.setContentText("Deseja encerrar o programa?");
   
               a.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
               //se não clicar no botão sim(YES) o envento é consumido e não terá ação
               if(!(a.showAndWait().get()==ButtonType.YES))
                  event.consume();
            }
        });
        
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
