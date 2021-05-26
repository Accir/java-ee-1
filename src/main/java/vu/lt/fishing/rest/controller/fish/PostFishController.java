package vu.lt.fishing.rest.controller.fish;

import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.entities.Lake;
import vu.lt.fishing.factories.FishFactory;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.persistence.LakeDAO;
import vu.lt.fishing.rest.dto.fish.PostFishDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fish")
@RequestScoped
public class PostFishController {

    @Inject
    private FishFactory fishFactory;

    @Inject
    private FishDAO fishDAO;

    @Inject
    private LakeDAO lakeDAO;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createAction(PostFishDTO fishDTO){

        Fish fish;

        if(fishDTO.getLake() != null) {
            Lake lake = this.lakeDAO.findById(fishDTO.getLake());
            fish = this.fishFactory.createFromDTO(fishDTO, lake);
        } else {
            fish = this.fishFactory.createFromDTO(fishDTO, null);
        }

        this.fishDAO.persist(fish);

        return Response.status(Response.Status.CREATED).build();
    }
}
