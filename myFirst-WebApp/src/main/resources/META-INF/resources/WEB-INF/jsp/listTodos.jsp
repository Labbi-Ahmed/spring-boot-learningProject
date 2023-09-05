<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>List of Todo Page</title>

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
		<a class="navbar-brand m-1" href="#">LearnJava-with-Labbi</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
			</ul>
		</div>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</ul>
	</nav>
	<div class="container">

		<h1>${name}Todos Are</h1>
		<table class="table border ">
			<thead>
				<tr>

					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>

						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">DELETE </a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">UPDATE </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add-Todo</a>

	</div>

	<script href="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
	<script href="webjars/jquery/3.7.0/jquery.min.js"></script>
</body>
</html>