package vu.lt.fishing.factories;

import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.entities.Lake;
import vu.lt.fishing.rest.dto.fish.PostFishDTO;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.NotFoundException;

@RequestScoped
public class FishFactory {

    public Fish createFromDTO(PostFishDTO fishDTO, Lake lake) throws NotFoundException {
       Fish fish = new Fish();

       fish.setName(fishDTO.getName());
       fish.setAverageLength(fishDTO.getLength());
       fish.setAverageSize(fishDTO.getSize());
       fish.setVersion(0);
       if(lake != null) {
           fish.setLake(lake);
       }


       return fish;
    }
}
