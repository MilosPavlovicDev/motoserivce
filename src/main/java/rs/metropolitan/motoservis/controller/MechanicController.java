package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.metropolitan.motoservis.model.Mechanic;
import rs.metropolitan.motoservis.service.MechanicService;

@Controller
@RequestMapping("/mechanics")
public class MechanicController {

    private final MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("mechanics", mechanicService.findAll());
        return "mechanics/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "mechanics/form";
    }

    @PostMapping
    public String save(@ModelAttribute Mechanic mechanic) {
        mechanicService.save(mechanic);
        return "redirect:/mechanics";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Mechanic mechanic = mechanicService.findById(id).orElseThrow();
        model.addAttribute("mechanic", mechanic);
        return "mechanics/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Mechanic mechanic) {
        mechanic.setId(id);
        mechanicService.save(mechanic);
        return "redirect:/mechanics";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        mechanicService.deleteById(id);
        return "redirect:/mechanics";
    }
}
