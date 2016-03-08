package com.webautomator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWriter
{
	
	//public void WriteExcelFile()
	public  void WriteExcelFile()
	{
		String filePath = System.getProperty("user.dir")+"\\screenshots"+"\\Hello.xlsx";
		System.out.println(filePath);
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void writeOutputExcel(boolean resultArray[]) throws IOException{
		int cellnum=4;
		String filePath = System.getProperty("user.dir")+"\\testcases"+"\\TestCase.xlsx";
		System.out.println(filePath);
        //Blank workbook
		FileInputStream file = new FileInputStream(new File(filePath));
        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int i=1;i<resultArray.length;i++){
        	System.out.println("In writer method"+resultArray[i]);
        }
        
        for(int i=1;i<resultArray.length;i++){
        	
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(cellnum);
        //String cellvalue =cell.getStringCellValue();
        if(resultArray[i]==true)
		cell.setCellValue("PASS");
        if(resultArray[i]==false)
        	cell.setCellValue("FAIL");
        }
		FileOutputStream out = new FileOutputStream(new File(filePath));
        workbook.write(out);
        out.close();
        System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        file.close();
	}
	
}