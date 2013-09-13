<%@ taglib prefix="s" uri="/struts-tags"%><!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="google-site-verification" content="q_grWpPnz5EQsHIx2h4tEuYM5lxBQ1HmYkmfs1pQeQw" />
        <title>University of Portsmouth - Inter-Site Bus</title>
        <meta name="description" content="University of Portsmouth Bus Timetable">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/favicon.ico">
		<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/images/apple-touch-icon-57x57.png" />
		<link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/images/apple-touch-icon-72x72.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/images/apple-touch-icon-114x114.png" />
		<link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/images/apple-touch-icon-144x144.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script>
        $(document).ready(function() {
        $("article").hide().fadeIn(2000);
				$("#showAll").click(function(){
   					 $("#altStops").toggle();
   					  $("#Stops").toggle();
  				});
				$('#LangBusTimesBtn').remove();
				$('#UniBusTimesBtn').remove();
				$('#altStops').hide();
				//just get the campus ones
   				//var busStops = new Array(1,7);
				//var busStops = new Array(1,2,3,4,7,8,9,10,11);
				//$.each(busStops, function(busStopsIndex,busStopNumber){getTimes(busStopsIndex,busStopNumber);});
   				function getTimes(busStopsIndex,busStopNumber){
	   				$.getJSON('timetableAjax',
								{StopNumber:busStopNumber},
								function(data) { 
									//just get the campus ones
									var ids = new Array('section#UniMapCampusTimes a h2','section#LangstoneMapTimes a h2');
									//var ids = new Array('section#UniMapCampusTimes a h2','section#altStops p#LockswayTimes','section#altStops p#GldsmithAveLidlTimesU','section#altStops p#FtnTimesU','section#LangstoneMapTimes a h2','section#altStops p#WinstonTimes','section#altStops p#FtnTimesL','section#altStops p#GldsmthAveLidlTimesL','section#altStops p#GldsmthAvePublTimesL');
									//window.console&&console.log("indexNo: "+ busStopsIndex+ " val: "+busStopNumber+ " selector: "+ids[busStopsIndex]);
									var busStopSelector = ids[busStopsIndex];
									var selector1 = $("#"+busStopSelector);
									var stringy = $('<p class="smallTimes">'+ getTimesStr(data,4)+ '</p>');

									$(busStopSelector).append(stringy);
									var busStopSelectorExisting = busStopSelector + ' .smallTimes';
									if ($('body').find(busStopSelectorExisting).length > 0) {
										$(busStopSelectorExisting).replaceWith(stringy);
									} else {
										$(busStopSelector).append(stringy);
									}

						});
   				}
				function getTimesStr(data,length){
					var content = "";
					for(var i = 0;i<length;i++){
						if (data[i] !="" && data[i] !== null && data[i] !== false && i < data.length){
							if (i != (length - 1)){
								content += data[i]+ ", ";
							}else{
								content += data[i]+ ".";
							}
						}
						else {
							return content.slice(0,content.length - 2) + ".";
						}
					}
					return content;
				};
						});
	</script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
<div class="screen">
        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title"><p>University of Portsmouth</p> <a href="<s:property value='/home' />">Inter-Site Bus</a></h1>
                <div id="StatusDivider"><p class="Status">Status:  <img src="${pageContext.request.contextPath}/images/<s:property value='status' />" alt="<s:property value='status_text' />"></p>
                <p class="Status_Text"><s:property value='status_text' /></p>
                </div>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <article>
                    <header >
                    <noscript>Please enable javascript for this page to function correctly</noscript>
                        <h1 id="nextBusLeavingText">The next bus is leaving</h1>
                    </header>
                    
                    <section id="UniMapCampusTimes" class="MapsTimes">
                    
	                    <a href="<s:property value="uni_map_link" />">
	                    	<img src="<s:property value="uni_map" />" alt="Map of the location of the bus stop by the Spinnaker Sports Centre.">
	                    	<h2>University Campus at <s:property value="uniTimes" escape="false" /></h2>
	                    </a>
                    </section>
                    
                    <section id="LangstoneMapTimes" class="MapsTimes">
                    
	                    <a href="<s:property value="lang_map_link" />">                  
	                    	<img src="<s:property value="lang_map" />"  alt="Map of the location of the bus stop by Langstone campus.">
	                    	<h2>Langstone Campus at <s:property value="langTimes" escape="false"/></h2>
	                    </a>
	                    
                    </section>
                </article>
				<aside>
                	<header>
                		<h2>Or choose your own bus stop</h2>
                	</header>  
                	<div id="Stops">                 
				    <section>
				    	<h4>Heading towards Langstone</h4>
						<s:form id="getLangBusTimes" action="timetable"><%--  name="input"
							method="post" enctype="multipart/form-data" --%>
							<s:select name="StopNumber" list="locationListLangstone" listKey="StopNumber"
								listValue="Location" label="Select a bus stop" />
							<s:submit value="Submit" id="LangBusTimesBtn" />
						</s:form>					
						<p id="LangstoneCampusTimes"></p>
					</section>
					<section>
						<h4>Heading towards University</h4>
						<s:form id="getUniBusTimes" action="timetable"><%--  name="input"
							method="post" enctype="multipart/form-data" --%>
							<s:select name="StopNumber" list="locationListUni" listKey="StopNumber"
								listValue="Location" label="Select a bus stop" />
							<s:submit value="Submit" id="UniBusTimesBtn" />
						</s:form>
						<p id="UniCampusTimes"></p>
					</section>	
					</div> 
					<%-- <section id="altStops">
					<h4>Heading towards Langstone</h4>
					<p id="WinstonTimes">Winston Churchill Ave (Law Courts)</p>
					<p id="FtnTimesL">Fratton Railway Stn</p>
					<p id="GldsmthAveLidlTimesL">Goldsmith Ave (Lidl)</p>
					<p id="GldsmthAvePublTimesL">Goldsmith Ave (White House Pub)</p>
					
					<h4>Heading towards University</h4>
					<p id="LockswayTimes">Locksway Rd (Milton)</p>
					<p id="GldsmithAveLidlTimesU">Goldsmith Ave (Lidl)</p>
					<p id="FtnTimesU">Fratton Railway Stn</p>					
					</section>				 --%>			
<!-- 					<a href="#" id="showAll">Click here to show all stops</a> -->
                </aside>             

            </div> <!-- #main -->
        </div> <!-- #main-container -->
        <div class="push"></div>
 </div>       
		<div class="footer-container">
            <footer class="wrapper">
                <p>
					<a href="<s:property value="mon_fri_link" />">Mon to Fri</a>
					and <a href="<s:property value="weekend_link" />">Weekend</a>
					 full timetables. Further information <a href="<s:url action='info'/>"><img src="${pageContext.request.contextPath}/images/information.png"></a>
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
