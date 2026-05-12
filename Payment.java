import java.time.*;

public class Payment 
{
    private int paymentID;
    private Debt debt;
    private double paymentAmount;
    private LocalDate paymentDate;

    //Constructor

    public Payment(int paymentID, Debt debt, double paymentAmount, LocalDate paymentDate)
    {
        setID(paymentID);
        setDebt(debt);
        setPaymentAmount(paymentAmount);
        setPaymentDate(paymentDate);
    }
    
    
    
    
    //SETTERS

    public void setID(int paymentID)
    {
        this.paymentID = paymentID;
    }

    public void setDebt(Debt debt)
    {
        this.debt = debt;
    }

    public void setPaymentAmount(double paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentDate(LocalDate paymentDate)
    {
        
        this.paymentDate = paymentDate;
        
    }

    //GETTERS
    public int getID()
    {
        return paymentID;
    }

    public Debt getDebt()
    {
        return debt;
    }

    public double getPaymentAmount()
    {
        return paymentAmount;
    }

    public LocalDate getPaymentDate()
    {
        return paymentDate;
    }
}
