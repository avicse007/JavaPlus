package com.snapdeal.webautomator.main;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.webautomator.utils.ExcelFileReader;
import com.webautomator.utils.ExcelFileWriter;
import com.webautomator.utils.Keywords;

public class Main {

	//private static Logger log=Logger.getLogger(Main.class);
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		Logger log =Logger.getLogger("Main");
		
		log.info("We are getting it now");
		ExcelFileWriter excelWriter=new ExcelFileWriter();
		ExcelFileReader excelReader = new ExcelFileReader();
		excelReader.testcasefileReader("testcases\\TestCase.xlsx");
		List<String> method = excelReader.methods;
		List<String> argus = excelReader.args;
		List<String> xpaths=excelReader.xpaths;
		int argscount=0;
		int xpathCount=0;
		int resultCount=0;
		boolean resultArray[]=new boolean[argus.size()];
		resultArray[0]=false;
		Keywords methods =new Keywords();
		Method[] arrays=methods.getClass().getMethods();
		for(String met:method){
			//System.out.println("value of the met"+met);
			for(Method m:arrays ){
				System.out.println("value of the met "+m.getName());
			try{
			if(m.getName().equals(met)){
				System.out.println(m.getName());
				int xpathparamCount = 0;
				int argsparamCount = 0;
				
				//Calculating the xPath parameter count
				String xpath[]=xpaths.get(xpathCount).split(",");
				System.out.println("xpath[0] outer  :"+xpath[0]);
				if((xpaths.get(xpathCount).trim().toLowerCase().equals("null"))){
					xpathparamCount=0;
				}
				else{
					System.out.println("Method name "+m.getName());
					System.out.println("xpath[0]   :"+xpath[0]);
					System.out.println("Length "+xpath.length);
					xpathparamCount=xpath.length;
				}
				//Calculating the arguments count
				String inputs[]=argus.get(argscount).split(",");
				if((argus.get(argscount).trim().toLowerCase().equals("null")))
					argsparamCount=0;
				else
					argsparamCount=inputs.length;
				
				//Invoking the method with there required number of parameters
				
				if(argsparamCount==1 && xpathparamCount==0){
					//System.out.println("input[0]"+inputs[0]);
				m.invoke(methods,inputs[0]);
				}
				else if(argsparamCount==2 && xpathparamCount==0){
					m.invoke(methods,inputs[0],inputs[1]);
				}
				else if(argsparamCount==3 && xpathparamCount==0)
					m.invoke(methods,inputs[0],inputs[1],inputs[2]);
				else if(argsparamCount==0 && xpathparamCount==0)
					m.invoke(methods);
				else if(argsparamCount==0 && xpathparamCount==1){
					System.out.println("method name is :"+m.getName()+" args are "+xpath[0]);
					m.invoke(methods, xpath[0]);
				}
				else if(argsparamCount==0 && xpathparamCount==2)
					m.invoke(methods, xpath[0],xpath[1]);
				else if(argsparamCount==1 && xpathparamCount==1){
					System.out.println("Method :"+m.getName()+" args :"+xpath[0]+" ,"+inputs[0]);
					m.invoke(methods, xpath[0],inputs[0]);
				}
				else if(argsparamCount==1 && xpathparamCount==2)
					m.invoke(methods, xpath[0],inputs[1],inputs[1]);
				else if(argsparamCount==2 && xpathparamCount==1)
					m.invoke(methods, xpath[0],inputs[0],inputs[1]);
				else if(argsparamCount==2 && xpathparamCount==2)
					m.invoke(methods, xpath[0],xpath[1],inputs[0],inputs[1]);
				else if(argsparamCount==3 && xpathparamCount==1)
					m.invoke(methods, xpath[0],inputs[0],inputs[1],inputs[2]);
				else if(argsparamCount==3 && xpathparamCount==2)
					m.invoke(methods, xpath[0],xpath[1],inputs[0],inputs[1],inputs[2]);
				else{
					log.error("Error no method matched "+m.getName());
					System.out.println("Error no method matched "+m.getName());
				}
				resultArray[resultCount+1]=true;
				argscount++;
				xpathCount++;
				resultCount++;
			}
			}
			catch(AssertionError e){
				log.error("Error in executing "+m.getName()+" with error :"+e.getLocalizedMessage());
				System.out.println(e.getMessage());
				resultArray[resultCount]=false;
				resultCount++;
				System.out.println("Does assertion got executed");
			}
			catch(Exception e){
				log.error("Error in executing "+m.getName()+" with error :"+e.getLocalizedMessage());
				//resultArray[resultCount]=false;
				resultCount++;
			}
			}
		}
		resultArray[resultCount-2]=true;
		//close the test file
		//open the testfile and write the result
		for(int i=0;i<resultArray.length;i++)
		//	System.out.println(resultArray[i]);
		
		excelWriter.writeOutputExcel(resultArray);

	}

}
