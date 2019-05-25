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

    public BankAccount(String ownerName,Currency currency, String creditCardNumber) {
        counter++;
        id = counter;
        this.currency = currency;
        this.ownerName = ownerName;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean verifyCreditCard(String creditCardNumber){
        char [] chars = creditCardNumber.toCharArray();
        int sum = 0;
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length ; i++) {
            numbers[i] = chars[i]- 48;
        }
        for (int i = 0; i < numbers.length - 1; i += 2) {
            numbers[i] = numbers[i] * 2;
            if (numbers[i] > 9) {
                int nr;
                nr = numbers[i] % 10;
                numbers[i] /= 10;
                numbers[i] = numbers[i] + nr;

            }

        }
//        int sum = 0;
//        long[] evenNumbers = new long[7];
//        long[] oddNumbers = new long[7];
//        int i = 0;
//        long number = Long.valueOf(creditCardNumber);
//        while(number > 0 ){
//            oddNumbers[i] = number % 10;
//            number /= 10;
//            evenNumbers[i] = number % 10;
//            number /= 10;
//            i++;
//        }
        int j = 0;
        while (j < numbers.length) {
            sum = sum + numbers[j];
            j++;
        }

        if (sum % 10 == 0){
            return TRUE;
        }
        else {
            return FALSE;
        }

    }

    public void withdrawMoney(double sum) {
        if (checkBalance(sum) == -1) {
            return;
        }
        sold = sold - sum;
        System.out.println("You withdraw " + sum +" " + this.currency);
    }

    public double checkBalance(double sum) {
        if (sum > this.sold) {
            System.out.println("You don't have enough money!");
            return -1;
        }
        return sum;
    }

    public void withdrawMoney(double sum, Currency currency) {
        double newSum;
        double secondSum;
        if (currency == this.currency) {
            withdrawMoney(sum);
            return;
        }
        System.out.println("You withdraw " + sum + " " + currency);
        if (this.currency == EUR) {
            if (currency == Currency.USD) {
                newSum = convertUsdToEur(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }

                sold = sold - newSum;
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToEur(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToEur(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
            }
        }

        if (this.currency == Currency.YEN) {
            if (currency == Currency.USD) {
                newSum = convertUsdToYen(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToYen(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }

                sold = sold - secondSum;
            }

            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToYen(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
            }
        }
        if (this.currency == Currency.RON) {
            if (currency == Currency.USD) {
                newSum = convertUsdToRon(sum);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
            }

            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToRon(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToRon(newSum);
                if (checkBalance(secondSum) == -1) {
                    return;
                }
                sold = sold - secondSum;
            }
        }
        if (this.currency == Currency.USD) {
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
            }

            if (currency == Currency.RON) {
                newSum = convertToUsd(sum, RON);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
            }

            if (currency == Currency.YEN) {
                newSum = convertToUsd(sum, YEN);
                if (checkBalance(newSum) == -1) {
                    return;
                }
                sold = sold - newSum;
            }
        }
    }

    public void depositMoney(double sum) {
        sold = sold + sum;
        System.out.println("You deposit " + sum + " " + this.currency);
    }

    public void depositMoney(double sum, Currency currency) {
        double newSum;
        double secondSum;
        if (currency == this.currency) {
            depositMoney(sum);
            return;
        }
        System.out.println("You deposit " + sum + " " + currency);

        if (this.currency == USD) {
            if (currency == RON) {
                newSum = convertToUsd(sum, RON);
                sold = sold + newSum;
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                sold = sold + newSum;
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                sold = sold + newSum;
            }
        }
        if (this.currency == RON) {
            if (currency == USD) {
                newSum = convertUsdToRon(sum);
                sold = sold + newSum;
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToRon(newSum);
                sold = sold + secondSum;
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToRon(newSum);
                sold = sold + secondSum;
            }
        }

        if (this.currency == EUR) {
            if (currency == USD) {
                newSum = convertUsdToEur(sum);
                sold = sold + newSum;
            }
            if (currency == RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToEur(newSum);
                sold = sold + secondSum;
            }
            if (currency == YEN) {
                newSum = convertToUsd(sum, YEN);
                secondSum = convertUsdToEur(newSum);
                sold = sold + newSum;
            }
        }

        if (this.currency == YEN) {
            if (currency == USD) {
                newSum = convertUsdToYen(sum);
                sold = sold + newSum;
            }
            if (currency == RON) {
                newSum = convertToUsd(sum, RON);
                secondSum = convertUsdToYen(newSum);
                sold = sold + secondSum;
            }
            if (currency == EUR) {
                newSum = convertToUsd(sum, EUR);
                secondSum = convertUsdToYen(newSum);
                sold = sold + secondSum;
            }
        }

    }
    private double convertUsdToRon(double sum) {
        return sum / RON.getConvertion();
    }

    private double convertToUsd(double sum, Currency currency) {
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
    }

    private double convertUsdToYen(double sum) {
        return sum / YEN.getConvertion();
    }
    public int getId() {
        return id;
    }

    public double getSold() {
        return sold;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", currency=" + currency +
                ", sold=" + sold +
                '}';
    }
}
