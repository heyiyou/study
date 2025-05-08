package com.test.nice;

import java.sql.Statement;
import java.util.Scanner;

public class product {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	void run() {
		Display.showTitle();
		dbInit();
		loop:
			while(true) {
				dbpostCount();
				Display.showMainMenu();
				System.out.println("명령입력 : ");
				String cmd=sc.next();
				switch(cmd) {
				case "1" :      
					System.out.println("===================================");
					System.out.println("===================================");
					System.out.println("===============게시판================");
					System.out.println("===================================");
					System.out.println("===================================");
					System.out.println("===================================");
		  		    System.out.println("글 번호 , 글 제목 , 작성자id , 작성시간");
		  		    try {
		  		    	result = st.executeQuery("select* from board");
		  		    	while (result.next ()) {
		  		    		String no = result.getString ("b_no");
		  		    		String title = 
		  		    	}
		  		    }
					
					
				}
				
			}
		
		
		
	}
	
	
	
}