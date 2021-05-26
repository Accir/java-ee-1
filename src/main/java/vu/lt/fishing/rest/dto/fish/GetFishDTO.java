package vu.lt.fishing.rest.dto.fish;

import lombok.Getter;
import lombok.Setter;
import vu.lt.fishing.entities.Fish;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GetFishDTO {

    private String Name;

    private Float Length;

    private Float Size;

    public static GetFishDTO createFromEntity(Fish fish) {

        GetFishDTO dto = new GetFishDTO();

        dto.setName(fish.getName());
        dto.setLength(fish.getAverageLength());
        dto.setSize(fish.getAverageSize());

        return dto;
    }

    public static List<GetFishDTO> createMany(List<Fish> fishList){
        return fishList
                .stream()
                .map(GetFishDTO::createFromEntity)
                .collect(Collectors.toList());
    }
}
