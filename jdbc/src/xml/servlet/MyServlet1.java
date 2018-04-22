package xml.servlet;

public class MyServlet1 implements InFMyServlet {

	@Override
	public void init() {
		System.out.println("MyServlet1初始化。。。。。。");
	}

	@Override
	public void service() {
		System.out.println("MyServlet1服务中。。。。。。");
	}

	@Override
	public void destory() {
		System.out.println("MyServlet1已销毁。。。。。。");
	}

}
