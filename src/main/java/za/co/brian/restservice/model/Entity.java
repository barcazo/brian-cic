package za.co.brian.restservice.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@javax.persistence.Entity
public class Entity implements Serializable {

    private static final long serialVersionUID = 8859833304544887154L;


    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Column(unique = true)
    private String email;

    @OneToMany(
            mappedBy = "entity",
            cascade = CascadeType.ALL)
    private Set<Cic> cics = new HashSet<>();

    public Entity() {
    }



    public Entity(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Cic> getCics() {
        return cics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCics(Set<Cic> cics) {
        this.cics = cics;
    }
}
