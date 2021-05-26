package vu.lt.fishing.rest.controller.fish;


import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.rest.dto.fish.GetFishDTO;
import vu.lt.fishing.rest.dto.fish.ListFishDTO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fish")
public class ListFishController {

    @Inject
    private FishDAO fishDAO;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAction() {
        List<Fish> fishList = this.fishDAO.loadAll();

        return Response
                .ok(new ListFishDTO(GetFishDTO.createMany(fishList)))
                .build();
    }
}
