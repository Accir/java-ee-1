package vu.lt.fishing.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "FISHING_RODS")
public class FishingRods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="PRICE")
    private float price;

    @ManyToMany(mappedBy = "fishingRods")
    private List<Fish> fish = new ArrayList<>();

    public FishingRods() {}

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }

}
