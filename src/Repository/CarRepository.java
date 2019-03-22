package Repository;

import Domain.Car;
import Domain.CarValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private Map<Integer, Car> storage = new HashMap<>();
    private CarValidator validator;

    public CarRepository(CarValidator validator){
        this.validator = validator;
    }

    public Car getById(int id){
        return storage.get(id);
    }

    public void add(Car car) {
        if (storage.containsKey(car.getId())) {
            throw new RuntimeException("There already is a car with that id");
        }
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    public void update(Car car) {
        if (!storage.containsKey(car.getId())) {
            throw new RuntimeException("There is no car with that id");
        }
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no car with that id");
        }
        storage.remove(id);
    }

    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }
}