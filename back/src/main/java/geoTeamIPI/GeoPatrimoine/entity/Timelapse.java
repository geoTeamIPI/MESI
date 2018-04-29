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
    private String period; 
    
    @Column(nullable=false)
    private Integer starting_year; 
    
    @Column
    private Integer ending_year;    
}
