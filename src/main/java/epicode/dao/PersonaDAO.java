package epicode.dao;

import epicode.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.transform.Source;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona p) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();
            System.out.println(p.getNome() + " " + p.getCognome() + " creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Persona findById(long id) {
        return em.find(Persona.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Persona found = em.find(Persona.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Persona eliminata");
            } else System.out.println("Persona non trovata");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
