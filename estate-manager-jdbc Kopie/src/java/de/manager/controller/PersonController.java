package de.manager.controller;

import de.manager.entity.Person;
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
public class PersonController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/showInsertPersonForm")
    public String showInsertPersonForm(Model model) {
        model.addAttribute(new Person());
        return "contract/insert-person";
    }

    @PostMapping("insertPerson")
    public  String insertPerson(@ModelAttribute("person") Person person) {
        if(!contractService.personExist(person)) {
            contractService.insertPerson(person);
        }
        return "redirect:showInsertPersonForm";
    }
}
