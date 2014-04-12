
<%@ page import="biblioj.Auteur" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'auteur.label', default: 'Auteur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-auteur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link controller="livre" class="home" action="list">Liste des livres</g:link></li>
                <li><g:link controller="auteur" class="list" action="list">Liste des auteurs</g:link></li>
			</ul>
		</div>
		<div id="show-auteur" class="content scaffold-show" role="main">
			<h1>Detail de l'auteur</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list auteur">
			
				<g:if test="${auteurInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="auteur.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${auteurInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auteurInstance?.oeuvres}">
				<li class="fieldcontain">
					<span id="oeuvres-label" class="property-label"><g:message code="auteur.oeuvres.label" default="Oeuvres" /></span>
					
						<g:each in="${auteurInstance.oeuvres}" var="o">
						<span class="property-value" aria-labelledby="oeuvres-label"><g:link controller="livre" action="show" id="${o.id}">${o?.titre}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${auteurInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="auteur.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${auteurInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>
