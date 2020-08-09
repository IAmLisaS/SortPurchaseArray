// Lisa Sinn
// Intro to Java - CSCI 1146 
// CSCI 1146
// Unit 9, Exercise #7
// Purchase.java

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortPurchaseArray {
  
   public static void main(String[] args)
   {
       Purchase[] purchase = new Purchase[5];
       getPurchaseDetails(purchase);
       int choice = printMenuAndGetChoice();
       do{
           if(choice == 1)
           {
               Arrays.sort(purchase, sortByInvoice);
               printAllPurchase(purchase);
           }
           else if(choice == 2)
           {
               Arrays.sort(purchase, sortBySalesAmount);
               printAllPurchase(purchase);
           }
           else if(choice == 3)
           {
               Arrays.sort(purchase, sortBySalesTax);
               printAllPurchase(purchase);
           }
           System.out.println();
           choice = printMenuAndGetChoice();
           System.out.println();
           if(choice == 0)
               System.out.println("Goodbye...");
       }
       while(choice != 0);
   }
  
   public static void getPurchaseDetails(Purchase[] purchase)
   {
       String p = "";
       Scanner kb = new Scanner(System.in);
       System.out.println("Enter the details of each purchases line by line in the format given below");
       System.out.println("InvoiceNumber SalesAmount SalesTax\n");
       for(int i = 0; i < purchase.length; i++)
       {
           System.out.println("Enter the details of purchase #"+(i+1));
           p = kb.nextLine();
           String[] tokens = p.split(" ");
           int invoice = Integer.parseInt(tokens[0]);
           double s_amt = Double.parseDouble(tokens[1]);
           double tax = Double.parseDouble(tokens[2]);
           purchase[i] = new Purchase(invoice, s_amt, tax);
           System.out.println();
       }
   }
  
   public static int printMenuAndGetChoice()
   {
       int choice = -1;
       Scanner kb = new Scanner(System.in);
       while(choice < 0 || choice > 3)
       {
           System.out.println("Select from the menu below.");
           System.out.println("---------------------------");
           System.out.println("1) Sort by invoice.");
           System.out.println("2) Sort by Amount of sale.");
           System.out.println("3) Sort by sales tax.");
           System.out.println("0) Exit.");
           System.out.println("===========================");
           System.out.print("Please enter your choice: ");
           choice = Integer.parseInt(kb.nextLine());
           if(choice < 0 || choice > 3)
               System.out.println("Invalid choice. Please re-try\n");
       }
       return choice;
   }

   public static Comparator<Purchase> sortByInvoice = new Comparator<Purchase>(){
       @Override
       public int compare(Purchase p1, Purchase p2)
       {
           return (int)(p1.getInvoiceNumber() - p2.getInvoiceNumber());
       }
   };
  
  
   public static Comparator<Purchase> sortBySalesAmount = new Comparator<Purchase>(){
       @Override
       public int compare(Purchase p1, Purchase p2)
       {
           return (int)(p1.getSalesAmount() - p2.getSalesAmount());
       }
   };
  
   public static Comparator<Purchase> sortBySalesTax = new Comparator<Purchase>(){
       @Override
       public int compare(Purchase p1, Purchase p2)
       {
           return (int)(p1.getSalesTax() - p2.getSalesTax());
       }
   };
  
   public static void printAllPurchase(Purchase[] p)
   {
       for(int i = 0; i < p.length; i++)
       {
           System.out.println(p[i] + "\n");
       }
   }


}