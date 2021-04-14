package vu.lt.fishing.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.persistence.LakeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class FishCase {

    @Inject
    private FishDAO fishDAO;

    @Inject LakeDAO lakeDAO;

    @Getter @Setter
    private Fish fishToCreate = new Fish();

    @Getter
    private List<Fish> allFish;

    @Getter
    private List<String> allLakes;

    @Getter @Setter
    private String selectedLake;


    @PostConstruct
    public void init() {
        loadAllLakes();
        loadAllFish();
    }

    @Transactional
    public String addFish(){
        fishToCreate.setLake(lakeDAO.findOne(this.selectedLake));
        this.fishDAO.persist(fishToCreate);
        return "Fish?faces-redirect=true";
    }

    private void loadAllFish() {
        this.allFish = fishDAO.loadAll();
    }

    private void loadAllLakes(){
        this.allLakes = lakeDAO.loadAllNames();
    }

}
