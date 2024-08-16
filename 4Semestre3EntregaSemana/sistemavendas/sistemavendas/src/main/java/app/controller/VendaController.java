package app.controller;

import app.entity.Venda;
import app.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // Endpoint para criar uma nova venda
    @PostMapping("/save")
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        Venda vendaCriada = vendaService.criarVenda(venda);
        return new ResponseEntity<>(vendaCriada, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as vendas
    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        List<Venda> vendas = vendaService.listarVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // Endpoint para obter uma venda pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Venda> obterVendaPorId(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.obterVendaPorId(id);
		return null;
    }

    // Endpoint para deletar uma venda pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
