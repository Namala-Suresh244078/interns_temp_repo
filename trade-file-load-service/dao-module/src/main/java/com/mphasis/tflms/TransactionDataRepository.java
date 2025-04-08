package com.mphasis.tflms;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TransactionDataRepository extends JpaRepository<TransactionDataRepository, Long>{
}
