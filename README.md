# README.md
This application takes as input the path to a file and prints the following:

The final balances of all bank accounts(rounded to 2 decimal place).
The bank accounts with the highest final balance
The most frequently used bank account as a Source
TransferService Interface: This is the Transfer contract which contains contract(abstract methods) to be implemented by any implementing class.

void extractedValues(String arg): this perform the operations of the gotten csv and saves result in a Map.
String getFrequentlyUsedSourceAccount(): this returns the most frequently used source account after the operations have been performed.
String getAccountWithHighestBalance(): this returns the account number with the highest balance after operations have been performed.
String getFinalBalances(): this returns a String of all the balances of the accounts after operations have been performed.
TransferServiceImpl Class: This class implements and provides the logic and implementation of the various abstract class of the TransferService.

To start up the application provide path to file as argument.
