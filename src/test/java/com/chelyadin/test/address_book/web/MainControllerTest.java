package com.chelyadin.test.address_book.web;

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
    private final static String FIELD_NAME_ADDRESS1 = "address1";
    private final static String FIELD_NAME_ADDRESS2 = "address2";

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
        // TODO phones
        when(addressService.getAll()).thenReturn(Arrays.asList(ADDRESS_OBJECT, ADDRESS_OBJECT_2));

        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("addresses"));
    }

    @Test
    public void testSave() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/save")
                .param(FIELD_NAME_FULLNAME, FULLNAME)
                .param(FIELD_NAME_POSTCODE, POSTCODE)
                .param(FIELD_NAME_COUNTRY, COUNTRY)
                .param(FIELD_NAME_REGION, REGION)
                .param(FIELD_NAME_CITY, CITY)
                .param(FIELD_NAME_ADDRESS1, ADDRESS_1)
                .param(FIELD_NAME_ADDRESS2, ADDRESS_2)
                .accept(MediaType.TEXT_HTML))

                .andExpect(redirectedUrl("/"))
                .andExpect(status().is(302)); // because of redirect
    }
}
