
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN“ "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>

<HEAD>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <TITLE>Prestige Designs</TITLE>
  <LINK REL="stylesheet" TYPE="text/css" HREF="styles/main_style.css">
  <LINK HREF="images/favicon.ico" REL="icon" TYPE="image/x-icon" />  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
  
</HEAD>

<DIV ID = "MENU">
  <DIV ID = "HEADER">
    <DIV ID = "MENU_IMAGE">
      <IMG SRC="images/banner_menu.png" STYLE = "width: 100%;">
    </DIV>
  </DIV>
  <P ID = "MENUBANNER">MENU</P>
  <P>Home</P><HR>
  <P><A HREF=Biography.html>About</A></P><HR>
  <P><A HREF=Social.html>The Team</A></P><HR>
  <P><A HREF=Resume.html>Resume</A></P><HR>
  <P><A HREF=ImageGallery.html>Photos</A></P><HR>
  <P><A HREF=Contact.html>Contact</A></P><HR>
  <P><A HREF=Scripts.html>Scripts</A></P>
</DIV>

<DIV ID = "BACKGROUND">
  <DIV ID = "CONTENT">
    <DIV ID = "CONTENT_BANNER">
      <IMG SRC="images/banner_content.png" STYLE = "width: 100%;">
    </DIV>
    <DIV ID = "CONTENT_IMG">
	<h3>Login successful,</h3>  
		<h4>  
			Hello,  
			<%=session.getAttribute("name")%></h4>  
    </DIV>
    
  </DIV>
</DIV>
<DIV ID = "FOOTER">
  <P ALIGN = "CENTER"><A HREF=mailto:horl0010@algonquinlive.com>Contact Us</A> | Privacy Statement</P>
  <P ALIGN = "CENTER">Copyright © 2015 Nick Horlings. All Rights Reserved</P>
</DIV> 
</html>  