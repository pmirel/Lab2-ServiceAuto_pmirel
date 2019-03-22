package Domain;

import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private int yearFabrication;
    private int acquisitionYear;
    private int km;
    private boolean warranty;


    public Car(int id, String model, int yearFabrication, int acquisitionYear, int km, boolean warranty) {
        this.id = id;
        this.model = model;
        this.yearFabrication = yearFabrication;
        this.acquisitionYear = acquisitionYear;
        this.km = km;
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", yearFabrication=" + yearFabrication +
                ", acquisitionYear=" + acquisitionYear +
                ", km=" + km +
                ", warranty=" + warranty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearFabrication() {
        return yearFabrication;
    }

    public void setYearFabrication(int yearFabrication) {
        this.yearFabrication = yearFabrication;
    }

    public int getAcquisitionYear() {
        return acquisitionYear;
    }

    public void setAcquisitionYear(int acquisitionYear) {
        this.acquisitionYear = acquisitionYear;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
