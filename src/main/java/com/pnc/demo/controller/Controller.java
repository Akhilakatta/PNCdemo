package com.pnc.demo.controller;

import com.pnc.demo.entity.AccountDetails;
import com.pnc.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping("/accountDetails")
    public List<AccountDetails> getAccountRecords() {
        return service.getAllAccountRecords();
    }

    @GetMapping("/accountDetails/{accountNumber}")
    public AccountDetails getLatestAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return service.getLatestAccountByAccountNumber(accountNumber);
    }

    @GetMapping("/v1/accountDetails/{accountNumber}")
    public Double getLatestBalByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        AccountDetails accountDetails = service.getLatestAccountByAccountNumber(accountNumber);
        return accountDetails != null ? accountDetails.getBalance() : null;
    }

    @GetMapping("/accountDetails/transactions/{accountNumber}")
    public List<AccountDetails> getAccountDetailsBetweenDateTimeRange(@PathVariable("accountNumber") String accountNumber,
                                                  @RequestParam("startDate") String startDate,
                                                  @RequestParam("endDate") String endDate) {
        if (!StringUtils.hasText(startDate) || !StringUtils.hasText(endDate) || !StringUtils.hasText(accountNumber) ) {
            return Collections.emptyList();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate, formatter);

        return service.getAccountDetailsBetweenDateTimeRange(accountNumber, startLocalDateTime, endLocalDateTime);
    }

    @GetMapping("/accountDetails/transactions/{accountNumber}/{type}")
    public List<AccountDetails> getAccountDetailsBetweenDateTimeRangeByType(@PathVariable("accountNumber") String accountNumber,
                                                                      @PathVariable("type") String type,
                                                                      @RequestParam("startDate") String startDate,
                                                                      @RequestParam("endDate") String endDate) {
        if (!StringUtils.hasText(startDate) || !StringUtils.hasText(endDate) ||
                !StringUtils.hasText(type) || !StringUtils.hasText(accountNumber)) {
            return Collections.emptyList();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate, formatter);

        return service.getAccountDetailsBetweenDateTimeRangeByType(accountNumber, type, startLocalDateTime, endLocalDateTime);
    }
}


