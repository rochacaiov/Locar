<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/listcard.css">
<title>Insert title here</title>
</head>
<body>

<span>${user.username}</span>

<main>
		<ul class="listcard">
			<c:forEach var="vehicle" items="${vehicles}" > 
				<li>
					<img src="images/audir8.png" alt="BMW">
					<h3>${vehicle.producer} ${vehicle.model} </h3>
					<i class="fas fa-user"><span>${vehicle.people} pessoas</span></i>
					<i class="fas fa-tachometer-alt"><span>${vehicle.velocity} KM</span></i>
					<i class="fas fa-bolt"><span>${vehicle.power} HP</span></i>
					<form action="rent" method="get">
						<input type="hidden" name="id" value="${vehicle.id}">
						<button type="submit">Pré-Alocar</button>
					</form>
					<span id="price"><fmt:formatNumber type="currency">${vehicle.valuePerDay}</fmt:formatNumber> /dia</span>
	    		</li>
    		</c:forEach>
		</ul>
</main>

</body>
</html>