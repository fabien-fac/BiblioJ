<%@ page import="biblioj.TypeDocument" %>



<div class="fieldcontain ${hasErrors(bean: typeDocumentInstance, field: 'intitule', 'error')} ">
	<label for="intitule">
		<g:message code="typeDocument.intitule.label" default="Intitule" />
		
	</label>
	<g:textField name="intitule" value="${typeDocumentInstance?.intitule}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: typeDocumentInstance, field: 'livre', 'error')} required">
	<label for="livre">
		<g:message code="typeDocument.livre.label" default="Livre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="livre" name="livre.id" from="${biblioj.Livre.list()}" optionKey="id" required="" value="${typeDocumentInstance?.livre?.id}" class="many-to-one"/>
</div>

