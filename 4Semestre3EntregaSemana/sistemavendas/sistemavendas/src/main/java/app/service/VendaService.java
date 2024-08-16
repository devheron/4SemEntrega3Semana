package app.service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    // Método para criar uma nova venda
    public Venda criarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    // Método para listar todas as vendas
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    // Método para obter uma venda pelo ID
    public Optional<Venda> obterVendaPorId(Long id) {
        return vendaRepository.findById(id);
    }

    // Método para deletar uma venda pelo ID
    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
    
    
    //PERSISTENCIA DE VALIDAÇÕES
    @Transactional
    public Venda save(Venda venda) {
        if (venda.getCliente().getIdade() < 18) {
            double valorTotal = calcularValorTotal(venda.getProdutos());
            if (valorTotal > 500) {
                throw new RuntimeException("Não pode comprar acima de 500 reais");
            }
        }
        return vendaRepository.save(venda);
    }

	private double calcularValorTotal(List<Produto> produtos) {
        // Implementar lógica para calcular o valor total
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}