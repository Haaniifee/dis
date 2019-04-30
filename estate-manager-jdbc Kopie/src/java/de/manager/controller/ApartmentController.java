package de.manager.controller;

import de.manager.entity.Apartment;
import de.manager.service.EstateAgentService;
import de.manager.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class ApartmentController {

    private int tempApartmentId;

    @Autowired
    private EstateAgentService estateAgentService;

    @Autowired
    private EstateService estateService;

    @GetMapping("/showApartmentCreateForm")
    public String showApartmentCreateForm(Model model) {
        model.addAttribute(new Apartment());
        return "estate/create-apartment";
    }

    @PostMapping("/createApartment")
    public String createApartment(@ModelAttribute("apartment") Apartment apartment) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        apartment.setEstateAgentId(estateAgentId);

        System.out.println(apartment);
        estateService.insertApartment(apartment);
        return "redirect:showApartmentCreateForm";
    }

    @GetMapping("/showApartmentDeleteForm")
    public String showApartmentDeleteForm() {
        return "estate/delete-apartment";
    }

    @PostMapping("/deleteApartment")
    public String deleteApartment(@RequestParam("apartmentId") int apartmentId) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);

        if(estateService.estateAgentMaintainApartment(estateAgentId, apartmentId)) {
            estateService.deleteApartment(apartmentId);
        }

        return "redirect:showApartmentDeleteForm";
    }

    @GetMapping("/showApartmentEditForm")
    public String showApartmentUpdateForm(Model model) {
        model.addAttribute(new Apartment());
        model.addAttribute("trigger", true);
        return "estate/edit-apartment";
    }

    @PostMapping("/showFilledApartmentEditForm")
    public String showFilledApartmentUpdateForm(@RequestParam("apartmentId") String apartmentId, Model model) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        int apartment_id = Integer.parseInt(apartmentId);

        Apartment apartment = estateService.getApartment(Integer.parseInt(apartmentId), estateAgentId);

        if(apartment != null) {
            tempApartmentId = apartment_id;
            model.addAttribute("apartment", apartment);
            model.addAttribute("trigger", false);
            return "estate/edit-apartment";
        }
        else {
            model.addAttribute("trigger", true);
            return "redirect:showApartmentEditForm";
        }
    }

    @PostMapping("/editApartment")
    public String editHouse(@ModelAttribute("apartment") Apartment apartment) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        apartment.setId(tempApartmentId);
        apartment.setEstateAgentId(estateAgentId);
        estateService.updateApartment(apartment);
        return "redirect:showHouseEditForm";
    }
}
