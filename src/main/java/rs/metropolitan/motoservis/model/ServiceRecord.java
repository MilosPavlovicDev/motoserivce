package rs.metropolitan.motoservis.model;

import java.time.LocalDate;

public class ServiceRecord {
    private Long id;
    private Motorcycle motorcycle;
    private  Mechanic mechanic;
    private LocalDate date;
    private String problemDescription;
    private Double laborCost;
    private ServiceStatus status;

    public ServiceRecord() {}

    public ServiceRecord(Long id, Motorcycle motorcycle, Mechanic mechanic, LocalDate date, String problemDescription, Double laborCost, ServiceStatus status) {
        this.id = id;
        this.motorcycle = motorcycle;
        this.mechanic = mechanic;
        this.date = date;
        this.problemDescription = problemDescription;
        this.laborCost = laborCost;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Motorcycle getMotorcycle(){
        return motorcycle;
    }
    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
}
