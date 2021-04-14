
package vu.lt.fishing.persistence;

import vu.lt.fishing.entities.FishingRods;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FishingRodsDAO {

    @Inject
    private EntityManager em;

    public List<FishingRods> loadAll(){
        return em.createNamedQuery("Fish.findAll", FishingRods.class).getResultList();
    }

    public void persist(FishingRods rod){
        this.em.persist(rod);
    }

    public FishingRods findOne(Integer id){
        return em.find(FishingRods.class, id);
    }

}