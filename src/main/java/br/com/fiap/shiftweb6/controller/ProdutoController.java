package br.com.fiap.shiftweb6.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.shiftweb6.model.ProdutoModel;
import br.com.fiap.shiftweb6.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findById(@PathVariable("id") Long id) {
		ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);
		if (null == produtoModel) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(produtoModel); //problema
		}
	}

	@GetMapping()
	public ResponseEntity<List<ProdutoModel>> findAll() {
		List<ProdutoModel> lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista); //problema
	}
}