//package com.example.demo.dao;
//
//import com.example.demo.model.DriverBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class DriverDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createDriver(DriverBean driver) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(driver);
//    }
//
//    public int deleteDrivers(ArrayList<String> driverIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM Driver WHERE driverId IN :driverIds");
//        query.setParameterList("driverIds", driverIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateDriver(DriverBean driver) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(driver);
//        return true;
//    }
//
//    public DriverBean getDriverById(String driverId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(DriverBean.class, driverId);
//    }
//
//    public ArrayList<DriverBean> getAllDrivers() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<DriverBean> query = session.createQuery("FROM Driver", DriverBean.class);
//        return (ArrayList<DriverBean>) query.list();
//    }
//}
