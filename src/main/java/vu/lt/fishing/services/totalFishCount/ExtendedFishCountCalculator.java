package vu.lt.fishing.services.totalFishCount;

import vu.lt.fishing.entities.Fish;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import java.util.List;

@Specializes
@RequestScoped
public class ExtendedFishCountCalculator extends DefaultFishCountCalculator{

    @Override
    public int calculate(List<Fish> fish){

        int totalCount = 0;
        for(Fish fishItem : fish) {
            totalCount = totalCount + Math.round(fishItem.getAverageSize()) + Math.round(fishItem.getAverageLength());
        }
        return totalCount;
    }
}
