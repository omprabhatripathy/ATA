//package com.example.demo.dao;
//
//import com.example.demo.model.RouteBean;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.hibernate.query.Query;
//
//import java.util.ArrayList;
//
//@Repository
//public class RouteDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public String createRoute(RouteBean route) {
//        Session session = sessionFactory.getCurrentSession();
//        return (String) session.save(route);
//    }
//
//    public int deleteRoutes(ArrayList<String> routeIds) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("DELETE FROM Route WHERE routeId IN :routeIds");
//        query.setParameterList("routeIds", routeIds);
//        return query.executeUpdate();
//    }
//
//    public boolean updateRoute(RouteBean route) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(route);
//        return true;
//    }
//
//    public RouteBean getRouteById(String routeId) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(RouteBean.class, routeId);
//    }
//
//    public ArrayList<RouteBean> getAllRoutes() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<RouteBean> query = session.createQuery("FROM Route", RouteBean.class);
//        return (ArrayList<RouteBean>) query.list();
//    }
//}