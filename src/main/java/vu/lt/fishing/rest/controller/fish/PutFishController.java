package vu.lt.fishing.rest.controller.fish;

import vu.lt.fishing.entities.Fish;
import vu.lt.fishing.persistence.FishDAO;
import vu.lt.fishing.rest.dto.fish.GetFishDTO;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fish")
@RequestScoped
public class PutFishController {

    @Inject
    FishDAO fishDAO;

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateAction(@PathParam("id") final Integer fishId, GetFishDTO fishDTO) {

        try {
            Fish existingFish = fishDAO.findOne(fishId);

            if(existingFish == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingFish.setName(fishDTO.getName());
            existingFish.setAverageSize(fishDTO.getSize());
            existingFish.setAverageLength(fishDTO.getLength());
            fishDAO.update(existingFish);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
