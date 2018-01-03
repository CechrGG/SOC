package struts2Test.interceptor;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class InvocationTest {
	//保存拦截器
	private List<Interceptor> interceptors = new LinkedList<Interceptor>();
	private Object action;
	private int interceptorIndex = 0;
	
	//构造方法，注册拦截器和Action对象
	public InvocationTest(Object action, Interceptor... interceptors ) {
		for (int i = 0; i < interceptors.length; i++) {
			this.interceptors.add(interceptors[i]);
		}
		this.action = action;
	}
	
	//执行调用链中的拦截器方法
	public void invoke() throws Exception {
		if(interceptorIndex == interceptors.size()) {
			try {
				Method method = action.getClass().getMethod("execute");
				method.invoke(getAction());
			} catch (Exception e) {
				throw new Exception("在action中未发现execute方法");
			}
			return;
		}
		interceptors.get(interceptorIndex++).intercept(this);
	}

	public Object getAction() {
		return action;
	}

	public void setAction(Object action) {
		this.action = action;
	}
	
	public static void main(String[] args) throws Exception {
		MyInterceptor1 myInterceptor1 = new MyInterceptor1();
		MyInterceptor2 myInterceptor2 = new MyInterceptor2();
		PropertyInterceptor propertyInterceptor = new PropertyInterceptor();
		MyAction myAction = new MyAction();
		InvocationTest invocationTest = new InvocationTest(myAction, myInterceptor1, myInterceptor2, propertyInterceptor);
		invocationTest.invoke();
	}
}
