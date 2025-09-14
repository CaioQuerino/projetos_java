package br.com.caioq.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ServicoEndereco {
    
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    
    public static String buscarEnderecoPorCep(String cep) {
        try {
            cep = cep.replaceAll("\\D", "");
            
            if (cep.length() != 8) {
                System.out.println("CEP inválido: " + cep);
                return "CEP inválido";
            }
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            if (response.statusCode() == 200) {
                RespostaViaCep respostaViaCep = gson.fromJson(response.body(), RespostaViaCep.class);
                
                if (respostaViaCep.erro != null && respostaViaCep.erro) {
                    return "CEP não encontrado: " + cep;
                }
                
                return formatarEndereco(respostaViaCep);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar endereço: " + e.getMessage());
        }
        return "Erro ao buscar endereço";
    }
    
    private static String formatarEndereco(RespostaViaCep endereco) {
        StringBuilder sb = new StringBuilder();
        if (endereco.logradouro != null && !endereco.logradouro.isEmpty()) {
            sb.append(endereco.logradouro);
        }
        if (endereco.bairro != null && !endereco.bairro.isEmpty()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(endereco.bairro);
        }
        if (endereco.localidade != null && !endereco.localidade.isEmpty()) {
            if (sb.length() > 0) sb.append(" - ");
            sb.append(endereco.localidade);
        }
        if (endereco.uf != null && !endereco.uf.isEmpty()) {
            if (sb.length() > 0) sb.append("/");
            sb.append(endereco.uf);
        }
        return sb.toString();
    }
    
    private static class RespostaViaCep {
        public String logradouro;
        public String bairro;
        public String localidade;
        public String uf;
        public Boolean erro;
    }
}