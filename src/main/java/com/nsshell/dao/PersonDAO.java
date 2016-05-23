package com.nsshell.dao;

import com.nsshell.model.Bank;
import com.nsshell.model.Person;

import java.util.List;

/**
 * Created by haifeng on 5/22/16.
 */
public interface PersonDAO {

    public void save(Person person);
    public Person getById(int id);
    public List<Person> getByFullname(String fullname);
    public List<Person> getByBankAccount(Bank bank, String bankAccount);
}
