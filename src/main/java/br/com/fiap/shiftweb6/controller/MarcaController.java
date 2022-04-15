package br.com.fiap.shiftweb6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.shiftweb6.model.MarcaModel;
import br.com.fiap.shiftweb6.repository.MarcaRepository;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	MarcaRepository marcaRepository;

	@GetMapping("/{id}")
	public ResponseEntity<MarcaModel> findById(@PathVariable("id") Long id) {
		MarcaModel marcaModel = marcaRepository.findById(id).orElse(null);
		if (null == marcaModel) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(marcaModel); // problema
		}
	}

	@GetMapping()
	public ResponseEntity<List<MarcaModel>> findAll() {
		List<MarcaModel> lista = marcaRepository.findAll();
		return ResponseEntity.ok(lista); // problema
	}
}
