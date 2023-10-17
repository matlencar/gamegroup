package br.com.fiap.gamegroup.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskConsultaService {

    @Autowired
    TaskConsultaRepository repository;
    
    public List<Consulta> findAll() {
        
        return repository.findAll();
    }

    public boolean delete(int id) {
        var consulta = repository.findById(id);

        if(consulta.isEmpty()) return false;

        repository.deleteById(id);
        return true;
    }

    public void save(Consulta consulta) {
        repository.save(consulta);
    }
}
