package br.com.fiap.shiftweb6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.shiftweb6.model.LojaModel;
import br.com.fiap.shiftweb6.repository.LojaRepository;

@RestController
@RequestMapping("/loja")
public class LojaController {
	@Autowired
	LojaRepository lojaRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaModel> findById(@PathVariable("id") Long id) {
		LojaModel lojaModel = lojaRepository.findById(id).orElse(null);
		if (null == lojaModel) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lojaModel); // problema
		}
	}

	@GetMapping()
	public ResponseEntity<List<LojaModel>> findAll() {
		List<LojaModel> lista = lojaRepository.findAll();
		return ResponseEntity.ok(lista); // problema
	}

}
