
<%@ page import="biblioj.Auteur" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'auteur.label', default: 'Auteur')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-auteur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link controller="livre" class="home" action="list">Liste des livres</g:link></li>
                <li><g:link controller="auteur" class="list" action="list">Liste des auteurs</g:link></li>
			</ul>
		</div>
		<div id="list-auteur" class="content scaffold-list" role="main">
			<h1>Liste des auteurs</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'auteur.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'auteur.prenom.label', default: 'Prenom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${auteurInstanceList}" status="i" var="auteurInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${auteurInstance.id}">${fieldValue(bean: auteurInstance, field: "nom")}</g:link></td>
					
						<td>${fieldValue(bean: auteurInstance, field: "prenom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${auteurInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
