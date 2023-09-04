package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AFAQDaoImpl implements AFAQDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<AFAQ> getAFAQs() {
        Session session = sessionFactory.getCurrentSession();
        Query<AFAQ> query = session.createQuery("from AFAQ", AFAQ.class);
        List<AFAQ> afaqs = query.getResultList();
        return afaqs;
    }

    @Override
    public void saveAFAQ(AFAQ afaq) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(afaq);
    }

    @Override
    public AFAQ getAFAQ(int afaqid) {
        Session session = sessionFactory.getCurrentSession();
        AFAQ afaq = session.get(AFAQ.class, afaqid);
        return afaq;
    }

    @Override
    public void deleteAFAQ(int afaqid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from AFAQ where id=:afaqid");
        query.setParameter("afaqid", afaqid);
        query.executeUpdate();
    }

    @Override
    public List<AFAQ> getAFAQDoesNotHaveQFAQ(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<AFAQ> query = session.createQuery("select q.afaqs from QFAQ q where q.id=:id");
        query.setParameter("id", id);
        List<AFAQ> afaqList1 = query.getResultList();
        query = session.createQuery("from AFAQ ");
        List<AFAQ> afaqList2 = query.getResultList();
        afaqList2.removeAll(afaqList1);
        return afaqList2;
    }


}
