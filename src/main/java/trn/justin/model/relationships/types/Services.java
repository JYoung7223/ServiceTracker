package trn.justin.model.relationships.types;

import java.util.Date;

import org.neo4j.graphdb.RelationshipType;

public class Services implements RelationshipType{
	
	private Date date;
	private String parts;
	private String serviceType;
	private String condition;
	private String description;
	private Double amount;
			
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
	public String getParts() { return parts; }
	public void setParts(String parts) { this.parts = parts; }
	
	public String getServiceType() { return serviceType; }
	public void setServiceType(String serviceType) { this.serviceType = serviceType; }
	
	public String getCondition() { return condition; }
	public void setCondition(String condition) { this.condition = condition; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Double getAmount() { return amount; }
	public void setAmount(Double amount) { this.amount = amount; }
		
	
	public static String getRelationshipType() {
		return "SERVICES";
	}
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
