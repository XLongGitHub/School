package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
        Configuration conf = new Configuration().configure();
        sessionFactory = conf.buildSessionFactory();
    }

    @Override
    public T get(Class<T> entity, Serializable id) {
        return getSessionFactory().getCurrentSession().get(entity, id);
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
        getSessionFactory().getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entity, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entity.getSimpleName()
                +" en where  en.id = :id")
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public List<T> findAll(Class<T> entity) {
        return find("select en from " + entity.getSimpleName() + " en");
    }

    public List<T> find(String hql) {
        return getSessionFactory().getCurrentSession()
                .createQuery(hql).list();
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
