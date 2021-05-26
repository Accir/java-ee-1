package vu.lt.fishing.services.totalFishCount;

import vu.lt.fishing.entities.Fish;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import java.util.List;

@RequestScoped
@Alternative
public class ExtraAlternativeFishCountCalculator implements FishCountCalculator{

    @Override
    public int calculate(List<Fish> fish) {
        int totalCount = 0;
        for(Fish fishItem : fish) {
            totalCount = totalCount + Math.round(fishItem.getAverageSize()) / 5;
        }
        return totalCount;
    }
}
