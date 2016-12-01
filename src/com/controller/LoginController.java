/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DAO.UsuarioDao;
import com.model.entidades.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Marcel
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private Label label;

    @FXML
    void loginButtonAction(ActionEvent event) {
        UsuarioDao dao = new UsuarioDao();
        Usuario user = dao.encontrar(usuario.getText());
        if (user.getUserUsr().equalsIgnoreCase(usuario.getText())
                && user.getSenhaUsr().equals(senha.getText())) {
            //TODO 
        } else {
            label.setText("Nome de usuário ou senha informados estão incorretos");
        }
    }

    @FXML
    void limparCampos(ActionEvent event) {
        usuario.setText(null);
        senha.setText(null);
        label.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
