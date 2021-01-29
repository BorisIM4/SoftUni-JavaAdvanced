package L6_Defining_Classes.P3_Bank_Account;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> listOfBankAccounts = new ArrayList<>();

        DecimalFormat dF = new DecimalFormat("###.######");

        String line = "";
        while (!("End".equals(line = scanner.nextLine()))) {
            String[] token = line.split("\\s+");
            String command = token[0];

            if ("Create".equals(command)) {
                BankAccount bankAccount = new BankAccount();
                listOfBankAccounts.add(bankAccount);

                System.out.printf("Account ID%d created%n"
                        ,bankAccount.getId());

            } else if ("Deposit".equals(command)) {
                int currentAccId = Integer.parseInt(token[1]);
                double amountOfMoneyToBeDeposit = Double.parseDouble(token[2]);

                if (currentAccId > listOfBankAccounts.size()) {
                    System.out.println("Account does not exist");
                } else {
                    for (int i = 0; i < listOfBankAccounts.size(); i++) {
                        if (currentAccId - 1 == i) {
                            BankAccount currentBankAcc = listOfBankAccounts.get(i);
                            currentBankAcc.deposit(amountOfMoneyToBeDeposit);

                            System.out.printf("Deposited %s to ID%d%n"
                                    , dF.format(amountOfMoneyToBeDeposit)
                                    , currentAccId);
                        }
                    }
                }
            } else if ("SetInterest".equals(command)) {
                double currentinterest = Double.parseDouble(token[1]);

                BankAccount bankAccount = new BankAccount();
                bankAccount.setInterest(currentinterest);
            } else if ("GetInterest".equals(command)) {
                int currentAccID = Integer.parseInt(token[1]);
                int numberOfYears = Integer.parseInt(token[2]);

                if (currentAccID > listOfBankAccounts.size()) {
                    System.out.println("Account does not exist");
                } else {
                    for (int i = 0; i < listOfBankAccounts.size(); i++) {
                        if (currentAccID - 1 == i) {
                            BankAccount currentBankAcc = listOfBankAccounts.get(i);
                            double interest = currentBankAcc.getInterest(numberOfYears);

                            System.out.printf("%.2f%n", interest);
                        }
                    }
                }

            }

        }

    }
}
