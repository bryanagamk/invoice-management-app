package com.agamdigital.invoice.dao;

import com.agamdigital.invoice.entity.InvoiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceTypeDao extends PagingAndSortingRepository<InvoiceType, String> {
}
