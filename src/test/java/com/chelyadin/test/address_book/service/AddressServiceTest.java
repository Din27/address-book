package com.chelyadin.test.address_book.service;

import com.chelyadin.test.address_book.TestBase;
import com.chelyadin.test.address_book.domain.Address;
import com.chelyadin.test.address_book.repository.AddressRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Dmitriy Chelyadin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class AddressServiceTest extends TestBase {

    @Mock
    AddressRepo addressRepo;

    @InjectMocks
    AddressService addressService = new AddressServiceImpl();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll_notEmpty() {
        when(addressRepo.findAll()).thenReturn(Arrays.asList(ADDRESS_OBJECT, ADDRESS_OBJECT_2));

        List<Address> actualAddresses = addressService.getAll();
        Assert.assertNotNull(actualAddresses);
        Assert.assertEquals(Arrays.asList(ADDRESS_OBJECT, ADDRESS_OBJECT_2), actualAddresses);
    }

    @Test
    public void testGetAll_empty() {
        when(addressRepo.findAll()).thenReturn(Collections.<Address>emptyList());

        List<Address> actualAddresses = addressService.getAll();
        Assert.assertNotNull(actualAddresses);
        Assert.assertEquals(Collections.<Address>emptyList(), actualAddresses);
    }

    @Test
    public void testSave() {
        addressService.saveAddress(ADDRESS_OBJECT);
        verify(addressRepo, times(1)).save(ADDRESS_OBJECT);
    }


}
