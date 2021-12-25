package br.unisul.aula.mscliente.repositorio;

import br.unisul.aula.mscliente.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByIdEndereco(Long id);
}

