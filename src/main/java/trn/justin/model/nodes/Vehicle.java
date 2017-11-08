package trn.justin.model.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import trn.justin.model.relationships.PersonOwnsVehicle;
import trn.justin.model.relationships.CompanyServicesVehicle;

@NodeEntity (label="Vehicle")
public class Vehicle {

	@GraphId 
	private Long id;
	
	private String vin;
	private String make;
	private String model;
	private String style;
	private String year;
	private String color;
	private String description;
	private Date dateCreated;
	private Date dateUpdated;
	
	@Relationship(type="OWNS", direction=Relationship.INCOMING)
	Set<PersonOwnsVehicle> owners = new HashSet<>();
	
	@Relationship(type="SERVICES", direction=Relationship.INCOMING)
	Set<CompanyServicesVehicle> services = new HashSet<>();
	
	public Vehicle(String description){
		super();
		this.description = description;
		this.dateCreated = new Date();
	}
	
	public Vehicle(String vin, String make, String model, String style, String year, String color, String description) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.style = style;
		this.year = year;
		this.color = color;
		this.description = description;
		this.dateCreated = new Date();
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getVin() { return vin; }
	public void setVin(String vin) { this.vin = vin; }

	public String getMake() { return make; }
	public void setMake(String make) { this.make = make; }

	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }

	public String getStyle() { return style; }
	public void setStyle(String style) { this.style = style; }

	public String getYear() { return year; }
	public void setYear(String year) { this.year = year; }

	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
	
	public Date getDateUpdated() { return dateUpdated; }
	public void setDateUpdated(Date dateUpdated) { this.dateUpdated = dateUpdated; }

	public Set<PersonOwnsVehicle> getOwners() { return owners; }
	public void setOwners(Set<PersonOwnsVehicle> owners) { this.owners = owners; }

	public Set<CompanyServicesVehicle> getServices() { return services; }
	public void setServices(Set<CompanyServicesVehicle> services) { this.services = services; }
}
