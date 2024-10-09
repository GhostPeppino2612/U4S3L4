package epicode.dao;

import epicode.entities.Concerto;
import epicode.entities.Event;
import epicode.entities.Genere;
import epicode.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event getById(long id) {
        return em.find(Event.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        return em.createNamedQuery("getPartitePareggiate", PartitaDiCalcio.class).getResultList();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> list = em.createNamedQuery("getConcertiInStreaming", Concerto.class);
        list.setParameter("inStreaming", inStreaming);
        return list.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> list = em.createQuery("SELECT c FROM Concerto c WHERE c.genere=:g", Concerto.class);
        list.setParameter("g", genere);
        return list.getResultList();
    }
}
