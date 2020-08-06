package lti.miniproject;

import java.io.Console;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;  
public class Ui  
{    static Scanner console = new Scanner(System.in);
	static List<String> dateReceived=new ArrayList<String>();
	static List<String> product=new ArrayList<String>();
	static List<String> subProduct=new ArrayList<String>();
	static List<String> issue=new ArrayList<String>();
	static List<String> subIssue=new ArrayList<String>();
	static List<String> company=new ArrayList<String>();
	static List<String> state=new ArrayList<String>();
	static List<String> zipCode=new ArrayList<String>();
	static List<String> submittedVia=new ArrayList<String>();
	static List<String> dateSentToCompany=new ArrayList<String>();
	static List<String> companyResponseToConsumer=new ArrayList<String>();
	static List<String> timelyResponse=new ArrayList<String>();
	static List<String> consumerDisputed=new ArrayList<String>();
	static List<String> complaintId=new ArrayList<String>();
	
	
	public static void mainScreen()  
	{  
		Scanner console = new Scanner(System.in);

		CSVReader reader = null;  
		try {  
	
			reader = new CSVReader(new FileReader("E:\\complaints.csv"));  
			String [] nextLine;  
			//reading one line at a time  
			while ((nextLine = reader.readNext()) != null) {  
// ADD DATE TO LIST
				String ld = nextLine[0].replace("-", "/");

				dateReceived.add(ld);
				
	
//				System.out.println(nextLine[1]);
				product.add(nextLine[1]);
	
				subProduct.add(nextLine[2]);

				issue.add(nextLine[3]);

				subIssue.add(nextLine[4]);

				company.add(nextLine[5]);

				state.add(nextLine[6]);
		
				zipCode.add(nextLine[7]);
				
				submittedVia.add(nextLine[8]);
				
				dateSentToCompany.add(nextLine[9]);
				
				companyResponseToConsumer.add(nextLine[10]);
				
				timelyResponse.add(nextLine[11]);
		
				consumerDisputed.add(nextLine[12]);
				
				complaintId.add(nextLine[13]);
			}  
		}  
		catch (Exception e) {  
			e.printStackTrace();  
		}
		
		dateReceived.remove(0);
		product.remove(0);
		subProduct.remove(0);
		issue.remove(0);
		subIssue.remove(0);
		company.remove(0);
		state.remove(0);
		zipCode.remove(0);
		submittedVia.remove(0);
		dateSentToCompany.remove(0);
		companyResponseToConsumer.remove(0);
		timelyResponse.remove(0);
		consumerDisputed.remove(0);
		complaintId.remove(0);
		
		System.out.println("Welcome User!");
		System.out.println("Want Complaint Details! What you know\n 1. Year\n 2. Name of Bank\n 3. Complaint Number\n");
		System.out.println("Enter Choice (1-3)\n");
		int choice = Integer.parseInt(console.nextLine());
		switch(choice) {
		case 1:
			showByYear();
			break;
		case 2: 
			showByName();
			break;
		case 3:
			showByComplaint();
			break;
		default:
			System.out.println("Enter correct choice");
			
		}
	}
		private static void showByComplaint() {
		
			System.out.println("Enter Complaint Id\n");
			String inputDate = console.nextLine();
			String com = complaintId.get(0);
			
			int a=complaintId.indexOf(com);
					System.out.println("This complaint is Regarding for:" + issue.get(a));
					mainScreen();
					
	}
		private static void showByName() {
		
			System.out.println("Which Bank you have1. Bank account or service\n 2. Consumer Loan\n 3. Mortgage\n 4. Debt collection\n 5. Credit card" );
			System.out.println("Enter Bank name properly\n");
			String in = console.nextLine();
			String bank= product.get(0);
		
			
			for(int j = 0;j<product.size();j++) {
				if(product.get(j).equals(in)) {
				
			System.out.println(complaintId.get(j));
					
				}}
			mainScreen();
	}
		private static void showByYear() {
			System.out.println("Enter Year\n");
			String inputYear = console.nextLine();
			String date = dateReceived.get(0);
			System.out.println(date);
			System.out.println(inputYear);
			
			for(int i = 0;i<dateReceived.size();i++) {
				if(dateReceived.get(i).substring(6).equals(inputYear)) {
					System.out.println(complaintId.get(i));
			
	}
			}
			mainScreen();
		}
	}  

