package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

//    public BaseDaoImpl(SessionFactory sessionFactory) {
//        Configuration conf = new Configuration().configure();
//        sessionFactory = conf.buildSessionFactory();
//        this.sessionFactory = sessionFactory;
//    }



    @Override
    public T get(Class<T> entity, Serializable id) {
                Session session = getSessionFactory().openSession();
                Transaction ts = session.beginTransaction();
                T object = session.get(entity, id);
                if (ts.getStatus().equals(TransactionStatus.ACTIVE)) {
                    ts.commit();
                }
                session.close();
                return object;
    }

    @Override
    public Serializable save(T entity) {
//        Session session = getSessionFactory().getCurrentSession();
        Session session = getSessionFactory().openSession();
        Transaction tans = session.getTransaction();
        session.save(entity);
        if(tans.getStatus().equals(TransactionStatus.ACTIVE)) {
            tans.commit();
        }
        session.close();
        return "s";
    }

    @Override
    public void update(T entity) {
        Session session = getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.update(entity);
        if (ts.getStatus().equals(TransactionStatus.ACTIVE)) {
            ts.commit();
        }
        session.close();
    }

    @Override
    public void delete(T entity) {
        Session session = getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        session.delete(entity);
        if (ts.getStatus().equals(TransactionStatus.ACTIVE)) {
            ts.commit();
        }
        session.close();
    }

    @Override
    public void delete(Class<T> entity, Serializable id) {
        Session session = getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("delete " + entity.getSimpleName() + " en where en.id = :id").setParameter("id", id);
        query.executeUpdate();
        if (ts.getStatus().equals(TransactionStatus.ACTIVE)) {
            ts.commit();
        }
        session.close();

//        getSessionFactory().getCurrentSession()
//                .createQuery("delete " + entity.getSimpleName()
//                +" en where  en.id = :id")
//                .setParameter("id", id)
//                .executeUpdate();

    }

    @Override
    public List<T> findAll(Class<T> entity) {
        return find("select en from " + entity.getSimpleName() + " en");
    }

    public List<T> find(String hql) {
        Session session = getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        List<T> list = session.createQuery(hql).list();
        if (ts.getStatus().equals(TransactionStatus.ACTIVE)) {
            ts.commit();
        }
        session.close();
        return list;

//        return getSessionFactory().getCurrentSession()
//                .createQuery(hql).list();
    }

    public List<T> find(String hql, Object ...args) {
        Session session = getSessionFactory().openSession();
        Transaction ts = session.beginTransaction();
        Query query =  session.createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i + "", args[i]);
        }
        return query.list();

    }

    public List findMysql(String sql) {
        return getSessionFactory().getCurrentSession().createSQLQuery("sql").list();
    }
//    public List<T> find(String hql, Object ...params) {
//        Query query = (Query) getSessionFactory().getCurrentSession().createQuery(hql);
//
//
//    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
