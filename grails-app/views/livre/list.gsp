
<%@ page import="biblioj.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link controller="livre" class="home" action="list">Liste des livres</g:link></li>
                <li><g:link controller="auteur" class="list" action="list">Liste des auteurs</g:link></li>
			</ul>
		</div>

		<div id="list-livre" class="content scaffold-list" role="main">

            <form>
                <fieldset>
                    <legend>Recherche</legend>
                    <label for="select-type">Type de document : </label>
                    <select name="type" id="select-type">
                    <option value=""> </option>
                        <g:each in="${biblioj.TypeDocument.list()}" status="x" var="typeDocument">
                            <g:if test="${params.type == typeDocument.intitule}">
                                <option selected value="${typeDocument.intitule}">${typeDocument.intitule}</option>
                            </g:if>
                            <g:else>
                                <option value="${typeDocument.intitule}">${typeDocument.intitule}</option>
                            </g:else>
                        </g:each>
                    </select>
                    <br />
                    <label for="titre">Titre du livre : </label><input id="titre" type="text" name="titre" value="${params.titre}"><br>
                    <label for="auteur">Auteur : </label><input id="auteur" type="text" name="auteur" value="${params.auteur}"><br>
                    <input type="submit" value="Rechercher">
                </fieldset>
            </form>
            <br />

            <h1>Liste des livres</h1>

			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>

                        <g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" params="${params}"/>

                        <th>Auteur(s)</th>
					
						<g:sortableColumn property="typeDocument" title="${message(code: 'livre.typeDocument.label', default: 'Type de document')}" params="${params}" />
					
						<g:sortableColumn property="nombreExemplairesDisponibles" title="${message(code: 'livre.nombreExemplairesDisponibles.label', default: 'Disponibles')}" params="${params}" />

                       <th> </th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>

                        <td>

                            <g:each in="${livreInstance.auteurs}" status="j" var="auteur">
                                <g:link controller="auteur" action="show" id="${auteur.id}">
                                   <li>
                                        ${fieldValue(bean: auteur, field: "nom")}
                                        ${fieldValue(bean: auteur, field: "prenom")}
                                   </li>
                                </g:link>
                                &nbsp;
                            </g:each>

                        </td>
					
						<td>${fieldValue(bean: livreInstance.typeDocument, field: "intitule")}</td>
					
						<td class="td-center">${fieldValue(bean: livreInstance, field: "nombreExemplairesDisponibles")}</td>

                        <td>
                            <g:if test="${livreInstance.nombreExemplairesDisponibles > 0 && !reservationInstance.isContainsLivre(livreInstance.id)}">
                                <g:link controller="reservation" action="ajoutLivre" params='[idReservation: "${reservationInstance.id}", idLivre: "${livreInstance.id}"]'>
                                    <g:img dir="images" file="panier.png"></g:img>
                                </g:link>
                            </g:if>
                        </td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${livreInstanceTotal}" params="${params}"/>
			</div>
		</div>
	</body>
</html>
