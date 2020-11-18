package ucb.locar.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucb.locar.dao.RentDAO;
import ucb.locar.models.Rent;

@WebServlet(name="Rent", urlPatterns={"/rent", "/rents"})
public class RentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// CREATE (urlPattern="/rent")
		// MÉTODO PARA CRIAR UM NOVO ALUGUEL
		
		//System.out.println(request.getAttribute("id"));
		RequestDispatcher dispatcher;
		long id = Long.valueOf(request.getParameter("id"));
		RentDAO rentDAO = new RentDAO();
		Rent rent = new Rent();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// READ (urlPattern="/rents")
		// MÉTODO PARA APRESENTAR TODOS OS ALUGUEIS REALIZADOS PARA O ADMINISTRADOR E TAMBÉM O STATUS DO ALUGUEL DO CLIENTE
		// essas duas funcionalidaddes serão separadas pelo urlPattern igual foi feito no AuthController
		// urlPattern="/rent/status" -> Para apresentar o status de aluguel do cliente
		// urlPattern="/rents" -> Para apresentar todos as locações solicitadas ao ADMIN
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UPDATE (urlPattern="/rents")
		// MÉTODO PARA CANCELAR OU CONFIRMAR UM ALUGUEL NA PÁGINA DO ADMINISTRADOR
	}

}
