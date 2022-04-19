package br.com.fiap.shiftweb6.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.shiftweb6.model.CategoriaModel;
import br.com.fiap.shiftweb6.model.ProdutoModel;
import br.com.fiap.shiftweb6.model.mixin.ProdutosMixin;
import br.com.fiap.shiftweb6.model.mixin.SkuMixin;
import br.com.fiap.shiftweb6.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/{id}")
	public ResponseEntity<JsonNode> findById(@PathVariable("id") Long id) throws JsonMappingException, JsonProcessingException {
		ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(CategoriaModel.class, ProdutosMixin.class);
		//mapper.addMixIn(ProdutoModel.class, SkuMixin.class);
		
		if (null == produtoModel) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(mapper.readTree(mapper.writeValueAsString(produtoModel))); //problema
		}
	}

	@GetMapping()
	public ResponseEntity<List<ProdutoModel>> findAll() {
		List<ProdutoModel> lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista); //problema
	}
}