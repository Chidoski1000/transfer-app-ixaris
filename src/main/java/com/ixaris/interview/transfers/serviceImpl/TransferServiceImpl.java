package com.ixaris.interview.transfers.serviceImpl;

import com.ixaris.interview.transfers.service.TransferService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 *This class implements the TransferService Interface and
 */
@Slf4j
@Service
@NoArgsConstructor
public class TransferServiceImpl implements TransferService {

     private final Map<String, BigDecimal> acctDetails = new HashMap<>();
     private final Map<String, Integer> countMap = new HashMap<>();


    @Override
    public String getFrequentlyUsedSourceAccount() {
        return countMap.entrySet().stream().max(
                Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    @Override
    public String getAccountWithHighestBalance() {
        return acctDetails.entrySet().stream().max(
                Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }


    @Override
    public String getFinalBalances() {
        final StringBuilder sb = new StringBuilder();
        acctDetails.forEach((k, v) -> sb.append(k).append(" - ")
                .append(v.setScale(2, RoundingMode.HALF_UP)).append('\n'));
        return sb.toString();
    }

    @Override
    public void extractedValues(final String arg) {
        final URL file = getClass().getClassLoader().getResource(arg);
        try {
            final List<String> list = Files.readAllLines(Path.of(file.toURI()));
            int i = 0;
            while (i < list.size()) {
                final String[] word = list.get(i).split(",");
                try {
                    BigDecimal db = new BigDecimal(word[0].trim());
                } catch (NumberFormatException e) {
                    i++;
                    continue;
                }
                if (new BigDecimal(word[0].trim()).compareTo(BigDecimal.ZERO) != 0) {
                    acctDetails.merge(word[0].trim(), new BigDecimal(word[2].trim()), BigDecimal::subtract);
                    countMap.merge(word[0].trim(), 1, Integer::sum);
                }
                acctDetails.merge(word[1].trim(), new BigDecimal(word[2].trim()), BigDecimal::add);
                i++;
            }
        } catch (final IOException | URISyntaxException e) {
            log.info(e.getMessage());
        }
    }
}
