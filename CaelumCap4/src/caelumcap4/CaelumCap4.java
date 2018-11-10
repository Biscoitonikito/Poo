
package caelumcap4;


public class CaelumCap4 {

    public static void main(String[] args) {
        //1º,2º,3º
        Conta c1 = new Conta();
        
        //6º{
        Data data = new Data();
        c1.abertura = data;
        //}

        c1.titular = "Hugo";
        c1.numero = 123;
        c1.agencia = "45678-9";
        c1.saldo = 50.0;
        //c1.abertura = "04/06/2015";

        c1.deposita(100.0);
        System.out.println("saldo atual:" + c1.saldo);
        System.out.println("rendimento mensal:" + c1.calculaRendimento());
        System.out.println(c1.recuperaDadosParaImpressao());
        
        //4º
        Conta c2 = new Conta();        
        c2.titular = "Danilo";
        c2.saldo = 100;

        Conta c3 = new Conta();        
        c3.titular = "Danilo";
        c3.saldo = 100;

        if (c2 == c3) {
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");        
        }
        
        //5º
        Conta c4 = new Conta();
        c1.titular = "Hugo";
        c1.saldo = 100;

        Conta c5 = c4;
        
        if (c4 == c5) {
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");        
        }
        
        
        
    }
    
}
