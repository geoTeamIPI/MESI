package geoTeamIPI.GeoPatrimoine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Types")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(nullable = false)
	private String name;

	@Lob
	@Column
	private String comments;

	@Column
	private Boolean isapproved;

	@Lob
	@Column
	private String logo;

	@Lob
	@Column
	private String pathpicture;

	/**
	 * @OneToOne private Story story;
	 */

	/**
	 * @ManyToOne private Type parentType;
	 */

	/**
	 * @OneToMany(mappedBy="parentType") private Collection<Type> childType;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPathpicture() {
		return pathpicture;
	}

	public void setPathpicture(String pathpicture) {
		this.pathpicture = pathpicture;
	}

	/**
	 * public Story getStory() { return story; }
	 * 
	 * public void setStory(Story story) { this.story = story; }
	 */

	/**
	 * public Type getParentType() { return parentType; }
	 * 
	 * public void setParentType(Type parentType) { this.parentType = parentType; }
	 * 
	 * public Collection<Type> getChildType() { return childType; }
	 * 
	 * public void setChildType(Collection<Type> childType) { this.childType = childType; }
	 */

}
