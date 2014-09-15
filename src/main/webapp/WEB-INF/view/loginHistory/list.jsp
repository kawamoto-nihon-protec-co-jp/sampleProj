<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${f:url('/css/global.css')}"/>
</head>
<body>

<html:errors/>

<s:form>
一覧表
<html:hidden property="offset" />
<html:hidden property="count" />
<table border="1">
	<tr>
		<th>loginId</th><td><html:text property="loginId" /></td>
	</tr>
	<tr>
		<th></th><td><input type="submit" name="retrieve" value="retrieve" /></td>
	</tr>
</table>
<br/>

<table border="1">
<tr style="background-color:pink">

	<th>loginId</th>
	<th>loginSeq</th>
	<th>loginDate</th>
<th></th><th></th><th></th>
</tr>

<c:forEach var="e" varStatus="s" items="${loginHistoryItems}">
	<tr style="background-color:${s.index %2 == 0 ? 'white' : 'aqua'}">
		<td>
			${f:h(e.loginId)}
		</td>
		<td>
			${f:h(e.loginSeq)}
		</td>
		<td>
			${f:h(e.loginDate)}
		</td>
		<td><s:link href="show"> show </s:link></td>
		<td><s:link href="edit"> edit </s:link></td>
		<td><s:link onclick="return confirm('delete OK?');" href="delete">delete</s:link></td>
	</tr>
</c:forEach>

</table>
<table>
	<tr>
		<td>
			${f:h(totalNumber)}Items
		</td>
	</tr>
	<tr>
		<td>
			${f:h(currentPageIndex)}/${f:h(totalPageIndex)}
		</td>
	</tr>
</table>
<table>
	<tr>
		<td><input type="submit" name="firsPage" value="firsPage" ${isPrevPage == "true" ? '' : 'disabled'} /></td>
		<td><input type="submit" name="prevPage" value="prevPage" ${isPrevPage == "true" ? '' : 'disabled'} /></td>
		<td><input type="submit" name="nextPage" value="nextPage" ${isNextPage == "true" ? '' : 'disabled'} /></td>
		<td><input type="submit" name="lastPage" value="lastPage" ${isNextPage == "true" ? '' : 'disabled'} /></td>
	</tr>
</table>
</s:form>

<s:link href="create"> create new Object </s:link>
</body>
</html>