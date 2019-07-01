package maven1.firstp.TestData.DataObjects;

import java.util.HashMap;

import maven1.firstp.Core.Other.DataSheet;

public class RegisterPageData {
	
	private static RegisterPageData instance;
	private static DataSheet dataSheet;
	
	private RegisterPageData()
	{
		String fileName = System.getProperty("user.dir") + "\\src\\main\\java\\maven1\\firstp\\TestData\\Datasheets\\RegisterPageData.xls";	
		dataSheet = new DataSheet(fileName);
	}
	
	public static RegisterPageData Load(String key)
	{
		if(instance == null)
			instance = new RegisterPageData();
		
		if(key == "")
			return instance;
		
		instance = (RegisterPageData) dataSheet.MapToObject(instance , key);
		return instance;
	}
	
	
	
	public String firstName;
	public String lastName;
}
