package com.ixaris.interview.transfers;

import com.ixaris.interview.transfers.service.TransferService;
import com.ixaris.interview.transfers.serviceImpl.TransferServiceImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransfersApplicationTests {

	private final TransferService transferService = new TransferServiceImpl();

	@BeforeAll
	void init() {
		transferService.extractedValues("transfers.txt");
	}

	@Test
	void testFrequentlyUsedSourceAccount(){
		assertNotNull(transferService.getFrequentlyUsedSourceAccount());
		assertEquals("112233", transferService.getFrequentlyUsedSourceAccount());
	}

	@Test
	void testAccountWithHighestBalance(){
		assertNotNull(transferService.getAccountWithHighestBalance());
		assertEquals("334455", transferService.getAccountWithHighestBalance());
	}

	@Test
	void testFinalBalances(){
		assertNotNull(transferService.getFinalBalances());
		assertEquals("112233 - 36.77\n223344 - 30.12\n334455 - 85.81\n", transferService.getFinalBalances());
	}


}
