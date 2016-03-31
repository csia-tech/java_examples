using System;// change first class to main method & change setter return value
namespace hello_world
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			string sMenuItem;
			double dTotal;
			int iItems = 1;
			gatherBill oBill = new gatherBill ();
			displayMenu oMenu = new displayMenu ();
			while (true) 
			{
				sMenuItem = oMenu.getChoice();
				if ( sMenuItem == "x" ) break;
				Console.WriteLine("How many would you like to order?");
				iItems = Int32.Parse(Console.ReadLine());
				oBill.setCost ( sMenuItem, iItems ); 
			}
			dTotal = oBill.getCost(0.06);
			dTotal = Math.Round(dTotal, 2);
			Console.Write("Your total bill, including 6% sales tax, is: $");
			Console.WriteLine(dTotal);
		}
	}
	class displayMenu      
	{
		string sChoice = "x";
		public string getChoice ( ) 
		{
		
			Console.WriteLine ("Yum Yum Burger Joint Lunch / Dinner menu:");
			Console.WriteLine ("[A] Yum Yum Burger: $0.99 dollars");
			Console.WriteLine ("[B] Grease Yum Fries: $0.79 dollars");
			Console.WriteLine ("[C] Soda Yum: $1.09 dollars");
			Console.WriteLine ("[X] Press x when done.");
			Console.WriteLine ("Enter in one of the following: [a,b,c,x]:");
			sChoice = Console.ReadLine ();
			while ( true ) 
			{
				if ( sChoice == "a" || sChoice == "b" || sChoice == "c" || sChoice == "x" ) return sChoice;
				Console.WriteLine ("Please enter in [a,b,c,x]:");
				sChoice = Console.ReadLine ();
			}
		}
	}
	class gatherBill
	{
		double dCost;
		public gatherBill ( )
		{
			if ( dCost > 0  )
			{
				// do nothing
			}
			else
			{
				dCost = 0;
			}
			
		}
		public double setCost ( string sItem, int iOrdered ) 
		{
			if ( sItem == "a" ) dCost = dCost + 0.99 * iOrdered;
			if ( sItem == "b" ) dCost = dCost + 0.79 * iOrdered;
			if ( sItem == "c" ) dCost = dCost + 1.09 * iOrdered;
			Console.WriteLine ("You added an item to your bill.");
			return dCost;
		}
		public double getCost ( double dTax )
		{
			dCost = dCost + dCost * dTax;
			Console.WriteLine ("You where taxed!");
			return dCost;
		}
	} 
}

