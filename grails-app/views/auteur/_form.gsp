<%@ page import="biblioj.Auteur" %>



<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="auteur.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${auteurInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'oeuvres', 'error')} ">
	<label for="oeuvres">
		<g:message code="auteur.oeuvres.label" default="Oeuvres" />
		
	</label>
	<g:select name="oeuvres" from="${biblioj.Livre.list()}" multiple="multiple" optionKey="id" size="5" value="${auteurInstance?.oeuvres*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="auteur.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${auteurInstance?.prenom}"/>
</div>

