package struts2Test;

import java.util.HashMap;

public class NameDAO {
	private static HashMap<String, String> names = new HashMap<String, String>();
	
	public NameDAO() {
		names.put("1", "guoguo");
		names.put("2", "gg");
		names.put("3", "qq");
	}
	
	public String getName(String id) {
		String name = null;
		if(names.containsKey(id)) {
			name = names.get(id);
		}
		return name;
	}
	
}
