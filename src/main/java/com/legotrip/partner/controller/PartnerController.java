package com.legotrip.partner.controller;

import com.legotrip.partner.domain.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class PartnerController {
    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/partners/new")
    public String createForm() {
        return "partners/createPartnerForm";
    }

    @PostMapping("/partners/new")
    public String create(PartnerForm form) {
        Partner partner = new Partner();
        partner.setPartnerName(form.getPartnerName());

//        System.out.println("member = " + member.getName());

        partnerService.join(partner);

        return "redirect:/";
    }

    @GetMapping("/partners")
    public String list(Model model) {
        List<Partner> partners = partnerService.findParnters();
        model.addAttribute("partners", partners);
        return "partners/partnerList";
    }
}
