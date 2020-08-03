import React, { useState } from 'react';
import {Container,Button,InputGroup,FormControl,ListGroup,Image} from 'react-bootstrap'; 
import logo from './logo.jpeg';

export default function Dashboard(props) {
    
    const [input, setInput] = useState("");
    const [tasks, setTasks] = useState([]);

     
  const addTask = async()=> { 
    if(input !== '' ){ 
        const newTask = { 
        id :  tasks.length, 
        value : input 
      }; 
  
      await setTasks([...tasks,newTask]);
      await setInput("");
    } 
  }
  
  
   const  deleteTask= async(key)=>{ 
 
    console.log('-----');
    console.log(key);
  
    const modifiedtasks = tasks.filter((item)=>item.id !== key)
    
    await setTasks(modifiedtasks);
    console.log(modifiedtasks)
    
  } 
    
    return (
        <Container> 
    
          <div style={Styles.heading} 
                >
                   
                    To Do App 
            </div>
  
           
        <br/>
          
          <div>
                
          <InputGroup style={{ 
                  display: "flex",
                  flexDirection:"column",
                  justifyContent: "center", 
                  alignItems: "center", 
              
                }} > 
               
          <FormControl 
            placeholder="Enter task"
            size="lg"
            value = {input} 
            onChange = {item => setInput(item.target.value)} 
            aria-label="add something"
            aria-describedby="basic-addon2"
            
          /> 
          <InputGroup.Append> 
            <Button 
              size="lg"
              onClick = {()=>addTask()} 
              style= {Styles.button}
              > 
              Add Task 
            </Button> 
          </InputGroup.Append> 
        </InputGroup> 
  
     
   </div> 
   <br/><br/>

     
        <ListGroup style={Styles.task}> 
         
         {tasks.map(item => {return( 
  
            <label style={Styles.container}>  
              <input type="checkbox" checked="" 
              onChange = { () => deleteTask(item.id) }/>
              {item.value} 
            </label> 
  
         )})} 
        </ListGroup> 
     
   
     </Container> 
    )
}



const Styles = {
    container: {

        borderRadius:7,
        backgroundColor:"#aceff2",
        fontSize: 12,
        padding: 5,
        width: "90%",
        alignSelf:"center",
        flexDirection:"row",
        margin:2
    },
    button:{
             
        borderRadius:5,
        backgroundColor:"#329ea8",
        fontSize: 14,
        padding: 7,
    
        alignSelf:"center",
        textAlign: 'center',
        marginTop:5,
        color:"white" ,
        },
    task:{ 
        display: "flex",
        flexDirection:"column",
        justifyContent: "center", 
        alignItems: "center", 
    
      },
      heading:{
         
            display: "flex", 
            flexDirection:"column",
           justifyContent: "center", 
           alignItems: "center", 
           fontWeight: 'bolder', 
           fontSize: '3rem', 
           fontWeight: 'bolder', 
         
      }

}
