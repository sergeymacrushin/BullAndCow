package game.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import game.model.Result;

import java.util.List;

@Repository
public class ResultDAOImpl implements ResultDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Result> allResults(int id_game) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Result where id_game ="+id_game).list();
    }

    @Override
    public void add(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(result);
    }
}
