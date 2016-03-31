	String sSales, sState, sCounty;
	boolean bTest = false; 
	System.out.println("The following must be entered as numbers.");
	while (true)
	{

        	System.out.println("Please enter the total amount of sales for the month: ");
        	sSales = System.console().readLine();
        	bTest = sSales.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");
		if ( ! bTest ) break;
	}
