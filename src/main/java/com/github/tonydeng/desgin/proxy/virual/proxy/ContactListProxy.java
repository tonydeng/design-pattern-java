package com.github.tonydeng.desgin.proxy.virual.proxy;

import com.github.tonydeng.desgin.proxy.virual.ContactList;
import com.github.tonydeng.desgin.proxy.virual.Employee;
import com.github.tonydeng.desgin.proxy.virual.impl.ContactListImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by tonydeng on 15/10/5.
 */
public class ContactListProxy implements ContactList {
    private  static final Logger log = LoggerFactory.getLogger(ContactListProxy.class);
    private ContactList contactList;

    @Override
    public List<Employee> getEmployeeList() {
        if(contactList == null){
            log.info("Creating contact list and fetching list of employees...");
            contactList = new ContactListImpl();
        }
        return contactList.getEmployeeList();
    }
}
