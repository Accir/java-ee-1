package vu.lt.fishing.rest.dto.fish;

import vu.lt.fishing.rest.dto.ApiResourceDTO;

import java.util.List;

public class ListFishDTO extends ApiResourceDTO<List<GetFishDTO>> {

    public ListFishDTO(List<GetFishDTO> data) {
        super(data);
    }
}
