package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column
    private String name; 
    
    @OneToOne
    private Story story;
    
    @ManyToOne
    private Type parentType;
    
    @OneToMany(mappedBy="parentType")
    private Collection<Type> childType;
}
