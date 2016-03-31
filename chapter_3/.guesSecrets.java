public class guesSecrets {
    public static void main(String[] args)
    	{
		oData oDataStore = new oData();// make object to hold data
		guesSecrets.gatherInput(oDataStore);// gather data from other main method
		oDataStore.dataCheck(); // produce output
	}
    static void gatherInput (oData oInfo) 
    {
	boolean bTest = false; // test var 
	System.out.println("The following must be entered as whole numbers or letters.");
	while (true) // first input loop
	{
        	System.out.println("Please enter you age: ");
        	oInfo.sAge = System.console().readLine(); // get string with age
		bTest = oInfo.sAge.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");// make sure it's a number
		if ( ! bTest ) // check return of regex
		{
			oInfo.iAge = Integer.parseInt(oInfo.sAge);// convert string to int
			break; // exit loop
		}
	}
	while (true)
	{	// do the same thing we did for age, but for weight
        	System.out.println("Please enter weight: ");
		oInfo.sWeight = System.console().readLine();
		bTest = oInfo.sWeight.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");
		if ( ! bTest ) 
		{
			oInfo.iWeight = Integer.parseInt(oInfo.sWeight);
			break;
		}
	}
	String mon; // temporary var for mon so we can conver it from input format to an integer
	while (true)
	{
        	System.out.println("Please enter your birth month (can be in format ex. Nov, Novermber, or 11): ");
        	oInfo.sMonth = System.console().readLine();
		if ( ! (bTest = oInfo.sMonth.matches(".*[\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*"))) // make sure it's a number OR letter
		{
			if ( bTest = oInfo.sMonth.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*"))// if it's a letter
			{
				oInfo.sMonth = oInfo.sMonth.toLowerCase(); // comnvert it to all lower case
				mon = oInfo.sMonth.substring(0,3); // retrive the first three letters
				if ( mon.equals("jan") || mon.equals("feb") ||mon.equals("oct") ||mon.equals("dec") ||mon.equals("nov") ||
				mon.equals("sep") ||mon.equals("jun") || mon.equals("jul") || mon.equals("apr") ||mon.equals("may") ||mon.equals("mar") ||mon.equals("aug") )
				{ // check to make sure that the first three letters are equal to those of a month ---^
					 if ( mon.equals("jan")) oInfo.iMonth = 1; // convert months to integer
					 if ( mon.equals("feb")) oInfo.iMonth = 2;
					 if ( mon.equals("oct")) oInfo.iMonth = 9;
					 if ( mon.equals("dec")) oInfo.iMonth = 12;
					 if ( mon.equals("nov")) oInfo.iMonth = 11;
					 if ( mon.equals("sep")) oInfo.iMonth = 10;
					 if ( mon.equals("jun")) oInfo.iMonth = 6;
					 if ( mon.equals("jul")) oInfo.iMonth = 7;
					 if ( mon.equals("apr")) oInfo.iMonth = 4;
					 if ( mon.equals("may")) oInfo.iMonth = 5;
					 if ( mon.equals("mar")) oInfo.iMonth = 3;
					 if ( mon.equals("aug")) oInfo.iMonth = 8;
					 break; // exit input loop
				}
			}
			else
				oInfo.iMonth = Integer.parseInt(oInfo.sMonth); // convert to integer
			if (oInfo.iMonth > 12 || oInfo.iMonth < 1 ) System.out.println("You entered an invalid number, try 1-12."); // make sure input is within month field
			else break; // break loop if month number
		}
	}
    }
}
class oData 
{ // data class
    int iAge, iWeight, iMonth; // local integer fields
    String sAge, sWeight, sMonth; // local string fields
    // i prolly should have had all the convertion code in this class & used accessors and mutators
    public void dataCheck ()
    {
    	//check for values requested in the assignment and produce output
	if ( iAge <= 25 ) System.out.println("Congratulations, the age is 25 or less");
	if ( iWeight >= 128 ) System.out.println("Congratulations, the weight is 128 or more");
	if ( iMonth == 4 ) System.out.println ("Congratulations, the birth month is April");
    }
}
