package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Entrou no run!");
        try {
            var consumoApi = new ConsumoApi();
            var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=e476b192");
            System.out.println("json obtido:" + json);
            ConverteDados conversor = new ConverteDados();
            DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
            System.out.println(dados);
        } catch (RuntimeException e) {
            System.err.println("\n\n----------------- ERRO CATCH PRINCIPAL -----------------");
            e.printStackTrace();
            System.err.println("------------------------------------------------------\n");
        }
    }
}