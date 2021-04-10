package vu.lt.fishing.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.persistence.FishDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class FishCase {

    @Inject
    private FishDAO fishDAO;

    @Getter @Setter
    private Fish fishToCreate = new Fish();

    @Getter
    private List<Fish> allFish;

    @PostConstruct
    public void init(){
        loadAllFish();
    }

    @Transactional
    public String addFish(){
        this.fishDAO.persist(fishToCreate);
        return "Fish?faces-redirect=true";
    }

    private void loadAllFish(){
        this.allFish = fishDAO.loadAll();
    }

}
