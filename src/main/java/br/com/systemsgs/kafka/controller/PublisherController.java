package br.com.systemsgs.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/publisher")
public class PublisherController {
	
	@Autowired
	private KafkaTemplate<String , Object> template;
	
	@GetMapping(value = "/{nome}")
	public String publishMessage(@PathVariable String nome) {
		template.send("", "Olá: " + nome);
		return "";
	}

}
