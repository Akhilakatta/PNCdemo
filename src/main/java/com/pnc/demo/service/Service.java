package com.pnc.demo.service;

import com.pnc.demo.entity.AccountDetails;
import com.pnc.demo.repository.AccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final AccountDetailsRepository accountDetailsRepository;

    @Autowired
    public Service(AccountDetailsRepository accountDetailsRepository){
        this.accountDetailsRepository = accountDetailsRepository;
    }

    public List<AccountDetails> getAllAccountRecords() {
        return accountDetailsRepository.findAll();
    }

    public AccountDetails getLatestAccountByAccountNumber(String accountNumber) {
        List<AccountDetails> accountDetails = accountDetailsRepository.findByAccountNumberOrderByLastUpdatedTimeStampDesc(accountNumber);
        return !accountDetails.isEmpty() ? accountDetails.get(0) : null;
    }

    public List<AccountDetails>  getAccountDetailsBetweenDateTimeRange(String accountNumber, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        return accountDetailsRepository.findByAccountNumberAndLastUpdatedTimeStampBetween(accountNumber, startLocalDateTime, endLocalDateTime);
    }

    public List<AccountDetails> getAccountDetailsBetweenDateTimeRangeByType(String accountNumber, String type, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        return accountDetailsRepository.findByAccountNumberAndTypeAndLastUpdatedTimeStampBetween(accountNumber, type, startLocalDateTime, endLocalDateTime);
    }
}
