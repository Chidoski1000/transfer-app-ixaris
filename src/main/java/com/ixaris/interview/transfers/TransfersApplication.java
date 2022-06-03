package com.ixaris.interview.transfers;

import com.ixaris.interview.transfers.service.TransferService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

/**
 * <p>
 * A Command-line application to parse and process a transfers file and provide the business requirements, namely:
 * 	<ul>
 * 	    <li>1. Print the final balances on all bank accounts</li>
 * 	    <li>2. Print the bank account with the highest balance</li>
 * 	    <li>3. Print the most frequently used source bank account</li>
 * 	</ul>
 * </p>
 */
@SpringBootApplication
@Log4j2
public class TransfersApplication implements CommandLineRunner {
    private final TransferService transferService;

    /**
     * @param transferService
     */
    public TransfersApplication(final TransferService transferService) {
        this.transferService = transferService;
    }

    public static void main(final String[] args) {
        SpringApplication.run(TransfersApplication.class, args);
    }

    @Override
    public void run(final String... args) {

        // Below is some sample code to get you started. Good luck :)

        transferService.extractedValues(args[0]);

        log.info("#Balances");
        Arrays.stream(transferService.getFinalBalances().split("\n")).forEach(log::info);

        log.info("#Bank Account with highest balance");
        log.info(transferService.getAccountWithHighestBalance());

        log.info("#Frequently used source bank account");
        log.info(transferService.getFrequentlyUsedSourceAccount());

    }



}
