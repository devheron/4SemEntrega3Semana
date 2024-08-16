package app.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	@Query("SELECT v FROM Venda v WHERE v.id = :id")
	Optional<Venda> findById(@Param("id") Long id);

	@Query("SELECT u FROM Venda u WHERE u.data = :data")
	Optional<Venda> findByData(@Param("data") Date data);

	@Query("SELECT u FROM Venda u WHERE u.id = :id AND u.data = :data")
	Optional<Venda> findByIdAndData(@Param("id") Long id, @Param("data") Date data);
}