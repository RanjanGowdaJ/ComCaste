package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {

	@Test(dataProvider="dataprovider_bookTestTickets")
	
	public void bookTestTickets(String src,String dts)
	{
		System.out.println("book ticket from"+ src + "to" +dts);
	}
	@DataProvider
	public Object[][] dataprovider_bookTestTickets()
	{
		Object[][] arr=new Object[5][2];
		
		arr[0][0]="Banglore";
		arr[0][1]="goa";
		
		arr[1][0]="Banglore";
		arr[1][1]="Mysore";
		
		arr[2][0]="Banglore";
		arr[2][1]="Manglore";
		
		arr[3][0]="Banglore";
		arr[3][1]="Hydrabad";
		
		arr[4][0]="Banglore";
		arr[4][1]="hassan";
		
		return arr;
		

	}
}
