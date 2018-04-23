package geoTeamIPI.GeoPatrimoine.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="STORIES")
public class Story implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String title;
    
    @Lob
    @Column
    private String description;
    
    @Lob
    @Column
    private String content;
    
    @OneToOne
    private User creatorUser;
    
    @ManyToOne
    private Place place;
    
    @OneToMany(mappedBy = "story")
    private Collection<Doc> docs;
    
    @OneToOne
    private Timelapse timelapse;
    
    @OneToOne
    private Type type;
    
    @ManyToOne
    private User user;
    
}
