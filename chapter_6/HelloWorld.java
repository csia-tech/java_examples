public class HelloWorld {
    	public static void main(String[] args) 
    	{
		String sGo;
		int i=0,iStudents;
		double dGrades, dAvg=0.0;
        	System.out.println("We will now computer the average for a test.");
		while (true)
		{
			System.out.println("How many students?");
			iStudents = Integer.parseInt(System.console().readLine());
			while (i < iStudents )
			{
				System.out.println("Enter student grade.");
				dGrades = Double.parseDouble(System.console().readLine());
				dAvg = dAvg + dGrades;
				i++;
			}
			dAvg = dAvg / iStudents;
			System.out.println("The average is " + dAvg );
			System.out.println("Compute average of another test?");
			sGo = System.console().readLine();
			if ( sGo.equals("no")) break;
			else i=0;
		}
	}

}
