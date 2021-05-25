package vu.lt.fishing.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.entities.Lake;
import vu.lt.fishing.interceptors.LoggedInvocation;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.persistence.LakeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Model
@LoggedInvocation
public class UpdateFishLake implements Serializable {

    @Inject
    private FishDAO fishDAO;

    @Inject
    private LakeDAO lakeDAO;

    @Getter
    private List<Lake> allLakes;

    @Getter @Setter
    private Integer selectedLake;

    @Getter @Setter
    private Fish fish;


    @PostConstruct
    public void init() {
        loadAllLakes();
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer fishId = Integer.parseInt(requestParameters.get("fishId"));
        this.fish = fishDAO.findOne(fishId);
    }

    @Transactional
    public String updateFish(){
        if(selectedLake == null ){
            return "FishDetails?faces-redirect=true&error=null-value&fishId=" + this.fish.getId();
        }
        fish.setLake(lakeDAO.findById(selectedLake));
        try {
            fishDAO.update(fish);
        } catch (OptimisticLockException e) {
            System.out.println("[Error]" + e.toString());
            return "FishDetails?faces-redirect=true&error=optimistic-lock-exception&fishId=" + this.fish.getId();
        }
        catch (Exception e) {
            System.out.println("[Error]" + e.toString());
            return "FishDetails?faces-redirect=true&error=internal-error&fishId=" + this.fish.getId();
        }
        return "FishDetails?faces-redirect=true&fishId=" + this.fish.getId();
    }

    private void loadAllLakes(){
        this.allLakes = lakeDAO.loadAll();
    }
}
