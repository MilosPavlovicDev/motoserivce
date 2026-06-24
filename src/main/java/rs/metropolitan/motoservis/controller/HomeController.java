package rs.metropolitan.motoservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rs.metropolitan.motoservis.model.ServiceStatus;
import rs.metropolitan.motoservis.service.MechanicService;
import rs.metropolitan.motoservis.service.MotorcycleService;
import rs.metropolitan.motoservis.service.OwnerService;
import rs.metropolitan.motoservis.service.ServiceRecordService;

@Controller
public class HomeController {

    private final OwnerService ownerService;
    private final MotorcycleService motorcycleService;
    private final MechanicService mechanicService;
    private final ServiceRecordService serviceRecordService;

    public HomeController(OwnerService ownerService,
                          MotorcycleService motorcycleService,
                          MechanicService mechanicService,
                          ServiceRecordService serviceRecordService) {
        this.ownerService = ownerService;
        this.motorcycleService = motorcycleService;
        this.mechanicService = mechanicService;
        this.serviceRecordService = serviceRecordService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("ownerCount", ownerService.findAll().size());
        model.addAttribute("motorcycleCount", motorcycleService.findAll().size());
        model.addAttribute("mechanicCount", mechanicService.findAll().size());
        model.addAttribute("totalServices", serviceRecordService.findAll().size());
        model.addAttribute("activeServices", serviceRecordService.findAll()
                .stream()
                .filter(sr -> sr.getStatus() == ServiceStatus.IN_PROGRESS)
                .count());
        model.addAttribute("completedServices", serviceRecordService.findAll()
                .stream()
                .filter(sr -> sr.getStatus() == ServiceStatus.COMPLETED)
                .count());
        return "index";
    }
}
