import java.util.*;
import java.lang.*; //Resource From the internet..
class GDSE_MMS{
	public static void main(String[] args) {
		clearConsole();
		titleBar("WELCOME TO GDSE MARK MANAGEMENT SYSTEM");
		welcomePage();
		int st_count=noOfStu();

		String[] stId=new String[st_count];	String[] stName=new String[st_count]; // Decleration of arrays for store info
		int[] stPfMarks=new int[st_count];	int[] stDbMarks=new int[st_count]; //marks arrays
		int[] stTotalM=new int[st_count];	double[] stAvgM=new double[st_count];
		int[] ar=new int[1]; //use for count variable

		selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		return;
	}

	public static void selectOption(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
									int[] stTotalM,double[] stAvgM){
		boolean b=true;
		mainWhile :
		do{
			clearConsole();
			titleBar("WELCOME TO GDSE MARK MANAGEMENT SYSTEM");
			welcomePage();
			int op=enterOption(); 
			switch(op){
				case 1 :
					clearConsole();
					titleBar("\tADD NEW STUDENT\t\t");
					addNewStu(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 2 :
					clearConsole();
					titleBar("   ADD NEW STUDENT WITH MARKS\t");
					addStuWithMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 3 :
					clearConsole();
					titleBar("\t   ADD MARKS\t\t");
					addMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 4 :
					clearConsole();
					titleBar("     UPDATE STUDENT DETAILS\t");
					updateStuDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 5 :
					clearConsole();
					titleBar("\t  UPDATE MARKS\t\t");
					updateMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 6 :
					clearConsole();
					titleBar("\t DELETE STUDENT\t\t");
					deleteStu(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 7 :
					clearConsole();
					titleBar("   PRINT STUDENT DETAILS\t");
					printStudentDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 8 :
					clearConsole();
					titleBar("    PRINT STUDENT RANKS\t\t");
					printStudentRanks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 9 :
					clearConsole();
					titleBar(" BEST IN PROGRAMMING FUNDEMENTALS");
					printBestPf(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				case 10 :
					clearConsole();
					titleBar("BEST IN DATABASE MANAGEMENT SYSTEM");
					printBestDb(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					break;
				default :
					Scanner inputEx=new Scanner(System.in);
					clearConsole();
					titleBar("WELCOME TO GDSE MARK MANAGEMENT SYSTEM");
					welcomePage();
					System.out.print("\nDo you want to exit From the Application..(Y/N) ? ");
					String ex=inputEx.nextLine();
					if (ex.equals("y") || ex.equals("Y")) {
						System.out.print("Bye,Have a Nice Day...!\n");
						System.exit(0);
					}			
			}	
		}while(b);
		return;		
	}

	public static void titleBar(String title){
		System.out.println(
			"+-------------------------------------------------------------------------------+\n"+
			"|\t\t\t"+title+"\t\t\t|\n"+
			"+-------------------------------------------------------------------------------+"
		);
	}

	public static void welcomePage(){
		System.out.println(
			"[1] Add New Student\t\t\t [2]  Add New Student With Marks\n"+
			"[3] Add Marks\t\t\t\t [4]  Update Student Details\n"+
			"[5] Update Marks\t\t\t [6]  Delete Student\n"+
			"[7] Print Student Details\t\t [8]  Print Student Ranks\n"+
			"[9] Best in Programming Fundementals\t [10] Best in Database Management System"
		);
	}

	public static int noOfStu(){ //I can't declare array size without input. array size auto increment ??
		Scanner input=new Scanner(System.in);
		System.out.print("\nHow many students are expected to attend the course ? : ");
		return (input.nextInt());
	}

	public static int enterOption(){
		Scanner input=new Scanner(System.in);
		System.out.println("\nIf you want to exit,Enter another number...");
		System.out.print("Enter an option to continue >  ");
		return(input.nextInt());
	}

	public static void selectYN(String line,String ynMsg,String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
								int[] stTotalM,double[] stAvgM){
		Scanner input=new Scanner(System.in);
		System.out.print(line);
		String x=input.nextLine();
		if (x.equals("Y") || x.equals("y")) {
			clearConsole();
			return;
		}
		else if(x.equals("N") || x.equals("n")){
			clearConsole();
			selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		}
		else{
			line="Invalid input..! Please Enter Y or N .. \n\n"+ynMsg;
			selectYN(line,ynMsg,stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		}
	}

	public static void addNewStu(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
								int[] stTotalM,double[] stAvgM){ //[1] add new st 
		Scanner input=new Scanner(System.in);
		outerLoop: //Add Label 
		for (int i=ar[0];i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String id=input.nextLine();
			for(String j:stId){
				if (id.equals(j)) {
					i--;
					System.out.println("The Student ID already Exists..\n");
					continue outerLoop;
				}
			}
			stId[i]=id;
			System.out.print("Enter Student Name\t: ");
			stName[i]=input.nextLine();
			stPfMarks[i]=-1;  stDbMarks[i]=-1; // make a chance for enter 0 mark
			ar[0]++;
			selectYN("\nStudent has been added Successfully.. Do you want to add a new student (Y/N) : ",
							  "Do you want to add a new student (Y/N) :",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
			
			titleBar("\tADD NEW STUDENT\t\t");
			continue outerLoop;	
		}
		return;
	}

	public static void addStuWithMarks(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
										int[] stTotalM,double[] stAvgM){ // [2] add new st with mark 
		Scanner input=new Scanner(System.in);
		outerLoop: //Add Label 
		for (int i=ar[0];i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String iq=input.nextLine();
			for(String j:stId){
				if (iq.equals(j)) {
					i--;
					System.out.println("The Student ID already Exists..\n");
					continue outerLoop;
				}
			}
			stId[i]=iq; 
			System.out.print("Enter Student Name\t: ");
			stName[i]=input.nextLine();
			{// start of add marks-----------------
				boolean b=true;
				do{
					System.out.print("\nEnter Programming Fundemental Mark\t: "); 
					int mp=input.nextInt();
					if (mp<0 || mp>100){
						System.out.println("Invalid mark,Please Enter correct mark.. ");
						continue;
					}else{
						stPfMarks[i]=mp;
						b=false;
					}
				}while(b);
				b=true;
				do{
					System.out.print("Enter Database Management System Mark\t: "); 
					int md=input.nextInt();
					if (md<0 || md>100){
						System.out.println("\nInvalid mark,Please Enter correct mark.. ");
						continue;
					}else{
						stDbMarks[i]=md;
						b=false;
					}
				}while(b);
			}// end of add marks-----------------
			ar[0]++;		
			selectYN("\nStudent has been added Successfully.. Do you want to add a new student (Y/N) : ",
					"Do you want to add a new student (Y/N) :",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
			titleBar("   ADD NEW STUDENT WITH MARKS\t");
			addStuWithMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		}
		return ;
	}

	public static void addMarks(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
								int[] stTotalM,double[] stAvgM){
		Scanner input=new Scanner(System.in);
		outerLoop: //Add Label 
		for (int k=0;k<stId.length ;k++ ) {
			System.out.print("Enter Student ID\t: ");
			String im=input.nextLine();
			if (checkValidId(stId,im,ar)) {
				System.out.print("Invalid Student ID. Do you want to Search Again(Y/N) ? ");
				String x=input.nextLine();
				if (x.equals("Y") || x.equals("y")) {
					clearConsole();
					titleBar("\t   ADD MARKS\t\t");
					addMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
				}else {
					clearConsole();
					selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}	
			}else{
				int index=checkMatchingIndex(stId,im,ar);
				if(stPfMarks[index]!=-1){
					System.out.println("Student Name\t\t: "+stName[index]);	
					System.out.println("This student's marks have been already added.."+
						"\nIf you want to update the marks. Please use [5] Update Marks Option.");
					selectYN("\nDo you want to add marks for another Student (Y/N) : ",
						"Do you want to add marks for another Student (Y/N) : ",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					clearConsole();
					titleBar("\t   ADD MARKS\t\t");
					addMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
				} 
				if (index>=0) {
					System.out.println("Student Name\t\t: "+stName[index]);	
					{//start of add marks-----------------
						boolean b=true;
						do{
							System.out.print("\nEnter Programming Fundemental Mark\t: "); 
							int mp=input.nextInt();
							if (mp<0 || mp>100){
								System.out.println("Invalid mark,Please Enter correct mark.. ");
								continue;
							}else{
								stPfMarks[index]=mp;
								b=false;
							}
						}while(b);

						b=true;
						do{
							System.out.print("Enter Database Management System Mark\t: "); 
							int md=input.nextInt();
							if (md<0 || md>100){
								System.out.println("\nInvalid mark,Please Enter correct mark.. ");
								continue;
							}else{
								stDbMarks[index]=md;
								b=false;
							}
						}while(b);
					}// end of add marks-----------------	
				}
			}
			selectYN("\nMarks has been added Successfully... Do you want to add marks for another Student (Y/N) : ",
					"Do you want to add marks for another Student (Y/N) : ",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
			titleBar("\t   ADD MARKS\t\t");
			addMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);		
		}
		return;
	}

	public static void updateStuDetails(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
										int[] stTotalM,double[] stAvgM){
		
		Scanner input=new Scanner(System.in);
		for (int i=0;i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String im=input.nextLine();
			if (checkValidId(stId,im,ar)) {
				System.out.print("Invalid Student ID. Do you want to Search Again(Y/N) ? ");
				String x=input.nextLine();
				if (x.equals("Y") || x.equals("y")) {
					clearConsole();
					titleBar("     UPDATE STUDENT DETAILS\t");
					updateStuDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
				}else {
					clearConsole();
					selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}
			}else {
				int index=checkMatchingIndex(stId,im,ar);
				System.out.println("Student Name\t\t: "+stName[index]+"\n");	
				System.out.print("Enter the new Student Name : ");
				stName[index]=input.nextLine();

				selectYN("\nStudent Details has been updated Successfully.. Do you want to update another Student Details (Y/N) : ",
					"Do you want to update another Student Details (Y/N) : ",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				titleBar("     UPDATE STUDENT DETAILS\t");
				updateStuDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
			}
		}
		return;
	}

	public static void updateMarks(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
								  int[] stTotalM,double[] stAvgM){
		
		Scanner input=new Scanner(System.in);
		for (int i=0;i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String im=input.nextLine();
			if (checkValidId(stId,im,ar)) {
				System.out.print("Invalid Student ID. Do you want to Search Again(Y/N) ? ");
				String x=input.nextLine();
				if (x.equals("Y") || x.equals("y")) {
					clearConsole();
					titleBar("\t  UPDATE MARKS\t\t");
					updateMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
				}else {
					clearConsole();
					selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}
			}else {
				int index=checkMatchingIndex(stId,im,ar);
				if (stPfMarks[index]!=-1) {
					System.out.println("Student Name\t\t: "+stName[index]+"\n");
					System.out.println("Programming Fundemental Mark\t: "+stPfMarks[index]);
					System.out.println("Database Management System Mark\t: "+stPfMarks[index]+"\n");
					System.out.print("Enter new Programming Fundemental Mark\t\t: ");
					stPfMarks[index]=input.nextInt();
					System.out.print("Enter new Database Management System Mark\t: ");
					stDbMarks[index]=input.nextInt();
					selectYN("\nMarks has been updated Successfully.. Do you want to update Marks for another Student (Y/N) : ",
						"Do you want to update Marks for another Student  (Y/N) : ",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					titleBar("\t  UPDATE MARKS\t\t");
					updateMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}else{
					System.out.println("Student Name\t\t: "+stName[index]+"\n");
					System.out.println("This Student's marks yet to be added..");
					selectYN("Do you want to update Marks for another Student (Y/N) : ",
						"",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					titleBar("\t  UPDATE MARKS\t\t");
					updateMarks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}	
			}
		}
		return;
	}

	public static void deleteStu(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
								int[] stTotalM,double[] stAvgM){
		
		Scanner input=new Scanner(System.in);
		for (int i=0;i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String im=input.nextLine();
			if (checkValidId(stId,im,ar)) {
				System.out.print("Invalid Student ID. Do you want to Search Again(Y/N) ? ");
				String x=input.nextLine();
				if (x.equals("Y") || x.equals("y")) {
					clearConsole();
					titleBar("\t DELETE STUDENT\t\t");
					deleteStu(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
				}else {
					clearConsole();
					selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}
			}else {
				int index=checkMatchingIndex(stId,im,ar);
				System.out.println("Student Name\t\t: "+stName[index]+"\n");
				System.out.println("Programming Fundemental Mark\t: "+/*stPfMarks[index]==-1 ? "marks not added":*/stPfMarks[index]);
				System.out.println("Database Management System Mark\t: "+/*stPfMarks[index]==-1 ? "marks not added" : */stDbMarks[index]+"\n");	
				if (stPfMarks[index]<0) {
					System.out.println("If mark is (-1),That Student's marks not added yet..!");
				}
				stId[index]="null"; stName[index]="null";  stPfMarks[index]=-1; stDbMarks[index]=-1;
				stTotalM[index]=-1;	stAvgM[index]=0;
				selectYN("\nAbove Student has been delete Successfully.. Do you want to delete another Student (Y/N) : ",
					"Do you want to delete another Student (Y/N) : ",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				titleBar("\t DELETE STUDENT\t\t");
				deleteStu(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);	
			}
		}
		return;
	}

	public static void printStudentDetails(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
											int[] stTotalM,double[] stAvgM){
		Scanner input=new Scanner(System.in);
		stTotalM=createTotalMarks(stPfMarks,stDbMarks,stTotalM,ar);
		stAvgM=createAvgMarks(stPfMarks,stDbMarks,stAvgM,ar);
		sortingTotalForRanks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);

		for (int i=0;i<stId.length ;i++ ) {
			System.out.print("Enter Student ID\t: ");
			String im=input.nextLine();
			if (checkValidId(stId,im,ar)) {
				System.out.print("Invalid Student ID. Do you want to Search Again(Y/N) ? ");
				String x=input.nextLine();
				if (x.equals("Y") || x.equals("y")) {
					clearConsole();
					titleBar("   PRINT STUDENT DETAILS\t");
					printStudentDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}else {
					clearConsole();
					selectOption(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}
			}else {
				int index=checkMatchingIndex(stId,im,ar);
				if (stPfMarks[index]!=-1) {
					int ind=index+1; String place="";
					switch(ind){
						case 1: place=" (First)";	  break;
			           	case 2: place=" (Second)";	  break;
			           	case 3: place=" (Third)";	  break;
			           	case 4: place=" (Fourth)";	  break;
			          	case 5: place=" (Fifth)";	  break;
			          	default :place=" (Above 5th)"; break;
					}
					System.out.println("Student Name\t\t: "+stName[index]+"\n");
					System.out.printf("+%-44s+%15s+%n","--------------------------------------------","---------------");
					System.out.printf("|%-44s|%15d|%n" ,"Programming Fundamentals Marks" ,stPfMarks[index]);
					System.out.printf("|%-44s|%15d|%n" ,"Database Management Systems Marks" ,stDbMarks[index]);
					System.out.printf("|%-44s|%15d|%n" ,"Total Marks" ,stTotalM[index]);
					System.out.printf("|%-44s|%15.2f|%n" ,"Average Marks" ,stAvgM[index]);
					System.out.printf("|%-44s|%15s|%n" ,"Rank" ,(ind+place));
					System.out.printf("+%-44s+%15s+%n","--------------------------------------------","---------------");
				}else{
					System.out.println("Student Name\t\t: "+stName[index]+"\n");
					System.out.println("Mark yet to be added..Do you want to add Mark for this student,use [3] Add Mark option");
					selectYN("\nDo you want to Search another Student Details (Y/N) : ","",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
					titleBar("   PRINT STUDENT DETAILS\t");
					printStudentDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				}
				selectYN("\nDo you want to Search another Student Details (Y/N) : ","",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
				titleBar("   PRINT STUDENT DETAILS\t");
				printStudentDetails(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
			}
		}
		return;
	}

	public static void printStudentRanks(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
										int[] stTotalM,double[] stAvgM){
	
		stTotalM=createTotalMarks(stPfMarks,stDbMarks,stTotalM,ar);
		stAvgM=createAvgMarks(stPfMarks,stDbMarks,stAvgM,ar);
		sortingTotalForRanks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);

		System.out.printf("+%-10s+%-10s+%-15s+%-15s+%-15s+%n","----------","----------","---------------","---------------","---------------");
        System.out.printf("|%-10s|%-10s|%-15s|%-15s|%-15s|%n", "Rank", "ID", "Name", "Total Marks", "Avg.Marks");
        System.out.printf("+%-10s+%-10s+%-15s+%-15s+%-15s+%n","----------","----------","---------------","---------------","---------------");
        
       	for (int i=0;i<ar[0] ;i++ ) {
       		if (stPfMarks[i]<0) {
       			continue;
       		}
       		System.out.printf("|%-10d|%-10s|%-15s|%-15d|%-15.2f|%n",(i+1),stId[i], stName[i], stTotalM[i], stAvgM[i]);
       	}
        
        System.out.printf("+%-10s+%-10s+%-15s+%-15s+%-15s+%n","----------","----------","---------------","---------------","---------------");
		
		selectYN("\nDo you want to stay more time (Y/N) : ","",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		titleBar("    PRINT STUDENT RANKS\t\t");
		printStudentRanks(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
	}

	public static void printBestPf(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
									int[] stTotalM,double[] stAvgM){
		
		stTotalM=createTotalMarks(stPfMarks,stDbMarks,stTotalM,ar);
		stAvgM=createAvgMarks(stPfMarks,stDbMarks,stAvgM,ar);
		sortingPfForBestPf(stId,stName,stPfMarks,stDbMarks,ar);

		System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
        System.out.printf("|%-10s|%-15s|%-15s|%-15s|%n","ID", "Name", "PF Marks Marks", "DBMS Marks");
        System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
        
      	for (int i=0;i<ar[0] ;i++ ) {
      		if (stPfMarks[i]<0) {
      			continue;
      		}	
      		System.out.printf("|%-10s|%-15s|%-15d|%-15d|%n",stId[i], stName[i], stPfMarks[i], stDbMarks[i]);
      	}

        System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
		
		selectYN("\nDo you want to stay more time (Y/N) : ","",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		titleBar(" BEST IN PROGRAMMING FUNDEMENTALS");
		printBestPf(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);

	}	

	public static void printBestDb(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
										int[] stTotalM,double[] stAvgM){

		stTotalM=createTotalMarks(stPfMarks,stDbMarks,stTotalM,ar);
		stAvgM=createAvgMarks(stPfMarks,stDbMarks,stAvgM,ar);
		sortingDbForBestDb(stId,stName,stPfMarks,stDbMarks,ar);

		System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
        System.out.printf("|%-10s|%-15s|%-15s|%-15s|%n","ID", "Name", "DBMS Marks", "PF Marks");
        System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
        
      	for (int i=0;i<ar[0] ;i++ ) {
  			if (stDbMarks[i]<0) {
  				continue;	
  			}
  			System.out.printf("|%-10s|%-15s|%-15d|%-15d|%n",stId[i], stName[i], stDbMarks[i], stPfMarks[i]);	
      	}
        System.out.printf("+%-10s+%-15s+%-15s+%-15s+%n","----------","---------------","---------------","---------------");
		
		selectYN("\nDo you want to stay more time (Y/N) : ","",stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
		titleBar("BEST IN DATABASE MANAGEMENT SYSTEM");
		printBestDb(stId,stName,stPfMarks,stDbMarks,ar,stTotalM,stAvgM);
	}

	public static int[] createTotalMarks(int[] stPfMarks,int[] stDbMarks,int[] stTotalM,int[] ar){
		for (int i=0;i<ar[0] ;i++ ) {
			stTotalM[i]=stPfMarks[i]+stDbMarks[i];
		}
		return stTotalM;
	}

	public static double[] createAvgMarks(int[] stPfMarks,int[] stDbMarks,double[] stAvgM,int[] ar){
		for (int i=0;i<ar[0] ;i++ ) {
			stAvgM[i]=(double)((stPfMarks[i]+stDbMarks[i])/2);
		}
		return stAvgM;
	}

	public static void sortingTotalForRanks(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar,
											int[] stTotalM,double[] stAvgM){
		for(int j=ar[0]-1; j>=0;j--){
			for(int i=0;i<j; i++){
				if(stTotalM[i]<stTotalM[i+1]){
					int t=stTotalM[i];
					stTotalM[i]=stTotalM[i+1];
					stTotalM[i+1]=t;

					String t1=stId[i];
					stId[i]=stId[i+1];
					stId[i+1]=t1;

					String t2=stName[i];
					stName[i]=stName[i+1];
					stName[i+1]=t2;

					int t3=stPfMarks[i];
					stPfMarks[i]=stPfMarks[i+1];
					stPfMarks[i+1]=t3;

					int t4=stDbMarks[i];
					stDbMarks[i]=stDbMarks[i+1];
					stDbMarks[i+1]=t4;

					double t5=stAvgM[i];
					stAvgM[i]=stAvgM[i+1];
					stAvgM[i+1]=t5;
				} 
			}
		}
	}

	public static void sortingPfForBestPf(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar){

		for(int j=ar[0]-1; j>=0;j--){
			for(int i=0;i<j; i++){
				if(stPfMarks[i]<stPfMarks[i+1]){
					int t=stPfMarks[i];
					stPfMarks[i]=stPfMarks[i+1];
					stPfMarks[i+1]=t;

					String t1=stId[i];
					stId[i]=stId[i+1];
					stId[i+1]=t1;

					String t2=stName[i];
					stName[i]=stName[i+1];
					stName[i+1]=t2;

					int t4=stDbMarks[i];
					stDbMarks[i]=stDbMarks[i+1];
					stDbMarks[i+1]=t4;
				} 
			}
		}
	}

	public static void sortingDbForBestDb(String[] stId,String[] stName,int[] stPfMarks,int[] stDbMarks,int[] ar){

		for(int j=ar[0]-1; j>=0;j--){
			for(int i=0;i<j; i++){
				if(stDbMarks[i]<stDbMarks[i+1]){
					int t=stDbMarks[i];
					stDbMarks[i]=stDbMarks[i+1];
					stDbMarks[i+1]=t;

					String t1=stId[i];
					stId[i]=stId[i+1];
					stId[i+1]=t1;

					String t2=stName[i];
					stName[i]=stName[i+1];
					stName[i+1]=t2;

					int t3=stPfMarks[i];
					stPfMarks[i]=stPfMarks[i+1];
					stPfMarks[i+1]=t3;
				} 
			}
		}
	}
	
	public static int checkMatchingIndex(String[] stId,String im,int[] ar){
		int index=-1;
		for (int j=0;j<ar[0] ;j++ ) {
			index=im.equals( stId[j]) ? j: index;	 
		}
		return index;
	}

	public static boolean checkValidId(String[] stId,String id,int[] ar){
		for(int i=0;i<ar[0];i++){
        	if(stId[i].equals(id))
           		return false;
    	}
      	return true;
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
}