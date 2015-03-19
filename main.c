#include <stdio.h>  
#include <stdlib.h>


int main(int argc, char** argv) {
    int linhabosta = 1; //TIPOS DE BOSTA
    /*
     int - inteiro
     float - real
     char - caractere
     _Bool - lógico
     vetor de char - cadeia - string
     */
    int idade;
    float salario;
    char sexo;
    _Bool aprovado;
    char nome[50];
    /*ESPECIFICADORES DE FORMATO
     %d
     %f  
     %c
     %d
     %s 
    scanf("%d",&aprovado);
    aprovado = 3;
    printf("%d\n",aprovado);
     */
    /*
    OPERADORES DE ATRIBUIÇÃO
     = recebe
     x++     x = x + 1;  pós-incremento
     x--     x = x - 1;  pós-decremento
     ++x     x = x + 1;  pré-incremento
     --x     x = x - 1;  pré-decremento
     +=      x += 5;  x = x + 5;
     -=      x -= 5;  x = x - 5;
     *=      x *= 5;  x = x * 5;
     /=      x /= 5;  x = x / 5;
     */
    int x = 10;
    x /= 5;
   // printf("%d\n",--x);
    printf("%d",x);
    
    
    
      
    
    
    
    
    

    return (EXIT_SUCCESS);
}

