package springTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloTest {
	private HelloSpring helloSpring;
	
	public HelloTest() {
		
	}
	
	public HelloTest(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	
	public HelloSpring getHelloSpring() {
		return this.helloSpring;
	}
	
	public void setHelloSpring(HelloSpring helloSpring) {
		this.helloSpring = helloSpring;
	}
	
	public String helloTest() {
		return this.helloSpring.helloSpring();
	}
	
	public static void main(String[] args) {
		Resource rs = new FileSystemResource("src\\spring.xml");
		//BeanFactory bf = new XmlBeanFactory(rs);//spring3.1之后废弃了，可用如下方式代替
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBDR = new XmlBeanDefinitionReader(bf);
		xmlBDR.loadBeanDefinitions(rs);
		HelloTest helloTest = (HelloTest)bf.getBean("helloTest");
		System.out.println(helloTest.helloTest());
		ApplicationContext context = new FileSystemXmlApplicationContext("src\\spring.xml");
		HelloTest helloTest2 = (HelloTest)context.getBean("helloTest");
		System.out.println(helloTest2.helloTest());
		((ConfigurableApplicationContext)context).close();
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("src\\spring.xml");
//		HelloTest helloTest3 = (HelloTest)beanFactory.getBean("helloTest");
//		System.out.println(helloTest3.helloTest());
		
		
	}
}
