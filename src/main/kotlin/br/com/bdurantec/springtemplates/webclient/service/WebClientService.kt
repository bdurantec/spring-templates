package br.com.bdurantec.springtemplates.webclient.service

import br.com.bdurantec.springtemplates.webclient.model.JsonPlaceHolder
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class WebClientService {

    fun getWebClient(baseUrl: String): WebClient {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .build()
    }

    fun buscarConselho(): String? {
        val id = 1
        val client = getWebClient("https://api.adviceslip.com")

        //retorno em String pois a API retorna TEXT/HTML
        return client.get()
            .uri("/advice/{id}", id)
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
    }

    fun buscarJsonPlaceHolder(): JsonPlaceHolder? {
        val postId = 1
        val id = 1
        val client = getWebClient("https://jsonplaceholder.typicode.com")

        return client.get()
            .uri { it ->
                it
                    .path("/comments")
                    .queryParam("postId", postId, "id", id)
                    .build()
            }
            .retrieve()
            .bodyToFlux(JsonPlaceHolder::class.java).blockFirst()

    }
}