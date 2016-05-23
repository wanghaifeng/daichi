package com.nsshell.dao.impl;

import com.nsshell.dao.PersonDAO;
import com.nsshell.model.Bank;
import com.nsshell.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by haifeng on 5/22/16.
 */
public class PersonDAOImpl implements PersonDAO{

    private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setBasicDataSource(DataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    @Override
    public void save(Person person) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(person);
        tx.commit();
        session.close();
    }

    @Override
    public Person getById(int id) {
        Session session = this.sessionFactory.openSession();
        Person person = (Person)session.createQuery("from Person").uniqueResult();
        session.close();
        return person;
    }

    @Override
    public List<Person> getByFullname(String fullname) {
        return null;
    }

    @Override
    public List<Person> getByBankAccount(Bank bank, String bankAccount) {
        return null;
    }
}
