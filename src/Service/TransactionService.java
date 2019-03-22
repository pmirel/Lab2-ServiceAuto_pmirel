package Service;

import Domain.Transaction;
import Repository.ClientCardRepository;
import Repository.CarRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;
    private CarRepository carRepository;
    private ClientCardRepository clienCardRepository;

    public TransactionService(TransactionRepository transactionRepository,CarRepository carRepository,ClientCardRepository clientCardRepository) {

        this.transactionRepository = transactionRepository;
        this.carRepository = carRepository;
        this.clienCardRepository = clientCardRepository;
    }

    public void add(int id, int carId, int clientId, double priceParts, double priceWork, String date, String hour){
        Transaction transaction = new Transaction( id,  carId,  clientId,  priceParts,  priceWork,  date,  hour);

        if (clienCardRepository.getById(clientId) != null){
            transaction.setDiscount(true);
        }
        if (carRepository.getById(carId).isWarranty()) {
            transaction.setPriceParts(0);
        }
        double disc=0;
        if (transaction.isDiscount()){
            disc = transaction.getPriceWork()*0.1;
        }

        transaction.setTotalPrice(transaction.getPriceParts()+(transaction.getPriceWork()-disc));
        transactionRepository.add(transaction);
    }

    public void update(int id, int carId, int clientId, double priceParts, double priceWork, String date, String hour){
        Transaction transaction = new Transaction( id,  carId,  clientId,  priceParts,  priceWork,  date,  hour);
        if (clienCardRepository.getById(clientId) != null){
            transaction.setDiscount(true);
        }
        if (carRepository.getById(carId).isWarranty()) {
            transaction.setPriceParts(0);
        }
        double disc=0;
        if (transaction.isDiscount()){
            disc = transaction.getPriceWork()*0.1;
        }

        transaction.setTotalPrice(transaction.getPriceParts()+(transaction.getPriceWork()-disc));
        transactionRepository.update(transaction);
    }

    public void remove(int id) {
        transactionRepository.remove(id);
    }

    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }
}