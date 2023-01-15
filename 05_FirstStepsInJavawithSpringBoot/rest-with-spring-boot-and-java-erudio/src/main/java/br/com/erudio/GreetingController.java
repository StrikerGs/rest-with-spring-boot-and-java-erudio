package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/* Resquet Mapping irá mapear uma requisição para um método e tornará isso um endereço HTTP, no caso,
	 * greeting.*/
	
	@RequestMapping("/greeting")
	/* Request Param é um tipo de parametro opcional, também chamado de query param ou query string
	* quando não passarmos nenhum value ao "name", o valor do parâmetro será World */
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}
	
}
