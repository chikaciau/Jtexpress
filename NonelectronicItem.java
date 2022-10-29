
public class NonelectronicItem extends Item {
	private String fragile;
	public NonelectronicItem(String itemID, String itemName, float weight, String fragile) {
		super(itemID, itemName, weight);
		this.fragile=fragile;
	}
	public String getFragile() {
		return fragile;
	}
	public void setFragile(String fragile) {
		this.fragile = fragile;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return fragile;
	}
}
