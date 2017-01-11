/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.services.MontadoraCRUD;
import com.controller.utils.AbstractControllerUtils;
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

    private final MontadoraCRUD crud = MontadoraCRUD.getInstance();
    private Montadora m = null;

    @FXML
    private TextField nomeTF;

    @FXML
    private Label codLBL;

    @FXML
    private TextField codTF;

    @FXML
    private Button acao;

    @FXML
    private Button cancelarBTN;

    @Override
    public void adicionar() {
        String nome = nomeTF.getText();
        acao.setId("salvarAlterar");
        if (verificaCampos()) {
            crud.inserir(nome);
            limparCampos();
            super.alertInfoAdiciona("A Montadora", nome);
        }
    }

    @Override
    public void excluir() {
        if (super.alertConfirmExclui()) {
            crud.apagar(m);
            limparCampos();
            //TODO chamar alert info exluir
        }
    }

    @Override
    public void alterar() {
        if (verificaCampos()) {
            if (super.alertConfirmAltera()) {
                crud.editar(m);
                limparCampos();
                //TODO chamar alert info exluir
            }
        }
    }

    @FXML
    @Override
    protected void limparCampos() {
        codTF.clear();
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
    public void preencheFormulario(String nome) {
        m = crud.ler(nome);
        codTF.setText(m.getCodMarca().toString());
        nomeTF.setText(m.getNomeMarca());
    }
}
