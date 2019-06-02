package bank;

import static bank.Currency.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BankAccount {


    private static int counter = 0;

    private int id;

    private String ownerName;

    private Currency currency;

    private double sold;

    private String creditCardNumber;

    public BankAccount(String ownerName, Currency currency, String creditCardNumber) {
        counter++;
        id = counter;
        this.currency = currency;
        this.ownerName = ownerName;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean verifyCreditCard(String creditCardNumber) { //Credit card verification
        char[] chars = creditCardNumber.toCharArray();
        int sum = 0;
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; i++) { //chars to int
            numbers[i] = chars[i] - 48;
        }
        for (int i = numbers.length - 2; i> -1 ; i -= 2) {
            numbers[i] = numbers[i] * 2;
            if (numbers[i] > 9) {
                int nr;
                nr = numbers[i] % 10;
                numbers[i] /= 10;
                numbers[i] = numbers[i] + nr;

            }

        }
        int j = 0;
        while (j < numbers.length) { //number addition
             sum = sum + numbers[j];
            j++;
        }

        if (sum % 10 == 0) {//verification
            return TRUE;
        } else {
            return FALSE;
        }

    }

    public void withdrawMoney(double sum) { //withdrow money function
        if (checkBalance(sum) == -1) { //check blanace function
            return;
        }
        sold = sold - sum;
        System.out.println("You withdraw " + sum + " " + this.currency);
    }

    private double checkBalance(double sum) { // check balance function
        if (sum > this.sold) {
            System.out.println("You don't have enough money!");
            return -1;
        }
        return sum;
    }

    public void withdrawMoney(double sum, Currency currency) { //withdraw money function
        double newSum;
        double secondSum;
        if (currency == this.currency) { // if account currency = withdraw currency
            withdrawMoney(sum);
            return;
        }

        if (this.currency == EUR) { // here we check the currency of the account
            if (currency == Currency.USD) { // withdraw currency
                newSum = convertUsdToEur(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }

                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToEur(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);

            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToEur(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);

            }
        }
        if (this.currency == Currency.YEN) {
            if (currency == Currency.USD) {
                newSum = convertUsdToYen(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToYen(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }

                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }

            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToYen(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
        }
        if (this.currency == Currency.RON) {
            if (currency == Currency.USD) {
                newSum = convertUsdToRon(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }

            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToRon(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToRon(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
        }
        if (this.currency == Currency.USD) {
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
                System.out.println("You withdraw " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
        }
    }

    public void depositMoney(double sum) { //deposit money function
        sold = sold + sum;
        System.out.println("You deposit " + sum + " " + this.currency);
    }

    public void depositMoney(double sum, Currency currency) { //deposit money in other currency
        double newSum;
        double secondSum;
        if (currency == this.currency) { //if deposit currency - account currency
            depositMoney(sum); // call depositMoney() function
            return;
        }

        if (this.currency == USD) { //check account currency
            if (currency == RON) { // check deposit currency
                newSum = convertToUsd(sum, RON);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
        }
        if (this.currency == RON) {
            if (currency == USD) {
                newSum = convertUsdToRon(sum);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToRon(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToRon(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
        }
        if (this.currency == EUR) {
            if (currency == USD) {
                newSum = convertUsdToEur(sum);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
            if (currency == RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToEur(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToEur(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
        }
        if (this.currency == YEN) {
            if (currency == USD) {
                newSum = convertUsdToYen(sum);
                sold = sold + newSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + newSum + " " + this.currency);
            }
            if (currency == RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToYen(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToYen(newSum);
                sold = sold + secondSum;
                System.out.println("You deposit " + sum + " " + currency + " / " + secondSum + " " + this.currency);
            }

        }
    }

    private double convertUsdToRon(double sum) {
        return sum / RON.getConvertion();
    } // convertion from USD to RON

    private double convertToUsd(double sum, Currency currency) { //convert from other currency to USD
        if (currency == Currency.RON) {
            return sum * RON.getConvertion();
        }

        if (currency == EUR) {
            return sum * EUR.getConvertion();
        }

        if (currency == Currency.YEN) {
            return sum * YEN.getConvertion();
        }
        return -1;
    }

    private double convertUsdToEur(double sum) {
        return sum / EUR.getConvertion();
    } //convertion from USD to EUR

    private double convertUsdToYen(double sum) {
        return sum / YEN.getConvertion();
    } // convertion from USD to YEN

    public int getId() {
        return id;
    } // get it function

    public double getSold() { //get sold function. Display the money that are in the account using account currency
        System.out.print("You sold is: ");
        return sold;
    }

    public Currency getCurrency() { // check account currency
        System.out.print("Your currency is ");
        return currency;
    }

    @Override
    public String toString() { // display the acccount details
        return "BankAccount{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", currency=" + currency +
                ", sold=" + sold +
                ", credit card number: " + creditCardNumber +
                '}';
    }
}
