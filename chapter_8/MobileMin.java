public class MobileMin 
{
	public static void main(String[] args) 
	{
		CellPhoneMin oMobile = new CellPhoneMin();
		System.out.println("Your bill is $" + oMobile.mCellOverage());
	}
}
class CellPhoneMin 
{// cell clase with computation & cell data
	private String sTmp;
	private int iMinUsed = 0, iMin = 0; 
	public CellPhoneMin ()
	{//constructor for settings private fields
		while ( true )
		{//input loop
			System.out.println("Please enter the amount of minutes on your cell phone plan:");
			sTmp = System.console().readLine(); //store input, then check if number, then check if null, & convert to integer 
			if (  sTmp.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must enter a number, not letters.");
			else if ( sTmp.equals("") ) System.out.println("You must enter something.");
			else iMin = Integer.parseInt(sTmp);// same as above
			System.out.println("Please enter the amount of minutes you used:");
			sTmp = System.console().readLine(); 
			if (  sTmp.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) System.out.println("You must enter a number, not letters.");
			else if ( sTmp.equals("") ) System.out.println("You must enter something.");
			else iMinUsed = Integer.parseInt(sTmp);
			if ( iMin > 200 && iMin < 800 && iMinUsed > 0 ) break;//break loop if all values are sane 
			else System.out.println("Please ensure values are within range.");
			//System.out.println("This is a debugging statement: iMin then iMinUsed " + iMin + " " + iMinUsed );
		}
	}
	public double mCellOverage ( )
	{
		int iMinOver = iMin - iMinUsed;
		double dCharge = (double)(abs((float)iMinOver)) * .2 + 74.99;//compute charge: (minutes over * .2 ) + plan cost
		//System.out.println("This is a debugging statement: iMin then iMinUsed then iMinOver then dCharge " + iMin + " " + iMinUsed + " " + iMinOver + " " + dCharge ); 
		if ( iMinOver < 0 ) 
		{// check if you went over minutes
			System.out.println("You are " + (abs((float)iMinOver)) + " minutes over your alotted usage.");
			return dCharge;//return bill
		}
		else System.out.println("You did not go over your alotted minutes.");
		return 74.99;// no overage return plan base cost
	}
	public static float abs(float a) 
	{
		//System.out.println("This is a debugging statement: a " + a);
		return (a <= 0.0F) ? 0.0F - a : a; // remove negatives
	}
}
