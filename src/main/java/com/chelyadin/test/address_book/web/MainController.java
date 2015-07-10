package com.chelyadin.test.address_book.web;

import com.chelyadin.test.address_book.domain.Address;
import com.chelyadin.test.address_book.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dmitriy Chelyadin
 */
@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private AddressService addressService;


    @RequestMapping("/")
    public ModelAndView index() {
        LOG.info("Index page request");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("addresses", addressService.getAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // TODO validation
    // TODO if validation errors, add request param /?validationError
    // TODO add exception handling for ?/error
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Address address) {
        LOG.info("Save address request");
        addressService.saveAddress(address);
        return "redirect:/";
    }

}
