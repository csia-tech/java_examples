import java.io.*; // import java input output packages 
public class MonthSavings 
{
    	public static void main(String[] args) 
	{
		int i = 1;
		outFile oFile = new outFile();// create file object
        	System.out.println("The monthly savings calculator.\nPlease enter in your data.");
		Months oMonth = new Months(12);// inform user as what to be done and create data object
        	String sLine;// string for formatted output
		do // assumed execution loop
		{// format line of output
			sLine = String.format("This is month " + i + ". Before going green you spent $" + oMonth.getMonthData(i,false) + ". After going green you spent $" + oMonth.getMonthData(i,true) + ". This resulted in $" + oMonth.getMonthSavings(i) + ".");
			System.out.println (sLine);//print line to console
			oFile.writeToFile(sLine);//print line to file
			i++;
		} while ( i <= 12 );
    	}
}
class Months
{	// hiding of information (internal array holding monthly data
	private double daMonths[][] = new double [13][2];
	public Months ( int i )// constructor creating months
	{
		String sTmp;
		while ( i <= 12 )
		{       // gathering input & validating	
			System.out.println("Enter in the amount paid for month " + (i) + " prior to going green:");
			sTmp = System.console().readLine();	
			if ( sTmp.matches(".*[a-zA-Z\\t\\n /<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must entere a number.");
			else daMonths [i] [0] = Double.parseDouble(sTmp);
			System.out.println("Enter in the amount paid for month " + (i) + " after going green:");
			sTmp = System.console().readLine();	
			if ( sTmp.matches(".*[a-zA-Z\\t\\n /<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must entere a number.");
			else daMonths [i] [1] = Double.parseDouble(sTmp);
			if ( daMonths [i][0] > 0 && daMonths[i][1] > 0 ) i--;//insure non null values
			if ( i <= 0 ) break;
		}
	}
	public double getMonthSavings ( int iMonth )
	{		// accessor for savings per month
		return (daMonths[iMonth][0] - daMonths[iMonth][1]);
	}
	public double getMonthData ( int iMonth, boolean bGreen )
	{		// accessor for monthly data from array
		if ( bGreen ) return daMonths[iMonth][1];
		else return daMonths[iMonth][0];
	}
}
class outFile 
{	//file class
	private static final String newLine = System.getProperty("line.separator");//insure each line is on it's own line
	synchronized void writeToFile(String msg)  
	{	
		String fileName = "savings.txt";//name of file
		PrintWriter printWriter = null;//declare and instistaniate 
		File file = new File(fileName);// create file descriptor
		try // try execution 
		{	// create file if it doesn't exist
			if (!file.exists()) file.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));// append input to file
			printWriter.write(newLine + msg);//write input to file
		} 
		catch (IOException ioex) 
		{// error checking, produce stack trace if exception is thrown
			ioex.printStackTrace();
		} 
		finally 
		{ 	//insure file was opened
			if (printWriter != null) 
			{
				printWriter.flush();//flush buffer/cache to file on disk
				printWriter.close();//close file descriptor
			}
		}
	}
}
