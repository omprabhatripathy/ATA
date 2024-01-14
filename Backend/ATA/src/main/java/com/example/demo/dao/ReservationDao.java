//package com.example.demo.dao;
//
//import com.example.demo.model.ReservationBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class ReservationDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createReservation(ReservationBean reservation) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(reservation);
//    }
//
//    public int deleteReservations(ArrayList<String> reservationIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM Reservation WHERE reservationId IN :reservationIds");
//        query.setParameterList("reservationIds", reservationIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateReservation(ReservationBean reservation) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(reservation);
//        return true;
//    }
//
//    public ReservationBean getReservationById(String reservationId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(ReservationBean.class, reservationId);
//    }
//
//    public ArrayList<ReservationBean> getAllReservations() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<ReservationBean> query = session.createQuery("FROM Reservation", ReservationBean.class);
//        return (ArrayList<ReservationBean>) query.list();
//    }
//}
