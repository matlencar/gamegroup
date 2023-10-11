package br.com.fiap.gamegroup.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/task")
public class TaskConsultaController {

    @Autowired
    TaskConsultaService service;
    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "task/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        
        if (service.delete(id)){
            redirect.addFlashAttribute("sucess", "Consulta apagada com sucesso");
        } else {
            redirect.addFlashAttribute("error", "Consulta não encontrada");
        }
        
        return "redirect:/task/";
    }
}
