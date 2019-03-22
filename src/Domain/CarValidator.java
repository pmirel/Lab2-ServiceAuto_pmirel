package Domain;

public class CarValidator {

    public void validate(Car car){
        if(car.getKm() <= 0 || car.getYearFabrication() <=0) {
            throw new RuntimeException("Kilometers and fabrication year must be positive!");
        }

    }


}
