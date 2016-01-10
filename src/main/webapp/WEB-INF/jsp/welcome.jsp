<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<title>Test jsp page</title>
</head>

<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br>
	Message: ${message}
	
	<p>this is the test jsp page.</p>
	<p>next page: <a href="/foo"> foo</a></p> 
	<table> <caption>Verzeichnis der Teilnehmer</caption>
	 	<thead> 
	 	<tr> 
	 	<th>firstname</th> 
	 	<th>lastname</th> 
	 	<th>age</th> 
	 	</tr> 
	 	</thead> 
	 	
	 	<tfoot> 
	 	<tr> 
	 	<th>firstname</th> 
	 	<th>lastname</th> 
	 	<th>age</th> 
	 	</tr> 
	 	</tfoot> 
	 	
	 	<tbody> 
	 	<tr> 
	 	<td>Müller</td> 
	 	<td>Max</td> 
	 	<td>24</td> 
	 	</tr> <tr> 
		<td>Siegert</td> 
		<td>Siegfried</td> 
		<td>65</td> 
		</tr> 
		</tbody> 
		</table> 
</body>

</html>
