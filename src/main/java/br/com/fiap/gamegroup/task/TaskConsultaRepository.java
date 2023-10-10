package br.com.fiap.gamegroup.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskConsultaRepository extends JpaRepository<Consulta, Integer> {
    
}
