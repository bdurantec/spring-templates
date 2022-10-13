package br.com.bdurantec.springtemplates.webclient.model

data class Conselho(
    val slip: SlipResponse
)

data class SlipResponse(
    val id: Int,
    val advice: String
)
