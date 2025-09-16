package br.com.caioq.positivo_ou_negativo;

public class Numero {
    private String mensagem;
    
    public String PositivoOrNegativo(int num) {
      if(num >= 0) {
          mensagem = positivo();
      } else {
          mensagem = negativo();
      }
       return mensagem;
    }
    
    private String positivo() {
        return "Numero Positivo !!!";
    }
    
    private String negativo () {
       return "Numero Negativo !!!";
    }
}