package br.com.fiap.gamegroup.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskConsultaController {

    @Autowired
    TaskConsultaService service;

    

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("tasks", service.findAll());
        return "task/index";
    } 
    

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

    @DeleteMapping
    public String deleteconsulta(Consulta consulta) {

        return "redirect:/task/";
    }

    @GetMapping("form")
    public String form(){

        return "task/form";
    }

    @PostMapping
    public String save(@Valid Consulta consulta, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "/task/form";
        service.save(consulta);
        redirect.addFlashAttribute("sucess", "Consulta cadastrada com sucesso com sucesso");

        return "redirect:/task/";
    }
}
