package vu.lt.fishing.myBatis.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.myBatis.dao.FishMapper;
import vu.lt.fishing.myBatis.dao.LakeMapper;
import vu.lt.fishing.myBatis.model.Fish;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class FishCaseMyBatis {

    @Inject
    private FishMapper fishMapper;

    @Inject
    private LakeMapper lakeMapper;

    @Getter @Setter
    private Fish fishToCreate = new Fish();

    @Getter
    private List<Fish> allFish;

    @Getter @Setter
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

        fishToCreate.setLakeId(lakeMapper.selectByName(selectedLake).get(0).getId());
        this.fishMapper.insert(fishToCreate);
        return "FishMyBatis?faces-redirect=true";
    }

    private void loadAllFish() {
        this.allFish = fishMapper.selectAll();
    }

    private void loadAllLakes(){
        allLakes = lakeMapper.selectAllNames();
    }

    public String selectLakeName(Integer id) {
        return lakeMapper.selectByPrimaryKey(id).getName();
    }
}