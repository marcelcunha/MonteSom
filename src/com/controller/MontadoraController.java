/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.utils.AbstractUIUtils;
import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class MontadoraController extends AbstractUIUtils implements Initializable {

    @FXML
    private Label codL;

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField codTF;

    @FXML
    @Override
    protected void adicionar() {
        String nome = nomeTF.getText();

        if (verificaCampos()) {
            MontadoraDao dao = new MontadoraDao();
            Montadora montadora = new Montadora(nome);
            dao.salvar(montadora);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }

    }

    @FXML
    @Override
    protected void limparCampos() {
        nomeTF.setText(null);
    }

    @Override
    protected boolean verificaCampos() {
        if (nomeTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Nome da Montadora\"");
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
