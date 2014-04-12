
<%@ page import="biblioj.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link controller="livre" class="home" action="list">Liste des livres</g:link></li>
                <li><g:link controller="auteur" class="list" action="list">Liste des auteurs</g:link></li>
			</ul>
		</div>
		<div id="show-livre" class="content scaffold-show" role="main">
			<h1>Detail du livre</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list livre">

                <g:if test="${livreInstance?.titre}">
                    <li class="fieldcontain">
                        <span id="titre-label" class="property-label"><g:message code="livre.titre.label" default="Titre" /></span>

                        <span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${livreInstance}" field="titre"/></span>

                    </li>
                </g:if>
			
				<g:if test="${livreInstance?.auteurs}">
				<li class="fieldcontain">
					<span id="auteurs-label" class="property-label"><g:message code="livre.auteurs.label" default="Auteurs" /></span>
					
						<g:each in="${livreInstance.auteurs}" var="a">
						<span class="property-value" aria-labelledby="auteurs-label"><g:link controller="auteur" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.nombreExemplaires}">
				<li class="fieldcontain">
					<span id="nombreExemplaires-label" class="property-label"><g:message code="livre.nombreExemplaires.label" default="Nombre Exemplaires" /></span>
					
						<span class="property-value" aria-labelledby="nombreExemplaires-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplaires"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.nombreExemplairesDisponibles}">
				<li class="fieldcontain">
					<span id="nombreExemplairesDisponibles-label" class="property-label"><g:message code="livre.nombreExemplairesDisponibles.label" default="Nombre Exemplaires Disponibles" /></span>
					
						<span class="property-value" aria-labelledby="nombreExemplairesDisponibles-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplairesDisponibles"/></span>
					
				</li>
				</g:if>
			
			</ol>

		</div>
	</body>
</html>
