/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dialogs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Marcel
 * @param <T>
 */
public class TrataExceptions {

    

    public static void mostraDialog(String mensagem, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Um erro foi encontrado!");
        alert.setContentText(mensagem);

        Label label = new Label("Stack Trace da excessão(Para o desenvolvedor):");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String conteudo = sw.toString();

        TextArea textArea = new TextArea(conteudo);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane gp = new GridPane();
        gp.setMaxWidth(Double.MAX_VALUE);
        gp.add(label, 0, 0);
        gp.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(gp);
        
        alert.showAndWait();
    }

}
