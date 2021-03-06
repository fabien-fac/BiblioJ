<%@ page import="biblioj.Reservation" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
<style type="text/css" media="screen">
#status {
    background-color: #eee;
    border: .1em solid #fff;
    margin-left : -32%;
    margin-top : 5em;
    padding: 0.5em;
    width: 22%;
    float: left;
    -moz-box-shadow: 0px 0px 1.25em #ccc;
    -webkit-box-shadow: 0px 0px 1.25em #ccc;
    box-shadow: 0px 0px 1.25em #ccc;
    -moz-border-radius: 0.6em;
    -webkit-border-radius: 0.6em;
    border-radius: 0.6em;
}

.ie6 #status {
    display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status h1 {
    text-transform: uppercase;
    font-size: 1.1em;
    margin: 0 0 0.3em;
}

#status caption{
    text-align: left;
}

#status th, #status td{
    font-size: 0.8em;
}

#status h2 {
    color: #48802c;
    font-weight: normal;
    font-size: 1.25em;
    margin: 0 0 0.3em 0;
}

</style>
    <a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<g:if test="${reservationInstance != null}">
<div id="status" role="complementary">

    <div class="panier" role="contentinfo">
        <h2>Panier</h2>
        <table>
            <thead>
                <tr>
                    <th>Titre livre</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${reservationInstance?.livres?.toList()}" status="l" var="livre">
                    <tr class="${(l % 2) == 0 ? 'even' : 'odd'}">
                        <td>  ${livre?.titre} </td>
                        <td>
                            <g:link controller="reservation" action="supressionLivre" params='[idReservation: "${reservationInstance?.id}", idLivre: "${livre?.id}"]'>
                            <g:img dir="images" file="supprimer.png"></g:img>
                            </g:link>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <g:if test="${reservationInstance.livres.size()>0 && hideButton == null}">
            <g:form controller="reservation" action="show" id="${reservationInstance.id}">
                <g:submitButton name="valider" value="valider"/>
            </g:form>
        </g:if>
    </div>

</div>
</g:if>
	<body>
		<div id="grailsLogo" role="banner"><a href="/BiblioJ/"><img src="${resource(dir: 'images', file: 'logo.png')}" alt="Grails"/></a></div>
		<g:layoutBody/>
        <br />
	   	<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
