/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dialogs;

import com.model.entidades.IEntidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Marcel
 * @param <T>
 */
public class SearchDialog {

   
    private final DialogPane dp = new DialogPane();

    private final ButtonType BUSCAR = new ButtonType("Buscar");
    private final Label label = new Label("Digite o código ou nome:");
    private final TextField tf = new TextField();
    private final GridPane gp = new GridPane();

    private void montarGridPane() {
        GridPane.setMargin(gp, new Insets(10, 10, 10, 10));
        gp.add(label, 0, 0);
        gp.add(tf, 1, 0);

    }

    private void montarDialogPane() {
        dp.setContent(gp);
        dp.getButtonTypes().addAll(ButtonType.CANCEL, BUSCAR);

    }

    public Dialog<IEntidades> getDialog(Callback<ButtonType, IEntidades> callback) {
        Dialog<IEntidades> d = new Dialog();
        
        d.setDialogPane(dp);
        d.setContentText("Counteudo");
        d.setTitle("titulo");
        d.setHeaderText("cabecalho");

        d.setResultConverter(callback);
        
        return d;
    }

    public String getCampoBusca() {
        return tf.getText();
    }

    public SearchDialog() {
        montarGridPane();
        montarDialogPane();
    }

}
