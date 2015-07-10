package com.chelyadin.test.address_book;

import com.chelyadin.test.address_book.domain.Address;

import java.util.Arrays;

/**
 * @author Dmitriy Chelyadin
 */
public class TestBase {
    protected final static String FULLNAME = "Ivan Ivanov";
    protected final static String POSTCODE = "49000";
    protected final static String COUNTRY = "Ukraine";
    protected final static String REGION = "Dnipropetrovs'ka";
    protected final static String CITY = "Dnipropetrovsk";
    protected final static String ADDRESS_1 = "35 Dzerzhinskogo str";
    protected final static String ADDRESS_2 = "Apartment 27";

    protected final static String FULLNAME_2 = "Jhon Jhonson";
    protected final static String POSTCODE_2 = "53234";
    protected final static String COUNTRY_2 = "USA";
    protected final static String REGION_2 = "NY";
    protected final static String CITY_2 = "New York";
    protected final static String ADDRESS_1_2 = "13 Broadway";
    protected final static String ADDRESS_2_2 = "Apartment 17";


    protected final static String PHONE_1 = "+380503625574";
    protected final static String PHONE_2 = "+38(050)3423333";
    protected final static String PHONE_3 = "362-55-27";
    protected final static String PHONE_4 = "(067) 320 50 34";
    protected final static String PHONE_INCORRECT = "Incorrect Phone :(";
    protected final static String PHONE_EMPTY = "";

    protected final static Address ADDRESS_OBJECT = new Address(FULLNAME, POSTCODE, COUNTRY, REGION, CITY, ADDRESS_1, ADDRESS_2, Arrays.asList(PHONE_1, PHONE_2, PHONE_3));
    protected final static Address ADDRESS_OBJECT_2 = new Address(FULLNAME_2, POSTCODE_2, COUNTRY_2, REGION_2, CITY_2, ADDRESS_1_2, ADDRESS_2_2, Arrays.asList(PHONE_4));

}
