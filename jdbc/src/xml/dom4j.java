package xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class dom4j {
	@Test
	public void textDom4j() {
		try {
			//创建dom4j核心类SAXReader类对象
			SAXReader saxReader = new SAXReader();
			//根据url路径加载xml文件
			Document dom = saxReader.read("src/xml/web.xml");
			//获得根节点
			Element rootElement = dom.getRootElement();
			//System.out.println(rootElement.getName());  //输出根节点的节点名称
			//System.out.println(rootElement.attributeValue("version"));   //输出根节点的version属性的属性值
			//获取根节点的所有子节点
			List<Element> elements = rootElement.elements();
			//遍历所有子节点
			for (Element element : elements) {
				if(element.getName().equals("servlet")) {
					System.out.println(element.element("servlet-name").getText());
					System.out.println(element.element("servlet-class").getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
