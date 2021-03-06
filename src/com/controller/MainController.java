/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class MainController implements Initializable {

    @FXML
    private Button pesquisarBTN;

    @FXML
    private Button cadastroBTN;

    @FXML
    private Button ManutencaoBTN;

    @FXML
    private Button sobreBTN;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private void cadastroButtonAction(ActionEvent e) {

        loadAnchorPane("Cadastro");
    }

    @FXML
    void manutencaoButtonAction(ActionEvent event) {

    }

    @FXML
    void pesquisarButtonAction(ActionEvent event) {

    }

    @FXML
    void sobreButtonAction(ActionEvent event) {
       // Alert a = new 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //
     void loadAnchorPane(String nome){
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getResource("/com/view/menus/"+nome+".fxml");

            loader.load(url.openStream());
            
            Region root = (Region) loader.getRoot();
            
            anchorpane.getChildren().clear(); 
             root.autosize();
             root.prefHeightProperty().bind(anchorpane.heightProperty());
             root.prefWidthProperty().bind(anchorpane.widthProperty());
            anchorpane.getChildren().add(root);
           
            /*anchorpane.prefHeightProperty().bindBidirectional(root.prefHeightProperty());
            anchorpane.prefWidthProperty().bindBidirectional(root.prefWidthProperty());*/
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
