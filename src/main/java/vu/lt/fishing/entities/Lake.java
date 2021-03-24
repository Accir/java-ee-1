package vu.lt.fishing.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "LAKE")
@NamedQueries({
        @NamedQuery(name = "Lake.findAll", query = "select a from Lake as a")
})
public class Lake {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="SIZE")
    private float size;

    @Column(name = "OPT_LOCK_VERSION")
    @Version
    private int optLockVersion;

    public Lake() {}

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
}
