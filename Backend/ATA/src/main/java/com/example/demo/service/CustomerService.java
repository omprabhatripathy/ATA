package com.example.demo.service;

import com.example.demo.model.ReservationBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;

import java.util.ArrayList;

public interface CustomerService {

    ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);

    ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);

    ArrayList<RouteBean> viewAllRoutes();

    String bookVehicle(ReservationBean reservationBean);

    boolean cancelBooking(String userID, String reservationID);

    ReservationBean viewBookingDetails(String reservationID);

    ReservationBean printBookingDetails(String reservationID);
}
