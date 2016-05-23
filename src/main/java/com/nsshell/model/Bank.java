package com.nsshell.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by haifeng on 5/20/16.
 */

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @Column(name = "pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;


    @Column(name = "bank_name", unique = true, nullable = false)
    public String bankName;

    @Column(name = "bank_branch_name")
    private String bankBranchName;

    @OneToMany(mappedBy = "bank")
    private List<PersonBankAccount> personAccounts;

    /**
     * Add bank account for a person, also Create an association object for the relationship and set its data.
     *
     * @see com.nsshell.model.Person#addBankAccount(Bank, String)
     */
    public void addPersonAccount(Person person, String accountString) {

        PersonBankAccount personBankAccount = new PersonBankAccount();
        personBankAccount.setPerson(person);
        personBankAccount.setPersonId(person.getId());
        personBankAccount.setBank(this);
        personBankAccount.setBankId(this.getId());
        personBankAccount.setPersonBankAccount(accountString);

        this.personAccounts.add(personBankAccount);

        // Also add the association object to the bank.
        person.getBankAccounts().add(personBankAccount);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public List<PersonBankAccount> getPersonAccounts() {
        return personAccounts;
    }

    public void setPersonAccounts(List<PersonBankAccount> personAccounts) {
        this.personAccounts = personAccounts;
    }
}
