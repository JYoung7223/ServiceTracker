package trn.justin.model.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import trn.justin.model.nodes.Company;
import trn.justin.model.nodes.Vehicle;
import trn.justin.model.relationships.types.Services;

@RelationshipEntity(type = "Services")
public class CompanyServicesVehicle {

	@GraphId 
	private Long id;

	@StartNode
	private Company company;
	
	private Services services;
	
	@EndNode
	private Vehicle vehicle;
	
	public CompanyServicesVehicle(Company startNode, Vehicle endNode){
		super();
		this.company = startNode;
		this.vehicle = endNode;
	}
	public CompanyServicesVehicle(Company startNode, String description, Vehicle endNode){
		super();
		this.company = startNode;
		this.services = new Services();
		this.services.setDescription(description);
		this.vehicle = endNode;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Company getCompany() { return company; }
	public void setCompany(Company company) { this.company = company; }
		
	public Services getServices() { return services; }
	public void setServices(Services services) { this.services = services; }
	
	public Vehicle getVehicle() { return vehicle; }
	public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
