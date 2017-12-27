package struts2Test;

//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts2.StrutsStatics;
//
//import com.opensymphony.xwork2.ActionContext;

public class QueryAction {
	private String id;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception {
		try {			
			NameDAO nameDao = new NameDAO();
			String name = nameDao.getName(id);
			if(null != name) {
				this.setName(name);
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			return "error";
		}
	}
}
