package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getpropertykeyvalue(String key) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./data/commondata.properties");
		Properties pro =new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	

}
