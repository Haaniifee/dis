package de.manager.controller;

import de.manager.entity.House;
import de.manager.service.EstateAgentService;
import de.manager.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class HouseController {

    private int tempHouseId;

    @Autowired
    private EstateAgentService estateAgentService;

    @Autowired
    private EstateService estateService;

    @GetMapping("/showHouseCreateForm")
    public String showHouseCreateForm(Model model) {
        model.addAttribute(new House());

        return "estate/create-house";
    }

    @PostMapping("/createHouse")
    public String createHouse(@ModelAttribute("house") House house) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        house.setEstateAgentId(estateAgentId);
        estateService.insertHouse(house);
        return "redirect:showHouseCreateForm";
    }

    @GetMapping("/showHouseDeleteForm")
    public String showHouseDeleteForm() {
        return "estate/delete-house";
    }

    @PostMapping("/deleteHouse")
    public String deleteHouse(@RequestParam("houseId") int houseId) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);

        if(estateService.estateAgentMaintainHouse(estateAgentId, houseId)) {
            estateService.deleteHouse(houseId);
        }

        return "redirect:showHouseDeleteForm";
    }


    @GetMapping("/showHouseEditForm")
    public String showHouseUpdateForm(Model model) {
        model.addAttribute(new House());
        model.addAttribute("trigger", true);
        return "estate/edit-house";
    }

    @PostMapping("/showFilledHouseEditForm")
    public String showFilledHouseUpdateForm(@RequestParam("houseId") String houseId, Model model) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        int house_Id = Integer.parseInt(houseId);

        House house = estateService.getHouse(Integer.parseInt(houseId), estateAgentId);

        if(house != null) {
            tempHouseId = house_Id;
            model.addAttribute("house", house);
            model.addAttribute("trigger", false);
            return "estate/edit-house";
        }
        else {
            model.addAttribute("trigger", true);
            return "redirect:showHouseEditForm";
        }
    }

    @PostMapping("/editHouse")
    public String editHouse(@ModelAttribute("house") House house) {
        int estateAgentId = estateAgentService.getEstateAgentId(HomeController.currentEstateAgent);
        house.setId(tempHouseId);
        house.setEstateAgentId(estateAgentId);
        estateService.updateHouse(house);
        return "redirect:showHouseEditForm";
    }
}
