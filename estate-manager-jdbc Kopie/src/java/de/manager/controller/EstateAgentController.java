package de.manager.controller;

import de.manager.entity.EstateAgent;
import de.manager.service.EstateAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/manager")
public class EstateAgentController {

    @Autowired
    private EstateAgentService estateAgentService;

    @GetMapping("/showEstateAgentCreateForm")
    public String showCreateForm(Model model) {
        EstateAgent estateAgent = new EstateAgent();
        model.addAttribute(estateAgent);
        return "estate-agent/create-agent";
    }

    @PostMapping("/createEstateAgent")
    public String addEstateAgent(@ModelAttribute("estateAgent") EstateAgent estateAgent) {
        estateAgentService.addEstateAgent(estateAgent);
        return "redirect:showEstateAgentCreateForm";
    }

    @GetMapping("/showEstateAgentDeleteForm")
    public String showDelete() {
        return "estate-agent/delete-agent";
    }

    @PostMapping("/deleteEstateAgent")
    public String deleteEstateAgent(@RequestParam("loginName") String loginName) {
        estateAgentService.deleteEstateAgent(loginName);
        return "redirect:showEstateAgentDeleteForm";
    }

    @GetMapping("/showEstateAgentEditForm")
    public String showUpdate(Model model) {
        EstateAgent estateAgent = new EstateAgent();
        model.addAttribute(estateAgent);
        return "estate-agent/edit-agent";
    }

    @PostMapping("/editEstateAgent")
    public String editEstateAgent(@ModelAttribute("estateAgent") EstateAgent estateAgent) {
        estateAgentService.updateEstateAgent(estateAgent);
        return "redirect:showEstateAgentEditForm";
    }
}
