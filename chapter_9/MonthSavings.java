/*
enter the energy bills from January to December for the year prior to going green
enter the energy bills from January to December of the past year after going green
calculate the energy difference from the two years and display the two years worth of data, along with the savings.  
use arrays, first year cost, secound year cost, differance
 */
public class MonthSavings 
{
    	public static void main(String[] args) 
	{
		int i = 1;
        	System.out.println("The monthly savings calculator.\nPlease enter in your data.");
		Months oMonth = new Months(12);
        	do 
		{
			System.out.println("This is month " + i + ". Before going green you spent $" + oMonth.getMonthData(i,false) + ". After going green you spent $" + oMonth.getMonthData(i,true) + ". This resulted in $" + oMonth.getMonthSavings(i) + ".");
			i++;
		} while ( i <= 12 );
    	}
}
class Months
{
	private double daMonths[][] = new double [13][2];
	public Months ( int i )
	{
		String sTmp;
		while ( i <= 12 )
		{	
			System.out.println("Enter in the amount paid for month " + (i) + " prior to going green:");
			sTmp = System.console().readLine();	
			if ( sTmp.matches(".*[a-zA-Z\\t\\n /<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must entere a number.");
			else daMonths [i] [0] = Double.parseDouble(sTmp);
			System.out.println("Enter in the amount paid for month " + (i) + " after going green:");
			sTmp = System.console().readLine();	
			if ( sTmp.matches(".*[a-zA-Z\\t\\n /<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must entere a number.");
			else daMonths [i] [1] = Double.parseDouble(sTmp);
			if ( daMonths [i][0] > 0 && daMonths[i][1] > 0 ) i--;
			if ( i <= 0 ) break;
		}
	}
	public double getMonthSavings ( int iMonth )
	{
		return (daMonths[iMonth][0] - daMonths[iMonth][1]);
	}
	public double getMonthData ( int iMonth, boolean bGreen )
	{
		if ( bGreen ) return daMonths[iMonth][1];
		else return daMonths[iMonth][0];
	}
}
