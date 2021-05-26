package vu.lt.fishing.services.totalLakeSize;

import vu.lt.fishing.entities.Lake;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DefaultLakeSize implements LakeSize{

    public int calculateLakeSize(List<Lake> lakeList) {
        return 0;
    }
}
