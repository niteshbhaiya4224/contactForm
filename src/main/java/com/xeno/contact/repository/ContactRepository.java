package com.xeno.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xeno.contact.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}

