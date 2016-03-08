package com.snapdeal.web.searchresult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class NoSearchResult {

	public static void main(String[] args) throws IOException {
		// First create the output
		File outputFile = new File("Output.txt");
		
		int count = downloadFileViaFTP(outputFile);
		System.out.println("Number of time the search return Zero result is "+count);

	}
	
	public static CharSequence fromFile(File file,long position,long buffersize) throws IOException {
		FileInputStream input = new FileInputStream(file);
		FileChannel channel = input.getChannel();
		System.out.println("initial postion of the buffer is"+position);
		ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY, position,buffersize);	  
		CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);
		return cbuf;
		}
	
	//===========================================================================================================================================
	@SuppressWarnings("resource")
	public static int rexExingAndWritingOutPutFile(File outputFile,File inputFile) throws IOException {
		String regexStr = "getSearchResults\\s*([^\\[]+):\\s*([^\\[]+)\\s*:\\s*\\[*[a-zA-Z0-9]+]\\,\\s*requestId:\\s*\\[*[a-zA-Z0-9]+\\]";
		FileWriter fileWriter =null;
		 int count =0;
		try{
			fileWriter = new FileWriter(outputFile,true);
			
		}catch(Exception e){
			System.out.println("Not able to create file writer for output file");
			e.printStackTrace();
		}
		
		Pattern p= Pattern.compile(regexStr);
		//Regexing using whole File 
       // Pattern p2 =Pattern.compile("ERROR");
       // Matcher m = p.matcher(ss);
        long fileLength = inputFile.length();
        long position = 524288L;
        long initialposition = 0;
        long buffersize=524288L;
       
        while(initialposition<fileLength){
		if(initialposition+buffersize>fileLength){
		long temp = (initialposition+buffersize)-(fileLength-1);
		buffersize = buffersize-temp;
		}
		Matcher m2 = p.matcher(fromFile(inputFile,initialposition,buffersize));
		while(m2.find()){
			fileWriter.append("\n"+m2.group());
			System.out.println(m2.group());
			count++;	
		}
		initialposition=initialposition+position;
        	}
        System.out.println("Done "+count);
        fileWriter.close();
        return count;
	}
	//=============================================================================================================================================
	public static int downloadFileViaFTP(File outputFile) throws IOException {
		
		
		/*String hosts[] = {"54.251.186.145",    
				"52.77.254.27",
				"54.169.250.205",
				"54.254.180.5",
				"54.169.144.96",
				"52.77.234.137",
				"52.77.250.13",
				"52.77.226.238",
				"54.254.213.154",
				"54.255.131.89",
				"52.74.148.153",
				"54.169.27.104"};
		boolean ispipeClosed = true;
		int missCount = 0;
		int hostSize = hosts.length;
		for(int i=0;i<hostSize;i++){
		String SFTPHOST = hosts[i];
		int SFTPPORT = 22;
		String SFTPUSER = "as15627";
		String SFTPPASS = "sshuser123";
		String privateKey = System.getProperty("user.dir")  + "\\keys\\private.pem";
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;*/
		/*Date date=new Date();
		int month=(date.getMonth())+1;
		int daydate=date.getDate()-1;
		String year = "2016";
		String serverFile="";
		if(month<9)
		 serverFile="server.log."+year+"-0"+month+"-"+daydate;
		else
			serverFile="server.log."+year+"-"+month+"-"+daydate;
		String dst ="D:/ProdLogs/prod.txt";
		
		while(ispipeClosed){
		try {
			JSch jsch = new JSch();
			jsch.addIdentity(privateKey);
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			System.out.println("Server file is "+serverFile);
			System.out.println("Session got created");
			//session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
			session.connect();
			System.out.println("Session got connected");
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd("/usr/local/apache-tomcat/logs");
			//channelSftp.cd("/usr/local/web3-tomcat/logs/");
			System.out.println("pwd:"+channelSftp.pwd());
			System.out.println("serverFile   : "+serverFile);
			
			channelSftp.get(serverFile,dst);*/
			//Calling Regexing on the downloaded file
			
			//rexExingAndWritingOutPutFile(,);
			File localFile = new File("server.log.2016-01-25");
			int missCount = rexExingAndWritingOutPutFile(outputFile,localFile);
			/*if(localFile.delete()){
				System.out.println("File got deleted");
			}*/
			//deleting file after reading
		//	new File(localFile).delete();
			//System.out.println(channelSftp.lpwd());
			//ispipeClosed = false;
		/*} catch (Exception ex) {
			ispipeClosed =true;
			ex.printStackTrace();
		} finally {
			channel.disconnect();
			session.disconnect(	);
		}*/
		//}//closing while loop
		//}//closing for loop
		return missCount;
	}
}

