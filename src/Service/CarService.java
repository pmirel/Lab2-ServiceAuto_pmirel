package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.List;

public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public void add(int id, String model, int yearFabrication, int acquisitionYear, int km, boolean warranty){
        Car car = new Car(id, model, yearFabrication, acquisitionYear, km, warranty);
        repository.add(car);
    }

    public void update(int id, String model, int yearFabrication, int acquisitionYear, int km, boolean warranty){
        Car car = new Car(id, model, yearFabrication, acquisitionYear, km, warranty);
        repository.update(car);
    }

    public void remove(int id){
        repository.remove(id);
    }

    public List<Car> getAll() {
        return repository.getAll();
    }
}
