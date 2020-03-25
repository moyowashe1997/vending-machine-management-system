/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * 
 */
public class Vending_machine {
    // creating the object date ,which is going to be used for date in receipt
    static Date date = new Date ();           
    static Scanner input = new Scanner(System.in); //creating the scanner object to read from the keyboard
 
    static String password = "password";  //variable contains admin password
    static String username  ="username";   //variable contains admin username
    static String secreteWord = "secrete";  //variable contains admin secrete word
    
     //variables for mone denominations  and all given money denominations are intialised to 6
    static int twoHundred = 3;
    static int oneHundred=3;
    static int fifty =3;
    static int twenty =3;
    static int ten =3;
    static int fiveDollars  =3;
    static int oneDollar =3;
    static int fiftyCents =3;
    static int tenCents =3;
    
    static double amount =0.0; //variable that contains the total amount 
    static double change =0.0; //variable that contains change
    static double vat =0.0;    //variable that contains vat
    static double sub_total =0.0; //variable that contains sub total
    static double total_cost =0.0;
    
    //variables that holds the quotiont after divide by money denominations in the system
    static int two_hundred_quotiont=0;
    static int one_hundred_quotiont=0;
    static int fifty_quotiont=0;
    static int twenty_quotiont =0;
    static int ten_quotiont=0;
    static int fiveDollars_quotiont=0;
    static int oneDollar_quotiont=0;
    static int fiftyCents_quotiont =0;
    static int tenCents_quotiont=0;
    
            
    static ArrayList <String> item_name = new ArrayList<>();   //declaration of arraylist which holds names of the products
    static  ArrayList <String> item_code =new ArrayList<>();     // declaration of arraylist which holds the products codes
    static ArrayList <Integer> item_quantity = new ArrayList<>(); // declaration of arraylist which holds the products quantity
    static ArrayList <Double> item_price = new ArrayList<>();
    
    static ArrayList <Integer> item_sold_quantity = new ArrayList<>();    //declaration of arraylist which holds the products sold
    static ArrayList <String> item_sold_name = new ArrayList<>();  // holds the name of product sold
    static ArrayList <String > item_sold_code = new ArrayList<>();  //holds the product sold code
    static ArrayList <Double> item_sold_price = new ArrayList<>();
    
    
    

 
    //main method for excuting our codes in
    public static void main(String[] args) {
        
        //initialising the arrayList
        item_code.add("0000");
        item_price.add(20.0);
        item_quantity.add(6);
        item_name.add("pain easy");
        item_code.add("1111");
        item_price.add(39.0);
        item_quantity.add(4);
        item_name.add("bruffen");
        
        
        welcomePage(); // calling the main page
       
   
    }
    // method for the main page
    public static void welcomePage(){
        System.out.println();
        System.out.println("**           WELCOME TO TIMO VENDMED          **");
        System.out.println("**           ADDRESS  : 565 TONO STR          **");
        System.out.println("**           PHONE #  : 08193884747           **");
       
        System.out.println();
        System.out.println("****           THE INSTRUCTIONS             ****");
        System.out.println();
        System.out.println("1.ENTER THE PRODUCT CODE TO CHECK PRICE ");
        System.out.println("2.ENTER THE AMOUNT TO BUY PRODUCT ");
        System.out.println("3.TAKE YOUR PRODUCT AND CHANGE FROM DRAW AT "
                         + "THE BOTTOM");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
       
        showingCodes();
        priceChecking();
    }
    //method for displing product codes on the screen
    public static void showingCodes(){
        System.out.println();
                System.out.println();
                System.out.println("BELOW ARE CODES FOR THE CORRESPONDING PRODUCTS");
                System.out.println();
                System.out.println("ITEM  NAME                             CODE");
                System.out.println("============                         =========");
                for (int i = 0; i < item_code.size(); i++) {
                    if(item_code.size()>0){
                System.out.println(item_name.get(i)+"\t\t\t\t"+item_code.get(i));
                    }else{
                System.out.println("There is nothing in the system now!!!!");
                }
                }
    System.out.println("==================================================");}  
    // method for selling the products 
    public static void priceChecking(){
        
        System.out.println();
        System.out.print("Enter product code  :");
        String code = input.next();
        if(item_code.contains(code)){
        int index = item_code.indexOf(code);
        double price =item_price.get(index);
        String productName = item_name.get(index);
        System.out.println("The price of "+productName+" is N$:"+price);
        System.out.println();
        
        makingTransaction(productName, index,code);  // calling the method for selling the products
        }
        if(password.equalsIgnoreCase(code)){
            LandingPage();
        }
        else{
            System.out.println("sorry invalid code ,try again!!!");
             //codes for going back  if the quantity is too much
        System.out.println("0.Back");
        int option = input.nextInt();
        if(option==0){
           priceChecking();
        }else{
            changePrices();}
        
        }}
    //method for making transaction with parameters
    public static void makingTransaction(String productName,int index,String productCode){
        
        System.out.print("Enter the number of "+productName+" you want to buy :");
        int products = input.nextInt();
        if(item_quantity.size()<products){
        System.out.println("Sorry your quantity is more that available, please reduce");
        
        //codes for going back  if the quantity is too much
        System.out.println("0.Back");
        int option = input.nextInt();
        if(option==0){
           priceChecking();
        }else{
            changePrices();}}
        
        else
        {
            
         double price = item_price.get(index);
         sub_total =sub_total+(price*products);
         System.out.println("The total cost of your money is N$"+sub_total);
         System.out.println();
         item_sold_quantity.add(products);
         int current = item_quantity.get(index);
         item_quantity.set(index,current -products);
         item_sold_code.add(productCode);
         item_sold_name.add(productName);
         System.out.println();
         System.out.print("Do you still want to add another product ?");
         String answer = input.next();
         
         if(answer.equalsIgnoreCase("yes")){
           priceChecking();                   // code for adding somemore products 
         }
        System.out.println("==================================================");
        System.out.println("Important notice !!! this machine accepts only");
        System.out.println("N$200 ,N$100 ,N$50 ,N$20 ,N$10 .N$5 ,N$1 ,50c ,10c");
        System.out.println("=================================================="); 
        System.out.println();
        System.out.print("Enter the amount  :");
         amount=input.nextDouble();
         
         
         if(amount<sub_total){
         System.out.println("Sorry your amount is not enough!!!");
         System.out.println("0.Back");
         int option = input.nextInt();
          if(option==0){
           priceChecking();
           }else{
            priceChecking();
        }}
         else{
         change =amount - sub_total;
         vat =sub_total*0.15;
        
         
        
         
         
         receipt();    // printing the receipt
        }}}
    // method for printing the receipt
    public static void receipt(){
        System.out.println();
        System.out.println("***                      OFFICE BUILDING VENDMED                               ***");
        System.out.println("***                      ADDRESS  : 6768 PILATO STR                            ***");
        System.out.println("***                      CONTACT  :081828228282                                ***");
        System.out.println();
        System.out.println("NAME \t\t PRCE \t\t QNTITY \t\t TOTAL");
     
         for (int i = 0; i < item_sold_quantity.size(); i++) {
            System.out.println(item_sold_name.get(i)+"\t\t"+item_price.get(i)+
            "\t\t"+item_sold_quantity.get(i)+"\t\t"+(item_sold_quantity.get(i)*item_price.get(i)));
             }
        
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("                    VAT@15%            N$:"+vat); 
        System.out.println("Total                                  N$:"+sub_total);
        System.out.println("Tendered                               N$:"+amount);
        System.out.println("Change                                 N$:"+change);
        System.out.println();  
        System.out.println("**********************************************************************************");
        System.out.println("                  Date :"+date.toString());
        System.out.println("**********************************************************************************");
        System.out.println();
        System.out.println("                                    Thank you                             ");
        System.out.println("                                 for your support ");
        System.out.println("**********************************************************************************");
        changeDispersion(); // calling the method that distibute change

        
        System.out.println();
        
        
        //removing iterms from sold arrays so that there wont get printed  again in another transaction 
        item_sold_code.clear();
        item_sold_name.clear();
       item_sold_price.clear();
        item_sold_quantity.clear();
        
        System.out.println("0.Back");
        int option = input.nextInt();
        if(option==0){
          welcomePage();
        }else{
            receipt();
        }  }
   //method for change distribution
    public static void changeDispersion(){
        
        System.out.println();
        if(change>=200 && twoHundred>=change/200){
            two_hundred_quotiont =(int)change/200;
            change = change%200;
        }
        if(change>=100 && oneHundred>=change/100){
            one_hundred_quotiont =(int)change/100;
            change = change%100;
        }
        if(change>=50 && fifty>=change/50){
            fifty_quotiont =(int)change/50;
            change = change%50;
        }
        if(change>=20 && twenty>=change/20){
            twenty_quotiont =(int)change/20;
            change = change%20;
        }
        if(change>=10 && ten>=change/10){
            ten_quotiont =(int)change/10;
            change = change%10;
        }
         if(change>=5 && fiveDollars>=change/5){
            fiveDollars_quotiont =(int)change/5;
            change = change%5;
        }
          if(change>=1 && oneDollar>=change/1){
            oneDollar_quotiont =(int)change/1;
            change = change%1;
        }
           if(change>=0.50 && fiftyCents>=change/0.50){
            fiftyCents_quotiont=(int)(change/0.50);
            change = change%0.50;
        }
            if(change>=0.10 && ten>=change/0.10){
            tenCents_quotiont =(int)(change/0.10);
            change = change%0.10;
        }
        
        System.out.println("Change dispensed as follows :");
        System.out.println(two_hundred_quotiont+ " x N$200 ,"+one_hundred_quotiont +"X N$100 ,"
                + "" +fifty_quotiont +" x N$50 , "+twenty_quotiont +" x N$20 ,"+ ten_quotiont+ " x N$10 ,"
                        + ""+fiveDollars_quotiont +" x N$5 ,"+ oneDollar_quotiont+" x N$1 ,"+fiftyCents_quotiont+ " x 50c ,"
                                + ""+tenCents_quotiont +" x10c");
       
        int total_quotiont =tenCents_quotiont+one_hundred_quotiont+fifty_quotiont+
                           twenty_quotiont+ten_quotiont+ten_quotiont+fiveDollars+
                           oneDollar_quotiont+fiftyCents_quotiont+tenCents_quotiont;
        if(total_quotiont<change){
            System.out.println("sorry there is no enough change, contact the owner from the number above !!");
        }
     
        
    }
    //method for admin landing page
    public static void LandingPage(){
        System.out.println();
        System.out.print("Enter admin username :");
        String name =input.next();
        System.out.print("Enter admin password :");
        String pass= input.next();
        
        if(username.equals(name)&&password.equals(pass)){
           
            System.out.println();
            adminMenu();     }
        else{
            System.out.println("Sorry invalid credentials !!!");
            System.out.println();
            System.out.println("0.Back");
            int back =input.nextInt();
        if(back==0){
            LandingPage();
        }else{
            LandingPage();
        }
        }}
    //method for admin main menu 
    public static void adminMenu(){
        System.out.println();
        System.out.println("*****         WELCOME TO ADMIN MENU       *******");
        System.out.println();
        System.out.println("==================================================");
        System.out.println("1 .ADD STOCK \t\t2 .VIEWSTOCK \t\t  "
                + "\t3 .RESTOCKING \n4 .VIEW PRICES \t\t5 .CHANGING PRICES  \t\t6 .ITEN SOLD "
                + "\n7 .COLLECTING MONEY \t8 .ADD MONEY"
                + "\t\t\t 9.CHANGING PASSWORD \n0 .EXIT ");
        System.out.println("==================================================");
        
        System.out.print("Select your corresponding option from above :");
        int option = input.nextInt();
        
        switch(option){
            case 1:
                addingItems();
                break;
            case 2:
                ViewItems();
                break;  
            case 3:
                Restocking();
                break;
            case 4:
                viewPrices();
                break;
            case 5:
                changePrices();
                break;
            case 6:
                showItermSold();
                break;
            case 7:
                 collectMoney();
                 break;
            case 8:
                addMoney();
                break;
                    
            case 9:
              changingCredentials();
                break;
  
            case 0:
               welcomePage();
                break;
            default: 
                System.out.println("Invalid input!!!!");
               }
        System.out.println("==================================================");}
    //method for adding stock
    public static void addingItems(){
        
        System.out.println();
        System.out.print("Enter the name of product you want to add :");
        String name = input.next();
        if(item_name.contains(name)){
        System.out.println("Sorry the "+name +" already exist in the machine !!!");} // this message displays if one wants to add already existing name
        else{
        item_name.add(name);  // this code add the iterm name into products name arralist
            
        System.out.print("Enter the product code :");
        String code = input.next();
        item_code.add(code);    //this adds the product code into arraylist
            
        System.out.println("Note!! your price must be divisible by 10");
        System.out.println();
            
        System.out.print("Enter the product price :");
        double price = input.nextDouble();
            
       
        item_price.add(price);}   // this adds product price into product price arraylist
        
        System.out.print("Enter the quantity of "+name+" you want to add :");
        int quantity =input.nextInt();
            
        if(quantity<=30){ // this code check to see if the product quantity is less than 30 it will add stock in quantity arraylist
            item_quantity.add(quantity);
            System.out.println(quantity +" "+name+" successfull added");
            }else{
                System.out.println("Reduce your quantity , the machine can only holds muximum of 30"); 
            }
       
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){        // this code is for going back to the  main menu
            adminMenu();
        }else{
            addingItems();
        }
    } 
    //method for viewing products sold from the machine
    public static void showItermSold(){
        System.out.println("You are viewing product sold");
        System.out.println();
        
        if(item_sold_quantity.size()>0){   //this arry displays the products which are greater than 0
            System.out.println("ITEM Name \t                        Quantity");
            System.out.println("===========                            ============");
        for (int i = 0; i < item_sold_quantity.size(); i++) {
            System.out.println(item_sold_name.get(i)+"\t\t\t\t"+item_sold_quantity.get(i));
        }
        }else{
            System.out.println("Sorry there is no product sold yet!!!");
        }
        System.out.println("==================================================");
        
        // below is code to go back to the adimn menu
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            showItermSold();
        }
    }
    // method for viewing the products in the machine 
    public static void ViewItems(){
        System.out.println();
        System.out.println("You are viewing stock");
        System.out.println();
        if(item_quantity.size()>0){
            System.out.println("Item Name \t                       Quantity");
            System.out.println("==============                      ============");
            for (int i = 0; i < item_quantity.size(); i++) {
                System.out.println(item_name.get(i)+"\t\t\t\t"+item_quantity.get(i));
                
            }
        }else{
            System.out.println("Sorry there is nothing in stock at the moment!!!!!");
        }
        System.out.println("==================================================");        
        // below is code to go back to the adimn menu
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            ViewItems();
        }
    }
    //method for restocking products into the machine
    public static void Restocking(){
        System.out.println();
        System.out.println("You are rectocking the products");
        System.out.println();
        System.out.print("Enter the name of the product you want to restock : ");
        String name = input.next();
        
        if(item_name.contains(name)){
            int index =item_name.indexOf(name);
            System.out.print("Enter the amount of "+ name +" you want to add :");
            int stock = input.nextInt();
            item_quantity.set(index, stock);
            System.out.println(name +" successully added ");
            }
        else{
            System.out.println("Sorry there is no " + name +" in the stock !!!!");
        }
        
        // below is code to go back to the adimn menu
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            Restocking();
        }
       
        
    }
    //method for viewing the prices of the products in the machine
    public static void viewPrices(){
        System.out.println();
        System.out.println("You are viewing prices");
        System.out.println();
        System.out.println("Product Name \t                              Price");
        System.out.println("=============                            =============");
        
        for (int i = 0; i < item_quantity.size(); i++) {
            System.out.println(item_name.get(i)+"\t\t\t\t"+"N$"+item_price.get(i));
            
        }
        System.out.println("==================================================");
        // below is code to go back to the adimn menu
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            viewPrices();
        }
    }
    // method for changing the prices of the products in the machine
    public static void changePrices(){
       System.out.println();
       System.out.println("You about to change prices");
       System.out.println();
       System.out.print("Enter the product name you want to change price :");
       String name = input.next();
       
       if(item_name.contains(name)){
         int index = item_name.indexOf(name);
         System.out.print("Enter the new price of "+ name +" :");
         double newPrice =input.nextDouble();
         item_price.set(index, newPrice);
         System.out.println("Price for "+ name +" successfully changed ");}
       else{
           System.out.println("Sorry there is no "+name+" in stock");}
       
        // below is code to go back to the adimn menu
        System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();}
        else{
            changePrices();}
   }
    //method for collecting money from the machine
    public static void collectMoney(){
       System.out.println("You are about to collect money");
       System.out.println();
       System.out.println("          The available money  :");
        System.out.println("==================================================");
       System.out.println("N$ 200                               :"+ twoHundred);
       System.out.println("N$ 100                               :"+ oneHundred);
       System.out.println("N$ 50                                :"+fifty);
       System.out.println("N$ 20                                :"+ twenty);
       System.out.println("N$ 10                                :"+ten);
       System.out.println("N$ 5                                 :"+fiveDollars);
       System.out.println("N$ 1                                 :"+oneDollar);
       System.out.println(" 50c                                 :"+fiftyCents);
       System.out.println(" 10c                                 :"+tenCents);
       System.out.println();
       System.out.println("==================================================");
       double total_amount_of_money_in_the_machine=(200*twoHundred)+(100*oneHundred)+(50*fifty)+(20*twenty)+
                                                   (10*ten)+(5*fiveDollars)+(1*oneDollar)+(0.50*fiftyCents)+(0.10*tenCents);
       System.out.println("The total amount of money in the machine is : $"+total_amount_of_money_in_the_machine);
       System.out.println("==================================================");
       System.out.println();
       System.out.println("*****             OPTIONS                     ****");
       System.out.println("==================================================");
       System.out.println("1.N$200 \n2.N$100 \n3.N$50 \n4.N$20 \n5.N$10 \n6.N$5 \n7.N$1 \n8.50c \n9. 10c \n0.Exit");
       System.out.println("==================================================");
       System.out.print("Select corresponding option from above :");
       int choice = input.nextInt();
       
       switch(choice){
           case 1:
               if(twoHundred>0){
                   System.out.print("Enter the amount of N$ 200 you want to collect ");
                   int collect_2 =  input.nextInt();
               if(twoHundred-collect_2<0){
                    System.out.println("reduce the number of N$ 200 you want too collect");}
               else{
                   twoHundred=twoHundred-collect_2;
                    System.out.println("You successfully collect "+collect_2 +" N$ 200");}}
               else{
                   System.out.println("There are no N$ 200 in the machine ");}
               break;
               
           case 2: 
               if(oneHundred>0){
                   System.out.print("Enter the amount of N$ 100 you want to collect ");
                   int collect_1 =  input.nextInt();
               if(oneHundred-collect_1<0){
                   System.out.println("reduce the number of N$ 00 you want too collect"); }
               else{
                   oneHundred =oneHundred-collect_1;
                   System.out.println("You successfully collect "+collect_1 +" N$ 100");}}
               else{
                   System.out.println("There are no N$ 100 in the machine ");}
               break;
           case 3:
                if(fifty>0){
                   System.out.print("Enter the amount of N$ 50 you want to collect ");
                   int collect_5 =  input.nextInt();
               if(fifty-collect_5<0){
                   System.out.println("reduce the number of N$ 50 you want too collect");}
               else{
                   fifty=fifty-collect_5;
                   System.out.println("You successfully collect "+collect_5 +" N$ 50");}}
               else{
                   System.out.println("There are no N$ 50 in the machine "); }
               break;
           case 4:
               
                if(twenty>0){
                   System.out.print("Enter the amount of N$ 20 you want to collect ");
                int collect_02 =  input.nextInt();
                if(twenty-collect_02<0){
                   System.out.println("reduce the number of N$ 20 you want too collect");}
                else{
                    twenty=twenty-collect_02;
                       System.out.println("You successfully collect "+collect_02 +" N$ 20");}}
               else{
                   System.out.println("There are no N$ 20 in the machine ");}
               break;
               
           case 5:
               if(ten>0){
                   System.out.print("Enter the amount of N$ 10 you want to collect ");
                   int collect_01 =  input.nextInt();
               if(ten-collect_01<0){
                       System.out.println("reduce the number of N$ 10 you want too collect");}
               else{
                    ten=ten-collect_01;
                    System.out.println("You successfully collect "+collect_01 +" N$ 10"); }}
               else{
                   System.out.println("There are no N$ 10 in the machine ");}
               break;
           case 6:
               if(fiveDollars>0){
                   System.out.print("Enter the amount of N$ 5 you want to collect ");
                   int collect_05 =  input.nextInt();
               if(fiveDollars-collect_05<0){
                       System.out.println("reduce the number of N$ 5 you want too collect");}
               else{
                    fiveDollars=fiveDollars-collect_05;
                    System.out.println("You successfully collect "+collect_05 +" N$ 5"); }}
               else{
                   System.out.println("There are no N$ 5 in the machine ");}
               break;
           case 7:
                if(oneDollar>0){
                   System.out.print("Enter the amount of N$ 1 you want to collect ");
                   int collect_001 =  input.nextInt();
               if(oneDollar-collect_001<0){
                       System.out.println("reduce the number of N$ 1 you want too collect");}
               else{
                    oneDollar=oneDollar-collect_001;
                    System.out.println("You successfully collect "+collect_001 +" N$ 1"); }}
               else{
                   System.out.println("There are no N$ 1 in the machine ");}
               break;
           case 8:
               if(fiftyCents>0){
                   System.out.print("Enter the amount of 50c you want to collect ");
                   int collect_05 =  input.nextInt();
               if(fiftyCents-collect_05<0){
                       System.out.println("reduce the number of 50c you want too collect");}
               else{
                    fiftyCents=fiftyCents-collect_05;
                    System.out.println("You successfully collect "+collect_05 +" 50c"); }}
               else{
                   System.out.println("There are no 50c in the machine ");}
               break;
               
           case 9 : 
                if(tenCents>0){
                   System.out.print("Enter the amount of 10c you want to collect ");
                   int collect_10 =  input.nextInt();
               if(tenCents-collect_10<0){
                       System.out.println("reduce the number of 10c you want too collect");}
               else{
                    tenCents=tenCents-collect_10;
                    System.out.println("You successfully collect "+collect_10 +" 10c"); }}
               else{
                   System.out.println("There are no 10c in the machine ");}
               break;
           case 0:
               adminMenu();
               break;
               
           default : 
                   System.out.println("sorry inavalid input!!!!");}
                 // below is code to go back to the adimn menu
                   System.out.println();
                   System.out.println("0.Back");
                   int back =input.nextInt();
               if(back==0){
                  adminMenu(); }
               else{
                   collectMoney();
        }
       
   }
    //method for adding money into the machine
    public static void addMoney(){
       System.out.println();
       System.out.println("You are about to add money into the machine");
       System.out.println("**                   0PTIONS                    **");
       System.out.println("==================================================");
       System.out.println("1.N$ 200 \n2.N$ 100 \n3.N$ 50 \n4.N$ 20 \n5.N$ 10 \n6.N$5 \n7.N$1 \n8.50c \n9.10c\n0.Exit");
       System.out.println("==================================================");
       System.out.print("Select corresponding option from above :");
       int choice = input.nextInt();
       
       switch(choice){
           case 1:
               System.out.print("Enter the number of N$ 200 you want to add :");
               int new200 = input.nextInt();
               twoHundred =twoHundred+new200;
               System.out.println(new200 +" N$ 200 successfully added !!!");
               break;
           case 2:
               System.out.print("Enter the number of N$ 100 you want to add :");
               int new100 = input.nextInt();
               oneHundred =oneHundred+new100;
               System.out.println(new100+ " N$ 100 successfully added !!!");
               break;
           case 3:
               System.out.print("Enter the number of N$ 50 you want to add :");
               int new50 = input.nextInt();
               fifty=fifty+new50;
               System.out.println(new50+" N$ 50 successfully added !!!");
               break;
           case 4:
               System.out.print("Enter the number of N$ 20 you want to add :");
               int new20 = input.nextInt();
               twenty=twenty+new20;
               System.out.println(new20+ " N$ 20 successfully added !!!");
               break;
           case 5:
               System.out.print("Enter the number of N$ 10 you want to add :");
               int new10 = input.nextInt();
               ten =ten+new10;
               System.out.println(new10+" N$ 10 successfully added !!!");
               break;
           case 6:
               System.out.print("Enter the number of N$ 5 you want to add :");
               int new05 = input.nextInt();
               fiveDollars =fiveDollars+new05;
               System.out.println(new05+" N$ 5 successfully added !!!");
               break;
           case 7:
                 System.out.print("Enter the number of N$ 1 you want to add :");
               int new001 = input.nextInt();
               oneDollar =oneDollar+new001;
               System.out.println(new001+" N$ 1 successfully added !!!");
               break;
           case 8:
                System.out.print("Enter the number of 50c you want to add :");
               int new005 = input.nextInt();
               fiftyCents =fiftyCents+new005;
               System.out.println(new005+" 50c successfully added !!!");
               break;
           case 9:
               System.out.print("Enter the number of 10c you want to add :");
               int new0001 = input.nextInt();
               tenCents =tenCents+new0001;
               System.out.println(new0001+" 10c successfully added !!!");
               break;
           case 0:
               adminMenu();
               break;
           default :
               System.out.println("sorry invalid input !!!");
               
      }
       // below is code to go back to the adimn menu
       System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            addMoney();
        }
   }
    //method for changing the admin credentials
    public static void changingCredentials(){
       System.out.println();
       System.out.println("You are about to change admin credentials");
       System.out.println();
       
       System.out.print("Enter admin username :");
       String pass =input.next();
       
       if(username.equals(pass)){
           System.out.print("Enter admin new username :");
           String newUser = input.next();
           username =newUser;
           
           System.out.print("Enter your new password :");
           String newPass = input.next();
           password =newPass;
           
           System.out.print("Enter new admin secrete word :");
           String newSecrete = input.next();
           secreteWord =newSecrete;
           
           System.out.println("Admin credentials succssfully changed !!!");}
       else{
           System.out.println("Sorry incorrect admin username !!");
       }
       
       // below is code to go back to the adimn menu
       System.out.println();
        System.out.println("0.Back");
        int back =input.nextInt();
        if(back==0){
            adminMenu();
        }else{
            changingCredentials();
        }
   }
    
    
    
}
