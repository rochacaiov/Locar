package ucb.locar.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucb.locar.dao.DAOFactory;
import ucb.locar.dao.UserDAO;
import ucb.locar.enums.PageEnum;
import ucb.locar.enums.PermissionEnum;
import ucb.locar.exceptions.UserNotFoundException;
import ucb.locar.models.User;

@WebServlet(name="Auth", urlPatterns= {"/auth", "/auth/register"})
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher;
		User user = new User();
		UserDAO userDAO = DAOFactory.createUserDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		switch(request.getServletPath()) {
			case "/auth": {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				try {
					user = userDAO.findUserByAuth(username, password);
					
					if(user.getPermission().equals(PermissionEnum.ADMIN)) {
						response.sendRedirect("rents");
						return; 
					}
					
					request.getSession().setAttribute("user", user);
					response.sendRedirect("vehicles");
				} catch (UserNotFoundException e) {
					request.setAttribute("error", e.getMessage());
					dispatcher = request.getRequestDispatcher(PageEnum.LOGIN.getPath());
					dispatcher.forward(request,  response);
				}
				break;
			}

			case "/auth/register": {
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				try {
					user.setBirthday(format.parse(request.getParameter("dataNascimento")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setCpf(request.getParameter("cpf"));
				user.setAddress(request.getParameter("endereco"));
				userDAO.insert(user);
				response.sendRedirect(PageEnum.LOGIN.getPath());
				break;
			}
		}
		
		
    }

}
