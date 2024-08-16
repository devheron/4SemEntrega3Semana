package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
	List<Usuario> findByNome(@Param("nome") String nome);

	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
	List<Usuario> findByCpf(@Param("cpf") String cpf);

	@Query("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.cpf = :cpf")
	List<Usuario> findByNomeAndCpf(@Param("nome") String nome, @Param("cpf") String cpf);

}