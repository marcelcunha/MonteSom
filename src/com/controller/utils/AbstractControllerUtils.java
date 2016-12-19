/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 *
 * @author Marcel
 */
public abstract class AbstractControllerUtils {

    @FXML
    public Button acao;

    protected abstract boolean verificaCampos();

    public abstract void adicionar();

    public abstract void excluir();

    public abstract void alterar();

    protected abstract void limparCampos();

    private void alertInfo(String mensagem) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setHeaderText(null);
        a.setContentText(mensagem);
        a.showAndWait();
    }

    public <T> T dialogPesquisa() {
        try {
            Dialog<T> dialog = new Dialog<>();
            
            DialogPane dp = new DialogPane();
            FXMLLoader loader = new FXMLLoader();
            loader.load(getClass().getResource("/com/view/dialogs/searchDialogPane.fxml").openStream());
            dp.setContent(loader.getRoot());
            dialog.setDialogPane(dp);
            
            dialog.showAndWait();
            /*
            Dialog<Pair<String, Boolean>> dialog = new Dialog<>();
            dialog.setTitle("Procurar");
            dialog.setHeaderText("Enter search parameters");
            
            // Set the search icon.
            dialog.setGraphic(new ImageView(getClass().getResource("/com/view/icons/search.png").
            toString()));
            
            // Set the button types.
            ButtonType searchButtonType = new ButtonType("Procurar", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(searchButtonType,
            ButtonType.CANCEL);
            
            // Create the layout for the controls.
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));
            
            // Create and initialize the search-text and case-sensitive-search controls.
            TextField srchText = new TextField();
            srchText.setPromptText("Search text");
            
            
            // Populate the layout with a label along with the search text and
            // case-sensitive search controls.
            grid.add(new Label("Search Text:"), 0, 0);
            grid.add(srchText, 1, 0);
            
            // Disable/enable search button depending on whether search-text field is
            // empty. Button defaults to being disabled.
            Node searchButton = dialog.getDialogPane().lookupButton(searchButtonType);
            searchButton.setDisable(true);
            srchText.textProperty().addListener((observable, oldValue, newValue) -> {
            searchButton.setDisable(newValue.trim().isEmpty());
            });
            
            // Install controls layout in the dialog panel.
            dialog.getDialogPane().setContent(grid);
            
            // Request focus on the search-text field. See
            // https://community.oracle.com/thread/2321126 for information on why
            // Platform.runLater() is used.
            Platform.runLater(() -> srchText.requestFocus());
            
            // Convert the result to a srchtext-css-status pair when the search button
            // is clicked.
            dialog.setResultConverter(dialogButton -> {
            if (dialogButton == searchButtonType) {
            return new Pair<>(srchText.getText(), css.isSelected());
            }
            return null;
            });
            
            // Display dialog box and wait for user response.
            Optional<Pair<String, Boolean>> result = dialog.showAndWait();
            
            // If the user closed the dialog box via the search button, output the
            // chosen search text and case-sensitive search status.
            result.ifPresent(stcss -> {
            System.out.println("Search text = " + stcss.getKey()
            + ", Case-sensitive search = " + stcss.getValue());
            });*/
        } catch (IOException ex) {
            Logger.getLogger(AbstractControllerUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected void alertInfoVerifica(String str) {
        alertInfo("O campo " + str + " não pode ser vazio ");
    }

    protected void alertInfoAdiciona(String tipo, String nome) {
        alertInfo(tipo + " " + nome + " foi cadastrado(a) com sucesso!");
    }

    /**
     *
     * @return
     */
    protected ObservableList<Montadora> preencheMarcasCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();
        MontadoraDao dao = new MontadoraDao();

        list.addAll(dao.getList());

        return list;
    }
}
