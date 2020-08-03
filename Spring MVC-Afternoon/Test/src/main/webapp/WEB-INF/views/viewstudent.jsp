       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
      	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
      
    <h1>Students List</h1>  
    <table border="2" width="70%" cellpadding="2">  
    <tr><th>Id</th><th>First Name</th><th>First Name</th><th>Department</th><th>Edit</th><th>Delete</th></tr>  
       <c:forEach var="student" items="${list}">   
       <tr>  
       <td>${student.id}</td>  
       <td>${student.firstName}</td>  
       <td>${student.lastName}</td>  
       <td>${student.department}</td>  
       <td><a href="editstudent/${student.id}">Edit</a></td>  
       <td><a href="deletestudent/${student.id}">Delete</a></td>  
       </tr>  
       </c:forEach>  
       </table>  
       <br/>  
       <a href="studentform">Add New Student</a>  