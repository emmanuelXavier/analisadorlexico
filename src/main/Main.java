package main;

import classes.AnalisadorLexico;
import classes.error.Error;
import classes.tabelaDeSimbolos.Simbolos;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author emmanuelsilvaxavier
 */
public class Main {


    public static void main(String[] args) {
        AnalisadorLexico analisador = new AnalisadorLexico("main.c");
        try {
            analisador.analisar();
            System.out.println("Pares <token,lexema> \n"+ analisador.getTokens());
            System.out.println("\n\nLista de erros léxicos");
            int i;
            for (i = 0; i < Error.getErros().size();i++){
                Error erro = Error.getErros().get(i);      
                System.out.println(erro.showErrors());
            }
            System.out.println("\n\nTabela de símbolos\n" + Simbolos.getTabelaDeSimbolos());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao ler o arquivo.");
        }
    }
}
