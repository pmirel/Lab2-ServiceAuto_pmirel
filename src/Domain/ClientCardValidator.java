package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientCardValidator {

    public void validate(ClientCard clientCard){
        if(clientCard.getCNP().length()!=13){
            throw new RuntimeException("CNP format not valid!");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        try {
            simpleDateFormat.parse(clientCard.getBirthDate());
        } catch (Exception e){
            throw new RuntimeException("Date format is not correct!");
        }
        try {
            simpleDateFormat.parse(clientCard.getRegistrationDate());
        } catch (Exception e){
            throw new RuntimeException("Date format is not correct!");
        }
    }
}
