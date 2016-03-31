public class Tree {

	public static void main(String[] args) {
		System.out.println("   X"); //print first line
		for (int i=0; i<2; i++){
			if(i<=0){
				System.out.println("  XXX");
			}
			if(i<1){
				System.out.println(" XXXXX");
			}// i know the two lines above execute at the same point due to i being 0 & the if isn't needed
			else{
				System.out.println("XXXXXXX");
			}
		}
		System.out.println("   X"); //print last line
	}
}
/*
print first line before main loop
print second and third line during first loop
print fourth line during second loop
print fith line after main loop

Meaning I could remove the second if statement as it is redudent 
*/
