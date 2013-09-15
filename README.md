Bus
===

Bus is a Struts2 webapp on Google App Engine to show the University of Portsmouth Bus Timetable.

The project was a copy of the work and research i did prior to leaving the University of Portsmouth Applications Development and Maintenance team, and is provided as a working example for others to learn how to build Struts2 webapps on Google App Engine.

The project itself uses the Objectify API to access the Google Datastore to store the information that could be wanted to updated by an Admin.

If you wish to build the project, once you have it running locally run the /admin/initial.action so the data is intially loaded, otherwise you'll encounter errors about accessing stuff that doesn't exist. 

At the momnent the admin area restriction is commented out in the web.xml file, if you uncomment it and plan on deploying a version of the app, then you'll need to set up admin's in the Google App Engine Admin Console.

The webpages were designed to be fully responsive and are partly based off <a href="www.intializr.com">Initalizr's</a> responsive template, which uses Respond.js and Modernizr.

The webpages have been further customized to allow for touch based use, and includes touch icons if a user decides to save a link to the webapp on their mobile device homescreen.


Dependancies
===

The project needs no additional libraries, however as the Google App Engine SDK versions are updated anyone wishing to use the app will need to update the relevant jar files in the /lib folder.
