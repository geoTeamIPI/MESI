package geoTeamIPI.GeoPatrimoine.entity;

import javax.persistence.*;

@Entity
@Table(name="TIMELAPSES")
public class Timelapse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    @Column(nullable=false)
    private String period; 
    
    @Column(nullable=false)
    private Integer starting_year; 
    
    @Column
    private Integer ending_year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getStarting_year() {
		return starting_year;
	}

	public void setStarting_year(Integer starting_year) {
		this.starting_year = starting_year;
	}

	public Integer getEnding_year() {
		return ending_year;
	}

	public void setEnding_year(Integer ending_year) {
		this.ending_year = ending_year;
	}   
    
    
}
