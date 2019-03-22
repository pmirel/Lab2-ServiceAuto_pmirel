package Repository;

import Domain.ClientCard;
import Domain.ClientCardValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCardRepository {
    private Map<Integer, ClientCard> storage = new HashMap<>();
    private Map<String, ClientCard> storeCnp = new HashMap<>();
    private ClientCardValidator validator;



    public ClientCardRepository(ClientCardValidator validator){
        this.validator = validator;
    }

    public ClientCard getById(int id){
        return storage.get(id);
    }

    public void add(ClientCard clientCard) {
        if (storage.containsKey(clientCard.getId()) ) {
            throw new RuntimeException("This client already exists!");
        }
        if (storeCnp.containsKey(clientCard.getCNP())){
            throw new RuntimeException("This CNP is already in use!");
        }
        validator.validate(clientCard);
        storage.put(clientCard.getId(), clientCard);
        storeCnp.put(clientCard.getCNP(),clientCard);
    }

    public void update(ClientCard client) {
        if (!storage.containsKey(client.getId())) {
            throw new RuntimeException("This client card doesn't exists!");
        }
        validator.validate(client);
        storage.put(client.getId(), client);
    }

    public void remove (int id){
        if (!storage.containsKey(id)) {
            throw new RuntimeException("This client doesn't exists!");
        }
        storage.remove(id);
    }

    public List<ClientCard> getAll(){
        return new ArrayList<>(storage.values());
    }
}
