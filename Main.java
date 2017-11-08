import java.util.Scanner;

public  class Main{
	
	public static void main(String[] args){
		
		Scanner text = new Scanner(System.in);
		String str = text.nextLine();
		int length = 100;
		String slova[] = new String [length];
		
		int slovoNum = 0;
		String slovo = "";
		for(int i=0; i<str.length(); i++){
		
		char smvl = str.charAt(i);
		
			if(smvl==' '){
			 //	System.out.println("insert new word = " + slovo );
			  slova[slovoNum] = slovo;		
			  slovo = "";
				slovoNum++;
				continue;
			}
			
			slovo = slovo + smvl;
			
			//System.out.println(slovo);
		
		}
		
		//System.out.println("Exit for");
		
		slova[slovoNum] = slovo;		
		slovo = "";
		slovoNum++;
				
		int maxWordNum = 0;
		int k = 1;
		do{
		  
		  if(slova[k].length() > slova[maxWordNum].length())
		  {
		    maxWordNum = k;
		  }
		  
		  k++;
		}	while(k<slovoNum);
		
		
		
		
	
	System.out.println(slova[maxWordNum]);
	
	
	
	
	}
}