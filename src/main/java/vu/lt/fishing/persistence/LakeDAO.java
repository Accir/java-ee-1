package vu.lt.fishing.persistence;

import vu.lt.fishing.entities.Lake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LakeDAO {

    @Inject
    private EntityManager em;

    public List<Lake> loadAll(){
        return em.createNamedQuery("Lake.findAll", Lake.class).getResultList();
    }

    public void persist(Lake lake){
        this.em.persist(lake);
    }

    public Lake findOne(Integer id){
        return em.find(Lake.class, id);
    }

    public Lake update(Lake lake){
        return em.merge(lake);
    }

}
