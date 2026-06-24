package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.metropolitan.motoservis.model.Mechanic;
import rs.metropolitan.motoservis.model.Motorcycle;
import rs.metropolitan.motoservis.model.ServiceRecord;
import rs.metropolitan.motoservis.model.ServiceStatus;
import rs.metropolitan.motoservis.service.MechanicService;
import rs.metropolitan.motoservis.service.MotorcycleService;
import rs.metropolitan.motoservis.service.ServiceRecordService;

@Controller
@RequestMapping("/service-records")
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;
    private final MotorcycleService motorcycleService;
    private final MechanicService mechanicService;

    public ServiceRecordController(ServiceRecordService serviceRecordService,
                                   MotorcycleService motorcycleService,
                                   MechanicService mechanicService) {
        this.serviceRecordService = serviceRecordService;
        this.motorcycleService = motorcycleService;
        this.mechanicService = mechanicService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("serviceRecords", serviceRecordService.findAll());
        return "service-records/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("serviceRecord", new ServiceRecord());
        model.addAttribute("motorcycles", motorcycleService.findAll());
        model.addAttribute("mechanics", mechanicService.findAll());
        model.addAttribute("statuses", ServiceStatus.values());
        return "service-records/form";
    }

    @PostMapping
    public String save(@ModelAttribute ServiceRecord serviceRecord,
                       @RequestParam Long motorcycleId,
                       @RequestParam Long mechanicId) {
        Motorcycle motorcycle = motorcycleService.findById(motorcycleId).orElseThrow();
        Mechanic mechanic = mechanicService.findById(mechanicId).orElseThrow();
        serviceRecord.setMotorcycle(motorcycle);
        serviceRecord.setMechanic(mechanic);
        serviceRecordService.save(serviceRecord);
        return "redirect:/service-records";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        ServiceRecord serviceRecord = serviceRecordService.findById(id).orElseThrow();
        model.addAttribute("serviceRecord", serviceRecord);
        model.addAttribute("motorcycles", motorcycleService.findAll());
        model.addAttribute("mechanics", mechanicService.findAll());
        model.addAttribute("statuses", ServiceStatus.values());
        return "service-records/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute ServiceRecord serviceRecord,
                         @RequestParam Long motorcycleId,
                         @RequestParam Long mechanicId) {
        Motorcycle motorcycle = motorcycleService.findById(motorcycleId).orElseThrow();
        Mechanic mechanic = mechanicService.findById(mechanicId).orElseThrow();
        serviceRecord.setId(id);
        serviceRecord.setMotorcycle(motorcycle);
        serviceRecord.setMechanic(mechanic);
        serviceRecordService.save(serviceRecord);
        return "redirect:/service-records";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        serviceRecordService.deleteById(id);
        return "redirect:/service-records";
    }
}
