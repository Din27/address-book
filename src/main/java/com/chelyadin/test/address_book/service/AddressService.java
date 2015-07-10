package com.chelyadin.test.address_book.service;

import com.chelyadin.test.address_book.domain.Address;

import java.util.List;

/**
 * @author Dmitriy Chelyadin
 */
public interface AddressService {
    void saveAddress(Address address);
    List<Address> getAll();
}
