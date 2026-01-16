import java.util.Scanner;
import java.util.ArrayList;
class BankApp
{
	static String name ;
	static int pin;
	static double balance;
	static Long contact ;
	static final Long ACCOUNT= 1234_3456_1234L;
	static final String IFSC_CODE ="LCF000001";
	static ArrayList<String>transactions= new ArrayList<>();
	public static void main(String[]args)
	{
		Scanner sc =new Scanner(System.in);
		
		
		WelcomeLoop:
		for(; ;)
		{
			System.out.println("\n ****WELCOME***** \n");
			System.out.println(" **** LAXMI CHIT FUND ****");
			System.out.println(" 1. LOGIN ");
			System.out.println(" 2. CREATE ACCOUNT ");
			System.out.println("\n Enter your option :");
			int opt=sc.nextInt();
			switch(opt){
				case 1:
				{
					if(name == null){
						System.out.println("\n CREATE YOUR ACCOUNT FIRST \n");
			 			continue;
					}
					// loop runs 3 times app terminates if cred is wrng
					for(int i=1, attempt=3; i<=3;i++)
					{ 
						System.out.println("\n **** LOGIN ****");
						System.out.println("Contact:");
						Long userContact =sc.nextLong();
						System.out.println("Pin :");
						int userPin =sc.nextInt();
						if(contact==userContact && pin==userPin)
						{
							homePage :
							for(; ;)
							{
								System.out.println("\n **** HOME PAGE ****\n");
								System.out.println("1. Deposite");	
								System.out.println("2. Withdrow");
								System.out.println("3. Check Balance");
								System.out.println("4. Transaction");
								System.out.println("5. Logout ");
								System.out.println("\n Enter your Choice");
								int opt1=sc.nextInt();
								switch(opt1)
								{
									case 1:{
										System.out.println("\n *** DEPOSIT MODULE ***\n");
										System.out.println(" Enter your amount: ");
										double depAmt =sc.nextDouble();
										balance +=depAmt;
										transactions.add("Deposite :"+depAmt);
										System.out.println("\n AMOUNT DEPOSITED SUCCESSFULLY \n");
										break;
									}
									 case 2:{
											System.out.println("\n *** WITHDROW MODULE ***\n");
											System.out.println("Enter an Amount");
											double withDrwAmt =sc.nextDouble();
											System.out.println("Enter your pin :");
											int userPin1 =sc.nextInt();
											if(userPin1==pin){
												if(withDrwAmt<=balance){
													balance -=withDrwAmt;
													transactions.add("withdraw :"+withDrwAmt);
													System.out.println("\n AMOUNT DEBITED SUCCESSFULLY"); 																			
                                                }else{
	                                                System.out.println("\n INSUFFICINT FOUNDS\n");
											    }
										}else{
											System.out.println("\n INVALID PIN\n");
										}
										break;
									}
									case 3:{
										System.out.println("\n *** CHECK BALANCE MODULE ***\n");
										System.out.println(" Enter your pin :");
										int userPin2 =sc.nextInt();
										if(userPin2==pin){
											System.out.println("Your Avil bal is :"+balance+"rs.");
										}else{
											System.out.println("\n INVALID PIN\n");
										}
										break;
									}
									case 4:{
										System.out.println("\n *** TRANSACTION 	MODULE****");
										for (String ele :transactions){
											System.out.println(ele);
										}
										break;
									}
									case 5:{
										System.out.println("\n**** THANKKK YOUUUU ETNA BDA CODE LIKHA ****");
										continue WelcomeLoop ;
									}
									default:{
											System.out.println("\n INVALID OPTION ");
									}
								}
							}
					}
					else {
						System.out.println("\n INVALID CRED \n");
						System.out.println("Attempt Left:"+--attempt);
					}
					
				}
				System.out.println("\n YOUR ACCOUNT IS BEEN BLOCKED FOR 24 HOURS");
				System.exit(0); // jvm terminator
				break;
			}
				case 2:
				{
					if(name!=null){
						System.out.println("\n ACCOUNT ALLREADY EXISTED ");
						continue WelcomeLoop;
					}
					System.out.println("\n *** ACCOUNT CREATION  ***");
					System.out.println("Name :");
					name= new Scanner(System.in).nextLine();
					System.out.println("Pin :");
					pin =sc.nextInt();
                    System.out.print("Contact :");
					contact= sc.nextLong();
                    System.out.println("Balance :");
					balance =sc.nextDouble();
					transactions.add("Deposite (Creation):"+balance);
					System.out.println("\n ACCOUNT CREATED SUCCESSFULLY \n");
					break;
				}
				default :{
					System.out.println("\n INVALID OPTION \n");
					}
				}
			}
		}
	}




	
											
	