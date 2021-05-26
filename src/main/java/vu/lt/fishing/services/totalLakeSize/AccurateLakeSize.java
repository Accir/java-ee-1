package vu.lt.fishing.services.totalLakeSize;

import vu.lt.fishing.entities.Lake;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public abstract class AccurateLakeSize implements LakeSize {

    @Inject @Delegate LakeSize lakeSize;


    public int calculateLakeSize(List<Lake> lakeList) {
        int lakeSizeCount = lakeSize.calculateLakeSize(lakeList);
        for(Lake lake : lakeList){
            lakeSizeCount = lakeSizeCount + Math.round(lake.getSize());
        }
        return lakeSizeCount;
    }
}
