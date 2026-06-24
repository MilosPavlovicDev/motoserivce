package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.metropolitan.motoservis.model.Part;
import rs.metropolitan.motoservis.model.ServiceRecord;
import rs.metropolitan.motoservis.service.PartService;
import rs.metropolitan.motoservis.service.ServiceRecordService;

@Controller
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;
    private final ServiceRecordService serviceRecordService;

    public PartController(PartService partService, ServiceRecordService serviceRecordService) {
        this.partService = partService;
        this.serviceRecordService = serviceRecordService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("parts", partService.findAll());
        return "parts/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("part", new Part());
        model.addAttribute("serviceRecords", serviceRecordService.findAll());
        return "parts/form";
    }

    @PostMapping
    public String save(@ModelAttribute Part part,
                       @RequestParam Long serviceRecordId) {
        ServiceRecord serviceRecord = serviceRecordService.findById(serviceRecordId).orElseThrow();
        part.setServiceRecord(serviceRecord);
        partService.save(part);
        return "redirect:/parts";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Part part = partService.findById(id).orElseThrow();
        model.addAttribute("part", part);
        model.addAttribute("serviceRecords", serviceRecordService.findAll());
        return "parts/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute Part part,
                         @RequestParam Long serviceRecordId) {
        ServiceRecord serviceRecord = serviceRecordService.findById(serviceRecordId).orElseThrow();
        part.setId(id);
        part.setServiceRecord(serviceRecord);
        partService.save(part);
        return "redirect:/parts";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        partService.deleteById(id);
        return "redirect:/parts";
    }
}
