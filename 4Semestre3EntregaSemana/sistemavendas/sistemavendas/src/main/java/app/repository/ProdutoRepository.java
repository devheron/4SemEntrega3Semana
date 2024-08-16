package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p WHERE p.nome = :nome")
	List<Produto> findByNome(@Param("nome") String nome);

	@Query("SELECT p FROM Produto p WHERE p.preco = :preco")
	List<Produto> findByPreco(@Param("preco") Double preco);

	@Query("SELECT p FROM Produto p WHERE p.preco = :preco AND p.nome = :nome")
	List<Produto> findByPrecoAndNome(@Param("preco") Double preco, @Param("nome") String nome);

	
}
