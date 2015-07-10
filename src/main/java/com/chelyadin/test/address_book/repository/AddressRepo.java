package com.chelyadin.test.address_book.repository;

import com.chelyadin.test.address_book.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Chelyadin
 */
@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
}
