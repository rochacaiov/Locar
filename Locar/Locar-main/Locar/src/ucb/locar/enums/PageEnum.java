package ucb.locar.enums;

public enum PageEnum {
	ADMIN_HOME("admin/home.jsp"), USER_HOME("user/home.jsp"), LOGIN("login.jsp"), REGISTER("register.html");
	
	String pagePath;
	
	PageEnum(String pagePath) {
		this.pagePath = pagePath;
	}
	
	public String getPath() {
		return this.pagePath;
	}
	
}
