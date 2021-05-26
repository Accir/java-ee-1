package vu.lt.fishing.services.totalFishCount;

import vu.lt.fishing.entities.Fish;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DefaultFishCountCalculator implements FishCountCalculator{

    @Override
    public int calculate(List<Fish> fish) {

        int totalCount = 0;
        for(Fish fishItem : fish) {
            totalCount = totalCount + Math.round(fishItem.getAverageSize());
        }
        return totalCount;
    }
}
