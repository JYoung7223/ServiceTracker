package trn.justin.model.relationships.types;

import java.util.Date;

import org.neo4j.graphdb.RelationshipType;

public class ResidesAt implements RelationshipType{
	
	private Date purchaseDate;
	private Double purchaseAmount;
	private String purchaseCondition;
	private String description;
	private Date saleDate;
	private Double saleAmount;
	private String saleCondition;
			
	public Date getPurchaseDate() { return purchaseDate; }
	public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
	
	public Double getPurchaseAmount() { return purchaseAmount; }
	public void setPurchaseAmount(Double purchaseAmount) { this.purchaseAmount = purchaseAmount; }
	
	public String getPurchaseCondition() { return purchaseCondition; }
	public void setPurchaseCondition(String purchaseCondition) { this.purchaseCondition = purchaseCondition; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Date getSaleDate() { return saleDate; }
	public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }
	
	public Double getSaleAmount() { return saleAmount; }
	public void setSaleAmount(Double saleAmount) { this.saleAmount = saleAmount; }
	
	public String getSaleCondition() { return saleCondition; }
	public void setSaleCondition(String saleCondition) { this.saleCondition = saleCondition; }
	
	public static String getRelationshipType(){
		return "RESIDES_AT";
	}
	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}
