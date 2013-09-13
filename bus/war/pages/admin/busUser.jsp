<%@ taglib prefix="s" uri="/struts-tags"%><!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

        <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title">University of Portsmouth Bus Service </h1>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
            <article>
	            <header>
	                	<h2>Update</h2>
	            </header>
	            <section>
				<p>Change status variables and press save.</p>
				<s:actionerror />
				</section>
				<section>	
					<s:form action="saveEdit">
						<p>Bus Status(tick.png,warning.png,cross.png): </p><s:textfield name="status" value="%{status}" label="Status" required="true" size="50" />
						<p>Bus Status Text: </p><s:textfield name="status_text" value="%{status_text}" label="Status Text" required="true" size="50" />
						<p><s:submit cssClass="Button" value="Save." />
					</s:form>

				</section>
			</article>
              

            </div> <!-- #main -->
        </div> <!-- #main-container -->
        
		<div class="footer-container">
            <footer class="wrapper">
                <p>
					<a href="http://www.port.ac.uk/lookup/generalinformation/gettingaround/bus/filetodownload,103195,en.pdf">Mon to Fri</a>
					and <a href="http://www.port.ac.uk/lookup/generalinformation/gettingaround/bus/filetodownload,122139,en.pdf">Weekend</a>
					 full timetables
				</p>
				<p>
				&copy; University of Portsmouth
				</p>
            </footer>
        </div>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
