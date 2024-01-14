import React, { useState } from 'react'
import axios from 'axios'
import './App.css';

function Route() {
    const [routeID,setRID]=useState();
    const [source,setSou]=useState();
    const [destination,setDest]=useState();
    const [distance,setDist]=useState();
    const [travelduration,setDur]=useState();
    const [all,setAll]=useState([]);

      const data={
        "routeID":routeID,
        "source":source,
        "destination":destination,
        "distance":distance,
        "travelDuration":travelduration,
    }
    const url='http://localhost:8080/admin/'
    const HandleSubmit=(e)=>{
        e.preventDefault();
        // console.log(e.target.eid.value)
        console.log(data)
        axios.post(url+'addRoute', data)
        document.getElementById("myForm").reset();
        alert("Data Inserted Successfully");
    }
    const HandleSubmitUpdate=(e)=>{
        e.preventDefault();
        //alert(`Employee ID: ${eid} Name:${ename} Salary:${esal}`);
        axios.put(url+'updateRoute', data)
        alert("Data Updated Successfully");
    }
    const HandelSubmitSelectAll=(e)=>{
        e.preventDefault();
        axios.get(url+"viewAllRoutes").then(response=>{
          //  console.log(response.data)
            setAll(response.data)
        }).catch(e=>{
            //console.log(e)
        })
      console.log('data')
        console.log(all)
      }

    return (
        <div className='route'>
        
            <h1>Add Route</h1>
            <form onSubmit={HandleSubmit} id="myForm">
                Enter Route Id : <input type='text' name='routeID' value={routeID} onChange={e => setRID(e.target.value)}/><br/>
                Enter Source : <input type='text' name='source' value={source} onChange={e => setSou(e.target.value)}/><br/>
                Destination : <input type='text' name='destination' value={destination} onChange={e => setDest(e.target.value)}/><br/>
                Distance : <input type='text' name='distance' value={distance} onChange={e => setDist(e.target.value)}/><br/>
                Travel Duration : <input type='text' name='travelduration' value={travelduration} onChange={e => setDur(e.target.value)}/><br/>
                <br/>
                <button type='submit'>Add Route</button>
            </form>

            <h1>Update Route</h1>

          <form onSubmit={HandleSubmitUpdate}>
            Enter Route Id : <input type='text' name='routeID' value={routeID} onChange={e => setRID(e.target.value)}/><br/>
            Enter Source : <input type='text' name='source' value={source} onChange={e => setSou(e.target.value)}/><br/>
            Enter Destination : <input type='text' name='destination' value={destination} onChange={e => setDest(e.target.value)}/><br/>
            Enter Distance : <input type='text' name='distance' value={distance} onChange={e => setDist(e.target.value)}/><br/>
            Enter Travel Duration : <input type='text' name='travelduration' value={travelduration} onChange={e => setDur(e.target.value)}/><br/>
            <button type='submit'>Update Vehicle</button>
        </form>
        
        
        <h1>viewAllRoutes</h1>
        <form onSubmit={HandelSubmitSelectAll}>
            <button type='submit'>Select all Data</button>
        </form>
        
        <table border="7">
        <tr><th>route ID</th><th>source</th><th>destination</th><th>distance</th><th>travelDuration</th></tr>
        {all.map((e,index)=>(
            <tr key={index}>
                <td>{e.routeID}</td>
                <td>{e.source}</td>
                <td>{e.destination}</td>
                <td>{e.distance}</td>
                <td>{e.travelDuration}</td>
            </tr>
        ))}
        </table><br/>
        </div>
    )
}
export default Route;
