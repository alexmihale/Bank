package bank;

public enum Currency {//here we create an enum with the all currency that we have and their convertion rate
    USD(1),
    RON(0.23),
    EUR(1.12),
    YEN(0.00915);

    private double convertion;

    Currency(double convertion){
        this.convertion = convertion;
    }

    public double getConvertion() { // get convertion function that we use in convertions in BankAccount class.
        return convertion;
    }

}
