package UI;
import Domain.ClientCard;
import Domain.Car;
import Domain.Transaction;
import Service.ClientCardService;
import Service.CarService;
import Service.TransactionService;

import java.util.Scanner;


public class NewConsole {
    private CarService carService;
    private ClientCardService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public NewConsole(CarService carService, ClientCardService clientService, TransactionService transactionService) {
        this.carService = carService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("Your option:");
        System.out.println("add/update car,id,model,year of fabrication, year of fabrication, km, warranty");
        System.out.println("add/update client card,id, firstName, secondName, CNP, birthDate, registrationDate");
        System.out.println("add/update transaction,id, carId, clientId, priceParts, priceWork, date(dd.mm.yyyy), hour(hh.mm)");
        System.out.println("remove car/client/transaction,id");
        System.out.println("show  car/client/transaction ");
        System.out.println();

        System.out.println();

        System.out.println();
        System.out.println("x. Exit");
    }


    public void run() {
        while (true) {
            showMenu();
            System.out.println();
            String input = scanner.nextLine();
            String text[] = input.split(",");
            switch (text[0].toLowerCase()) {
                case "add car":{
                    carService.add( Integer.parseInt(text[1]),  text[2],  Integer.parseInt(text[3]),  Integer.parseInt(text[4]), Integer.parseInt(text[5]), Boolean.parseBoolean(text[6]));
                    break;
                }
                case "add client": {
                    clientService.add(Integer.parseInt(text[1]), text[2], text[3], text[4], text[5], text[6]);
                    break;
                }
                case "add transaction": {
                    transactionService.add(Integer.parseInt(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]), Integer.parseInt(text[4]), Integer.parseInt(text[5]), text[6], text[7]);
                    break;
                }
                case "update car":{
                    carService.update( Integer.parseInt(text[1]),  text[2],  Integer.parseInt(text[3]),  Integer.parseInt(text[4]),Integer.parseInt(text[5]), Boolean.parseBoolean(text[6]));
                    break;
                }
                case "update client": {
                    clientService.update(Integer.parseInt(text[1]), text[2], text[3], text[4], text[5], text[6]);
                    break;
                }
                case "update transaction": {
                    transactionService.update(Integer.parseInt(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]), Integer.parseInt(text[4]), Integer.parseInt(text[5]), text[6], text[7]);
                    break;
                }
                case "remove car": {
                    carService.remove(Integer.parseInt(text[1]));
                    break;
                }
                case "remove client": {
                    clientService.remove(Integer.parseInt(text[1]));
                    break;
                }
                case "remove transaction": {
                    transactionService.remove(Integer.parseInt(text[1]));
                    break;
                }
                case "show car":{
                    for (Car car : carService.getAll()) {
                        System.out.println(car);
                    }
                    break;
                }
                case "show client":{
                    for (ClientCard clientCard : clientService.getAll()) {
                        System.out.println(clientCard);
                    }
                    break;}
                case "show transaction": {
                    for (Transaction transaction : transactionService.getAll()) {
                        System.out.println(transaction);
                    }
                    break;
                }
//                case "show interval":{
//                    try {
//                        System.out.print("Enter first price intervals: ");
//                        double a =Double.parseDouble(scanner.nextLine());
//                        System.out.print("Enter second price intervals: ");
//                        double b =Double.parseDouble(scanner.nextLine());
//                        for (Transaction transaction : transactionService.getPriceInterval(a,b)) {
//                            System.out.println(transaction);
//                        }
//
//                    } catch (RuntimeException re) {
//                        System.out.println("Price interval error");
//                    }
//                }
                case "x":
                    return;
                default: {
                    System.out.println("Invalid option!");
                    break;
                }
            }
        }
    }





}

