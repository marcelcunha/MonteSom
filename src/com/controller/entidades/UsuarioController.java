/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.services.ICRUD;
import com.controller.utils.AbstractControllerUtils;
import com.model.DAO.UsuarioDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Usuario;
import com.services.UsuarioCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class UsuarioController extends AbstractControllerUtils implements Initializable {

    private UsuarioCRUD crud = UsuarioCRUD.getInstance();

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField userTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField telTF;

    @FXML
    private PasswordField passPF;

    @FXML
    CheckBox adminCB;

    /**
     *
     */
    @FXML
    protected void limparCampos() {
        nomeTF.clear();
        emailTF.clear();
        passPF.clear();
        telTF.clear();
        userTF.clear();
        adminCB.setSelected(false);
    }

    @FXML
    @Override
    public void adicionar() {
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

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preencheFormulario(String nome) {
        Usuario u = crud.ler(nome);
        
        userTF.setText(u.getUserUsr());
        nomeTF.setText(u.getNomeUsr());
        emailTF.setText(u.getEmail());

    }

    @Override
    public Button getLimparBTN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
