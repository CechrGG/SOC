package struts2Test.interceptor;

public class PropertyInterceptor implements Interceptor {

	@Override
	public void intercept(InvocationTest invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PropertyInterceptor before invoke");
		Object action = invocation.getAction();
		if(action instanceof Property) {
			Property property = (Property)action;
			System.out.println("property value:" + property.getValue());
		}
		invocation.invoke();
		System.out.println("PropertyInterceptor after invoke");
	}

}
