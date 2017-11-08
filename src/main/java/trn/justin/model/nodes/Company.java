package trn.justin.model.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import trn.justin.model.relationships.CompanyResidesAtAddress;
import trn.justin.model.relationships.CompanyServicesVehicle;

@NodeEntity (label="Company")
public class Company {

	@GraphId 
	private Long id;
	
	private String name;
	private String type;
	private Date openDate;
	private String operatingHours; //TODO change from String to custom object for day/times
	private String phone;
	private String email;
	private Date closeDate;
	private String status;
	private Date dateCreated;
	private Date dateUpdated;
	
	@Relationship(type="SERVICES", direction=Relationship.OUTGOING)
	Set<CompanyServicesVehicle> services = new HashSet<>();
	
	@Relationship(type="RESIDES_AT", direction=Relationship.OUTGOING)
	Set<CompanyResidesAtAddress> residesAt = new HashSet<>();
	
	public Company(String name){
		super();
		this.name = name;
		this.dateCreated = new Date();
	}
	public Company(String name, String type, Date openDate, String operatingHours, String phone, String email,
			Date closeDate, String status) {
		super();
		this.name = name;
		this.type = type;
		this.openDate = openDate;
		this.operatingHours = operatingHours;
		this.phone = phone;
		this.email = email;
		this.closeDate = closeDate;
		this.status = status;
		this.dateCreated = new Date();
	}
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public Date getOpenDate() { return openDate; }
	public void setOpenDate(Date openDate) { this.openDate = openDate; }

	public String getOperatingHours() { return operatingHours; }
	public void setOperatingHours(String operatingHours) { this.operatingHours = operatingHours; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public Date getCloseDate() { return closeDate; }
	public void setCloseDate(Date closeDate) { this.closeDate = closeDate; }

	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

	public Date getDateUpdated() { return dateUpdated; }
	public void setDateUpdated(Date dateUpdated) { this.dateUpdated = dateUpdated; }

	public Set<CompanyServicesVehicle> getServices() { return services; }
	public void setServices(Set<CompanyServicesVehicle> services) { this.services = services; }

	public Set<CompanyResidesAtAddress> getResidesAt() { return residesAt; }
	public void setResidesAt(Set<CompanyResidesAtAddress> residesAt) { this.residesAt= residesAt; }

	public void servicesVehicle(Vehicle vehicle){
		// Create Service Relation
		CompanyServicesVehicle newService = new CompanyServicesVehicle(this, vehicle);
		// Add relation to this node
		this.services.add(newService);
		// Add relation to end node
		vehicle.getServices().add(newService);
	}
	
	public void servicesVehicle(Vehicle vehicle, String description){
		// Create Service Relation
		CompanyServicesVehicle newService = new CompanyServicesVehicle(this, description, vehicle);
		// Add relation to this node
		this.services.add(newService);
		// Add relation to end node
		vehicle.getServices().add(newService);
	}
	
	public void residesAt(Address address, String description){
		// Create Resident Relation
		CompanyResidesAtAddress newResidance = new CompanyResidesAtAddress(this, description, address);
		// Add relation to this node
		this.residesAt.add(newResidance);
		// Add relation to end node
		address.getCompanyResidances().add(newResidance);
	}
}
