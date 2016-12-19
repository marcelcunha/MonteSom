/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dialogs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Marcel
 */
public class SearchDialogController<T>implements Initializable {
    
    
    @FXML
    private Label tituloLBL;

    @FXML
    private TextField pesquisaTF;

    @FXML
    private Button cancelarBTN;

    @FXML
    private Button pesquisaBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
