<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN“ "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<HEAD>
  <TITLE>Prestige Designs</TITLE>
  <LINK REL="stylesheet" TYPE="text/css" HREF="styles/main_style.css">
  <LINK HREF="images/favicon.ico" REL="icon" TYPE="image/x-icon" />  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
  <SCRIPT>
function dropdown_Button(id) {
     document.getElementById(id).classList.toggle('show');
}

window.onclick = function(event) {
  if (!event.target.matches('.DROPBTN')) {

    var dropdowns = document.getElementsByClassName("DROPDOWN-CONTENT");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
  </SCRIPT>
</HEAD>

<DIV ID = "MENU">
  <P ID = "MENUBANNER">Prestige Computers</P>
  
  <P>
    <input type="search" value="Search Products" onFocus="if(this.value=='Search Products') this.value='';" onBlur="if(this.value=='') this.value='Search Products';" name="keywords" size="25" style="padding: 3px 0px 0px 3px; width:20em; font-size: 13px;display:block; background-repeat:no-repeat; border:none; margin-left:0px; color:#666;float:left;height:21px;margin-left:-10%;margin-top:5%;">
    
<input type="image" src="images/Search_Nav5.jpg"  alt="Quick Search" title=" Quick Search " onClick="return CheckKeywords();" style = "margin-top:5%;">
</P>
  </P>
  <div class="DROPDOWN">
  	<button onclick="dropdown_Button('computerhardware')" class="DROPBTN">Computer Hardware</button>
  	<div id="computerhardware" class="DROPDOWN-CONTENT">
    		<p><b>Computer Parts</b></p>
                <p><a href="#">Cases & Chassis</a></p>
    		<p><a href="#">CPUs & Processors</a></p>
                <p><a href="#">Cooling</a></p>
    		<p><a href="#">Computer Memory</a></p>
    		<p><a href="#">Harddrive</a></p>
    		<p><a href="#">Video Cards</a></p>
    		<p><a href="#">Motherboards</a></p>
  	</div>
  </div>
  <div class="DROPDOWN">
  	<button onclick="dropdown_Button('desktophardware')" class="DROPBTN">Desktop PC & Servers</button>
  	<div id="desktophardware" class="DROPDOWN-CONTENT">
    		<p>Desktop Computers</p>
    		<p><a href="#">Desktop PCs</a></p>
    		<p><a href="#">All-in-One Computers</a></p>
    		<p><a href="#">Barebone PCs</a></p>
    		<p><a href="#">Refurbished PCs</a></p>
    		<p><a href="#">Refurbished All-in-One PCs</a></p>
    		<p>Servers</p>
    		<p><a href="#">Server Systems</a></p>
    		<p><a href="#">Workstations</a></p>
  	</div>
  </div>
  <div class="DROPDOWN">
  	<button oncpck="dropdown_Button('notebooks')" class="DROPBTN">Laptops & Tablets</button>
  	<div id="notebooks" class="DROPDOWN-CONTENT">
    		<p>Notebooks</p>
    		<p><a href="#">Notebooks</a></p>
    		<p><a href="#">Refurbished Notebooks</a></p>
    		<p>Tablets & Mobile PCs</p>
    		<p><a href="#">Tablets & Mobile PCs</a></p>
    		<p><a href="#">Refurbished Tablets & Mobile PCs</a></p>
  	</div>
  </div>
  <div class="DROPDOWN">
  	<button oncpck="dropdown_Button('software')" class="DROPBTN">Software & Gaming</button>
  	<div id="software" class="DROPDOWN-CONTENT">
    		<p>Software</p>
    		<p><a href="#">Operating System</a></p>
    		<p><a href="#">Business & Home Office</a></p>
    		<p>Gaming</p>
    		<p><a href="#">Games</a></p>
    		<p><a href="#">Gaming Hardware & Accessories</a></p>
  	</div>
  </div>
  <div class="DROPDOWN">
  	<button oncpck="dropdown_Button('cables')" class="DROPBTN">Cables & Tools</button>
  	<div id="cables" class="DROPDOWN-CONTENT">
    		<p>Cables</p>
    		<p><a href="#">Power Cables</a></p>
    		<p><a href="#">USB Cables</a></p>
    		<p>Tools & Household Products</p>
    		<p><a href="#">Tools & Hardware</a></p>
    		<p><a href="#">Home Decor</a></p>
  	</div>
  </div>
  <P><A HREF="#">Contact</A></P>
</DIV>

<DIV ID = "BACKGROUND">
  <DIV ID = "CONTENT">
    <DIV ID = "CONTENT_BANNER">
      <IMG SRC="images/bannersa.png" STYLE = "width: 100%;">
    </DIV>
    <DIV ID = "CONTENT_IMG">
      <br>
      <form action="loginServlet" method="post">
      <fieldset style="width: 300px">  
          <legend><b>Account Login</b></legend>  
          <table>  
              <tr>  
                  <td>User ID</td>  
                  <td><input type="text" name="username" required="required" /></td>  
              </tr>  
              <tr>  
                  <td>Password</td>  
                  <td><input type="password" name="userpass" required="required" /></td>  
              </tr>  
              <tr>  
                  <td><input type="submit" value="Login" /></td>
                  <td><input type="submit" value="Register" /></td>  
              </tr>  
          </table>  
      </fieldset>  
    </form>  
    </DIV>
    
  </DIV>
</DIV>
<DIV ID = "FOOTER">
  <P ALIGN = "CENTER"><A HREF=mailto:horl0010@algonquinlive.com>Contact Us</A> | Privacy Statement</P>
  <P ALIGN = "CENTER">Copyright © 2015 Prestige Computers. All Rights Reserved</P>
</DIV> 
</html>  