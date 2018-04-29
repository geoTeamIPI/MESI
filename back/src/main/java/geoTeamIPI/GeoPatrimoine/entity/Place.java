package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="PLACES")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String longitude;
    
    @Column(nullable = false)
    private String latitude; 
    
    @Column
    private String street; 
    
    @Column 
    private String city; 
    
    @Column
    private String zipcode;
    
    @OneToMany(mappedBy = "place")
    private Collection<Story> stories;

}
