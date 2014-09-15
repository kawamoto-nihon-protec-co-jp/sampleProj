<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${f:url('/css/global.css')}"/>
</head>
<body>

<html:errors/>

<s:form>
<table class="tablebg">
	<tr>
		<td> loginId </td>
		<td>
		    <html:text property="loginId" />
		</td>	
	</tr>
	<tr>
		<td> loginSeq </td>
		<td>
		    <html:text property="loginSeq" />
		</td>	
	</tr>
	<tr>
		<td> loginDate </td>
		<td>
		    <html:text property="loginDate" />
		</td>	
	</tr>

</table>

<input type="submit" name="update" value="UPDATE" />
</s:form>
<br/><br/>

<s:link href="/loginHistory/">list page</s:link>

</body>
</html>