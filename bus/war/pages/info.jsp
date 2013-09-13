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
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

        <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
<div class="screen">
        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title"><p></p> <a href="<s:url action='home'/>">Bus</a></h1>
                <p class="Status">Status:  <img src="${pageContext.request.contextPath}/images/<s:property value='status' />"></p>
                <p class="Status_Text"><s:property value='status_text' /></p>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <article>
                    <header>
                    <noscript><h2>Please enable javascript for this page to function correctly</h2></noscript>
                    </header>


                	<header>
                	<h2>Information</h2>
                	</header>
                	<section>
                	<s:property value="information" escape="false"/>
                	<s:property value="following_should_be_noted" escape="false"/>
					</section>
				</article>

            </div> <!-- #main -->
        </div> <!-- #main-container -->
          <div class="push"></div>
 </div>       
		<div class="footer-container">
            <footer class="wrapper">
                <p>
					<a href="<s:property value="mon_fri_link" />">Mon to Fri</a>
					and <a href="<s:property value="weekend_link" />">Weekend</a>
					 full timetables. Other information <a href="<s:url action='info'/>"><img src="${pageContext.request.contextPath}/images/information.png"></a>
				</p>
				<p>
				&copy; Adam Hansrod
				</p>
            </footer>
        </div>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
