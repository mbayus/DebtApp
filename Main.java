import java.time.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main 
{
    //HELPER FUNCTIONS

    public static void menuOptions()
    {
        System.out.println("Menu Options: ");
        System.out.println("1. View All Debts");
        System.out.println("2. Log Payment");
        System.out.println("3. Add Debt");
        System.out.println("4. Remove Debt");
        System.out.println("5. Exit");
    }

    public static void addDebt(ArrayList<Debt> debts, Scanner inp)
    {
      
      System.out.println("What is your new Debt Account's name?");
      String newDebtName = inp.nextLine();
      System.out.println("What is your new Debt Account's original balance?");
      double newDebtOrigBalance = Double.parseDouble(inp.nextLine());
      System.out.println("What is your new Debt Account's current balance?");
      double newDebtCurrBalance = Double.parseDouble(inp.nextLine());
      System.out.println("What is your new Debt Account's interest rate?");
      double newDebtIntRate = Double.parseDouble(inp.nextLine());
      System.out.println("What is your new Debt Account's minimum monthly payment?");
      double newDebtMinPayment = Double.parseDouble(inp.nextLine());
      System.out.println("What is your new Debt Account's due date? Put in YYYY-MM-DD form.");
      
      LocalDate newDebtDueDate = LocalDate.parse(inp.nextLine());
      System.out.println("What is your new Debt Account's account type?" + 
      " Common Types are: Credit Cards, Personal Loans, Auto Loans, and Student Loans. If other, put other.");
      String newDebtAccountType = inp.nextLine();
      boolean newDebtPaidOff = false;

      Debt newDebt = new Debt(newDebtName, 
        newDebtOrigBalance, 
        newDebtCurrBalance, 
        newDebtIntRate, 
        newDebtMinPayment, 
        newDebtDueDate, 
        newDebtAccountType, 
        newDebtPaidOff);

        debts.add(newDebt);

    }

    public static void deleteDebt(ArrayList<Debt> debts, Scanner inp)
    {
     
        viewAllDebt(debts);
        System.out.println();
        System.out.println("Choose a debt to delete.");
        String debtName = inp.nextLine();
        for (int i = 0; i < debts.size(); i++)
        {
            Debt currentDebt = debts.get(i);
            if (debtName.equals(currentDebt.getName()))
            {
                debts.remove(currentDebt);
                break;
            }
        }
        System.out.println("Debt deleted. Congratulations!");

    }

    public static void logPayment(ArrayList<Debt> debts, ArrayList<Payment> payments, Scanner inp)
    {
        Random rand = new Random();
        viewAllDebt(debts);
        System.out.println();
        System.out.println("Choose a debt to pay on.");
        String debtName = inp.nextLine();
        for (int i = 0; i < debts.size(); i++)
        {
            Debt currentDebt = debts.get(i);
            if (debtName.equals(currentDebt.getName()))
            {
                int paymentID = rand.nextInt(10000);
                System.out.println("Payment ID: " + paymentID);
                System.out.println("How much would you like to pay?");
                double paymentAmount = Double.parseDouble(inp.nextLine());
                
                Payment newPayment = new Payment(paymentID, currentDebt, paymentAmount, LocalDate.now());
                currentDebt.applyPayment(paymentAmount);
                payments.add(newPayment);
                break;
            }
        }
    }

    public static void viewAllDebt(ArrayList<Debt> debts)
    {
        if (debts.isEmpty())
        {
           System.out.println("No debts found."); 
        }
        else
        {
        for (Debt debt : debts)
        {
            System.out.println(debt.getName() + ": " + debt.getCurrBalance());
        }
    }
    }
    public static void main(String[] args) throws Exception 
    {
        ArrayList<Debt> debts = new ArrayList<>();
        ArrayList<Payment> payments = new ArrayList<>();
        Scanner inp = new Scanner(System.in);
        


        int menuChoice;
        do
        {
            menuOptions();
            menuChoice = Integer.parseInt(inp.nextLine());
            

            switch(menuChoice)
            {
                case 1:
                System.out.println();
                viewAllDebt(debts);
                System.out.println();
                break;
                
            case 2:
                System.out.println();
                logPayment(debts, payments, inp);
                System.out.println();
                break;
                
            case 3:
                System.out.println();
                addDebt(debts, inp);
                System.out.println();
                break;
            case 4: 
                System.out.println();
                deleteDebt(debts, inp);
                System.out.println();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option, choose again.");
            }
        } while (menuChoice != 5);
    }
}
