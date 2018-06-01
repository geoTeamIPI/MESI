package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String name; 
    
    @OneToOne
    private Story story;
    
    @ManyToOne
    private Type parentType;
    
    @OneToMany(mappedBy="parentType")
    private Collection<Type> childType;

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

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Type getParentType() {
		return parentType;
	}

	public void setParentType(Type parentType) {
		this.parentType = parentType;
	}

	public Collection<Type> getChildType() {
		return childType;
	}

	public void setChildType(Collection<Type> childType) {
		this.childType = childType;
	}
    
    
}
