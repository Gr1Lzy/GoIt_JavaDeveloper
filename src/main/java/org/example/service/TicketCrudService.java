package org.example.service;

import org.example.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    private final SessionFactory sessionFactory;

    public TicketCrudService(HibernateUtil hibernateUtil) {
        sessionFactory = hibernateUtil.getSessionFactory();
    }

    public void add(Ticket ticket) {
        if (ticket.getClient() != null || ticket.getFromPlanet() != null || ticket.getToPlanet() != null) {
            throw new NullPointerException();
        }

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public Ticket getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateById(Integer id, Ticket ticket) {
        if (ticket.getClient() != null || ticket.getFromPlanet() != null || ticket.getToPlanet() != null) {
            throw new NullPointerException();
        }
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            ticket.setId(id);
            transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
