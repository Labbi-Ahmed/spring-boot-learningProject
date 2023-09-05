<html>
	<head>
	<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css"
	rel="stylesheet">
		<title>
			Welcome page
		</title>
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
		<div>
		<h1>Welcome ${name} to the login page</h1>
		<hr>
		<h1><a href="list-todos">Manage</a> ToDos</h1>
		</div>
		
		
	</body>
</html>