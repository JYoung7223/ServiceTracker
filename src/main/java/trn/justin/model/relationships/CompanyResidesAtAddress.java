package trn.justin.model.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import trn.justin.model.nodes.Address;
import trn.justin.model.nodes.Company;
import trn.justin.model.relationships.types.ResidesAt;

@RelationshipEntity(type = "RESIDES_AT")
public class CompanyResidesAtAddress {

	@GraphId 
	private Long id;

	@StartNode
	private Company startNode;
	
	//TODO add UUID to permanently be able to identify node ("id" is not sufficient as it gets reused)
	private ResidesAt residesAt;
	
	@EndNode
	private Address address;
	
	public CompanyResidesAtAddress(Company startNode, Address address){
		super();
		this.startNode = startNode;
		this.address = address;
	}
	public CompanyResidesAtAddress(Company startNode, String description, Address address){
		super();
		this.startNode = startNode;
		this.residesAt = new ResidesAt();
		residesAt.setDescription(description);
		this.address = address;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Company getStartNode() { return startNode; }
	public void setStartNode(Company startNode) { this.startNode = startNode; }
	
	public ResidesAt getResidesAt() { return residesAt; }
	public void setResidesAt(ResidesAt residesAt) { this.residesAt = residesAt; }
	
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
}
