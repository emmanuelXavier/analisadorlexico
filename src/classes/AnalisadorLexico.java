package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AnalisadorLexico {
    private BufferedReader codigoFonte;
    private String linha;
    private String caractere;
    private List listaElementos;
    private String palavra = "";
    private List delimitadores = new ArrayList();
    
    public AnalisadorLexico(String pathFile){
        try {
            delimitadores.add(" ");
            delimitadores.add(",");
            delimitadores.add(";");
            delimitadores.add(":");
            delimitadores.add("(");
            delimitadores.add(")");
            delimitadores.add("\n");
            delimitadores.add("{");
            delimitadores.add("}");
            codigoFonte = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
    }
    
    public void analisar() throws IOException{
        while (true){
            linha = codigoFonte.readLine();
            if (linha == null)
                break;
            
            int size = linha.length();
            for (int i = 0; i < size;i++){
                caractere = linha.substring(i,i+1);
                if (delimitadores.contains(caractere)){
                    if ((!palavra.equals("")) && (!palavra.contains("//")) && (!palavra.contains("/*"))){
                        JOptionPane.showMessageDialog(null, palavra);
                        //alinhar o token correspondente
                        palavra = "";
                    }
                }
                else
                    palavra = palavra + caractere;
            }
            
        }
    }
}
