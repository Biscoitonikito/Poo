
package caelumcap3_1;

public class CaelumCap3_1 {

    public static void main(String[] args) {
        int gastoJaneiro = 15000;
        int gastoFervereiro = 23000;
        int gastoMarco = 17000;
        int gastoTrimestre = gastoJaneiro + gastoFervereiro + gastoMarco;
        int mediaMensal = gastoTrimestre/3;
        System.out.println(gastoTrimestre);
        System.out.println("Valor da média mensal = " + mediaMensal);
    }
    
}
