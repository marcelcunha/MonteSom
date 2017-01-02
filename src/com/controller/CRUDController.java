/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.dialogs.TrataExceptions;
import com.controller.utils.AbstractControllerUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcel
 * @param <T>
 */
public class CRUDController<T extends AbstractControllerUtils> implements Initializable {

    private String entidade;
    private FXMLLoader loader = new FXMLLoader();
    T controller = null;
    Map<String, String> fxmlNames = new LinkedHashMap<>();

    public CRUDController(String entidade) {
        this.entidade = entidade;

        fxmlNames.put("Usuário", "Usuario");
        fxmlNames.put("Veículo", "Veiculo");

        URL url = getClass().getResource("/com/view/entidades/" + fxmlNames.getOrDefault(entidade, entidade) + ".fxml");

        try {
            loader.load(url.openStream());
        } catch (IOException ex) {
            TrataExceptions.mostraDialog(ex.getMessage(), ex);
            ex.printStackTrace();

        }
        controller = loader.getController();
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
        Stage stage = (Stage) fecharBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    void atualizarButtonAction(ActionEvent event) throws IOException {
        buscarEntidade();
        // loadAnchorPane(Action.ALTERAR, "Salvar Alteração");        
    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        // controller.preencheFormulario(controller.buscarEntidade());
        loadAnchorPane(Action.REMOVER, "Excluir Registro");
    }

    @FXML
    void novoButtonAction(ActionEvent event) {
        loadAnchorPane(Action.INSERIR, "Salvar");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tituloLBL.setText(entidade);
    }

    public void loadAnchorPane(Action a, String textoButton) {

        controller.getAcaoBTN().setText(textoButton);
        controller.getAcaoBTN().setOnAction(btnAction(a));

        trocaAPane(loader.getRoot());

    }

    public EventHandler<ActionEvent> btnAction(Action metodo) {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (metodo == Action.INSERIR) {
                    controller.adicionar();
                } else if (metodo == Action.ALTERAR) {
                    controller.alterar();
                } else if (metodo == Action.REMOVER) {
                    controller.excluir();
                }
            }
        };
    }

    public void buscarEntidade() {
        try {
            FXMLLoader l = new FXMLLoader();
            l.load(getClass().getResource("/com/view/busca/BuscaEntidade.fxml").openStream());
            trocaAPane(l.getRoot());
        } catch (IOException ex) {
            Logger.getLogger(CRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void trocaAPane(Parent root) {
        anchorpane.getChildren().clear();
        anchorpane.getChildren().add(root);
    }

}
