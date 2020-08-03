import React, { useEffect, useState } from 'react';
import { View, Alert,Text, Button,TextInput,SafeAreaView, Platform, StyleSheet, FlatList,AsyncStorage } from 'react-native';
import Task from "./Task";

export default function Dashboard(props) {

    const [tasks, setTasks] = useState([]);
    const [newtask, setNewTask] = useState("");
    const [user, setUser] = useState("");

    useEffect(() => {
        fetchData();
    }, [])

    const logout = async() => {
        
        await console.log(AsyncStorage.getItem("username"))
        await AsyncStorage.removeItem("username")
        
        await props.navigation.navigate("Login")
    }

    const fetchData = async () => {
        //for each username we are storing an array of tasks
        //this is an array of key-value pairs, eg [{key:value},{key:value}] 
        const userName = await AsyncStorage.getItem("username");
        setUser(userName)
        const myArray = await AsyncStorage.getItem(userName);
        if (myArray !== null) {
            // We have data!!
            setTasks(JSON.parse(myArray));
          }
         
        
    }

    const renderTasks = () => {
        
        if (tasks.length > 0) {
            return (<FlatList
                data={tasks}
            renderItem={({ item }) => <Task data={item} func={taskFunc}/>}
                keyExtractor={(item) => item.key}
                initialNumToRender={5}
            />)
        }
        return
    }

    const addTask = async () => {
        //tasks.push({key:len,task:newtask})
        await setTasks([...tasks,{key:tasks.length,task:newtask}])
        //for each username we are storing an array of tasks
        //this is an array of key-value pairs, eg [{key:value},{key:value}] 
        const userName = await AsyncStorage.getItem("username");
        await AsyncStorage.setItem(userName, JSON.stringify(tasks));
        Alert.alert('New task added')    
        
    }

    const removeTask = async (key) => {
        //removing the particular task
        const modifiedtasks = tasks.filter((item)=>item.key !== key)
        //for each username we are storing an array of tasks
        //this is an array of key-value pairs, eg [{key:value},{key:value}] 
        
        const userName = await AsyncStorage.getItem("username");
        await AsyncStorage.setItem(userName, JSON.stringify(modifiedtasks));   
        setTasks(modifiedtasks);
        Alert.alert('Task completed!')  
    }

    const taskFunc = removeTask;


    return (
        <SafeAreaView style={Styles.mainContainer}>
           <View  style={Styles.topBar}>
                <Text title="logout" style={Styles.userNameStyle}  >{user}</Text>
                <Text title="logout" color="#329ea8" style={Styles.logoutButtonStyle} onPress={logout} >logout</Text>
           </View>
            
                <TextInput style={Styles.textInputStyle} multiline={true} onChangeText={(text) => setNewTask(text)} placeholder="New Task"  />
                <Text title="Add" color="#329ea8" style={Styles.addButtonStyle} onPress={addTask} >Add</Text>
                {renderTasks()}
         
        </SafeAreaView>
    );
}


const Styles = StyleSheet.create({
    mainContainer: {
        marginTop: Platform.OS === 'android' ? 25 : 0
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius:10,
        backgroundColor:"white",
        fontSize: 14,
        padding: 10,
        width: "90%",
        alignSelf:"center"
    },
    addButtonStyle:{

        borderRadius:30,
        backgroundColor:"#329ea8",
        fontSize: 14,
        padding: 10,
        width: "30%",
        alignSelf:"center",
        textAlign: 'center',
        marginTop:10,
        color:"white",
        marginBottom:50,
 
    },
    nav:{

        backgroundColor:"#329ea8",
        fontSize: 14,
        width:"90%",
        height:"15%",
        alignSelf:"center",
        textAlign: 'center',
        color:"white",
        marginBottom:10,
        marginTop:0,
    },
    logoutButtonStyle:{
        backgroundColor:"#329ea8",
        fontSize: 14,
        color:"white",
        
    
        
        marginRight:20,
        padding:3,
        borderRadius:5,
        textAlign: 'center',


      },
      topBar:{
        marginTop:10,
        marginBottom:20,
        flexDirection:"row",
        justifyContent:"space-between"
        

        
      },
      userNameStyle:{
        backgroundColor:"#aceff2",
        marginLeft:20,
        padding:3,
        borderRadius:5,
      },

})

