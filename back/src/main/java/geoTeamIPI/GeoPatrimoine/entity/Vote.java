package geoTeamIPI.GeoPatrimoine.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

public class Vote implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USERS", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "STORIES", referencedColumnName = "id")
    private Story story;
    
    @Column
    private Boolean value; 
}
