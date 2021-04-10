package vu.lt.fishing.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Lake;
import vu.lt.fishing.persistence.LakeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Lakes {

    @Inject
    private LakeDAO lakeDAO;

    @Getter @Setter
    private Lake lakeToCreate = new Lake();

    @Getter
    private List<Lake> allLakes;

    @PostConstruct
    public void init(){
        loadAllLakes();
    }

    @Transactional
    public String addLake(){
        this.lakeDAO.persist(lakeToCreate);
        return "Lakes?faces-redirect=true";
    }

    private void loadAllLakes(){
        this.allLakes = lakeDAO.loadAll();
    }

}
