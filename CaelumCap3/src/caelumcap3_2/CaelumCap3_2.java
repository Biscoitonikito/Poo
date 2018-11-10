
package caelumcap3_2;

import java.util.Scanner;

public class CaelumCap3_2 {
    public static void main(String[] args) {
        //1º
        for(int i = 150; i <= 300; i++){
            System.out.println(i);
        }
        
        //2º
        int soma = 0;
        for(int i = 1; i <= 1000; i++){
            soma+= i;
        }     
        System.out.println(soma);
        
        //3º
        for(int i = 1; i <= 100; i++){
            if(i % 3 == 0){
                System.out.println(i);
            }
        }
        
        //4º
        for(int i = 0; i < 10; i++){
            int fatorial = 1;
            if(i == 0){
               System.out.println("O fatorial de " + i + "é 1"); 
            }   
            
            else{
                for(int j = i; j != 0; j--){
                    fatorial *= j;
                }
                System.out.println("O fatorial de " + i + "é ("+(i-1)+"!)*" + i + " = "+ fatorial); 
            }
        }
        
        //5º
        for(int i = 0; i < 40; i++){
            long fatorial = 1;
            if(i == 0){
               System.out.println("O fatorial de " + i + "é 1"); 
            }   
            
            else{
                for(int j = i; j != 0; j--){
                    fatorial *= j;
                }
                System.out.println("O fatorial de " + i + "é ("+(i-1)+"!)*" + i + " = "+ fatorial); 
            }
        }
        
        //6º
        int a = 0;
        int b = 1;
        System.out.println(a+",");
        System.out.println(b+",");
        
        for(int r = 0; r < 100;){
            r = a + b;
            a = b;
            b = r;
            System.out.println(r+",");
        }
        
        //7º
        int x;
        Scanner escolha1 = new Scanner(System.in);
        x = escolha1.nextInt();
        
        for(int i = x; i != 1;){
            if(i%2 == 0){
                i = i/2;
                System.out.println(i);
            }
            else{
                i = (3*i)+1;
                System.out.println(i);
            }
        }
        
        //8º
        
        for(int i = 1; i<10 ; i++){
            for(int j = 1; j<=i ; j++){
                System.out.println(i*j+" ");
            }
            System.out.println("\n");
        }
        
        
    }
}
