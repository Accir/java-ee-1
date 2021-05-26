package vu.lt.fishing.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.interceptors.LoggedInvocation;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.persistence.LakeDAO;
import vu.lt.fishing.services.totalFishCount.DefaultFishCountCalculator;
import vu.lt.fishing.services.totalFishCount.FishCountCalculator;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@LoggedInvocation
public class FishCase {

    @Inject
    private FishDAO fishDAO;

    @Inject
    private LakeDAO lakeDAO;

    @Inject
    private DefaultFishCountCalculator fishCountCalculator;

    @Inject
    private FishCountCalculator alternativeFishCountCalculator;

    @Getter @Setter
    private Fish fishToCreate = new Fish();

    @Getter
    private List<Fish> allFish;

    @Getter
    private List<String> allLakes;

    @Getter @Setter
    private String selectedLake;

    @Getter @Setter
    private Integer totalFishCount;

    @Getter @Setter
    private Integer alternativeFishCount;

    @PostConstruct
    public void init() {
        loadAllLakes();
        loadAllFish();
        calculateTotalFishCount();
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

    private void calculateTotalFishCount() {
        this.totalFishCount = this.fishCountCalculator.calculate(allFish);
        this.alternativeFishCount = this.alternativeFishCountCalculator.calculate(allFish);
    }



}
