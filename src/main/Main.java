/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.AnalisadorLexico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author emmanuelsilvaxavier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalisadorLexico analisador = new AnalisadorLexico("main.c");
        try {
            analisador.analisar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao ler o arquivo.");
        }
    }
}
