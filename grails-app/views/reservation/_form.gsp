<%@ page import="biblioj.Reservation" %>



<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'codeReservation', 'error')} ">
	<label for="codeReservation">
		<g:message code="reservation.codeReservation.label" default="Code Reservation" />
		
	</label>
	<g:textField name="codeReservation" value="${reservationInstance?.codeReservation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'dateReservation', 'error')} required">
	<label for="dateReservation">
		<g:message code="reservation.dateReservation.label" default="Date Reservation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateReservation" precision="day"  value="${reservationInstance?.dateReservation}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'livres', 'error')} ">
	<label for="livres">
		<g:message code="reservation.livres.label" default="Livres" />
		
	</label>
	<g:select name="livres" from="${biblioj.Livre.list()}" multiple="multiple" optionKey="id" size="5" value="${reservationInstance?.livres*.id}" class="many-to-many"/>
</div>

