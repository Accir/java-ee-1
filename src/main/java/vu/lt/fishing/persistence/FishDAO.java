package vu.lt.fishing.persistence;


import vu.lt.fishing.entities.Fish;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FishDAO {

    @Inject
    private EntityManager em;

    public List<Fish> loadAll(){
        return em.createNamedQuery("Fish.findAll", Fish.class).getResultList();
    }

    public void persist(Fish fish){
        this.em.persist(fish);
    }

    public Fish findOne(Integer id){
        return em.find(Fish.class, id);
    }

    public Fish update(Fish fish){
        return em.merge(fish);
    }
}
