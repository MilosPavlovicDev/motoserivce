package rs.metropolitan.motoservis.model;

public class Part {
    private Long id;
    private String name;
    private Double price;
    private ServiceRecord serviceRecord;

    public Part() {}

    public Part(Long id, String name, Double price, ServiceRecord serviceRecord) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.serviceRecord = serviceRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ServiceRecord getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(ServiceRecord serviceRecord) {
        this.serviceRecord = serviceRecord;
    }
}
