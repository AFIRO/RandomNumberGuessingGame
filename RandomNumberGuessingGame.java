package cui;
import java.util.Scanner;
import java.security.SecureRandom;

public class RandomNumberGuessingGame {

	public static void main(String[] args) {
		int[] ingevoerd = new int[5];
		int[] random = new int[5];
		voerGetallenIn(ingevoerd);
		bepaalRandomGetallen(random);
		toonArray("De door jouw ingevoerde getallen:",ingevoerd);
		toonArray("De door de door het systeem gekozen getallen:",random);
		bepaalZelfde(ingevoerd,random);
}
	
private static void voerGetallenIn(int[] ingevoerd)	{
	Scanner S = new Scanner(System.in);
	for (int i=0; i<=4;i++) {
		System.out.printf("Geef getal %d: ",i+1);
		int check = S.nextInt();
		//check 1
		while (check <0)
			{System.out.println("Mag niet lager dan 0");
			System.out.printf("Geef getal %d: ",i+1);
		    check = S.nextInt();}
		//check 2
		while (check >10) 
		{System.out.println("Mag niet hoger dan 10");
		System.out.printf("Geef getal %d: ",i+1);
	    check = S.nextInt();}
		//check 3
		while (zitAllInArray(ingevoerd,check))
		{System.out.println("Dubbel getal");
		System.out.printf("Geef getal %d: ",i+1);
	    check = S.nextInt();}
		//clear
		ingevoerd[i]=check;	
		}}
	
private static void toonArray(String boodschap,int[] array) {
	System.out.printf("\n%s\n", boodschap);	
	for (int element:array) {
			System.out.printf("%s ",element);}
	}
				
private static boolean zitAllInArray(int[] array, int check) {
	boolean a = false; 
	
	for (int element: array) {
		 if (element == check) {
			 a = true;
		     break;}}
	return a;}

private static void bepaalRandomGetallen(int[] random) {
	int check=0; 
	SecureRandom r = new SecureRandom();
	 for (int i=0; i<=4;i++) {
		 check = 0+r.nextInt(10);
	      while (zitAllInArray(random,check)) {
		  check = 0+r.nextInt(10);}
		 random[i]= check;}}

private static void bepaalZelfde(int[] ingevoerd, int[] random) {
	String boodschap = "";
	int y=0;
	int i = 0;
	//double enhanced for to compare two arrays
	for (i =0; i<=4;i++) {
		for (y = 0; y<=4;y++) {
			if (ingevoerd[i] == random[y]) {
			boodschap = boodschap +	Integer.toString(ingevoerd[i]) + " ";
			}
		}
	}
	if (boodschap=="") {
		System.out.println("Er zijn geen overeenkomende getallen");}
		else
		System.out.printf("\nDe overeenkomende getallen zijn: %s",boodschap);	
	}
	
}



	
	
	

