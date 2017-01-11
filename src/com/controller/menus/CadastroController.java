/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.menus;

import com.controller.CRUDController;
import com.controller.MainController;
import com.controller.dialogs.TrataExceptions;
import com.controller.utils.AbstractStageUtils;
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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    void modeloButtonAction(ActionEvent event) {
        loadAnchorPane("Modelo");
    }

    @FXML
    void categoriaButtonAction(ActionEvent event) {
        loadAnchorPane("Categoria");
    }

    @FXML
    void grupoButtonAction(ActionEvent event) {
        loadAnchorPane("Grupo");
    }

    @FXML
    void fabricanteButtonAction(ActionEvent event) {
        loadAnchorPane("Fabricante");
    }

    @FXML
    void montadoraButtonAction(ActionEvent event) {
        loadAnchorPane("Montadora");
    }

    @FXML
    void prateleiraButtonAction(ActionEvent event) {
        loadAnchorPane("Prateleira");
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
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.setOnCloseRequest((event -> {
                controller.fecharButtonAction(event);
            }));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/view/icons/title.png")));
            stage.centerOnScreen();
            stage.setTitle("Cadastro: " + nome);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            TrataExceptions.mostraDialog(ex.getMessage(), ex);
            ex.printStackTrace();
        }
    }

}
