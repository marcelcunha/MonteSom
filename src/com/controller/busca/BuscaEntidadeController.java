/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.busca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import com.controller.dialogs.AbstractDialogsUtils;
/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class BuscaEntidadeController extends AbstractDialogsUtils implements Initializable  {

    @FXML
    private Label mensagemLBL;

    @FXML
    private TextField campoTF;

    @FXML
    private CheckBox tipoCKB;

    @FXML
    private GridPane grid;

    @FXML
    void buscarButtonAction(ActionEvent event) {
        if (!campoTF.getText().isEmpty()) {
            if (tipoCKB.isSelected()) {

            } else {

            }
        }else{
            super.alertInfoVerifica("\"Pesquisa\"");
        }
        
    }

    @FXML
    void limparCamposButtonAction(ActionEvent event) {
        campoTF.clear();
        tipoCKB.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String msg = "Digite o nome: ";
        mensagemLBL.setText(msg);
        tipoCKB.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if ((newValue)) {
                    mensagemLBL.setText("Digite o código: ");
                } else {
                    mensagemLBL.setText(msg);
                }
            }

        });

        grid.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    buscarButtonAction(null);
                }
            }
        });
    }

}
