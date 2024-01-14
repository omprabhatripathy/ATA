package com.example.demo.service;

import com.example.demo.model.DriverBean;
import com.example.demo.model.ReservationBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;

import java.util.ArrayList;
import java.util.Date;

public interface AdminService {

    String addVehicle(VehicleBean vehicleBean);

    int deleteVehicle(ArrayList<String> vehicleID);

    VehicleBean viewVehicle(String vehicleID);

    boolean modifyVehicle(VehicleBean vehicleBean);

    String addDriver(DriverBean driverBean);

    int deleteDriver(ArrayList<String> driverID);

    boolean allotDriver(String reservationID, String driverID);

    boolean modifyDriver(DriverBean driverBean);

    String addRoute(RouteBean routeBean);

    int deleteRoute(ArrayList<String> routeID);

    RouteBean viewRoute(String routeID);

    boolean modifyRoute(RouteBean routeBean);

    ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination);
}
