import java.time.*;

public class Debt 
{
    //Debt Account requirements

    private String debtName;
    private double origBalance;
    private double currBalance;
    private double intRate;
    private double minPayment;
    private LocalDate dueDate;
    private String accountType;
    private boolean isPaidOff;

    //Constructor
    public Debt(String debtName, double origBalance, double currBalance, double intRate, 
        double minPayment, LocalDate dueDate, String accountType, boolean isPaidOff)
    {
        setName(debtName);
        setOrigBalance(origBalance);
        setCurrBalance(currBalance);
        setIntRate(intRate);
        setMinPayment(minPayment);
        setDueDate(dueDate);
        setAccType(accountType);
        setPaidOff(isPaidOff);
    }

//SETTERS
    public void setName(String debtName)
    {
        this.debtName = debtName;
    }

    public void setOrigBalance(double origBalance)
    {
        this.origBalance = origBalance;
    }

    public void setCurrBalance(double currBalance)
    {
        this.currBalance = currBalance;
    }

    public void setIntRate(double intRate)
    {
        if (intRate >= 0 && intRate <= 100 )
        {
        this.intRate = intRate / 100;
        }
    }

    public void setMinPayment(double minPayment)
    {
        this.minPayment = minPayment;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public void setAccType(String accountType)
    {
        this.accountType = accountType;
    }

    public void setPaidOff(boolean isPaidOff)
    {
        this.isPaidOff = isPaidOff;
    }
//GETTERS
    public String getName()
    {
        return debtName;
    }

    public double getOrigBalance()
    {
        return origBalance;
    }

    public double getCurrBalance()
    {
        return currBalance;
    }

    public double getIntRate()
    {
        return intRate;
    }

    public double getMinPayment()
    {
        return minPayment;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public String getAccType()
    {
        return accountType;
    }

    public boolean getPaidOff()
    {
        return isPaidOff;
    }

    public void applyPayment(double paymentAmount)
    {
        if (currBalance - paymentAmount < 0)
        {
            System.out.println("Overpayment not allowed. Please pay the exact amount.");
        }
        else
        {
            currBalance = currBalance - paymentAmount;
        }

        if (currBalance == 0)
        {
           isPaidOff = true;
        }
    }
}
