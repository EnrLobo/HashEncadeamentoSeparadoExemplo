/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estudocasosi2024.controlador;

import com.mycompany.estudocasosi2024.servico.WebConstantes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author tulio
 */
@WebServlet(WebConstantes.BASE_PATH + "/LogoutControlador")
public class LogoutControlador extends HttpServlet{
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Obter a sessão, não criar uma nova
        if (session != null) {
            session.invalidate(); // Encerra a sessão
             request.setAttribute("mensagem", "Sessão encerrada");
        }
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        //    dispatcher.forward(request, response);
        response.sendRedirect("/projetoWEB/login.jsp");
    }
}