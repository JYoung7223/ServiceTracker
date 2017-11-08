package trn.justin.model.nodes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import trn.justin.model.relationships.CompanyResidesAtAddress;
import trn.justin.model.relationships.PersonResidesAtAddress;

@NodeEntity (label="Address")
public class Address {

	@GraphId 
	private Long id;
	
	private String name;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String postalCode;
	private String phone;
	private String status;
	private Date dateCreated;
	private Date dateUpdated;
	
	@Relationship(type="RESIDES_AT", direction=Relationship.INCOMING)
	Set<PersonResidesAtAddress> personResidances = new HashSet<>();
	
	@Relationship(type="RESIDES_AT", direction=Relationship.INCOMING)
	Set<CompanyResidesAtAddress> companyResidances = new HashSet<>();
	
	public Address(String name, String street1, String street2, String city, String state, String postalCode,
			String phone, String status) {
		super();
		this.name = name;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phone = phone;
		this.status = status;
		this.dateCreated = new Date();
	}
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getStreet1() { return street1; }
	public void setStreet1(String street1) { this.street1 = street1; }
	public String getStreet2() { return street2; }
	public void setStreet2(String street2) { this.street2 = street2; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	public String getPostalCode() { return postalCode; }
	public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public Date getDateCreated() { return dateCreated; }
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
	public Date getDateUpdated() { return dateUpdated; }
	public void setDateUpdated(Date dateUpdated) { this.dateUpdated = dateUpdated; }
	public Set<PersonResidesAtAddress> getPersonResidances() { return personResidances; }
	public void setPersonResidances(Set<PersonResidesAtAddress> personResidances) { this.personResidances = personResidances; }
	public Set<CompanyResidesAtAddress> getCompanyResidances() { return companyResidances; }
	public void setCompanyResidances(Set<CompanyResidesAtAddress> companyResidances) { this.companyResidances = companyResidances; }
	
}
