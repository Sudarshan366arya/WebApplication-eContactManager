<%@page import="net.viralpatel.contact.controller.ContactManager"%>
<%@page import="net.viralpatel.contact.model.Contact"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
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
	<title>Contact Manager - Struts2 Hibernate Example</title>
</head>
<body>
<h1>Contact Manager</h1>

<s:actionerror/>

<s:form action="updatedone" method="post">
     <s:hidden name="contact.id" key="id" value="%{contactedit.id}" />
	<s:textfield name="contact.firstname"  value="%{contactedit.firstname}" label="Firstname" />
	<s:textfield name="contact.lastname" value="%{contactedit.lastname}" label="Lastname"/>
	<s:textfield name="contact.emailId" value="%{contactedit.emailId}" label="Email"/>
	<s:textfield name="contact.cellNo" value="%{contactedit.cellNo}" label="Cell No."/>
	<s:textfield name="contact.website" value="%{contactedit.website}" label="Homepage"/>
	<s:textfield name="contact.birthdate" value="%{contactedit.birthdate}" label="Birthdate"/>
	<s:submit value="Update Contact" align="center"/>
</s:form>

</body>
</html>