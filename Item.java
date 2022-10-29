public abstract class Item {
	private String itemID;
	private String itemName;
	private float weight;
	public String getitemID() {
		return itemID;
	}
	public void setitemID(String itemID) {
		itemID = itemID;
	}
	public String getitemName() {
		return itemName;
	}
	public void setitemName(String itemName) {
		itemName = itemName;
	}
	public float getweight() {
		return weight;
	}
	public void sewWeight(float weight) {
		weight = weight;
	}
	public Item(String itemID, String itemName, float weight) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.weight = weight;
	}
	public abstract String getType();
}
