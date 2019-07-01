package maven1.firstp.Core.Other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.poi.hpsf.Decimal;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.common.collect.Table.Cell;

public class DataSheet<T> {

	private File file;
	private FileInputStream inputStream;
	private HSSFWorkbook workBook;
	private HSSFSheet sheet;
	private int rowCount;

	public DataSheet(String fileName) {
		try {

			file = new File(fileName);
			inputStream = new FileInputStream(file);
			workBook = new HSSFWorkbook(inputStream);
			sheet = workBook.getSheetAt(0);

			rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T> T MapToObject(T instance, String key) {
		
		Class c = instance.getClass();
		Field[] fields = c.getDeclaredFields();
		HashMap<String, Object> map = LoadData(key);
		
		for(Field x : fields)
		{
			//if(x.getName().toLowerCase() == 
			Object value = map.get(x.getName().toLowerCase());
			Class fieldType = x.getType();
			try {			
			if(fieldType == Double.class)
				x.setDouble(instance, (double) value);
			else if(fieldType == boolean.class)
				x.setBoolean(instance, (boolean) value);
			else if(fieldType == String.class)
				x.set(instance, (String) value);
			}
			catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return instance;
	}

	private HashMap<String, Object> LoadData(String key) {

		HashMap<String, Object> map = new HashMap<>();
		Row firstRow = sheet.getRow(0);
		String keyValue = "";

		try {

			for (int i = 1; i < rowCount + 1; i++) {
				/*Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					System.out.println(row.getCell(j).getStringCellValue().toLowerCase());
				}*/

				Row row = sheet.getRow(i);
				String val = row.getCell(0).getStringCellValue().toLowerCase();
				if (val.equals(key.toLowerCase())) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						if(firstRow.getCell(j) != null)
							keyValue = firstRow.getCell(j).getStringCellValue().toLowerCase();
						
						if(keyValue != "")
						{
							org.apache.poi.ss.usermodel.Cell currentCell = row.getCell(j);
							CellType cellType = CellType.STRING;
							switch (currentCell.getCellType()) {
							case STRING:
								map.put(keyValue, currentCell.getStringCellValue());
								break;
							case BLANK:
								map.put(keyValue, "");
								break;
							case _NONE:
								map.put(keyValue, "");
								break;
							case ERROR:
								map.put(keyValue, "");
								break;
							case BOOLEAN:
								map.put(keyValue, currentCell.getBooleanCellValue());
								break;
							case NUMERIC:
								map.put(keyValue, currentCell.getNumericCellValue());
								break;
							default:
								map.put(keyValue, "");
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return map;
	}

}
