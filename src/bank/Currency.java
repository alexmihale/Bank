package bank;

public enum Currency {
    USD(1),
    RON(0.23),
    EUR(1.12),
    YEN(0.00915);

    private double convertion;

    Currency(double convertion){
        this.convertion = convertion;
    }

    public double getConvertion() {
        return convertion;
    }

}
