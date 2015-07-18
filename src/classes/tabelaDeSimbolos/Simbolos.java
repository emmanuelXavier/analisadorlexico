package classes.tabelaDeSimbolos;

import java.util.ArrayList;
import java.util.List;


public class Simbolos {
    
    private String nome;
    private static final List<Simbolos> tabelaDeSimbolos = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void addSimbolo(Simbolos simbolo) {
        if (!Simbolos.tabelaDeSimbolos.contains(simbolo))
            Simbolos.tabelaDeSimbolos.add(simbolo);
    }

    public static List<Simbolos> getTabelaDeSimbolos() {
        return tabelaDeSimbolos;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
    @Override
    public boolean equals(Object obj){
        Simbolos s = (Simbolos) obj;
        return s.getNome().equals(this.nome);
    }
   
    
}
