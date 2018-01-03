package struts2Test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExecuteTimeInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getName() + " 开始执行");
		long start = System.currentTimeMillis();
		String result = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println(getName() + " 执行Action方法的时间：" + (end - start) + "毫秒");
		System.out.println(getName() + " 执行结束");
		return result;
	}

}
