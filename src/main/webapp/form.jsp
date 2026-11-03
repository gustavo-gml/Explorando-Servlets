<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Testando Servlets</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-icons.css">
</head>

<body>
	<div class="container">
		<div class="row mt-3">
			
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h1>Testes de Servlets</h1>


				<form action="${pageContext.request.contextPath}/request-body" method="POST" class="">

					<div class="mb-3">
						<label for="nome">Nome:</label> 
						<input name="nome" class="form-control">
					</div>



					<div class="mb-3">

						<label for="email">Email:</label> 
						<input name="email"class="form-control">
					</div>
					
					
					<div class="mb-3">

						<label for="msn">Mensagem:</label> 
						<input name="msn"class="form-control">
					</div>
					

					<div class="mb-3"></div>





					<button type="submit" class="btn btn-primary">Enviar Form</button>

				</form>


			</div>

		</div>
	</div>

</body>

</html>