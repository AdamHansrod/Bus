<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link rel="stylesheet" href="<s:url value='/css/css.css'/>"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

</head>

<body>
	<section>
		<s:form id="getLangBusTimes" action="timetable" >
			<s:select name="StopNumber" list="locationListLangstone" listKey="StopNumber"
				listValue="Location" label="Select a bus stop" />
			<s:submit value="Submit" id="BusTimes" />
		</s:form>
		<p id="LangstoneCampusTimes"></p>
	</section>
	<section>
		<s:form id="getUniBusTimes" action="timetable">
			<s:select name="StopNumber" list="locationListUni" listKey="StopNumber"
				listValue="Location" label="Select a bus stop" />
			<s:submit value="Submit" id="BusTimes" />
		</s:form>
		<p id="UniCampusTimes"></p>
	</section>
</body>
</html>