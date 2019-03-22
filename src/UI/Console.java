package UI;

import Domain.Car;
import Domain.ClientCard;
import Domain.Transaction;
import Service.ClientCardService;
import Service.CarService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {
    private CarService carService;
    private ClientCardService clientCardService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(CarService carService, ClientCardService clientCardService, TransactionService transactionService) {
        this.carService = carService;
        this.clientCardService = clientCardService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runCars();
                    break;
                case "2":
                    runClients();
                    break;
                case "3":
                    runTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runCars() {
        while (true) {
            showCarsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddCar();
                    break;
                case "2":
                    handleUpdateCar();
                    break;
                case "3":
                    handleRemoveCar();
                    break;
                case "4":
                    handleShowAllCars();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleShowAllCars() {
        for (Car car : carService.getAll()) {
            System.out.println(car);
        }
    }

    private void handleRemoveCar() {
        try {
            System.out.print("Enter id to remove: ");
            int id = scanner.nextInt();

            carService.remove(id);

            System.out.println("Car removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Car not removed");
        }
    }

    private void handleUpdateCar() {
        try {
            System.out.print("Enter id to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter model to update: ");
            String model = scanner.nextLine();
            System.out.print("Enter year of fabrication to update: ");
            int yearFabrication = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter year of acquisition to update:");
            int acquisitionYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of km to update: ");
            int km = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter if the car has warranty : ");
            boolean warranty = Boolean.parseBoolean(scanner.nextLine());
            carService.update(id, model, yearFabrication, acquisitionYear, km, warranty);
            System.out.println("Car updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Car not updated");
        }
    }

    private void handleAddCar() {
        try {
            System.out.print("Enter id to add: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter model to add: ");
            String model = scanner.nextLine();
            System.out.print("Enter year of fabrication to add: ");
            int yearFabrication = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter year of acquisition to add:");
            int acquisitionYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of km to add: ");
            int km = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter if the car has warranty : ");
            boolean warranty = Boolean.parseBoolean(scanner.nextLine());
            carService.add(id, model, yearFabrication, acquisitionYear, km, warranty);
            System.out.println("Car added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Car not added");
        }
    }

    private void showCarsMenu() {
        System.out.println("1. Add car");
        System.out.println("2. Update car");
        System.out.println("3. Remove car");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void showClientsMenu() {
        System.out.println("1. Add client");
        System.out.println("2. Update client");
        System.out.println("3. Remove client");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void runClients() {
        while (true) {
            showClientsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddClient();
                    break;
                case "2":
                    handleUpdateClient();
                    break;
                case "3":
                    handleRemoveClient();
                    break;
                case "4":
                    handleShowAllClients();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleAddClient() {
        try {
            System.out.print("Enter id: ");
            int id =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter secondName: ");
            String secondName = scanner.nextLine();
            System.out.print("Enter CNP: ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter registration date: ");
            String registrationDate = scanner.nextLine();
            clientCardService.add(id, firstName, secondName, CNP, birthDate, registrationDate);
            System.out.println("Client added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Client not added");
        }
    }

    private void handleUpdateClient() {
        try {
            System.out.print("Enter id to update: ");
            int id =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter firstName to update: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter secondName to update: ");
            String secondName = scanner.nextLine();
            System.out.print("Enter CNP to update: ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth to update : ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter registration date to update: ");
            String registrationDate = scanner.nextLine();
            clientCardService.update(id, firstName, secondName, CNP, birthDate, registrationDate);
            System.out.println("Client updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Client not updated");
        }
    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter id to remove: ");
            int id = Integer.parseInt(scanner.nextLine());

            clientCardService.remove(id);

            System.out.println("Client removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Client not removed");
        }
    }

    private void handleShowAllClients() {
        for (ClientCard clientCard : clientCardService.getAll()) {
            System.out.println(clientCard);
        }
    }

    private void showTransactionsMenu() {
        System.out.println("1. Add transaction");
        System.out.println("2. Update transaction");
        System.out.println("3. Remove transaction");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }

    private void runTransactions() {
        while (true) {
            showTransactionsMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddTransaction();
                    break;
                case "2":
                    handleUpdateTransaction();
                    break;
                case "3":
                    handleRemoveTransaction();
                    break;
                case "4":
                    handleShowAllTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleAddTransaction() {
        try {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter car id: ");
            int carId =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter client id: ");
            int clientId =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter price for parts: ");
            int priceParts = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter workforce price: ");
            int priceWork = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour: ");
            String hour = scanner.nextLine();

            transactionService.add(id, carId, clientId, priceParts, priceWork, date, hour);

            System.out.println("Transaction added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Transaction not added");
        }
    }

    private void handleUpdateTransaction() {
        try {
            System.out.print("Enter id to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter car id to update: ");
            int carId =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter client id to update: ");
            int clientId =Integer.parseInt(scanner.nextLine());
            System.out.print("Enter price for parts to update: ");
            int priceParts = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter workforce price to update: ");
            int priceWork = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date to update: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour to update: ");
            String hour = scanner.nextLine();

            transactionService.update(id, carId, clientId, priceParts, priceWork, date, hour);

            System.out.println("Transaction updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Transaction not updated");
        }
    }

    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter id to remove: ");
            int id =Integer.parseInt(scanner.nextLine());

            transactionService.remove(id);

            System.out.println("Transaction removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Transaction not removed");
        }
    }

    private void handleShowAllTransactions() {
        for (Transaction transaction : transactionService.getAll()) {
            System.out.println(transaction);
        }
    }

    private void showMenu() {
        System.out.println("1. CRUD Cars");
        System.out.println("2. CRUD Clients");
        System.out.println("3. CRUD Transactions");
        System.out.println("x. Exit");
    }
}
