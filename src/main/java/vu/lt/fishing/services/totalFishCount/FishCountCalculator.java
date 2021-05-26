package vu.lt.fishing.services.totalFishCount;

import vu.lt.fishing.entities.Fish;

import java.util.List;

public interface FishCountCalculator {

    int calculate(List<Fish> fish);
}
