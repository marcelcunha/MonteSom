/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.model.DAO.ModeloDao;
import com.model.DAO.MontadoraDao;
import com.model.entidades.Modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
public class MainUtil {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Chevrolet");
        map.put(2, "Volkswagen");
        map.put(3, "Fiat");
        map.put(5, "Citroen");
        map.put(7, "Honda");
        map.put(13, "Ford");
        map.put(14, "Hyundai");
        map.put(22, "Peugeot");
        map.put(23, "Toyota");
        map.put(24, "Renault");

        try {
            FileReader fr = new FileReader(new File("D:\\Usuarios\\Marcel\\Documents\\carros ordenados por cod fabrica.csv"));
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                try {
                    String str = br.readLine();
                    String[] array = str.split(";");

                    if (map.keySet().contains(Integer.parseInt(array[0]))) {
                      /*  ModeloDao vDao = new ModeloDao();
                        MontadoraDao mdao = new MontadoraDao();

                        Modelo v = new Modelo(array[1], mdao.encontrar(map.get(Integer.parseInt(array[0]))));

                        vDao.salvar(v);*/
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainUtil.class.getName()).log(Level.SEVERE, null, ex);

                } 
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
