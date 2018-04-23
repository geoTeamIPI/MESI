package geoTeamIPI.GeoPatrimoine.entity;

import javax.persistence.*;

@Entity
@Table(name="DOCS")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column
    private String comment;
    
    @ManyToOne
    private Story story;
    
    @Lob
    @Column(nullable=false)
    private String path;
}
