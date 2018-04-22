<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账----事务操作</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/transfer" method="post">
		转出账户：<input type="text" name="out" /><br/><br/>
		转入账户：<input type="text" name="in" /><br/><br/>
		转出金额：<input type="text" name="money" /><br/><br/>
		<input type="submit" value="确认转账" />
	</form>
</body>
</html>