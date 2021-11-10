package com.agamdigital.invoice.dao;

import com.agamdigital.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {
}
