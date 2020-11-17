package ucb.locar.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucb.locar.enums.PermissionEnum;
import ucb.locar.models.User;

public class AuthUtils {
	
	public static void sendRedirectPathByPermission(HttpServletRequest request, HttpServletResponse response, User user) {
		if(user.getPermission().equals(PermissionEnum.ADMIN))
			try {
				response.sendRedirect(request.getContextPath() + "/vehicles/rents");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(user.getPermission().equals(PermissionEnum.USER))
			try {
				response.sendRedirect(request.getContextPath() + "/vehicles");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
