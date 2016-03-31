import java.util.Random;//need for random numbers
public class oMathQuiz // main class
{
    public static void main(String[] args) 
    {
	System.out.println("Please enter your name: ");
	oMenu oStart = new oMenu();//input gather & storage
	oStart.mQuestion();// ask questions
	oStart.mOutput();//produce output
    }

}
class oDataMath
{// math class
	int iRan1, iRan2;//temp random number holders
	public oDataMath ( )
	{// constructor to initialize 
		iRan1 = 0;
		iRan2 = 0;
	}
	public void mRanNums ( int iMin, int iMax )
	{//random number mutator
	 	Random rand = new Random(System.currentTimeMillis());// use current time in miliseconds to seed random number genorator
		iRan1 = rand.nextInt((iMax - iMin) + 1) + iMin;// set first number
		iRan2 = rand.nextInt((iMax - iMin) + 1) + iMin;//set second number
	}
	public boolean mAddNum ( int iGuess )
	{//compare guess to sum of random numbers
		if (iGuess == (iRan1 + iRan2) )	return true;
		else return false;
	}//random number accessor (above)
	public double mAvgCorrect ( int iRight )
	{// average percent accessor
		double score = (double)iRight / 10;
		return score;
	}
}
class oStudent
{// student data class
	oDataMath oDataM = new oDataMath();// create math data object for comparison of collected data
	String sName;// name field
	int iAvg;//stores number correct
	public oStudent ()
	{ // oStudent constructor for initialization and input
		iAvg = 1;
		while (true)
		{// input loop
			sName = System.console().readLine();
			if ( ! sName.matches(".*[0-9\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) break;
			System.out.println("Please only enter letters. Enter your name:");
		}// regex validation 
	}
	public double getAvg ()
	{// compute average from amount correct
		double dPercent = oDataM.mAvgCorrect ( iAvg );
		dPercent = dPercent * 100;
		return dPercent;// convert average percent to readable percent
	}
	public void setAvg ( )
	{// average mutator (askes numbers to collect average)
		String sTmp;
		oDataM.mRanNums ( 1, 500);// initialize random numbers within a range
		System.out.println(oDataM.iRan1 + " + " + oDataM.iRan2 + " = " ); //print out problem
		int iAwn = oDataM.iRan1 + oDataM.iRan2;//compute awnser
		while (true)
		{// input loop for awnser number
			sTmp  = System.console().readLine();
			if (  ! sTmp.matches(".*[a-zA-Z\\t\\n ./<>?;:\"'`!~,@#$%^&*()\\[\\]{}_+=|\\\\-]+.*")) break;    
			else System.out.println("You can only enter a number. Your guess is: ");
		}// ensure it's a number
		int iGuess = Integer.parseInt(sTmp);
		if ( iAwn == iGuess ) iAvg = iAvg + 1; 
	}// increament amount right if guess is correct
}
class oMenu
{// menu class that outputs questions & requested results
	oStudent oKid = new oStudent();// student object that collects student info
	public void mQuestion ( )
	{//questions mutator
		int i=0;// counter
		while ( i < 10 )
		{// ask 10 questions
			System.out.println("Question " + (i+1) + ". ");
			oKid.setAvg();
			i++;
		}
	}
	public void mOutput ( )
	{//questions accessor
		salestax oTax = new salestax();
		System.out.println( oKid.sName + " guess " + oKid.iAvg + " out of 10 right. You scored a " + oTax.round ((oKid.getAvg()),0) + "%.");
	}
}
