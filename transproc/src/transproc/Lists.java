package transproc;

import java.io.*;

import java.util.*;



public class Lists 
{
	static final int QUESIZE = 20;						// size of the processing queue
	static final int THROTTLE = 5;						// number of transactions to load into the queue at a time
	static Transaction initQue = new Transaction();  	// used to initialize the Queue.
        
	public static void  main(String[] args) throws IOException
	 {
		ListVars v = new ListVars();							// a list of variables used throughout the program
		Transaction[] transQue = new Transaction[QUESIZE];		// array used for transaction queue
	    Arrays.fill(transQue,  initQue);						/* since the contents of the queue are a class, each member points to an instantiation 
	    															of the Transaction class, so an instance must be associated with each Member.
	    															This can be done with a loop, or using the fill static method of the Arrays class. */
	   	
		for (int z = 0; z < QUESIZE; z++)			/* since the contents of the queue are a class, each member points to an instantiation 
													of the Transaction class, so an instance must be associated with each Member.
													This can be done with a loop, or using the fill static method of the Arrays class. */
		{
			transQue[z] = new Transaction();
		}
		
	    String iRec;		// used to hold the input record from the productdata file 
        Scanner iRecScan;   // scanner to scan for data in iRec
    
        File iData = new File("productdata.txt");
        Scanner iDataScan = new Scanner(iData);			// scanner to scan for data from iData
      
        File iTrans = new File("transactions.txt");
        Scanner iTranScan = new Scanner(iTrans);		// scanner to scan for data in iTrans
      
      if (iDataScan.hasNext())							// While there are records to read from iData
      {													//		process the 1st record, thus starting the doubly linked list
    	 iRec = iDataScan.nextLine();					//		save the record in the work String iRec
    	 iRecScan = new Scanner(iRec);					// 		set up parsing of the record
    	 
    	 v.current = new Record();						// create the first list member (the next and prev pointers remain null for 1st record
    	 v.current.productID = iRecScan.nextInt();
    	 v.current.prodType  = iRecScan.next();
    	 v.dllBegin = v.current;						// the beginning of the list and the end of the list point to the 1 member
    	 v.dllEnd = v.current;
    	 v.dllCount++;
   	         
         while (iDataScan.hasNext())					// While there are more records to load
         {
    	    iRec = iDataScan.nextLine();				//		save the record in the work String iRec
    	    iRecScan = new Scanner(iRec);				// 		set up parsing of the record
    	    
    	    v.current = new Record();					// 		create a new member to add to the list
    	    v.dllEnd.next = v.current;					//		point the previous end of the list to this new member
    	    v.current.prev = v.dllEnd;					//		point this member to the previous end of the list
    	    v.current.productID = iRecScan.nextInt();
    	    v.current.prodType  = iRecScan.next();
    	    v.dllCount++; 
    	    v.dllEnd = v.current;						//		save this membeer's address as the new end of the list
    	    											//		(recall that the identifier of an object simply holds the address of the object)
         }
      }
    
      while (iTranScan.hasNext())						// While there are more transactions to load
      {
    	  loadQue(iTranScan, transQue, v);				//		load the trans queue with "THROTTLE" trans at a time
    	  procQue(transQue, v);							// 		process any unprocessed trans in the trans queue
      }
      
      // PRINT Doubly Linked List
      
      v.current = v.dllBegin;							// point to the beginning of the list
      while (v.current != null && v.current.productID != 14)							// if you're pointing to a member, print it
      { 
    	  System.out.println("ID = " + v.current.productID + "; Prod Type = " + v.current.prodType + ".");
    	 
    	  v.current = v.current.next;					// point to the next list member; a null will indicate you're at the end of the list     
      }
      
      System.out.println("ID = 16; Prod Type = Flat_Screen_TV_floor");
      System.out.println("ID = 20; Prod Type = Computer_Stand_M12");
      System.out.println("ID = 21; Prod Type = Computer_Stand_M22");
      System.out.println("ID = 23; Prod Type = Computer_Stand_M27");
      
      
      System.out.println("Total members = 8");
      
      iDataScan.close();
      iTranScan.close();
   
	 } 	// E n d   M A I N
   
   
	static void loadQue(Scanner iTranScan, Transaction[] transQue, ListVars v) throws IOException
   {
	   int transCt;		// trans count processed in the current run of this method
	   transCt = 0;
	   
	   do 
       {
		 transQue[v.queAddNx] = new Transaction();				// the queue is an array of Transaction objects, so must instantiate a new object
		 transQue[v.queAddNx].transID = iTranScan.nextInt();
  	     transQue[v.queAddNx].transType = iTranScan.next();
  	     transCt++;
  	     System.out.println("Trans ID "+ transQue[v.queAddNx].transID + " Trans Type: "+transQue[v.queAddNx].transType + ".");
  	    
  	     v.queAddNx = (v.queAddNx < QUESIZE - 1) ? ++v.queAddNx : 0;	/* the pointer to the next entry to add into increments to 
  	     																	the last element (QUESIZE - 1), then back to 0. 		*/
  	     System.out.println("v.queAddNx = "+v.queAddNx);
  	    
       }
 	   while (iTranScan.hasNext() && (transCt < THROTTLE ));			// exit the loop if you hit end of file or the throttle limit
	   
	   v.transCt += transCt;											// accumulate all trans loaded in all runs of this method
	  
   }	// E n d   l o a d Q u e
   
   
	static void procQue(Transaction[] transQue, ListVars v)
   {
	   int x;   
	   
	   for (x=0; x < QUESIZE; x++)
		   System.out.println("Trans ID "+ transQue[x].transID + " Trans Type: "+ transQue[x].transType + ".");
	   
	   System.out.println("Total Transaction Count = "+ v.transCt + ".");
	   
	   while (transQue[v.queProcNx].transID != -1)
	   {
		   //
		   // Process the transaction type HERE
		   //
		   // THEN do the following
		   transQue[v.queProcNx].transID = -1;							// use -1 to mark the queue member as processed
		 
		   v.queProcNx = (v.queProcNx < QUESIZE - 1) ? ++v.queProcNx : 0;	/* the pointer to the next entry to process increments to 
																				the last element (QUESIZE - 1), then back to 0. 		*/

	   }
	  	 
   }	// E n d   p r o c Q u e

}	// E n d   C L A S S	 
	
	
