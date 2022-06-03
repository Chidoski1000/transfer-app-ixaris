package com.ixaris.interview.transfers.service;

/**
 * This interface has the contract for the functions of the transfer application
 * and returns the required results
 */
public interface TransferService {

    /**
     * This helps to perform transactions on the account and save the record on a HashMap
     * @param arg
     */
    void extractedValues(String arg);

    /**
     * This is for returning the frequently used source account
     * @return String
     */
    String getFrequentlyUsedSourceAccount();

    /**
     * This is for returning the account with the highest account balance after every transaction is concluded
     * @return String
     */
    String getAccountWithHighestBalance();

    /**
     * This is for returning the final balances of every account after every transaction is concluded
     * @return
     */
    String getFinalBalances();


}
