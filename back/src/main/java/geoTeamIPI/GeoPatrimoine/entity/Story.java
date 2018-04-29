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
    
    @Column(nullable=false)
    private Integer starting_year;
    
    @Column
    private Integer starting_month;
    
    @Column
    private Integer starting_day;
    
    @Column
    private Integer ending_year;
    
    @Column
    private Integer ending_month;
    
    @Column
    private Integer ending_day;
    
    @ManyToOne
    private User creatorUser;
    
    @ManyToOne
    private Place place;
    
    @OneToOne
    private Type type;
    
    @OneToMany(mappedBy = "story")
    private Collection<Doc> docs;
    
    @OneToMany(mappedBy = "votedStory")
    private Collection<Vote> votes;
}
