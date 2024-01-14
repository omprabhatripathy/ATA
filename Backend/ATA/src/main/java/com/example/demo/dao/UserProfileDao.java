//package com.example.demo.dao;
//
//import com.example.demo.model.UserProfileBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class UserProfileDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createUserProfile(UserProfileBean userProfile) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(userProfile);
//    }
//
//    public int deleteUserProfiles(ArrayList<String> userIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM UserProfile WHERE userId IN :userIds");
//        query.setParameterList("userIds", userIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateUserProfile(UserProfileBean userProfile) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(userProfile);
//        return true;
//    }
//
//    public UserProfileBean getUserProfileById(String userId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(UserProfileBean.class, userId);
//    }
//
//    public ArrayList<UserProfileBean> getAllUserProfiles() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<UserProfileBean> query = session.createQuery("FROM UserProfile", UserProfileBean.class);
//        return (ArrayList<UserProfileBean>) query.list();
//    }
//}
