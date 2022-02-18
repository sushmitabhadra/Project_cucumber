package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static List<String>readExcel() throws IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\SUSBHADR\\eclipse-workspace\\Booking_Cucumber\\Booking.xlsx");

		Workbook book=new XSSFWorkbook(file);
		int sheets=book.getNumberOfSheets();
		//System.out.println("sheet"+sheets);
		Sheet sheet = book.getSheetAt(0);
		Iterator<Row>rows=sheet.iterator();
		List<String> getData=new ArrayList<String>();
		while(rows.hasNext())
		{
		Row row=rows.next();
		Iterator<Cell>cols=row.cellIterator();
		while(cols.hasNext())
		{
		
		String data;
		Cell value=cols.next();
		
		if(value.getCellType()==CellType.NUMERIC)
		{
		System.out.println((long)value.getNumericCellValue()+"");	
		String result=(long)value.getNumericCellValue()+"";
		getData.add(result);
		}
		else
		{
		System.out.println(value);
			getData.add(value+"");
		
		}
		}
		}
		return getData;
		
		}
	public static void main(String args[])  throws IOException
	{
System.out.println(readExcel());
			}
}
