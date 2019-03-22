import Domain.ClientCardValidator;
import Domain.CarValidator;
import Domain.TransactionValidator;
import Repository.ClientCardRepository;
import Repository.CarRepository;
import Repository.TransactionRepository;
import Service.ClientCardService;
import Service.CarService;
import Service.TransactionService;
import UI.Console;


public class Main {

    public static void main(String[] args) {
        ClientCardValidator clientValidator = new ClientCardValidator();
        ClientCardRepository clientRepository = new ClientCardRepository(clientValidator);
        ClientCardService clientService = new ClientCardService(clientRepository);

        CarValidator carValidator = new CarValidator();
        CarRepository carRepository = new CarRepository(carValidator);
        CarService carService = new CarService(carRepository);

        TransactionValidator transactionValidator = new TransactionValidator();
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);
        TransactionService transactionService = new TransactionService(transactionRepository,carRepository,clientRepository);

        Console console = new Console(carService,clientService,transactionService);
        console.run();

    }
}