<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>


<body>
<center>
<h1>Welcome to register page</h1>
<form:form method="post"  modelAttribute="registerDto">
Name    :<input type="text"  name="name">
<br><br>

UserName: <input type="text" name="username">
<br><br>

Password: <input type="password" name="password">
<br><br>

Address :<input type="text" name="address">
<br><br> 

State   :<input type="text" name="state">
<br><br> 

Country :<input type="text" name="country">
<br><br> 

Email    : :<input type="text" name="email">
<br><br> 

Pan  :<input type="text" name="pan">
<br><br> 

Contact No :<input type="text" name="contactno">
<br><br> 



Account Type :<input type="text" name="accountType">
<br><br> 




<input type="submit">
</form:form>
</body>
</center>
</html>