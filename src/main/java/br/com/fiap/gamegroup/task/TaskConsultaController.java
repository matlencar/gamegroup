package br.com.fiap.gamegroup.task;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskConsultaController {
    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", List.of("Consulta 1", "Consulta 2", "Consulta 3"));
        return "task/index";
    }
}
