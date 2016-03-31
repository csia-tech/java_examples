public class ordercost {
    public static void main(String[] args) {
	String sAmount;// main amount variable
	double dTip=0; // tip variable
	boolean bTest; // used to test contents of string
	while (true) // input loop
	{
		System.out.println("Please enter the amount of your meal [must enter a number].");
		sAmount = System.console().readLine();
		bTest = sAmount.matches(".*[a-zA-Z\\t\\n /<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*");// make sure it's a number (it can contain a decimal)
		if ( ! bTest ) break; // exit loop if it doesn't have letters or symbls
	}
	double dAmount = Double.parseDouble(sAmount);// convert string to double
	dAmount = dAmount * 0.06 + dAmount; // calculate tax
	if ( dAmount >= .01 && dAmount <= 5.99 ) dTip = .1; // figure out what tip to charge
	if ( dAmount >=  6 && dAmount <= 12 ) dTip = .13 ;
	if ( dAmount >= 12.01 && dAmount <= 17 ) dTip = .16 ;
	if ( dAmount >= 17.01 && dAmount <= 25 ) dTip = .19 ;
	if ( dAmount >= 25.01 ) dTip = .22 ;
	else if ( dAmount <= 0 ) // exit if they entered 0 and tell'em to try again
	{
		System.out.println("You entered 0 or less, try again.");
		System.exit(0);
	}
	dAmount = dAmount * dTip + dAmount;// calculate total
	salestax oTax = new salestax();// i didn't want to rewrite a rounding function
	dAmount = oTax.round(dAmount, 2);// so i made a class of chapter 2 homework & used that
	System.out.println("Total cost of meal was $ " + dAmount + ". You paid this tip " + (dTip * 100) + "%. 6% sales tax was charged."); // produce output
    }
}
