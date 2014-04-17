
<%@ page import="biblioj.Reservation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reservation.label', default: 'Reservation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reservation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link controller="livre" class="home" action="list">Liste des livres</g:link></li>
                <li><g:link controller="auteur" class="list" action="list">Liste des auteurs</g:link></li>
			</ul>
		</div>
		<div id="show-reservation" class="content scaffold-show" role="main">
			<h1>Votre réservation :</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reservation">
			
				<g:if test="${reservationInstance?.codeReservation}">
				<li class="fieldcontain">
					<span id="codeReservation-label" class="property-label"><g:message code="reservation.codeReservation.label" default="Code Reservation" /></span>
					
						<span class="property-value" aria-labelledby="codeReservation-label"><g:fieldValue bean="${reservationInstance}" field="codeReservation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.dateReservation}">
				<li class="fieldcontain">
					<span id="dateReservation-label" class="property-label"><g:message code="reservation.dateReservation.label" default="Date Reservation" /></span>
					
						<span class="property-value" aria-labelledby="dateReservation-label"><g:formatDate date="${reservationInstance?.dateReservation}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservationInstance?.livres}">
				<li class="fieldcontain">
					<span id="livres-label" class="property-label"><g:message code="reservation.livres.label" default="Livres" /></span>
						<g:each in="${reservationInstance.livres}" var="l">
						    <span class="property-value" aria-labelledby="livres-label">
                                - <g:link controller="livre" action="show" id="${l.id}">${l?.titre}</g:link>
                                <g:if test="${l?.nombreExemplairesDisponibles < 1}">
                                    (indisponible)
                                </g:if>
                            </span>
                        </g:each>
				</li>
				</g:if>
			
			</ol>
            <div id="form-panier">
                <g:if test="${nbLivreDispo > 0}">
                    <g:form controller="reservation" action="validerPanier" params='[idReservation: "${reservationInstance.id}"]'>
                        <g:submitButton id="btn-valid" name="confirmer" value="confirmer"/>
                    </g:form>
                </g:if>
                <g:form controller="livre" action="list">
                    <g:submitButton id="btn-cancel" name="annuler" value="annuler"/>
                </g:form>
            </div>
		</div>
	</body>
</html>
