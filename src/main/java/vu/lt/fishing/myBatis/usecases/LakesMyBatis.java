package vu.lt.fishing.myBatis.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.myBatis.dao.FishMapper;
import vu.lt.fishing.myBatis.dao.LakeMapper;
import vu.lt.fishing.myBatis.model.Fish;
import vu.lt.fishing.myBatis.model.Lake;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class LakesMyBatis {

    @Inject
    private LakeMapper lakeMapper;

    @Inject
    FishMapper fishMapper;

    @Getter
    @Setter
    private Lake lakeToCreate = new Lake();

    @Getter
    private List<Lake> allLakes;

    @PostConstruct
    public void init(){
        loadAllLakes();
    }

    @Transactional
    public String addLake(){
        this.lakeMapper.insert(lakeToCreate);
        return "LakesMyBatis?faces-redirect=true";
    }

    private void loadAllLakes(){
        this.allLakes = lakeMapper.selectAll();

    }

    public List<Fish> getFish(Integer id){
        System.out.println(fishMapper.selectFishForLake(id));
        return fishMapper.selectFishForLake(id);
    }
}
