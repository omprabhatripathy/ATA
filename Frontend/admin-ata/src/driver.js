import React, { useState } from 'react'
import axios from 'axios'
import './App.css';

function Driver(){
    const [driverID,setDID]=useState();
    const [dName,setDName]=useState();
    const [dStreet,setDStreet]=useState();
    const [dLocation,setDLocation]=useState();
    const [dCity,setDCity]=useState();
    const [dState,setDState]=useState();
    const [dPincode,setDPincode]=useState();
    const [dMobileno,setDMobileNo]=useState();
    const [dlicenseNumber,setDLicenseNumber]=useState();
    const [all,setAll]=useState([]);

      const data={
        "driverID":driverID,
        "name":dName,
        "street":dStreet,
        "location":dLocation,
        "city":dCity,
        "state":dState,
        "pincode":dPincode,
        "mobileNo":dMobileno,
        "licenseNumber":dlicenseNumber
}

const url='http://localhost:8080/admin/'
    const HandleSubmit=(e)=>{
        e.preventDefault();
        // console.log(e.target.eid.value)
        console.log(data)
        axios.post(url+'addDriver', data)
        document.getElementById("myForm").reset();
        alert("Data Inserted Successfully");
    }
    const HandleSubmitUpdate=(e)=>{
        e.preventDefault();
        axios.put(url+'modifyDriver', data)
        alert("Data Updated Successfully");
    }
    const HandleSubmitDelete=(e)=>{
        e.preventDefault();
        axios.delete(url+'deleteDriver/'+driverID)
        alert("Data Deleted Successfully")
    }
    const HandelSubmitSelectAll=(e)=>{
        e.preventDefault();
        axios.get(url+"viewAllDrivers").then(response=>{
          //  console.log(response.data)
            setAll(response.data)
        }).catch(e=>{
            //console.log(e)
        })
      console.log('data')
        console.log(all)
      }

    return (
        <div className='driver'>
            <h1>Add Driver Details</h1>
        <form onSubmit={HandleSubmit} id="myForm">
            Enter Driver Id : <input type='text' name='driverid' value={driverID} onChange={e => setDID(e.target.value)}/><br/>
            Enter Driver Name : <input type='text' name='dName' value={dName} onChange={e => setDName(e.target.value)}/><br/>
            Enter Driver Street : <input type='text' name='dStreet' value={dStreet} onChange={e => setDStreet(e.target.value)}/><br/>
            Enter Driver Location : <input type='text' name='dLocation' value={dLocation} onChange={e => setDLocation(e.target.value)}/><br/>
            Enter Driver City : <input type='text' name='dCity' value={dCity} onChange={e => setDCity(e.target.value)}/><br/>
            Enter State : <input type='text' name='dState' value={dState} onChange={e => setDState(e.target.value)}/><br/>
            Enter Pincode : <input type='text' name='dPincode' value={dPincode} onChange={e => setDPincode(e.target.value)}/><br/>
            Enter MobileNo : <input type='text' name='dMobileno' value={dMobileno} onChange={e => setDMobileNo(e.target.value)}/><br/>
            Enter licenseNo : <input type='text' name='dlicenseNumber' value={dlicenseNumber} onChange={e => setDLicenseNumber(e.target.value)}/><br/>
            <button type='submit'>Add Driver</button>
        </form>

        <h1>Update Driver</h1>

        <form onSubmit={HandleSubmitUpdate}>
        Enter Driver Id : <input type='text' name='driverID' value={driverID} onChange={e => setDID(e.target.value)}/><br/>
            Enter Driver Name : <input type='text' name='dName' value={dName} onChange={e => setDName(e.target.value)}/><br/>
            Enter Driver Street : <input type='text' name='dStreet' value={dStreet} onChange={e => setDStreet(e.target.value)}/><br/>
            Enter Driver Location : <input type='text' name='dLocation' value={dLocation} onChange={e => setDLocation(e.target.value)}/><br/>
            Enter Driver City : <input type='text' name='dCity' value={dCity} onChange={e => setDCity(e.target.value)}/><br/>
            Enter State : <input type='text' name='dState' value={dState} onChange={e => setDState(e.target.value)}/><br/>
            Enter Pincode : <input type='text' name='dPincode' value={dPincode} onChange={e => setDPincode(e.target.value)}/><br/>
            Enter MobileNo : <input type='text' name='dMobileno' value={dMobileno} onChange={e => setDMobileNo(e.target.value)}/><br/>
            Enter licenseNo : <input type='text' name='dlicenseNumber' value={dlicenseNumber} onChange={e => setDLicenseNumber(e.target.value)}/><br/>
            <button type='submit'>Update Driver</button>
        </form>

        <h1>Delete Driver</h1>
            <form onSubmit={HandleSubmitDelete}>
                Enter Vehicle ID you want to delete : <input type='text' name='driverID' value={driverID} onChange={e => setDID(e.target.value)}/><br/>
                <button type='submit'>Delete Driver</button>
            </form>

            <h1>Select All Driver</h1>
            <form onSubmit={HandelSubmitSelectAll}>
                <button type='submit'>Select all Data</button>
            </form>

            <table border="7">
        <tr><th>Driver ID</th><th>Driver Name</th><th>Street</th><th>Location</th><th>City</th><th>State</th><th>Pincode</th><th>MobileNo</th><th>LicenseNo</th></tr>
        {all.map((e,index)=>(
            <tr key={index}>
                <td>{e.driverID}</td>
                <td>{e.name}</td>
                <td>{e.street}</td>
                <td>{e.location}</td>
                <td>{e.city}</td>
                <td>{e.state}</td>
                <td>{e.pincode}</td>
                <td>{e.mobileNo}</td>
                <td>{e.licenseNumber}</td>

            </tr>
        ))}
    </table><br/>

        </div>
    )

}
export default Driver;