package app.service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ProdutoService {

        @Autowired
        private ProdutoRepository produtoRepository;

        // Método para criar um novo produto
        public Produto criarProduto(Produto produto) {
            return produtoRepository.save(produto);
        }

        // Método para atualizar um produto existente
        public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
            Optional<Produto> produtoOptional = produtoRepository.findById(id);
            if (produtoOptional.isPresent()) {
                Produto produto = produtoOptional.get();
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setDescricao(produtoAtualizado.getDescricao());
                return produtoRepository.save(produto);
            }
            return null; // Ou lance uma exceção personalizada
        }

        // Método para listar todos os produtos
        public List<Produto> listarProdutos() {
            return produtoRepository.findAll();
        }

        // Método para obter um produto pelo ID
        public Optional<Produto> obterProdutoPorId(Long id) {
            return produtoRepository.findById(id);
        }

        // Método para deletar um produto pelo ID
        public void deletarProduto(Long id) {
            produtoRepository.deleteById(id);
        }
    }