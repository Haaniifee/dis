package de.manager.controller;

import de.manager.entity.PurchaseContract;
import de.manager.entity.TenancyContract;
import de.manager.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/showPurchaseContractForm")
    public String showPurchaseContractForm(Model model) {
        model.addAttribute(new PurchaseContract());
        return "contract/create-purchase-contract";
    }

    @PostMapping("/createPurchaseContract")
    public String createPurchaseContract(@ModelAttribute("purchaseContract") PurchaseContract purchaseContract) {
        String contractNumber = purchaseContract.getContractNumber();
        int personId = purchaseContract.getPersonID();
        int houseId = purchaseContract.getHouseID();

        if(!contractService.purchaseContractExist(personId, houseId, contractNumber)) {
            contractService.createPurchaseContract(purchaseContract);
        }
        return "redirect:showPurchaseContractForm";
    }

    @GetMapping("/showTenancyContractForm")
    public String showTenancyContractForm(Model model) {
        model.addAttribute(new TenancyContract());
        return "contract/create-tenancy-contract";
    }


    @PostMapping("/createTenancyContract")
    public String createTenancyContract(@ModelAttribute("tenancyContract") TenancyContract tenancyContract) {
        String contractNumber = tenancyContract.getContractNumber();
        int personId = tenancyContract.getPersonID();
        int apartmentId = tenancyContract.getApartmentID();

        if(!contractService.tenancyContractExist(personId, apartmentId, contractNumber)) {
            contractService.createTenancyContract(tenancyContract);
        }
        return "redirect:showTenancyContractForm";
    }

    @RequestMapping("/showOverview")
    public String showContractOverview(Model model) {
        model.addAttribute("purchaseContracts", contractService.getAllPurchaseContracts());
        model.addAttribute("tenancyContracts",  contractService.getAllTenancyContracts());

        return "contract/contract-overview";
    }
}