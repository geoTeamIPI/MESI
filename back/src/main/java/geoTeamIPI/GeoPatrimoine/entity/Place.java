package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="PLACES")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String longitude;
    
    @Column(nullable = false)
    private String latitude; 
    
    @Column
    private String number_street; 
    
    @Column
    private String street; 
    
    @Column 
    private String city; 
    
    @Column
    private String zipcode;
    
    @OneToMany(mappedBy = "place")
    private Collection<Story> stories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNumber_street() {
		return number_street;
	}

	public void setNumber_street(String number_street) {
		this.number_street = number_street;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Collection<Story> getStories() {
		return stories;
	}

	public void setStories(Collection<Story> stories) {
		this.stories = stories;
	}

    
}
