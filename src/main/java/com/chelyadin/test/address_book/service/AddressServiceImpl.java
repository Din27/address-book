package com.chelyadin.test.address_book.service;

import com.chelyadin.test.address_book.domain.Address;
import com.chelyadin.test.address_book.repository.AddressRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Dmitriy Chelyadin
 */
@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private AddressRepo addressRepo;

    public void saveAddress(Address address) {
        LOG.info("Saving address of " + address.getFullname());
        addressRepo.save(address);
    }

    @Override
    public List<Address> getAll() {
        LOG.info("Getting all addresses...");
        return (List<Address>) addressRepo.findAll();
    }
}
