    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
      
      
            <h1>Add New student</h1>  
           <form:form method="post" action="save">    
            <table >    
             <tr>    
              <td>id : </td>   
              <td><form:input path="id"  /></td>  
             </tr>
             <tr>    
              <td>First Name : </td>   
              <td><form:input path="firstName"  /></td>  
             </tr>    
              <tr>    
              <td>Last Name : </td>   
              <td><form:input path="lastName"  /></td>  
             </tr> 
             <tr>    
             	<td>Department : </td>   
              	<td><form:input path="department"  /></td>  
             </tr> 
              <tr>    
          		<td> </td>    
          		<td><input type="submit" value="Save" /></td>    
         	  </tr>    
   
            </table>    
           </form:form>    