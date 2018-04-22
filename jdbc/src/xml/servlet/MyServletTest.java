package xml.servlet;

import java.lang.reflect.Method;
import java.rmi.server.ServerCloneException;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;
/**
 * 从配置文件中获取类全名，根据类全名通过反射技术调用类中的方法
 * @author Administrator
 * @date 2018年4月6日
 */

public class MyServletTest {
	//创建一个map集合
	private HashMap<String, String> data = new HashMap<String,String>();
	/**
	 * 从xml配置文件中获取信息，将url-pattern和servlet-class作为<key,value>写入map集合中
	 */
	@Before
	public void MyServletBefore() {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read("src/xml/servlet/web.xml");
			Element rootElement = document.getRootElement();
			List<Element> ServletElements = rootElement.elements();
			for (Element element : ServletElements) {
				if(element.getName().equals("servlet")) {
					String servletName = element.element("servlet-name").getText();
					String servletClass = element.element("servlet-class").getText();
					//将servletName和servletClass作为<key,value>写入map集合中
					data.put(servletName, servletClass);
				}
				if(element.getName().equals("servlet-mapping")) {
					String servletName = element.element("servlet-name").getText();
					String servletUrlPattern = element.element("url-pattern").getText();
					//根据servletName获取map集合中servletClass的值
					String ServletClass = data.get(servletName);
					//将servletUrlPattern和servletClass作为<key,value>写入map集合中
					data.put(servletUrlPattern, ServletClass);
					//移除以servletName作为key的<key,value>对
					data.remove(servletName);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过反射技术调用类中的方法
	 */
	@Test
	public void MyServletText() {
		try {
			//模拟浏览器中输入url
			String url = "/myServlet1";
			//获取map集合中以url作为key所对应的value
			String servletClass = data.get(url);
			//通过反射技术，根据servletClass对应的类全名获取字节码文件
			Class clazz = Class.forName(servletClass);
			//通过字节码文件，创建实例对象
			Object obj = clazz.newInstance();
			//通过字节码文件，获取指定的方法（两个参数：第一个是方法名称；第二个参数是方法的参数）
			Method method = clazz.getMethod("init",null);
			//执行实例对象中的方法  invoke(两个参数：第一个是调用方法的实例对象，第二个是方法的实参)
			method.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
