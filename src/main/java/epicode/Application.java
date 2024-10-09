package epicode;

import com.github.javafaker.Faker;
import epicode.dao.EventsDAO;
import epicode.dao.LocationsDAO;
import epicode.dao.PartecipazioneDAO;
import epicode.dao.PersonaDAO;
import epicode.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO attendancesDAO = new PartecipazioneDAO(em);

        Location location1 = new Location("nome città1", "nomecitta1");
        Location location2 = new Location("nome città2", "nomecitta2");
        // locationsDAO.save(location1);
        // locationsDAO.save(location2);
        Persona persona1 = new Persona("Luigi", "Grassi", "luigigrassi@gmail.com", LocalDate.now().minusYears(20), Sesso.MASCHIO);
        // PersonaDAO.save(persona1)

        // Persona persona = pd.findById(2);
        // Event event = eventsDAO.getById(2);

      //  Partecipazione partecipazione = new Partecipazione(persona, event, Stato.DA_CONFERMARE);

      //  persona.getListaPartecipazioni().forEach(System.out::println);

       // event.getListaPartecipazioni().forEach(System.out::println);

     // eventsDAO.delete(24);

        em.close();
        emf.close();
   }
}
