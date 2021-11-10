package com.agamdigital.invoice.dao;

import com.agamdigital.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentDao extends PagingAndSortingRepository<Payment, String> {
}
