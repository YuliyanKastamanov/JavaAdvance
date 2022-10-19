package L06_DefiningClasses.Labs.P03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineArguments = scanner.nextLine().split("\\s+");
        String command = lineArguments[0];

        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!command.equals("End")){
            String result = "";

            switch (command){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    result = String.format("Account ID%d created", bankAccount.getId());
                    accounts.put(bankAccount.getId(), bankAccount);
                    break;

                case "Deposit":

                    int accountId = Integer.parseInt(lineArguments[1]);
                    double money = Double.parseDouble(lineArguments[2]);


                    if (accounts.containsKey(accountId)){
                        BankAccount currentBankAccount =  accounts.get(accountId);
                        currentBankAccount.deposit(money);
                        accounts.put(accountId, currentBankAccount);
                        result = String.format("Deposited %.0f to ID%d", money, accountId);
                    } else {
                        result = "Account does not exist";
                    }
                    break;

                case "SetInterest":

                    double interestRate =  Double.parseDouble(lineArguments[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":

                    int accountID =  Integer.parseInt(lineArguments[1]);
                    int years =  Integer.parseInt(lineArguments[2]);

                    if (accounts.containsKey(accountID)){
                        BankAccount bankAccount1 = accounts.get(accountID);
                        double totalInterest = bankAccount1.getInterest(years);

                        result = String.format("%.2f",totalInterest );
                    }else {
                        result = "Account does not exist";
                    }

                    break;


            }

            if (!result.isEmpty()){
                System.out.println(result);
            }

            lineArguments = scanner.nextLine().split("\\s+");
            command = lineArguments[0];
        }
    }
}
