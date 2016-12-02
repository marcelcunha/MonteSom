/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

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
public class ModeloController extends AbstractUIUtils implements Initializable {
    
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
       portasCBB.getItems().addAll((short)2,(short)3,(short)4);
       marcaCBB.setItems(preencheMarcaCBB());
       marcaCBB.setCellFactory(marcaCBBFactory());
       marcaCBB.setButtonCell(cell());
       marcaCBB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Montadora>() {

           @Override
           public void changed(ObservableValue<? extends Montadora> observable, Montadora oldValue, Montadora newValue) {
               modeloCBB.setItems(preencheVeiculoCBB(newValue.getCodMarca()));
           }
       });
      // 
       
       
    }    

    @Override
    protected boolean verificaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private ObservableList<Montadora> preencheMarcaCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();
         MontadoraDao mDao = new MontadoraDao();

        list.addAll(mDao.getList());

        return list;
    }
    
     private ObservableList<Veiculo> preencheVeiculoCBB(int id) {
        ObservableList<Veiculo> list = FXCollections.observableArrayList();
        VeiculoDao vDao = new VeiculoDao();

        list.addAll(vDao.getListFromMarca(id));

        return list;
    }
     
    private Callback<ListView<Montadora>, ListCell<Montadora>> marcaCBBFactory() {
        return new Callback<ListView<Montadora>, ListCell<Montadora>>() {

            @Override
            public ListCell<Montadora> call(ListView<Montadora> param) {
                return cell();
            }
        };
    }

    private ListCell<Montadora> cell() {
        final ListCell<Montadora> cell = new ListCell<Montadora>() {

            @Override
            protected void updateItem(Montadora item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setText(item.getNomeMarca());
                 //   
                }
            }
        };
        return cell;
    }
}
