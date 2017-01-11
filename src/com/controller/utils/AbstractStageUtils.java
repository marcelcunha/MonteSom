/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 *
 * @author Marcel
 */
public class AbstractStageUtils {
    
    public static EventHandler<WindowEvent> botaoFechar(){
       return (WindowEvent event) -> {
           Alert a = new Alert(Alert.AlertType.CONFIRMATION);
           a.setContentText("Deseja encerrar o programa?");
           
           a.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
           //se não clicar no botão sim(YES) o envento é consumido e não terá ação
           if(!(a.showAndWait().get()==ButtonType.YES))
               event.consume();
       };
    }
}
