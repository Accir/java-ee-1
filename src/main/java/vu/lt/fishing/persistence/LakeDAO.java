package vu.lt.fishing.persistence;

import vu.lt.fishing.entities.Lake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class LakeDAO {

    @Inject
    private EntityManager em;

    public List<Lake> loadAll(){
        return em.createNamedQuery("Lake.findAll", Lake.class).getResultList();
    }

    public List<String> loadAllNames(){
        return em.createNamedQuery("Lake.findNames", String.class).getResultList();
    }

    public void persist(Lake lake){
        this.em.persist(lake);
    }

    public Lake findOne(String name){
        Query query = em.createNamedQuery("Lake.findByName", Lake.class);
        query.setParameter("name", name);
        return (Lake) query.getSingleResult();
    }

    public Lake findById(Integer id) {
        return em.find(Lake.class, id);
    }

}
