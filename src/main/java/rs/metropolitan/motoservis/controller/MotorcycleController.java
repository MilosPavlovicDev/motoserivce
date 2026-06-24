package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.metropolitan.motoservis.model.Motorcycle;
import rs.metropolitan.motoservis.model.Owner;
import rs.metropolitan.motoservis.service.MotorcycleService;
import rs.metropolitan.motoservis.service.OwnerService;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;
    private final OwnerService ownerService;

    public MotorcycleController(MotorcycleService motorcycleService, OwnerService ownerService) {
        this.motorcycleService = motorcycleService;
        this.ownerService = ownerService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("motorcycles", motorcycleService.findAll());
        return "motorcycles/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("motorcycle", new Motorcycle());
        model.addAttribute("owners", ownerService.findAll());
        return "motorcycles/form";
    }

    @PostMapping
    public String save(@ModelAttribute Motorcycle motorcycle,
                       @RequestParam Long ownerId) {
        Owner owner = ownerService.findById(ownerId).orElseThrow();
        motorcycle.setOwner(owner);
        motorcycleService.save(motorcycle);
        return "redirect:/motorcycles";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Motorcycle motorcycle = motorcycleService.findById(id).orElseThrow();
        model.addAttribute("motorcycle", motorcycle);
        model.addAttribute("owners", ownerService.findAll());
        return "motorcycles/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute Motorcycle motorcycle,
                         @RequestParam Long ownerId) {
        Owner owner = ownerService.findById(ownerId).orElseThrow();
        motorcycle.setId(id);
        motorcycle.setOwner(owner);
        motorcycleService.save(motorcycle);
        return "redirect:/motorcycles";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        motorcycleService.deleteById(id);
        return "redirect:/motorcycles";
    }
}
