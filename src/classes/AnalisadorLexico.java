package classes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AnalisadorLexico {
    private BufferedReader codigoFonte;
    private String linha;
    private String caractere;
    private List listaElementos;
    private String palavra = "";
    private List delimitadores = new ArrayList();
    private boolean inComment = false;
    private String numerica;
    private String vareaveis;
    private String literais;
    private String funcoes;
    private List operRelacionais = new ArrayList();
    private List reservadas = new ArrayList();
    private List operAtribuicao = new ArrayList();
    private List<Elemento> tokens = new ArrayList<Elemento>();
    
    public AnalisadorLexico(String pathFile){
        try {
            int i = 10; 
            
            numerica = ("^\\d+\\.?\\d+");
            vareaveis = ("^\\D\\w+");
            literais = ("^\".*\"$");
            
            delimitadores.add(" ");
            delimitadores.add(",");
            delimitadores.add(";");
            delimitadores.add(":");
            delimitadores.add("(");
            delimitadores.add(")");
            delimitadores.add("\n");
            delimitadores.add("{");
            delimitadores.add("}");
            
            operRelacionais.add("==");
            operRelacionais.add("!=");
            operRelacionais.add(">=");
            operRelacionais.add("<=");
            operRelacionais.add(">");
            operRelacionais.add("<");
            
            operAtribuicao.add("=");
            operAtribuicao.add("+=");
            operAtribuicao.add("-=");
            operAtribuicao.add("*=");
            operAtribuicao.add("/=");
            operAtribuicao.add("%=");
            operAtribuicao.add("++");
            operAtribuicao.add("--");
            
            reservadas.add("#include");
            reservadas.add("<stdio.h>");
            reservadas.add("void");
            reservadas.add("int");
            reservadas.add("char");
            reservadas.add("float");
            reservadas.add("long");
            reservadas.add("double");
            reservadas.add("_Bool");
            reservadas.add("struct");
            reservadas.add("typedef");
            reservadas.add("if");
            reservadas.add("else");
            reservadas.add("while");
            reservadas.add("do");
            reservadas.add("for");
            reservadas.add("return");
            reservadas.add("break");
            reservadas.add("switch");
            reservadas.add("case");
            reservadas.add("continue");
            reservadas.add("printf");
            
             
            
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
                     if ((!inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                        "//"))){
                        palavra = "";
                        break;
                     }
                     if ((!inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                        "/*"))){
                        palavra = "";
                        inComment = true;
                     }
                     if ((inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                        "*/"))){
                        palavra = "";
                        inComment = false;
                     }
                     
                    if (!inComment){ 
                        if ((!palavra.equals("")) && (!palavra.contains("/*")))
                            this.addToken(palavra);
                        //alinhar o token correspondente
                    }
                        palavra = "";
                    
                }
                else
                    palavra = palavra + caractere;
            }
            
        }
    }

    private void addToken(String palavra) {
        if (palavra.matches(numerica)){
            Elemento elemento = new Elemento();
            elemento.setToken("numerico");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        
        if (palavra.matches(literais)){
            Elemento elemento = new Elemento();
            elemento.setToken("literais");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
                   
        if (operRelacionais.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken("Operador Relacional");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        
        if (reservadas.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken(palavra);
            tokens.add(elemento);
            return;
        }
        if (operAtribuicao.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken("Operador Atribuição");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        if(!palavra.equals(reservadas)){
        if (palavra.matches(vareaveis)){
            Elemento elemento = new Elemento();
            elemento.setToken("vareaveis");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        
        }
        
        
            
            
    }
    
    
    
    public List<Elemento> getTokens(){
        return tokens;
    }
    
    
 
}
