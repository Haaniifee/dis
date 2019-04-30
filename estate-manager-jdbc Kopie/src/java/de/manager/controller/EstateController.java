package de.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class EstateController {

    @GetMapping("/apartmentMenu")
    public String showApartmentMenu() {
        return "estate/apartment-menu";
    }

    @GetMapping("/houseMenu")
    public String showHouseMenu() {
        return "estate/house-menu";
    }

}