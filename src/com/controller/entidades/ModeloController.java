/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.DAO.MontadoraDao;
import com.model.DAO.VeiculoDao;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class ModeloController extends AbstractControllerUtils implements Initializable {

    @FXML
    private ComboBox<Short> portasCBB;

    @FXML
    private ComboBox<Veiculo> modeloCBB;

    @FXML
    private ComboBox<Montadora> marcaCBB;

    @FXML
    private TextField descTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modeloCBB.setDisable(true);

        portasCBB.getItems().addAll((short) 2, (short) 3, (short) 4);

        marcaCBB.setItems(preencheMarcasCBB());
        marcaCBB.getSelectionModel()
                .selectedItemProperty().addListener(
                        new ChangeListener<Montadora>() {

                            @Override
                            public void changed(
                                    ObservableValue<? extends Montadora> observable,
                                    Montadora oldValue, Montadora newValue) {
                                        modeloCBB.setDisable(false);
                                        modeloCBB.setItems(preencheVeiculoCBB(newValue));
                                    }
                        });
      
    }

    @Override
    protected boolean verificaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ObservableList<Veiculo> preencheVeiculoCBB(Montadora m) {
        ObservableList<Veiculo> list = FXCollections.observableArrayList();
        VeiculoDao vDao = new VeiculoDao();

        list.addAll(vDao.getListFromMarca(m));

        return list;
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
