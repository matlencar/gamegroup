package br.com.fiap.gamegroup.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Consulta {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    @Size(min = 1)
    String medico;
    
    @NotBlank
    @Size(min = 1)
    String especialidade;
    
    @NotBlank
    @Size(min = 1, message = "{task.description.size}")
    String descricao;

    @Positive
    Integer status;
}
