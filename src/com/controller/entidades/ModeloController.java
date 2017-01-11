/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.entidades.Modelo;
import com.model.entidades.Montadora;
import com.services.ModeloCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class ModeloController extends AbstractControllerUtils implements Initializable {

    private final ModeloCRUD crud = ModeloCRUD.getInstance();
    private Modelo m = null;

    @FXML
    private Label codLBL;

    @FXML
    private TextField codTF;

    @FXML
    private TextField nomeTF;

    @FXML
    private ComboBox<Montadora> marcaCBB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        marcaCBB.setItems(preencheMarcasCBB());
        nomeTF.disableProperty().bind(marcaCBB.valueProperty().isNull());
    }

    @Override
    protected boolean verificaCampos() {
        if (nomeTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Nome\"");
            return false;

        } else if (marcaCBB.getSelectionModel().isEmpty()) {
            super.alertInfoVerifica("\"Marca\"");
            return false;
        }
        return true;
    }

    @Override
    @FXML
    public void adicionar() {

        if (verificaCampos()) {
            m = new Modelo(nomeTF.getText(), marcaCBB.getSelectionModel().getSelectedItem());

            crud.inserir(m);
            alertInfoAdiciona("Veículo", nomeTF.getText());
            limparCampos();
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

    @Override
    @FXML
    protected void limparCampos() {
        nomeTF.clear();
        codTF.clear();
        marcaCBB.getSelectionModel().clearSelection();
    }

    @Override
    public void preencheFormulario(String nome) {
        m = crud.ler(nome);

        codTF.setText(m.getCod().toString());
        codTF.setText(m.getNome());
        marcaCBB.setValue(m.getCodMarca());
    }
}
