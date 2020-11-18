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

import ucb.locar.dao.VehicleDAO;
import ucb.locar.enums.PageEnum;
import ucb.locar.models.Vehicle;

@WebServlet("/vehicles")
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		List<Vehicle> vehicles = new ArrayList<>();
		VehicleDAO vehicleDAO = new VehicleDAO();
		
		try {
			vehicles = vehicleDAO.findAll();
			request.setAttribute("vehicles", vehicles);
			
			dispatcher = request.getRequestDispatcher(PageEnum.USER_HOME.getPath());
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UPDATE
		// ESSE MÉTODO É RESPONSÁVEL POR ATUALIZAR O STATUS DE UM VEÍCULO QUE FOI LOCADO OU ENTREGUE
	}

}
