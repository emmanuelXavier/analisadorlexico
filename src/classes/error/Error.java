package classes.error;

import java.util.ArrayList;
import java.util.List;

public abstract class Error {
    private int codigo;
    private String descricao;
    private int numLinha;
    private String nomeArquivo;
    private static final List<Error> erros = new ArrayList();
    
    
    public abstract String showErrors();
    
    public static final void addErro(Error error){
        Error.erros.add(error);
    }
    
    public static final void limparErros(){
        Error.erros.clear();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumLinha() {
        return numLinha;
    }

    public void setNumLinha(int numLinha) {
        this.numLinha = numLinha;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public static List<Error> getErros() {
        return erros;
    }
    
    
}
