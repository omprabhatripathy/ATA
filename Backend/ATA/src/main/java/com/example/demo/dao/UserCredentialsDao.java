//package com.example.demo.dao;
//
//import com.example.demo.model.UserCredentialsBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class UserCredentialsDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createUserCredentials(UserCredentialsBean userCredentials) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(userCredentials);
//    }
//
//    public int deleteUserCredentials(ArrayList<String> userIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM UserCredentials WHERE userId IN :userIds");
//        query.setParameterList("userIds", userIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateUserCredentials(UserCredentialsBean userCredentials) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(userCredentials);
//        return true;
//    }
//
//    public UserCredentialsBean getUserCredentialsById(String userId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(UserCredentialsBean.class, userId);
//    }
//
//    public ArrayList<UserCredentialsBean> getAllUserCredentials() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<UserCredentialsBean> query = session.createQuery("FROM UserCredentials", UserCredentialsBean.class);
//        return (ArrayList<UserCredentialsBean>) query.list();
//    }
//}
