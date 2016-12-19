/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class MontadoraController extends AbstractControllerUtils implements Initializable {
    
    @FXML 
    private Button actionBTN;
    
    @FXML
    private Label codL;

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField codTF;

    @Override
    public void adicionar() {
        String nome = nomeTF.getText();

        if (verificaCampos()) {
            MontadoraDao dao = new MontadoraDao();
            Montadora montadora = new Montadora(nome);
            dao.salvar(montadora);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }
    }

    @Override
    public void excluir() {
        String nome = nomeTF.getText();

        /*if (verificaCampos()) {
            MontadoraDao dao = new MontadoraDao();
            Montadora montadora = new Montadora(nome);
            dao.salvar(montadora);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }*/
        
        System.out.println("excluir");
    }

    @Override
    public void alterar() {
        String nome = nomeTF.getText();

        /*if (verificaCampos()) {
            MontadoraDao dao = new MontadoraDao();
            Montadora montadora = new Montadora(nome);
            dao.salvar(montadora);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }*/
        System.out.println("atualizar");
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
