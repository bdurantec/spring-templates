package br.com.bdurantec.springtemplates.webclient.controller

import br.com.bdurantec.springtemplates.webclient.model.JsonPlaceHolder
import br.com.bdurantec.springtemplates.webclient.service.WebClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webclient")
class Controller(
    private val service: WebClientService
) {

    /*
    Descobrir como fazer conversão de TEXT/HTML para Objeto
     */
    @GetMapping("/conselho")
    fun getConselho(): ResponseEntity<String> {
        val resposta: String? = service.buscarConselho()
        return ResponseEntity.ok(resposta)
    }

    @GetMapping("/jsonPlaceHolder")
    fun getJsonPlaceHolder(): ResponseEntity<JsonPlaceHolder>{
        val resposta: JsonPlaceHolder? = service.buscarJsonPlaceHolder()
        return ResponseEntity.ok(resposta)
    }

}