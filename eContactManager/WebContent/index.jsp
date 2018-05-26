<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Contact Manager - Struts2 Hibernate Example</title>
	<style>
		body, input{
			font-family: Calibri, Arial;
		}
		table#contact {
			border-collapse: collapse;
			width:550px;
		}
		th {
			height: 40px;
			background-color: #ffee55;
		}
	</style>
<script>
</script>	
</head>
<body>
<h1>Contact Manager</h1>

<s:actionerror/>
<s:form  method="post" name="studentForm"  action="add">
 <s:hidden name="contact.id" key="id" value="%{contactedit.id}" />
	<s:textfield name="contact.firstname" value="%{contactedit.firstname}"  label="Firstname"/>
	<s:textfield name="contact.lastname" value="%{contactedit.lastname}"  label="Lastname"/>
	<s:textfield name="contact.emailId" value="%{contactedit.emailId}" label="Email"/>
	<s:textfield name="contact.cellNo" value="%{contactedit.cellNo}"  label="Cell No."/>
	<s:textfield name="contact.website" value="https://www.google.co.in/" label="Homepage"/>
	<s:textfield name="contact.birthdate" value="%{contactedit.birthdate}" label="Birthdate"/>
	<s:submit value="Add Contact" align="center"/>
	<s:submit value="Search Contact" action="search" align="center"/>
</s:form>
<a href="view">View Contact List</a>

<h2>Contacts</h2>
<table id="contact" border="1">
<tr>
	<th>Name</th>
	<th>Email</th>
	<th>Cell No.</th>
	<th>Birthdate</th>
	<th>Homepage</th>
	<th>Delete</th>
	<th>Edit</th>
</tr>
<s:iterator value="contactList" var="contact">
	<tr>
		<td><s:property value="firstname"/>,<s:property value="lastname"/> </td>
		<td><s:property value="emailId"/></td>
		<td><s:property value="cellNo"/></td>
		<td><s:property value="birthdate"/></td>
		<td><a href="<s:property value="website"/>">link</a></td>
		<td><a href="delete?id=<s:property value="id"/>">delete</a></td>
		<td><a href="update?id=<s:property value="id"/>">edit</a></td>
	</tr>	
</s:iterator>
</table>
</body>
</html>