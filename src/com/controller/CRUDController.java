/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.utils.AbstractControllerUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcel
 * @param <T>
 */
public class CRUDController<T extends AbstractControllerUtils> implements Initializable {

    private String entidade;
    private FXMLLoader loader = new FXMLLoader();
     T controller;
     
    public CRUDController(String entidade) {
        this.entidade = entidade;
    }

    @FXML
    private AnchorPane anchorpane;

    @FXML
    public Label tituloLBL;

    @FXML
    private Button novoBTN;

    @FXML
    private Button salvarBTN;

    @FXML
    private Button atualizarBTN;

    @FXML
    private Button excluirBTN;

    @FXML
    Button fecharBTN;

    @FXML
    void fecharButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void atualizarButtonAction(ActionEvent event) {
        
        loadAnchorPane(entidade, Action.REMOVER);
        controller.dialogPesquisa();
    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        loadAnchorPane(entidade, Action.ALTERAR);
    }

    @FXML
    void novoButtonAction(ActionEvent event) {
        loadAnchorPane(entidade, Action.INSERIR);
    }

    @FXML
    void salvarButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tituloLBL.setText(entidade);
    }

    public void loadAnchorPane(String nome, Action a) {
        try {         
            URL url = getClass().getResource("/com/view/entidades/" + nome + ".fxml");

            loader.load(url.openStream());
             controller = loader.getController();

            controller.acao.setOnAction(btnAction(a, controller));

            anchorpane.getChildren().clear();
            anchorpane.getChildren().add(loader.getRoot());

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EventHandler<ActionEvent> btnAction(Action metodo, T controller) {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (metodo == Action.INSERIR) {
                    controller.acao.setText("Salvar");
                    controller.adicionar();
                } else if (metodo == Action.ALTERAR) {
                    controller.acao.setText("Alterar");
                    controller.alterar();
                } else if (metodo == Action.REMOVER) {
                    controller.acao.setText("Remover");
                    controller.excluir();
                }
            }
        };
    }

    
}
