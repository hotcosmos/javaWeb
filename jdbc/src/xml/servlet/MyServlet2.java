package xml.servlet;

public class MyServlet2 implements InFMyServlet {

	@Override
	public void init() {
		System.out.println("MyServlet2初始化。。。。。。");
	}

	@Override
	public void service() {
		System.out.println("MyServlet2服务中。。。。。。");
	}

	@Override
	public void destory() {
		System.out.println("MyServlet2已销毁。。。。。。");
	}

}
