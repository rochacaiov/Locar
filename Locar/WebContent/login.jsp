<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<main>
	${error}
	<div class="loginForm">
		<h1>Login</h1>
			<form class="form" action="auth" method="POST">
				<div id="inputArea">
					<i class="fas fa-user"></i>
					<input type="text" name="username" placeholder="Insira o usuário" pattern="^(?!.*\.\.)(?!.*\.$)[^\W][\w.]{0,29}$" required>

					<i class="fas fa-lock"></i>
					<input type="password" name="password" placeholder="Insira a senha" required>
      			</div>
      			<button type="submit">Entrar</button>
    		</form>
  		<div class="register">
    		<span>Você não possui uma conta? <a href="#">Nova Conta</a></span>
  		</div>
  	</div>
</main>

</body>
</html>