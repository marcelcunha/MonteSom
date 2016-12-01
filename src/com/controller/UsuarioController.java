/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.AbstractUIUtils;
import com.model.DAO.UsuarioDao;
import com.model.entidades.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class UsuarioController extends AbstractUIUtils implements Initializable {

    @FXML
    TextField nomeTF;

    @FXML
    TextField userTF;

    @FXML
    TextField emailTF;

    @FXML
    TextField telTF;

    @FXML
    PasswordField passPF;

    @FXML
    CheckBox adminCB;

    /**
     *
     */
    @FXML
    protected void limparCampos() {
        nomeTF.setText(null);
        emailTF.setText(null);
        passPF.setText(null);
        telTF.setText(null);
        userTF.setText(null);
        adminCB.setSelected(false);
    }

    @FXML
    @Override
    protected void adicionar() {
        if (verificaCampos()) {
            if (adminCB.selectedProperty().get()) {

            }
            UsuarioDao uDao = new UsuarioDao();
            Usuario user = new Usuario(userTF.getText().toLowerCase(), passPF.getText(), nomeTF.getText(),
                    adminCB.selectedProperty().get(), emailTF.getText(),
                    telTF.getText().isEmpty() ? null : Long.parseLong(telTF.getText()));

            uDao.salvar(user);

            alertInfoAdiciona("Usuariio", nomeTF.getText());
            limparCampos();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    protected boolean verificaCampos() {

        if (nomeTF.getText().isEmpty()) {
            alertInfoVerifica("\"Nome\"");
            nomeTF.requestFocus();
            return false;
        } else if (userTF.getText().isEmpty()) {
            alertInfoVerifica("\"Nome de Usuário\" ");
            userTF.requestFocus();
            return false;
        } else if (passPF.getText().isEmpty()) {
            alertInfoVerifica("\"Senha\"");
            passPF.requestFocus();
            return false;
        }

        return true;
    }
}
