	class orderFood 
	{
	   	public static void main(String[] args)
		{ 	// declare fields n objects
			String sMenuItem;
			double dTotal;
			int iItems = 1;
			gatherBill oBill = new gatherBill ();
			displayMenu oMenu = new displayMenu ();
			while (true) 
			{// menu display loop with input loop & questions
				sMenuItem = oMenu.getChoice();
				if ( sMenuItem.equals("x") ) break;
				System.out.println("How many would you like to order?");
				iItems = Integer.parseInt(System.console().readLine());
				oBill.setCost ( sMenuItem, iItems ); 
			}// compute requested information
			dTotal = oBill.getCost(0.06);
			salestax oTax = new salestax();
			dTotal = oTax.round(dTotal, 2);// previous rounding function from earlier chapter
			System.out.print("Your total bill, including 6% sales tax, is: $");
			System.out.println(dTotal);// provide output 
		}
	}
	class displayMenu      
	{
		String sChoice = "x";
		public String getChoice ( ) 
		{// print menu
		
			System.out.println ("Yum Yum Burger Joint Lunch / Dinner menu:");
			System.out.println ("[A] Yum Yum Burger: $0.99 dollars");
			System.out.println ("[B] Grease Yum Fries: $0.79 dollars");
			System.out.println ("[C] Soda Yum: $1.09 dollars");
			System.out.println ("[X] Press x when done.");
			System.out.println ("Enter in one of the following: [a,b,c,x]:");
			sChoice = System.console().readLine ();
			while ( true ) 
			{ // check choices
				if ( sChoice.equals("a") || sChoice.equals("b") || sChoice.equals("c") || sChoice.equals("x") ) return sChoice;
				System.out.println ("Please enter in [a,b,c,x]:");
				sChoice = System.console().readLine ();
			}
		}
	}
	class gatherBill
	{
		double dCost;
		public gatherBill ( )
		{// constructor to preserve total cost and initialize
			if ( dCost > 0  )
			{
				// do nothing
			}
			else
			{
				dCost = 0;
			}
			
		}
		public double setCost ( String sItem, int iOrdered ) 
		{// prices
			if ( sItem.equals("a") ) dCost = dCost + 0.99 * iOrdered;
			if ( sItem.equals("b") ) dCost = dCost + 0.79 * iOrdered;
			if ( sItem.equals("c") ) dCost = dCost + 1.09 * iOrdered;
			System.out.println ("You added an item to your bill.");
			return dCost;
		}
		public double getCost ( double dTax )
		{// compute tax
			dCost = dCost + dCost * dTax;
			System.out.println ("You where taxed!");
			return dCost;
		}
	} 

