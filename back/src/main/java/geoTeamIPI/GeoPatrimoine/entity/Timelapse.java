package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="TIMELAPSES")
public class Timelapse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Lob
    @Column(nullable=false)
    private String name; 
    
    @OneToOne
    private Story story; 
       
    @ManyToOne
    private Timelapse parentTime;
    
    @OneToMany(mappedBy="parentTime")
    private Collection<Timelapse> childTime;
}
