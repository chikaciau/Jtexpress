
public class ElectronicItem extends Item{
	private String warranty;
	public ElectronicItem(String itemID, String itemName, float weight, String warranty) {
		super(itemID, itemName, weight);
		this.warranty=warranty;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return warranty;
	}
}
