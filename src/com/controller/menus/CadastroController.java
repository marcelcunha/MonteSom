/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.menus;

import com.controller.CRUDController;
import com.controller.MainController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class CadastroController implements Initializable {

    @FXML
    private Button produtoBTN;

    @FXML
    private Button categoriaBTN;

    @FXML
    private Button fabricanteBTN;

    @FXML
    private Button prateleiraBTN;

    @FXML
    private Button carrosBTN;

    @FXML
    private Button MontadoraBTN;

    @FXML
    private Button grupoBTN;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button veiculoBTN;

    @FXML
    void veiculoButtonAction(ActionEvent event) {
           loadAnchorPane("Veículo");
    }
    @FXML
    void usuarioButtonAction(ActionEvent event) {
        loadAnchorPane("Usuário");
    }
    @FXML
    void carroButtonAction(ActionEvent event) {

    }

    @FXML
    void categoriaButtonAction(ActionEvent event) {

    }

    @FXML
    void grupoButtonAction(ActionEvent event) {

    }

    @FXML
    void fabricanteButtonAction(ActionEvent event) {

    }

    @FXML
    void montadoraButtonAction(ActionEvent event) {
        loadAnchorPane("Montadora");
    }

    @FXML
    void prateleiraButtonAction(ActionEvent event) {

    }

    @FXML
    void produtoButtonAction(ActionEvent event) {
        loadAnchorPane("Produto");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void loadAnchorPane(String nome) {
        Stage stage = new Stage();
        Scene scene;
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getResource("/com/view/CRUD.fxml");

            CRUDController controller = new CRUDController(nome);
            loader.setController(controller);
            loader.load(url.openStream());

            scene = new Scene(loader.getRoot());
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Cadastro de " + nome);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
            

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
