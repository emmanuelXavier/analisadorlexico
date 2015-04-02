package classes;

public class Elemento {
    private String token;
    private String lexema;
    
    public String getToken(){
        return token;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public String getLexema(){
        return lexema;
    }
    
    public void setLexema(String lexema){
        this.lexema = lexema;
        
    }
    
    public String toString(){
        return token + ", " + lexema;
    }
            
    
    
}
