package com.nsshell.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "person")
    private List<PersonBankAccount> bankAccounts;

    /**
     * Add bank account for a person, also Create an association object for the relationship and set its data.
     *
     * @see com.nsshell.model.Bank#addPersonAccount(Person, String)
     */
    public void addBankAccount(Bank bank, String accountString) {
        PersonBankAccount personBankAccount = new PersonBankAccount();
        personBankAccount.setPerson(this);
        personBankAccount.setPersonId(this.getId());
        personBankAccount.setBank(bank);
        personBankAccount.setBankId(bank.getId());
        personBankAccount.setPersonBankAccount(accountString);

        this.bankAccounts.add(personBankAccount);
        // Also add the association object to the bank.
        bank.getPersonAccounts().add(personBankAccount);
    }

    @Override
    public String toString(){
        return String.format(
                "Person[id=%d, fullname='%s', phoneNumber='%s']", id, fullName, phoneNumber);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PersonBankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<PersonBankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
