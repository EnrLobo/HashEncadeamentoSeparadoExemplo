<%-- 
    Document   : menu
    Created on : 1 de jul de 2024, 22:14:15
    Author     : 10414032675
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp"> Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador?opcao=cancelar"> Cidade</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=cancelar"> Funcionário</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/login.jsp"> Login</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}${URL_BASE}/LogoutControlador"> Logout</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
