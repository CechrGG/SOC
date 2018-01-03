package struts2Test.interceptor;

public class MyInterceptor1 implements Interceptor {

	@Override
	public void intercept(InvocationTest invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor1 before invoke");
		invocation.invoke();
		System.out.println("MyInterceptor1 after invoke");
	}

}
