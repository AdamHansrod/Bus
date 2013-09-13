Bus
===

A Struts2 webapp on Google App Engine to show the UoP Bus Timetable


A copy of the work and research i did prior to leaving the University of Portsmouth Applications Development and Maintenance team.

They wanted to be able to use the Struts2 java web application framework on top of the Google App Engine platform, this was an example of this work.

The project itself uses the Objectify API to access the Google Datastore to store the information that could be wanted to updated by an Admin.

If you wish to build the project, once you have it running locally run the /admin/initial.action so the data is intially loaded, otherwise you'll encounter errors about accessing stuff that doesn't exist. 

At the momnent the admin area restriction is commented out in the web.xml file, if you uncomment it and plan on deploying a version of the app, then you'll need to set up admin's in the Google App Engine Admin Console.
