import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Main {
	Connect con = Connect.getConnection();
	Scanner scan = new Scanner(System.in);
	ArrayList<Item> item = new ArrayList<>();
	ArrayList<Package> packagee = new ArrayList<>();
	public Main() throws SQLException {
		boolean checkMenu = false;
		int choose;
		while(checkMenu==false) {
			LoadItem();
			LoadPackage();
			System.out.println("1. create delevery");
			System.out.println("2. view");
			System.out.println("3. Delete");
			System.out.println("4. Exit");
			choose = scan.nextInt();
			switch (choose) {
			case 1:
				
				break;
			case 2:
				createD();
				break;
			case 3:
				delete();
				break;
			case 4:
				checkMenu=true;
				break;
			default:
				break;
			}
		}
	}
	public void LoadItem() throws SQLException {
		item.clear();
		String itemID;
		String itemName, Type, query;
		float weight;
		
		query = "SELECT * FROM nonelectronicitem";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while (rs.next()) {
				itemID = rs.getString("itemID");
				itemName = rs.getString("itemName");
				weight = rs.getFloat("weight");
				Type = rs.getString("fragile");
				
				item.add(new NonelectronicItem(itemID, itemName, weight, Type));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		query = "SELECT * FROM electronicitem";
		rs = con.executeQuery(query);
		
		try {
			while (rs.next()) {
				itemID = rs.getString("itemID");
				itemName = rs.getString("itemName");
				weight = rs.getFloat("weight");
				Type = rs.getString("warranty");
				
				item.add(new ElectronicItem(itemID, itemName, weight, Type));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void LoadPackage() throws SQLException {
		packagee.clear();
		String packageID;
		String itemID;
		String recipientName;
		String recipientAddress;
		String recipientEmail, query;
		
		query = "SELECT * FROM package";
		ResultSet rs = con.executeQuery(query);
		try {
			while (rs.next()) {
				packageID = rs.getString("packageID");
				itemID = rs.getString("itemID");
				recipientName = rs.getString("recipientName");
				recipientAddress = rs.getString("recipientAddress");
				recipientEmail = rs.getString("recipientEmail");
				packagee.add(new Package(packageID, itemID, recipientName, recipientAddress, recipientEmail));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void viewItem() throws SQLException{
		System.out.println();
		System.out.println("List Item");
		for (int i = 0; i < item.size(); i++) {
			System.out.printf("%d %s %s %f %s\n", i++, item.get(i).getitemID(), item.get(i).getitemName(), item.get(i).getweight(), 
					item.get(i).getType());
		}
	}
	public void createD() throws SQLException {
		String recipientName, recipientAddress, recipientEmail,query;
		Integer flag = 0,opsi = 0 ,quantity = 0;
		viewItem();
		do {
			System.out.print("Choose your item : ");
			opsi = scan.nextInt();
		} while (opsi < 1 || opsi > 10);
		do {
			scan.nextLine();
			System.out.print("Input your name [5-10 character] : "); 
			recipientName = scan.nextLine();
		} while (recipientName.length() <= 5 || recipientName.length()>=10);
		do {
			scan.nextLine();
			System.out.print("Input your Address [8-25 character] : "); 
			recipientAddress = scan.nextLine();
		} while (recipientName.length() <= 8 || recipientName.length()>=25);
		do {
			System.out.print("Input your Email [must contain @ and .com] : ");
			recipientEmail = scan.nextLine();
		} while (!recipientEmail.contains("@") || !recipientEmail.contains(".com"));
		
		System.out.println("Detail Package");
		//System.out.println("Recipient : %s", packagee.get(opsi-1).getRecipientName());
		//System.out.println("Name : %s", packagee.get(opsi-1).get);
		//if(item.getType()==)
	}
	public void delete() throws SQLException{
		String query;
		int opsi = 0;
		
		//view();
		
		do {
			System.out.print("Choose : ");
			opsi = scan.nextInt();
		}while(opsi < 1 || opsi > packagee.size());
		query = String.format("DELETE FROM `package` WHERE packageID = '%s' ", packagee.get(opsi-1).getPackageID());
		con.executeUpdate(query);
	}
	public static void main(String[] args) throws SQLException {
		new Main();
	}

}
