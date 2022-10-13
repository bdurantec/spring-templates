package br.com.bdurantec.springtemplates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringTemplatesApplication

fun main(args: Array<String>) {
	runApplication<SpringTemplatesApplication>(*args)
}
