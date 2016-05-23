package com.nsshell.model;

import javax.persistence.*;

/**
 * Created by haifeng on 5/20/16.
 */

@Entity
@Table(name = "person_bank_account")
@IdClass(value = PersonBankAccountId.class)
public class PersonBankAccount {
    @Id
    private int personId;
    @Id
    private int bankId;

    @Column(name = "person_bank_account")
    private String personBankAccount;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "personid", referencedColumnName = "ID")
  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
  * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    private Person person;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "bankid", referencedColumnName = "ID")
  /* the same goes here:
  *  if this JPA model doesn't create a table for the "person_bank_account" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
  * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    private Bank bank;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getPersonBankAccount() {
        return personBankAccount;
    }

    public void setPersonBankAccount(String personBankAccount) {
        this.personBankAccount = personBankAccount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
