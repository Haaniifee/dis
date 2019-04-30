package de.manager.controller;

import de.manager.service.EstateAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/manager")
public class HomeController {

    private final String  ADMIN_PASSWORD = "12345";

    public static String currentEstateAgent;

    @Autowired
    private EstateAgentService estateAgentService;

    @GetMapping("/main")
    public String showEstateManager() {
        return "main/main-view";
    }

    @GetMapping("/admin-login")
    public String showAdminLogin() {
        return "main/admin-login";
    }

    @PostMapping("/manage-estate-agents")
    public String showManageEstateAgents(@RequestParam("loginPassword") String loginPassword) {

        if(loginPassword.equals(ADMIN_PASSWORD)) {
            return "estate-agent/manage-estate-agents";
        }
        return "redirect:admin-login";
    }

    @GetMapping("/estate-agent-login")
    public String showEstateAgentLogin() {
        return "main/estate-agent-login";
    }

    @PostMapping("/manage-estates")
    public String showManageEstates(@RequestParam("loginName") String loginName,
                                    @RequestParam("loginPassword") String loginPassword) {

        if(estateAgentService.existEstateAgent(loginName, loginPassword)) {
            currentEstateAgent = loginName;
            return "estate/manage-estates";
        }
        return "redirect:estate-agent-login";
    }

    @GetMapping("/manage-contracts")
    public String showManageContracts() {

        return "contract/manage-contracts";
    }
}
