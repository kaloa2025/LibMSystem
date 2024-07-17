package com.example.LibMSystem.repository;

import com.example.LibMSystem.model.Txn;
import com.example.LibMSystem.model.TxnStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TxnRepo extends JpaRepository<Txn,Integer> {
    Txn findByUserPhoneNoAndBookBookNoAndTxnStatus(String phoneNo, String bookNo, TxnStatus status);
    @Transactional
    @Modifying
    @Query(value =  "update txn set created_on = '2024-05-01 17:11:07.756000' , settlement_amount=0 ,  txn_status=0  where id =1 ", nativeQuery = true)
    void updateExistingTxn();


    @Transactional
    @Modifying
    @Query(value = "update book set user_id = 2 where id =1;" , nativeQuery = true)
    void updateBook();
}
