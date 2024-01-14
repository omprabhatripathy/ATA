import React, { useState } from 'react'
import axios from 'axios'
import './App.css';

function App() {
  const [vehicalID,setVID]=useState();
  const [vName,setVName]=useState();
  const [type,setType]=useState();
  const [reg,setReg]=useState();
  const [seatCap,setSeatCap]=useState();
  const [fate,setFare]=useState();
  const [all,setAll]=useState([]);
    const data={
      "vehicleID":vehicalID,
      "name":vName,
      "type":type,
      "registrationNumber":reg,
      "seatingCapacity":seatCap,
      "farePerkm":fate
  }
    const url='http://localhost:8080/admin/'
    const HandleSubmit=(e)=>{
        e.preventDefault();
        // console.log(e.target.eid.value)
        console.log(data)
        axios.post(url+'addVehicle', data)
        document.getElementById("myForm").reset();
        alert("Data Inserted Successfully");
    }
    const HandleSubmitUpdate=(e)=>{
      e.preventDefault();
      //alert(`Employee ID: ${eid} Name:${ename} Salary:${esal}`);
      axios.put(url+'modifyVehicle', data)
      alert("Data Updated Successfully");
  }
  const HandleSubmitDelete=(e)=>{
    e.preventDefault();
    //alert(`Employee ID: ${eid} Name:${ename} Salary:${esal}`);
    axios.delete(url+'deleteVehicle/'+vehicalID)
    alert("Data Deleted Successfully")
}
const HandelSubmitSelectAll=(e)=>{
  e.preventDefault();
  axios.get(url+"viewAllVehicles").then(response=>{
    //  console.log(response.data)
      setAll(response.data)
  }).catch(e=>{
      //console.log(e)
  })
console.log('data')
  console.log(all)
}


    return (

      
      

    <div className='entire'>
    <div>
      
      <img src="https://t4.ftcdn.net/jpg/04/88/86/91/240_F_488869198_sSHzzGPRWvg3VfzJiXdPSvryj0kjP4xg.jpg"/>
       <div class='centered'><h2>Welcome to Tour n Travels</h2></div>
        <h1>Add Vehicle</h1>
        <form onSubmit={HandleSubmit} id="myForm">
            Enter Vehical Id : <input type='text' name='vehicalID' value={vehicalID} onChange={e => setVID(e.target.value)}/><br/>
            Enter Vehical Name : <input type='text' name='vName' value={vName} onChange={e => setVName(e.target.value)}/><br/>
            Enter Vehical Type : <input type='text' name='type' value={type} onChange={e => setType(e.target.value)}/><br/>
            Enter Regestration Number : <input type='text' name='reg' value={reg} onChange={e => setReg(e.target.value)}/><br/>
            Enter Seating Capacity : <input type='text' name='seatCap' value={seatCap} onChange={e => setSeatCap(e.target.value)}/><br/>
            Enter Fare Per KM : <input type='text' name='fate' value={fate} onChange={e => setFare(e.target.value)}/><br/>
            <button type='submit'>Add Vehicle</button>
        </form>
        <div>
          </div>

          <h1>Update Vehicle</h1>

          <form onSubmit={HandleSubmitUpdate}>
            Enter Vehical Id : <input type='text' name='vehicalID' value={vehicalID} onChange={e => setVID(e.target.value)}/><br/>
            Enter Vehical Name : <input type='text' name='vName' value={vName} onChange={e => setVName(e.target.value)}/><br/>
            Enter Vehical Type : <input type='text' name='type' value={type} onChange={e => setType(e.target.value)}/><br/>
            Enter Regestration Number : <input type='text' name='reg' value={reg} onChange={e => setReg(e.target.value)}/><br/>
            Enter Seating Capacity : <input type='text' name='seatCap' value={seatCap} onChange={e => setSeatCap(e.target.value)}/><br/>
            Enter Fare Per KM : <input type='text' name='fate' value={fate} onChange={e => setFare(e.target.value)}/><br/>
            <button type='submit'>Update Vehicle</button>
        </form>
        </div>

        <div>
            <h1>Delete Vehicle</h1>
            <form onSubmit={HandleSubmitDelete}>
                Enter Vehicle ID you want to delete : <input type='text' name='vehicalID' value={vehicalID} onChange={e => setVID(e.target.value)}/><br/>
                <button type='submit'>Delete Vehicle</button>
            </form>
            <hr/>
        </div>

        <div>
            <h1>Select All</h1>
            <form onSubmit={HandelSubmitSelectAll}>
                <button type='submit'>Select all Data</button>
            </form>
        </div>
        <div>
    <table border="7">
        <tr><th>Vehicle ID</th><th>Vehicle Name</th><th>Vehicle Type</th><th>registration Number</th><th>Seating Capacity</th><th>farePerKM</th></tr>
        {all.map((e,index)=>(
            <tr key={index}>
                <td>{e.vehicleID}</td>
                <td>{e.name}</td>
                <td>{e.type}</td>
                <td>{e.registrationNumber}</td>
                <td>{e.seatingCapacity}</td>
                <td>{e.farePerKM}</td>
            </tr>
        ))}
    </table><br/>
    </div>
    </div>

   
    
  )
}

export default App;
