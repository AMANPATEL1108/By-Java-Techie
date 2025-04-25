package com.example.HibernateExample.dao;

import com.example.HibernateExample.model.Person;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @Autowired
    private SessionFactory factory;

    public void savePerson(Person person) {
        getSession().save(person);
    }

    public List<Person> getPerson() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    private Session getSession() {
        Session session = factory.getCurrentSession();
        if (session == null) {
            session = factory.openSession();
        }
        return session;
    }
}
