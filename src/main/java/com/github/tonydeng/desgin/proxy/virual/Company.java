package com.github.tonydeng.desgin.proxy.virual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tonydeng on 15/10/5.
 */
public class Company {
    private static  final Logger log = LoggerFactory.getLogger(Company.class);

    private String companyName;
    private String companyAddress;
    private String companyContactNo;
    private ContactList contactList;

    public Company(String companyName, String companyAddress, String companyContactNo, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyContactNo = companyContactNo;
        this.contactList = contactList;

        log.info("Company object created...");
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyContactNo() {
        return companyContactNo;
    }

    public ContactList getContactList() {
        return contactList;
    }
}
