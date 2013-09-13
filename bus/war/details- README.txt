app engine sdk 1.8
datanucleus v1
JRE 1.7
objectify 4.0b3
asm 3.3( not asm 4.0, jersey which is a part of datanucleus expects asm 3.3 and asm 4.0 won't work correctly for it)

If it comes out saying that it's missing libraries when they're actually in the lib folder, 
	remove them from the build path and re-add them until it gets rid of the error 
	also trying cleaning the project
	repeat till it stops showing the errors.
Important! You're workspace can't have a space in it's name e.g. 
	C:\Documents and Settings\HansrodA\Workspaces\ won't work
	You will get an error that looks like this :
		Error 500 access denied ("java.io.FilePermission" 
		"C:\Documents%20and%20Settings\HansrodA\Workspaces\MyEclipse%2010\bus_dev\war\WEB-INF\lib\
		struts2-core-2.3.8.jar" "read") - Class: java.security.AccessControlContext 
		File: AccessControlContext.java Method: checkPermission Line: 366 - 
		java/security/AccessControlContext.java:366:-1
		
The Freemaker.core.TextBlock class is required as well as the Struts2ListenerOnGAE class for struts to work on GAE

the css.css file is for the location.jsp pages only, otherwise disregard, 
	this file is old stuff is kept in, if anyone wants to see how it would work :)