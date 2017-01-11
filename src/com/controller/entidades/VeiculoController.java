/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.entidades.Modelo;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;
import com.services.ModeloCRUD;
import com.services.VeiculoCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class VeiculoController extends AbstractControllerUtils implements Initializable {

    private final VeiculoCRUD crud = VeiculoCRUD.getInstance();
    private Veiculo v = null;

    @FXML
    private Label codLBL;

    @FXML
    private TextField codTF;

    @FXML
    private TextField descTF;

    @FXML
    private ComboBox<Integer> portasCBB;

    @FXML
    private ComboBox<Modelo> modeloCBB;

    @FXML
    private ComboBox<Montadora> marcaCBB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // modeloCBB.setDisable(true);

        portasCBB.getItems().addAll(2, 3, 4);

        marcaCBB.setItems(preencheMarcasCBB());
        marcaCBB.getSelectionModel()
                .selectedItemProperty().addListener(
                        (ObservableValue<? extends Montadora> observable, Montadora oldValue, Montadora newValue) -> {
                            modeloCBB.setItems(preencheModeloCBB(newValue));
                        });
        modeloCBB.disableProperty().bind(marcaCBB.valueProperty().isNull());
        descTF.disableProperty().bind(modeloCBB.valueProperty().isNull());

    }

    @Override
    protected boolean verificaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar() {
       if(verificaCampos()){
           v = new Veiculo(descTF.getText(), 
                   portasCBB.getValue(), modeloCBB.getValue());
           crud.inserir(v);
       }
    }

    @FXML
    @Override
    protected void limparCampos() {
        codTF.clear();
        descTF.clear();
        marcaCBB.getSelectionModel().clearSelection();
        portasCBB.getSelectionModel().clearSelection();
        modeloCBB.getSelectionModel().clearSelection();
    }

    @Override
    public void excluir() {
        if (super.alertConfirmExclui()) {
            crud.apagar(v);
            limparCampos();
            //TODO chamar alert info exluir
        }
    }

    @Override
    public void alterar() {
        if (verificaCampos()) {
            if (super.alertConfirmAltera()) {
                crud.editar(v);
                limparCampos();
                //TODO chamar alert info exluir
            }
        }
    }

    @Override
    public void preencheFormulario(String nome) {
        v = crud.ler(nome);

        codTF.setText(v.getCodVei().toString());
        descTF.setText(v.getDescVei());
        marcaCBB.setValue(v.getCodMod().getCodMarca());
        portasCBB.setValue(v.getQtdPortas());
        modeloCBB.setValue(v.getCodMod());
    }
}
