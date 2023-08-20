<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<head>
	<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet" >
		<title>
			List of Todo Page
		</title>
		
	</head>
	<body>	
		<div class="container">
		
			<h1>Your Todos Are</h1>		
			<table class="table border ">
				<thead>
					<tr >
						<th>Id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items ="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				
		</div>
		
		<script href="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
		<script href="webjars/jquery/3.7.0/jquery.min.js"></script>
	</body>
</html>