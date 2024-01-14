package com.example.demo.dao;

public class AdminDao {

}

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//

package com.wipro.ata.service;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.DriverDAO;
import com.wipro.ata.dao.RouteDAO;
import com.wipro.ata.dao.VehicleDAO;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdministratorImpl implements Administrator {
 @Autowired
 private VehicleDAO vehicledao;
 @Autowired
 private DriverDAO driverdao;
 @Autowired
 private RouteDAO routedao;

 public AdministratorImpl() {
 }

 public VehicleDAO getVehicledao() {
     return this.vehicledao;
 }

 public void setVehicledao(VehicleDAO vehicledao) {
     this.vehicledao = vehicledao;
 }

 public DriverDAO getDriverdao() {
     return this.driverdao;
 }

 public void setDriverdao(DriverDAO driverdao) {
     this.driverdao = driverdao;
 }

 public RouteDAO getRoutedao() {
     return this.routedao;
 }

 public void setRoutedao(RouteDAO routedao) {
     this.routedao = routedao;
 }

 public String addVehicle(VehicleBean vehicleBean) {
     int generatedseqNum = this.vehicledao.generateVehicleId();
     String id = vehicleBean.getName().substring(0, 2) + generatedseqNum;
     vehicleBean.setVehicleID(id);
     String result = this.vehicledao.createVehicle(vehicleBean);
     return result;
 }

 public int deleteVehicle(ArrayList<String> vehicleID) {
     int num = this.vehicledao.deleteVehicle(vehicleID);
     return num;
 }

 public ArrayList<VehicleBean> viewVehicle() {
     ArrayList<VehicleBean> arr = this.vehicledao.findAll();
     return arr;
 }

 public boolean modifyVehicle(VehicleBean vehicleBean) {
     boolean updateResult = this.vehicledao.updateVehicle(vehicleBean);
     return updateResult;
 }

 public String addDriver(DriverBean driverBean) {
     int generatedseqNum = this.driverdao.generateDriverId();
     String id = driverBean.getName().substring(0, 2) + generatedseqNum;
     driverBean.setDriverID(id);
     String str = this.driverdao.createDriver(driverBean);
     return str;
 }

 public ArrayList<DriverBean> viewDriver() {
     ArrayList<DriverBean> arr = this.driverdao.findAll();
     return arr;
 }

 public int deleteDriver(ArrayList<String> driverID) {
     int deleteStatus = this.driverdao.deleteDriver(driverID);
     return deleteStatus;
 }

 public boolean allotDriver(String reservationID, String driverID) {
     return false;
 }

 public boolean modifyDriver(DriverBean driverBean) {
     if (driverBean != null) {
         return this.driverdao.updateDriver(driverBean);
     } else {
         return false;
     }
 }

 public String addRoute(RouteBean routeBean) {
     if (routeBean != null) {
         int id = this.routedao.generateRouteId();
         String route_id = routeBean.getSource().substring(0, 2) + id;
         routeBean.setRouteID(route_id);
         return this.routedao.createRoute(routeBean);
     } else {
         return "FAIL";
     }
 }

 public int deleteRoute(ArrayList<String> routeID) {
     return routeID != null ? this.routedao.deleteRoute(routeID) : 0;
 }

 public ArrayList<RouteBean> viewRoute() {
     ArrayList<RouteBean> arr = this.routedao.findAll();
     return arr;
 }

 public boolean modifyRoute(RouteBean routeBean) {
     return routeBean != null ? this.routedao.updateRoute(routeBean) : false;
 }

 public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) {
     return null;
 }
}

