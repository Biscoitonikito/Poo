
package modelCap9;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    Data(int a,int b, int c){
        if(b == 2){
            if( 0 < a && a <= 28 && 1950 < c && c <= 2108){
                this.dia = a;
                this.mes = b;
                this.ano = c;
            }
        }
        else{
            if(0 < a && a <= 28 && 0 < b && b <= 12 && 1950 < c && c <= 2108){
                this.dia = a;
                this.mes = b;
                this.ano = c;
            }
        }
    }
    public String dados(){
        return "Dia = " + this.dia + " Mês = " + this.mes + " Ano = " + this.ano;
    }
}
