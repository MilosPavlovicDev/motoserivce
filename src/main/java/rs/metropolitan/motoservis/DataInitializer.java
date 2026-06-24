package rs.metropolitan.motoservis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.metropolitan.motoservis.model.*;
import rs.metropolitan.motoservis.service.*;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final MotorcycleService motorcycleService;
    private final MechanicService mechanicService;
    private final ServiceRecordService serviceRecordService;
    private final PartService partService;

    public DataInitializer(OwnerService ownerService,
                           MotorcycleService motorcycleService,
                           MechanicService mechanicService,
                           ServiceRecordService serviceRecordService,
                           PartService partService) {
        this.ownerService = ownerService;
        this.motorcycleService = motorcycleService;
        this.mechanicService = mechanicService;
        this.serviceRecordService = serviceRecordService;
        this.partService = partService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner(null, "Milos", "Pavlovic", "0641234567", "milos@email.com");
        Owner owner2 = new Owner(null, "Marko", "Markovic", "0651234567", "marko@email.com");
        ownerService.save(owner1);
        ownerService.save(owner2);

        Mechanic mechanic1 = new Mechanic(null, "Nikola", "Nikolic", "Motori i transmisija");
        Mechanic mechanic2 = new Mechanic(null, "Stefan", "Stefanovic", "Elektrika");
        mechanicService.save(mechanic1);
        mechanicService.save(mechanic2);

        Motorcycle moto1 = new Motorcycle(null, "Yamaha", "MT-07", 2021, "BG123-AA", owner1);
        Motorcycle moto2 = new Motorcycle(null, "Honda", "CB650R", 2020, "NS456-BB", owner2);
        motorcycleService.save(moto1);
        motorcycleService.save(moto2);

        ServiceRecord sr1 = new ServiceRecord(null, moto1, mechanic1, LocalDate.now(), "Zamena ulja i filtera", 3500.0, ServiceStatus.COMPLETED);
        ServiceRecord sr2 = new ServiceRecord(null, moto2, mechanic2, LocalDate.now(), "Dijagnostika elektrike", 2000.0, ServiceStatus.IN_PROGRESS);
        serviceRecordService.save(sr1);
        serviceRecordService.save(sr2);

        Part part1 = new Part(null, "Filter ulja", 800.0, sr1);
        Part part2 = new Part(null, "Motorno ulje 4L", 2400.0, sr1);
        partService.save(part1);
        partService.save(part2);
    }
}
