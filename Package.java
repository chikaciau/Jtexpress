
public class Package {
	private String packageID;
	private String itemID;
	private String recipientName;
	private String recipientAddress;
	private String recipientEmail;
	public String getPackageID() {
		return packageID;
	}
	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public Package(String packageID, String itemID, String recipientName, String recipientAddress,
			String recipientEmail) {
		super();
		this.packageID = packageID;
		this.itemID = itemID;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.recipientEmail = recipientEmail;
	}
	
}
