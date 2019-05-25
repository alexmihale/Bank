package bank;

public enum Bank {
    ING;
    private int counter = 0;

    private BankAccount[] bankAccounts = new BankAccount[5];

    private Bank() {}

    public void registerBankAccount(BankAccount bankAccount){
        if(counter + 1 > this.bankAccounts.length ){
            doubleArray();
        }
        this.bankAccounts[counter] = bankAccount;
        counter++;
    }

    private void doubleArray(){
    BankAccount[] newArray = new BankAccount[bankAccounts.length * 2];
        for (int i = 0; i < bankAccounts.length ; i++) {
            newArray[i] = bankAccounts[i];
        }

    bankAccounts = newArray;
    }

    public void deleteBankAccount(BankAccount bankAccount){
        int i = findIdOfBankAccount(bankAccount);

        if(i == -1){
            System.out.println("We couldn't find that client!");
            return;
        }
        for (int j = i; j < counter -1 ; j++) {
            bankAccounts[j] = bankAccounts[j+1];
        }
        System.out.println("Bank Account deleted!");
        bankAccounts[counter-1] = null;
        counter--;

    }

    public int findIdOfBankAccount(BankAccount bankAccount){
        int low = 0;
        int high = counter;
        while (low <= high){
            int mid = (low+high)/2;
            if (bankAccount.getId() < mid ){
                high = mid - 1;
            }

            if (bankAccount.getId() > mid){
                low = mid + 1;
            }
            if(bankAccount.getId() == mid) {
                return mid;
            }
        }
        return -1;
    }

    public int getNumberOfTotalAccounts() {
        return counter;
    }

}
