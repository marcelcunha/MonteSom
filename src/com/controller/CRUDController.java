/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.dialogs.TrataExceptions;
import com.controller.utils.AbstractControllerUtils;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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

    public CRUDController(String entidade) throws IOException {
        this.entidade = entidade;

        fxmlNames.put("Usuário", "Usuario");
        fxmlNames.put("Veículo", "Veiculo");

        URL url = getClass().getResource("/com/view/entidades/" + fxmlNames.getOrDefault(entidade, entidade) + ".fxml");

        loader.load(url.openStream());
        controller = loader.getController();

    }

    @FXML
    private AnchorPane anchorpane;

    @FXML
    public Label tituloLBL;

    @FXML
    private Button novoBTN;

    @FXML
    private Button atualizarBTN;

    @FXML
    private Button excluirBTN;

    @FXML
    private Button fecharBTN;

    public Button getFecharBTN() {
        return fecharBTN;
    }

    @FXML
    public void fecharButtonAction(Event event) {
        Stage stage = (Stage) fecharBTN.getScene().getWindow();

        //se estiver em edição mostra a confirmação, caso contrário, sai direto
        if (atualizarBTN.isDisable()) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Deseja sair sem salvar as informações?");

            a.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
            //se não clicar no botão sim(YES) o envento é consumido e não terá ação
            if (!(a.showAndWait().get() == ButtonType.YES)) {
                event.consume();
            } else {
                stage.close();
            }
        } else {
            stage.close();
        }

    }

    @FXML
    void atualizarButtonAction(ActionEvent event) {
        String resultado = buscarStringEntidadeDialog();
        if (resultado != null) {
            controller.preencheFormulario(resultado);
            atualizarBTN.setDisable(true);
            loadAnchorPane(Action.ALTERAR, "Salvar Alteração");
            //anchorpane.getChildren().clear();
            
        }

        atualizarBTN.setDisable(false);

    }

    @FXML
    void excluirButtonAction(ActionEvent event) {
        String resultado = buscarStringEntidadeDialog();
        excluirBTN.setDisable(true);
        controller.getAcaoBTN().setId("salvar");
        /*controller.getAcaoBTN().setGraphic(
                new ImageView("/com/view/icons/delete.png"));*/
        if (resultado != null) {
            controller.preencheFormulario(resultado);
            controller.getLimparBTN().setDisable(true);
            loadAnchorPane(Action.REMOVER, "Excluir Registro");
//            this.wait();
            //         anchorpane.getChildren().clear();
            // 
        }
        //      excluirBTN.setDisable(false);
        //      controller.getLimparBTN().setDisable(false);
    }

    @FXML
    void novoButtonAction(ActionEvent event) {
        novoBTN.setDisable(true);
        loadAnchorPane(Action.INSERIR, "Salvar");
  //      novoBTN.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tituloLBL.setText(entidade);

        Property<Boolean> property = novoBTN.disableProperty();
        atualizarBTN.disableProperty().bindBidirectional(property);
        excluirBTN.disableProperty().bindBidirectional(property);
        controller.getAcaoBTN().setId("salvar");
    }

    public void loadAnchorPane(Action a, String textoButton) {
        controller.getAcaoBTN().setText(textoButton);
        controller.getAcaoBTN().setOnAction(btnAction(a));
        controller.getAcaoBTN().setDefaultButton(true);
        controller.getCancelarBTN().setOnAction(btnCancel());
        controller.getCancelarBTN().setCancelButton(true);
        trocaAPane(loader.getRoot());

    }

    private EventHandler<ActionEvent> btnAction(Action metodo) {
        return (ActionEvent event) -> {
            if (metodo == Action.INSERIR) {
                controller.adicionar();
            } else if (metodo == Action.ALTERAR) {
                controller.alterar();
            } else if (metodo == Action.REMOVER) {
                controller.excluir();

            }
        };
    }

    private EventHandler<ActionEvent> btnCancel() {
        return (ActionEvent event) -> {
            novoBTN.setDisable(false);
            anchorpane.getChildren().clear();
        };
    }

    public void trocaAPane(Parent root) {
        anchorpane.getChildren().clear();
        anchorpane.getChildren().add(root);
        anchorpane.setFocusTraversable(true);
    }

    public String buscarStringEntidadeDialog() {
        Dialog dialog = new TextInputDialog();

        dialog.setTitle("Buscar " + entidade);
        dialog.setHeaderText("Buscar pelo(a) " + entidade + " que deseja remover");
        dialog.setContentText("Digite o nome do(a): " + entidade);

        dialog.getDialogPane().getButtonTypes().setAll(
                new ButtonType("Buscar", ButtonBar.ButtonData.OK_DONE), ButtonType.CANCEL);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            //TODO trocar a cor da letra pra vermelho e piscar, se possível emitir som 
        }

        return null;
    }

}
