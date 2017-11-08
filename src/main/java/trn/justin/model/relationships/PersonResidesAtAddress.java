package trn.justin.model.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import trn.justin.model.nodes.Address;
import trn.justin.model.nodes.Person;
import trn.justin.model.relationships.types.ResidesAt;

@RelationshipEntity(type = "RESIDES_AT")
public class PersonResidesAtAddress {

	@GraphId 
	private Long id;

	@StartNode
	private Person startNode;
	
	//TODO add UUID to permanently be able to identify node ("id" is not sufficient as it gets reused)
	private ResidesAt residesAt;
	
	@EndNode
	private Address address;
	
	public PersonResidesAtAddress(Person startNode, Address address){
		super();
		this.startNode = startNode;
		this.address = address;
	}
	public PersonResidesAtAddress(Person startNode, String description, Address address){
		super();
		this.startNode = startNode;
		this.residesAt = new ResidesAt();
		residesAt.setDescription(description);
		this.address = address;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Person getStartNode() { return startNode; }
	public void setStartNode(Person startNode) { this.startNode = startNode; }
	
	public ResidesAt getResidesAt() { return residesAt; }
	public void setResidesAt(ResidesAt residesAt) { this.residesAt = residesAt; }
	
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
}
