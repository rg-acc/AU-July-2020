import React, { useState, useEffect } from "react";
import { Text, TextInput, View, StyleSheet, Button, AsyncStorage, Image,Alert } from "react-native";
//in asyn storage, username : denotes current logged in user
const Login = ({ navigation }) => {
    const [username, setUserName] = useState("");

    useEffect(() => {
        checkAuth()
    }, [])

    const checkAuth = async () => {
        const userName = await AsyncStorage.getItem("username");
        if (userName) {
            navigation.navigate("Dashboard");
        }
        return;
    }

    const login = async () => {
        const userName = await AsyncStorage.getItem("username");
        if (userName) {
            navigation.navigate("Dashboard");
        }

        if(username) {
            await AsyncStorage.setItem("username", username);
            navigation.navigate("Dashboard");
        }
        else
            Alert.alert('Enter a valid username!')  
    }

    return (
        <View style={Styles.container}>
            <Image style={Styles.tinyLogo} source={require('../../assets/logo.jpeg')}  />
            <Text style={Styles.logoTextStyle}>To Do</Text>

            <TextInput style={Styles.textInputStyle} onChangeText={(text) => setUserName(text)} placeholder="username" />
            <Text title="Login" color="#329ea8" style={Styles.loginButtonStyle}  onPress={login} >Login</Text> 
        </View>
    )
}


const Styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor:"white",
   
    },
    logoTextStyle: {
        fontSize: 25,
        fontWeight: "600",

    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius:10,
        backgroundColor:"white",
        fontSize: 20,
        padding: 10,
        width: "40%",
        marginTop:40,
        marginBottom:20,

    },

    tinyLogo:{
        width: "45%",
        height: "25%",
    },
    loginButtonStyle:{
      
        
        borderRadius:30,
        backgroundColor:"#329ea8",
        fontSize: 14,
        padding: 10,
        width: "30%",
        alignSelf:"center",
        textAlign: 'center',
        marginTop:5,
        color:"white" ,

    }


})

export default Login;