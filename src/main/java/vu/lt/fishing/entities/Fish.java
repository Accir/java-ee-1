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
@Table(name = "FISH")
@NamedQueries({
        @NamedQuery(name = "Fish.findAll", query = "select a from Fish as a")
})
public class Fish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Lake lake;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="FISH_SIZE")
    private float averageSize;

    @Column(name="LENGTH")
    private float averageLength;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToMany
    private List<FishingRods> fishingRods = new ArrayList<>();

    public Fish() {}


    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }

}