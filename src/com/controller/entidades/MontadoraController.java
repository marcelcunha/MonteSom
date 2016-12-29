/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.DAO.MontadoraDao;
import com.model.entidades.IEntidades;
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

    Montadora montadora = null;
    MontadoraDao dao = new MontadoraDao();
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

            montadora = new Montadora(nome);
            dao.salvar(montadora);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }
    }

    @Override
    public void excluir() {
        if (super.alertConfirmExclui()) {
            //TODO chama dao e exclui item 
        }
    }

    @Override
    public void alterar() {
        if (verificaCampos()) {
            if (super.alertConfirmAltera()) {
                //TODO chama dao e altera item
            }
        }
    }

    @FXML
    @Override
    protected void limparCampos() {
        nomeTF.clear();
    }

    @Override
    protected boolean verificaCampos() {
        if (nomeTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Nome da Montadora\"");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void preencheFormulario(IEntidades entidade) {
        Montadora m = (Montadora) entidade;
        codTF.setText(m.getCodMarca().toString());
        nomeTF.setText(m.getNomeMarca());     
    }
    
    @Override
    public IEntidades encontraEntidade(String str){
        return dao.encontrar(str);
    }
}
