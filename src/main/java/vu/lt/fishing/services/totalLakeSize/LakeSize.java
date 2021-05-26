package vu.lt.fishing.services.totalLakeSize;

import vu.lt.fishing.entities.Lake;

import java.util.List;

public interface LakeSize {

    int calculateLakeSize(List<Lake> lakeList);
}
