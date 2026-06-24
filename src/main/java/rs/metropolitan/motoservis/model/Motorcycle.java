package rs.metropolitan.motoservis.model;

public class Motorcycle {
    private Long id;
    private String brand;
    private String model;
    private Integer yearOfManufacture;
    private String licencePlate;
    private Owner owner;

    public Motorcycle() {}

    public Motorcycle(Long id, String brand, String model, Integer yearOfManufacture, String licencePlate, Owner owner) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.licencePlate = licencePlate;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
