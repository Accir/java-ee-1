package vu.lt.fishing.usecases;


import vu.lt.fishing.services.FishCountGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateFishCount implements Serializable {

    @Inject
    FishCountGenerator fishCountGenerator;

    private CompletableFuture<Integer> countGenerationTask = null;

    public String generateNewFishCount() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        countGenerationTask = CompletableFuture.supplyAsync(() -> fishCountGenerator.generateFishCount());

        return "FishDetails?faces-redirect=true&fishId=" + requestParameters.get("fishId");
    }

    public boolean isCountGenerationRunning() {
        return countGenerationTask != null && !countGenerationTask.isDone();
    }

    public String getCountGenerationStatus() throws ExecutionException, InterruptedException{
        if(countGenerationTask == null ){
            return null;
        } else if (isCountGenerationRunning()) {
            return "Fish count prediction in progress!";
        }
        return countGenerationTask.get().toString();

    }
}
