package trn.justin.model.relationships;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import trn.justin.model.nodes.Person;
import trn.justin.model.nodes.Vehicle;

@RelationshipEntity(type = "OWNS")
public class PersonOwnsVehicle {

	@GraphId 
	private Long id;
	
	@StartNode
	private Person person;
	
	private Double purchaseAmount;
	private Date purchaseDate;
	private String purchaseCondition;
	
	private Double saleAmount;
	private Date saleDate;
	private String saleCondition;
	
	@EndNode
	private Vehicle vehicle;

	public PersonOwnsVehicle(Person startNode, Vehicle endNode){
		super();
		this.person = startNode;
		this.vehicle = endNode;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Person getPerson() { return person; }
	public void setPerson(Person person) { this.person = person; }

	public Double getPurchaseAmount() { return purchaseAmount; }
	public void setPurchaseAmount(Double purchaseAmount) { this.purchaseAmount = purchaseAmount; }

	public Date getPurchaseDate() { return purchaseDate; }
	public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }

	public String getPurchaseCondition() { return purchaseCondition; }
	public void setPurchaseCondition(String purchaseCondition) { this.purchaseCondition = purchaseCondition; }

	public Double getSaleAmount() { return saleAmount; }
	public void setSaleAmount(Double saleAmount) { this.saleAmount = saleAmount; }

	public Date getSaleDate() { return saleDate; }
	public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }

	public String getSaleCondition() { return saleCondition; }
	public void setSaleCondition(String saleCondition) { this.saleCondition = saleCondition; }

	public Vehicle getVehicle() { return vehicle; }
	public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
