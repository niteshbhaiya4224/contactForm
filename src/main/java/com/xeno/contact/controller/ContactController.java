package com.xeno.contact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.xeno.contact.entity.Contact;
import com.xeno.contact.repository.ContactRepository;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String getAllContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact-list";
    }

    @GetMapping("/add")
    public String showAddContactForm() {
        return "add-contact";
    }

    @PostMapping("/addContact")
    public String createContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteContact(@RequestParam("contactId") Long contactId) {
        contactRepository.deleteById(contactId);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String viewUpdate(Model model) {
        return "updateContact";
    }


    @PostMapping("/updateContact")
    public String updateContact(@ModelAttribute("contact") Contact updatedContact) {
        //Write code for updating contact
        contactRepository.save(updatedContact);
        return "redirect:/";
    }

}
