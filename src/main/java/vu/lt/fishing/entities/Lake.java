package vu.lt.fishing.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "LAKE")
@NamedQueries({
        @NamedQuery(name = "Lake.findAll", query = "select a from Lake as a"),
        @NamedQuery(name = "Lake.findNames", query = "select name from Lake"),
        @NamedQuery(name="Lake.findByName", query = "select o from Lake as o where o.name like :name")
})
public class Lake {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "lake")
    private List<Fish> fishList = new ArrayList<>();

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="SIZE")
    private float size;

    public Lake() {}

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
}
