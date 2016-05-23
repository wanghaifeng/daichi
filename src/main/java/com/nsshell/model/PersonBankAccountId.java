package com.nsshell.model;

import java.io.Serializable;

/**
 * Created by haifeng on 5/22/16.
 */
public class PersonBankAccountId implements Serializable {

    private int personId;
    private int bankId;

    public int hashCode() {
        return personId + bankId;
    }

    public boolean equals(Object object) {
        if (object instanceof PersonBankAccountId) {
            PersonBankAccountId otherId = (PersonBankAccountId) object;
            return (otherId.personId == this.personId && otherId.bankId == this.bankId);
        }
        return false;

    }
}
