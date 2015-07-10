package com.chelyadin.test.address_book.web;

import com.chelyadin.test.address_book.domain.Address;
import com.chelyadin.test.address_book.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author Dmitriy Chelyadin
 */
@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private AddressService addressService;


    @RequestMapping("/")
    public ModelAndView index(
            @RequestParam(value = "added", required = false) String added) {
        LOG.info("Index page request");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("addresses", addressService.getAll());
        modelAndView.addObject("address", new Address());
        if (added != null) {
            modelAndView.addObject("msg", "Successfully added");
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // TODO add exception handling for ?/error
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult) {
        LOG.info("Save address request");

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            LOG.info("Not saving address due to validation errors");
            modelAndView.addObject("addresses", addressService.getAll());
            modelAndView.addObject("address", address);
            modelAndView.setViewName("index");
            return modelAndView;
        }

        addressService.saveAddress(address);
        modelAndView.setViewName("redirect:/?added");
        return modelAndView;
    }

}
