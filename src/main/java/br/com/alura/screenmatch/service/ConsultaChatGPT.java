package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}