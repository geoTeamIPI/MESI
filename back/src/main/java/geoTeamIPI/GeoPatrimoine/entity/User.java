package geoTeamIPI.GeoPatrimoine.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String email; 
    
    @Column(nullable=false)
    private String password; 
    
    @Column(nullable=false)
    private String city; 
    
    @Column(nullable=false)
    private String profile; 
    
    @OneToMany(mappedBy = "creatorUser")
    private Collection<Story> stories;
    
    @OneToMany(mappedBy = "voter")
    private Collection<Vote> votes;
}
