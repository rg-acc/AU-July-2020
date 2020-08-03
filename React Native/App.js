import { StatusBar } from 'expo-status-bar';
import React,{useRef} from 'react';
import { Button,StyleSheet, Text, View, AsyncStorage} from 'react-native';
import { createStackNavigator,HeaderBackButton, HeaderTitle } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';


import Login from "./src/components/Login"
import Dashboard from "./src/components/Dashboard"




const Stack = createStackNavigator();

function App() {
  const myRef = useRef(null);
  return (
    <NavigationContainer>
      
      <Stack.Navigator>
      <Stack.Screen name="Login" options={{headerTitleAlign:"center"}} component={Login} />
        <Stack.Screen name="Dashboard"  
        options={{
          headerLeft: (props) => {},
          headerTitleAlign:"center",
        }}
      component={Dashboard} />
     

      </Stack.Navigator>
    </NavigationContainer>
  );
}



const Styles = StyleSheet.create({
    logoutButtonStyle:{
      borderRadius:30,
      backgroundColor:"#329ea8",
      fontSize: 14,
      textAlign: 'center',
      color:"white",
      marginRight:10,
      padding: 6,
 
    }

  })

export default App;

