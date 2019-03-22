package Service;

import Domain.ClientCard;
import Repository.ClientCardRepository;

import java.util.List;

public class ClientCardService {
    private ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository) {
        this.repository = repository;
    }

    public void add(int id, String firstName, String secondName, String CNP, String birthDate, String registrationDate){
        ClientCard clientCard = new ClientCard(id, firstName, secondName, CNP, birthDate, registrationDate);
        repository.add(clientCard);
    }

    public void update(int id, String firstName, String secondName, String CNP, String birthDate, String registrationDate){
        ClientCard clientCard = new ClientCard(id, firstName, secondName, CNP, birthDate, registrationDate);
        repository.update(clientCard);
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public List<ClientCard> getAll() {
        return repository.getAll();
    }
}