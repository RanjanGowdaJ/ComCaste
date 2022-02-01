package Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * *   its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return 
	 */
	
	public int getrandomnumber()
	{
		Random ran=new Random();
		int randomnumber= ran.nextInt(1000);
		return randomnumber;
	}
	/**
	 * 
	 * @return
	 */
	public String getCurretnDate()
	{
		Date da=new Date();
		String  currentDateAndTime  = da.toString();
		return  currentDateAndTime ;
	}
	/**
	 * this method will return the date in specific formate
	 * @return
	 */
	public String getsystemDateinformate()
	{
		Date date=new Date();
		String dtime = date.toString();
		System.out.println(dtime);
		String[] dt = dtime.split("");
		String yyyy = dt[5];
		String dd = dt[2];
		 int mm = date.getMonth();
		String today = yyyy+"_"+mm+"_"+dd;
		return today;
		
	}
	/**
	 * * used to pass Virtual Key to OS
	 * @throws Throwable
	 */
	public void pressVurtualEnterKey() throws Throwable 
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
