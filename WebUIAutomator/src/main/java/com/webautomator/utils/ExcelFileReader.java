package com.webautomator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	public List<String> methods;
	public List<String> xpaths ;
	public List<String> args;
	
	 public void testcasefileReader(String filePath1) throws IOException
	    {
		 methods = new ArrayList<String>();
		  xpaths = new ArrayList<String>();
		  args = new ArrayList<String>();
		  FileInputStream file = null;
	        try
	        {
	        	String filePath = System.getProperty("user.dir")+"//"+filePath1;
	             file = new FileInputStream(new File(filePath));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            //marking which row to read 
	            int rowCount =0;
	            
	            while (rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                //marking which column to read
	                int colcount=0;
	                
	                while (cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    if(rowCount!=0){
	                          
	                    switch (cell.getCellType())
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:
	                          //  System.out.print(cell.getNumericCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	if(rowCount!=0 && colcount==1){
	                        		methods.add(cell.getStringCellValue().split("\\(")[0]);
	                        	}
	                        	if(rowCount!=0 && colcount==2){
	                        		xpaths.add(cell.getStringCellValue());
	                        	}
	                        	if(rowCount!=0 && colcount==3){
	                        		args.add(cell.getStringCellValue());
	                        	}
	                            //System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                    }
	                    colcount++;
	                
	                    }//closing if row is not zero
	                }
	                //System.out.println("");
	                rowCount++;
	            }
	            file.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally{
	        	file.close();
	        }
	        
	        //System.out.println("Printing out the method that has been read");
	        //for(String method: methods)
	        //	System.out.println("methods read is  " +method);
	        
	        System.out.println("Printing out the method xpath that has been read");
	        for(String arg: args)
	        	System.out.println("args read is  " +arg);
	        
	    }
	 
	 public void fileReader(String filePath1)
	    {
	        try
	        {
	        	String filePath = System.getProperty("user.dir")+"//"+filePath1;
	            FileInputStream file = new FileInputStream(new File(filePath));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                while (cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    switch (cell.getCellType())
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                    }
	                }
	                System.out.println("");
	            }
	            file.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	 
	 
	 

}
