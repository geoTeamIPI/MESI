package geoTeamIPI.GeoPatrimoine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TIMELAPSES")
public class Timelapse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(nullable = false)
	private String period;

	@Column(nullable = false)
	private Integer startingYear;

	@Column
	private Integer endingYear;

	@Lob
	@Column
	private String comments;

	@Column(nullable = false)
	private String color;

	@Column
	private Boolean isapproved;

	@Lob
	@Column
	private String logo;

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

	public Integer getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(Integer startingYear) {
		this.startingYear = startingYear;
	}

	public Integer getEndingYear() {
		return endingYear;
	}

	public void setEndingYear(Integer endingYear) {
		this.endingYear = endingYear;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(Boolean isapproved) {
		this.isapproved = isapproved;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
