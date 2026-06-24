package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.metropolitan.motoservis.model.Owner;
import rs.metropolitan.motoservis.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/form";
    }

    @PostMapping
    public String save(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findById(id).orElseThrow();
        model.addAttribute("owner", owner);
        return "owners/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Owner owner) {
        owner.setId(id);
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        ownerService.deleteById(id);
        return "redirect:/owners";
    }
}