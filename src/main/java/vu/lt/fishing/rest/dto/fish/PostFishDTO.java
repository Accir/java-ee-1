package vu.lt.fishing.rest.dto.fish;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

@Getter @Setter
public class PostFishDTO {

    @NotNull
    @FormParam("name")
    private String name;

    @NotNull
    @FormParam("length")
    private Float length;

    @NotNull
    @FormParam("size")
    private Float size;

    @FormParam("lake")
    private Integer lake;
}
