import java.util.Scanner;

public class Hotel {
	
	 static int Ast=0,Tst=0,Bst=0,Vst=0,Rst=0,gtot=0;
	 static Scanner sc=new Scanner(System.in);
	 
	static void menu()
	{
		System.out.println("       ::MENU::               ::Price:: ");
		System.out.println("1.Avocado & Crab Salad         1,200 Rs");
		System.out.println("2.Tandoori Prawns              1,100 Rs");
		System.out.println("3.Butter Chicken               1,800 Rs");
		System.out.println("4.Vegetarian Thali             1,500 Rs");
		System.out.println("5.Red Wine                     1,900 Rs");
		System.out.println("0.Order Done");
	}
	
	static void quantity(int ch)
	{
		System.out.println("Enter Number Of ");
		
		if(ch==5)
			System.out.println("Glass: ");
		else
			System.out.println("Plates: ");
	}
	
	static void order(int rate, int ch)
	{
		int qty=0;
		quantity(ch);
		qty=sc.nextInt();
		
		switch (ch)
		{
		case 1:
			Ast+=qty*rate;
			break;
			
		case 2:
			Tst+=qty*rate;
			break;
			
		case 3:
			Bst+=qty*rate;
			break;
			
		case 4:
			Vst+=qty*rate;
			break;
			
		case 5:
			Rst+=qty*rate;
		}
	}
	
	static void cashReturn(int cash) {
        int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int temp = cash;
        for (int i = 0; i < denominations.length; i++) {
            int x = temp / denominations[i];
            if (x != 0)
                System.out.printf("\n%d X %d = %d", denominations[i], x, denominations[i] * x);
            temp = temp % denominations[i];
            System.out.println();
        }
    }
	
	static void billing()
	{
		System.out.println("Enter Cash: ");
		int cash=sc.nextInt();
		
		if(cash>gtot)
		{
			cash-=gtot;
			
			System.out.println("Return Cash: "+cash);
			cashReturn(cash);
		}
		
		else if(cash<gtot)
		{
			gtot-=cash;
			
			System.out.println("Plz Pay More: "+gtot);
			billing();
			System.out.println();
		}
		
	}
	
	
	static void bill() {
	    int k = 0;  
	    System.out.println("\n:: Your Bill ::");
	    System.out.println("----------------------------------------------------------------------------");
	    System.out.println("Sr.No. |\t Item                 |\t Qty | \tRate  | \tSub Total  |");

	    if (Ast != 0 || Tst != 0 || Bst != 0 || Vst != 0 || Rst != 0) {
	        System.out.println("------------------------------------------------------------------------");

	        if (Ast != 0) {
	            System.out.printf(" %d    | \tAvocado & Crab Salad     |  \t%d |  \t1,200/-  |   \t%d       |\n", ++k, Ast / 1200, Ast);
	        }
	        if (Tst != 0) {
	            System.out.printf(" %d    | \tTandoori Prawns          |  \t%d |  \t1,100/-  |   \t%d       |\n", ++k, Tst / 1100, Tst);
	        }
	        if (Bst != 0) {
	            System.out.printf(" %d    | \tButter Chicken           |  \t%d |  \t1,800/-  |   \t%d       |\n", ++k, Bst / 1800, Bst);
	        }
	        if (Vst != 0) {
	            System.out.printf(" %d    | \tVegetarian Thali         |  \t%d |  \t1,500/-  |   \t%d       |\n", ++k, Vst / 1500, Vst);
	        }
	        if (Rst != 0) {
	            System.out.printf(" %d    | \tRed Wine                 |  \t%d |  \t1,900/-  |   \t%d       |\n", ++k, Rst / 1900, Rst);
	        }

	        System.out.println("------------------------------------------------------------------------");

	        gtot = Ast + Tst + Bst + Vst + Rst;
	        System.out.println("                               \t\tGrand Total:-   " + gtot);
	        System.out.println("------------------------------------------------------------------------");
	    } else {
	        // No items were ordered
	        System.out.println("No items were ordered.");
	        System.out.println("------------------------------------------------------------------------");
	    }
	}

	
	static void userChoice(){
		
		int ch=0;
		boolean A=true;
		
		while(A)
		{
			menu();
			
			System.out.println("Enter Your Choice: ");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				
				System.out.println("You Have Selected The Avocado & Crab Salad");
				order(1200,ch);
			break;
			
			case 2:
				
				System.out.println("You Have Selected The Tandoori Prawns");
				order(1100,ch);
			break;
			
			case 3:
				
				System.out.println("You Have Selected The Butter Chicken");
				order(1800,ch);
			break;
			
			case 4:
				
				System.out.println("You Have Selected The Vegetarian Thali");
				order(1500,ch);
			break;
			
			case 5:
				
				System.out.println("You Have Selected The Red Wine");
				order(1900,ch);
			break;
			
			case 0:
				
				A=false;
				bill();
				billing();
			break;
			
			default:
				System.out.println("Wrong Input Plz Enter Correct Input");
			break;
				
			
			}
		}
	}

	
	
	
	
	
	

	public static void main(String[] args) {
		
		System.out.println("\t\tWELCOME TO THE IMPERIAL HOTEL");
		System.out.println();
		userChoice();
		
		System.out.println("THANK YOU FOR COMING!! VISIT AGAIN");
	}

}
