import React from "react";
import { CheckBox, Text, ImageBackground, TouchableOpacity, StyleSheet, View} from "react-native";

const Task = (props) => {
    
    
    const {data,func}= props
    const key = data.key
    const value = data.task
    const myfunc = func
    
    return (
        <View style={Styles.container} >
                <CheckBox onValueChange={()=>myfunc(key)} />
                <Text style={Styles.styleText}>{value}</Text>
        </View>
    );
}

const Styles = StyleSheet.create({
    container: {

        borderRadius:7,
        backgroundColor:"#aceff2",
        fontSize: 30,
        padding: 5,
        width: "90%",
        alignSelf:"center",
        flexDirection:"row",
        margin:2,
        color:"white"
    },
    styleText: {
        fontSize: 15,
        alignSelf:"center",
        margin:2,
        color:"black"
    }


})

export default Task;