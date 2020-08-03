    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
      
            <h1>Edit Student</h1>  
           <form:form method="POST" action="/Test/editsave">    
            <table >    
            <tr>  
            <td></td>    
             <td><form:hidden  path="id" /></td>  
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
              <td>Department :</td>    
              <td><form:input path="department" /></td>  
             </tr>     
               
             <tr>    
              <td> </td>    
              <td><input type="submit" value="Edit Save" /></td>    
             </tr>    
            </table>    
           </form:form>    