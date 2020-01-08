package com.celtic.flink;

import java.util.Date;
import java.net.Socket;
import java.util.Random;
import java.io.FileReader;
import java.sql.Timestamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.BufferedReader;

public class BankDataServer {
    public static void main(String[] args) throws IOException{
    System.out.println("Starting Bank Server..");
	ServerSocket listener = new ServerSocket(9093);
	BufferedReader br = null;
	try{
	    Socket socket = listener.accept();
	    System.out.println("Got new connection: " + socket.toString());

	    br = new BufferedReader(new FileReader("C:\\Users\\asinha13\\Documents\\tools\\Flink\\development\\fda\\flinkfwausecase\\src\\main\\resources/bank_data.txt"));
	    
	    try {		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String line;

		while((line = br.readLine()) != null){
		    out.println(line);
		    Thread.sleep(500);
		}
		
		// Random rand = new Random();
		// int count = 0;
		// int tenSum = 0;
		// Date d = new Date();
					
		// for (int x=1; x<100000; ++x)
		//     {
		// 	int key =( x%2) +1 ;
		// 	String s = key + "," + x;
		// 	System.out.println(s);
		// 	out.println(s);
		// 	Thread.sleep(50);
		//     }
					
	    } finally{
		socket.close();
	    }
			
	} catch(Exception e ){
	    e.printStackTrace();
	} finally{	    
	    listener.close();
	    if (br != null)
		br.close();
	}
    }
}

