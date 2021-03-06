package com.chelyadin.test.address_book.web;

import com.chelyadin.test.address_book.TestBase;
import com.chelyadin.test.address_book.domain.Address;
import com.chelyadin.test.address_book.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Dmitriy Chelyadin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class MainControllerTest extends TestBase {

    private final static String FIELD_NAME_FULLNAME = "fullname";
    private final static String FIELD_NAME_POSTCODE = "postcode";
    private final static String FIELD_NAME_COUNTRY = "country";
    private final static String FIELD_NAME_REGION = "region";
    private final static String FIELD_NAME_CITY = "city";
    private final static String FIELD_NAME_ADDRESS_1 = "address1";
    private final static String FIELD_NAME_ADDRESS_2 = "address2";
    private final static String FIELD_NAME_PHONES_1 = "phones[0]";
    private final static String FIELD_NAME_PHONES_2 = "phones[1]";
    private final static String FIELD_NAME_PHONES_3 = "phones[2]";
    private final static String FIELD_NAME_PHONES_4 = "phones[3]";

    private MockMvc mvc;

    @Mock
    AddressService addressService;

    @InjectMocks
    MainController mainController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testIndex() throws Exception {
        when(addressService.getAll()).thenReturn(Arrays.asList(ADDRESS_OBJECT, ADDRESS_OBJECT_2));

        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("addresses", equalTo(Arrays.asList(ADDRESS_OBJECT, ADDRESS_OBJECT_2))))
                .andExpect(model().attribute("address", equalTo(new Address())));
    }

    @Test
    public void testSave_success() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, FULLNAME)
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS_1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS_2, ADDRESS_2)
                .param(FIELD_NAME_PHONES_1, PHONE_1)
                .param(FIELD_NAME_PHONES_2, PHONE_2)
                .param(FIELD_NAME_PHONES_3, PHONE_3)
                .param(FIELD_NAME_PHONES_4, PHONE_4)
                .accept(MediaType.TEXT_HTML))

                .andExpect(redirectedUrl("/?added"))
                .andExpect(status().is(302)); // because of redirect
    }

    @Test
    public void testSave_validationFails_fullname() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, "")
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS_1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS_2, ADDRESS_2)
                .accept(MediaType.TEXT_HTML))

                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("address", FIELD_NAME_FULLNAME));
    }

    @Test
    public void testSave_validationFails_phoneEmptyString() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, FULLNAME)
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS_1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS_2, ADDRESS_2)
                .param(FIELD_NAME_PHONES_1, PHONE_EMPTY)
                .accept(MediaType.TEXT_HTML))

                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("address"));
    }

    @Test
    public void testSave_validationFails_phoneIncorrect() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, FULLNAME)
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS_1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS_2, ADDRESS_2)
                .param(FIELD_NAME_PHONES_1, PHONE_INCORRECT)
                .accept(MediaType.TEXT_HTML))

                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("address"));
    }

    @Test
    public void testSave_validationFails_noPhones() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, FULLNAME)
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS_1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS_2, ADDRESS_2)
                .accept(MediaType.TEXT_HTML))

                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("address"));
    }
}
