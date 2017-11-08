package trn.justin.model.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import trn.justin.model.relationships.PersonOwnsVehicle;
import trn.justin.model.relationships.PersonResidesAtAddress;

@NodeEntity (label="Person")
public class Person {

	@GraphId 
	private Long id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;
	private String gender;
	private String phone;
	private String email;
	private Date deceaseDate;
	private String status;
	private Date dateCreated;
	private Date dateUpdated;
	
	@Relationship(type="OWNS", direction=Relationship.OUTGOING)
	Set<PersonOwnsVehicle> owns = new HashSet<>();
	
	@Relationship(type="RESIDES_AT", direction=Relationship.OUTGOING)
	Set<PersonResidesAtAddress> residesAt = new HashSet<>();
	
	public Person(String firstName, String lastName){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = new Date();
	}
	public Person(String firstName, String middleName, String lastName, Date birthDate, String gender, String phone,
			String email, Date deceaseDate, String status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.deceaseDate = deceaseDate;
		this.status = status;
		this.dateCreated = new Date();
	}

	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getMiddleName() { return middleName; }
	public void setMiddleName(String middleName) { this.middleName = middleName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public Date getBirthDate() { return birthDate; }
	public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public Date getDeceaseDate() { return deceaseDate; }
	public void setDeceaseDate(Date deceaseDate) { this.deceaseDate = deceaseDate; }

	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

	public Date getDateUpdated() { return dateUpdated; }
	public void setDateUpdated(Date dateUpdated) { this.dateUpdated = dateUpdated; }

	public Set<PersonOwnsVehicle> getOwns() { return owns; }
	public void setOwns(Set<PersonOwnsVehicle> owns) { this.owns = owns; }

	public Set<PersonResidesAtAddress> getResidesAt() { return residesAt; }
	public void setResidesAt(Set<PersonResidesAtAddress> residesAt) { this.residesAt = residesAt; }

	// TODO move to Vehicle to reduce duplicate code
	public void ownsVehicle(Vehicle vehicle){
		// Create Ownership
		PersonOwnsVehicle newOwnership = new PersonOwnsVehicle(this, vehicle);
		// Add relation to this node
		this.owns.add(newOwnership);
		// Add relation to end node
		vehicle.getOwners().add(newOwnership);
	}
	
	// TODO move to Address to reduce duplicate code
	public void residesAt(Address address, String description){
		// Create Resident Relation
		PersonResidesAtAddress newResidance = new PersonResidesAtAddress(this, description, address);
		// Add relation to this node
		this.residesAt.add(newResidance);
		// Add relation to end node
		address.getPersonResidances().add(newResidance);
	}
}
