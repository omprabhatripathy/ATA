//package com.example.demo.dao;
//
//import com.example.demo.model.VehicleBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class VehicleDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createVehicle(VehicleBean vehicle) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(vehicle);
//    }
//
//    public int deleteVehicles(ArrayList<String> vehicleIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM Vehicle WHERE vehicleId IN :vehicleIds");
//        query.setParameterList("vehicleIds", vehicleIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateVehicle(VehicleBean vehicle) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(vehicle);
//        return true;
//    }
//
//    public VehicleBean getVehicleById(String vehicleId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(VehicleBean.class, vehicleId);
//    }
//
//    public ArrayList<VehicleBean> getAllVehicles() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<VehicleBean> query = session.createQuery("FROM Vehicle", VehicleBean.class);
//        return (ArrayList<VehicleBean>) query.list();
//    }
//}
