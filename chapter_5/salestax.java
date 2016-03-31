public class salestax {
    public static void main(String[] args) {
	String sSales, sState, sCounty; // input vars
	boolean bTest = false; // validation check var
	System.out.println("The following must be entered as numbers.");
	while (true) // loops for validation checking
	{
        	System.out.println("Please enter the total amount of sales for the month: ");
        	sSales = System.console().readLine(); // get input
        	bTest = sSales.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*"); //regex to ensure input is just a number
		if ( ! bTest ) break; // exit loop if number is inputed
	}
	while (true)
	{
		System.out.println("Enter the amount of state tax: ");
        	sState = System.console().readLine();
        	bTest = sState.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");
		if ( ! bTest ) break;
	}
	while (true)
	{
	        System.out.println("Enter the amount of county tax: ");
        	sCounty = System.console().readLine();
        	bTest = sCounty.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");
		if ( ! bTest ) break;
	}
	double dSales = Double.parseDouble(sSales), dState = Double.parseDouble(sState), dCounty = Double.parseDouble(sCounty); // declare doubles & convert strings to doubles
	dState = dSales * (dState * .01 ); // computations of taxes
	dState = round(dSales, 2); // rounding figures to money decimal level of precisions
	dCounty = dSales * (dCounty * .01 );
	dCounty = round(dCounty, 2);
	dSales = dSales + dState + dCounty; // calculating totals
	dSales = round(dSales, 2);
	System.out.println("*****************\n*Tax information*\n*****************"); // producing output for user
        System.out.println("The state sales tax you paid for the amount entered is: " + dState);
        System.out.println("The county sales tax you paid for the amount entered us: " + dCounty);
        System.out.println("Your total tax paid it: " + dSales);
    }
    public static double round(double value, int places) // method to round double
    {
	if (places < 0) throw new IllegalArgumentException(); // throw an exception if request level of precisions is less than 0
	long factor = (long) Math.pow(10, places); // convert places to percent 
	value = value * factor; // do computation
	long tmp = Math.round(value); // round value
	return (double) tmp / factor; // return rounded double
    }

}
