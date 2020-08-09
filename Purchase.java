// Lisa Sinn
// Intro to Java - CSCI 1146 
// CSCI 1146
// Unit 9, Exercise #7
// Purchase.java

public class Purchase {
  
   private int invoiceNumber;
   private double salesAmount;
   private double salesTax;
  
   // default constructor
   public Purchase()
   {
       invoiceNumber = 0;
       salesAmount = 0.0;
       salesTax = 0.0;
   }
  
   // parameterized constructor
   public Purchase(int invoiceNumber, double salesAmount, double salesTax) {
       this.invoiceNumber = invoiceNumber;
       this.salesAmount = salesAmount;
       this.salesTax = salesTax;
   }

   public int getInvoiceNumber() {
       return invoiceNumber;
   }

   public void setInvoiceNumber(int invoiceNumber) {
       this.invoiceNumber = invoiceNumber;
   }

   public double getSalesAmount() {
       return salesAmount;
   }

   public void setSalesAmount(double salesAmount) {
       this.salesAmount = salesAmount;
   }

   public double getSalesTax() {
       return salesTax;
   }

   public void setSalesTax(double salesTax) {
       this.salesTax = salesTax;
   }
  
   @Override
   public String toString()
   {
       return "Invoice Number\t: " + invoiceNumber + "\n" +
               "Sales Amount\t: " + salesAmount + "\n" +
               "Sales Tax\t: " + salesTax;
   }

}