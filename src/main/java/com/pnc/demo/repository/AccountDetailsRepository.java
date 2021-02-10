package com.pnc.demo.repository;

import com.pnc.demo.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    List<AccountDetails> findByAccountNumberOrderByLastUpdatedTimeStampDesc(String accountNumber);

    List<AccountDetails> findByAccountNumberAndLastUpdatedTimeStampBetween(String accountNumber, LocalDateTime startDate, LocalDateTime endDate);

    List<AccountDetails> findByAccountNumberAndTypeAndLastUpdatedTimeStampBetween(String accountNumber, String type, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);
}
