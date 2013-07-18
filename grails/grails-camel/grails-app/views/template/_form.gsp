<%@ page import="grails.camel.Template" %>



<div class="fieldcontain ${hasErrors(bean: templateInstance, field: 'body', 'error')} ">
	<label for="body">
		<g:message code="template.body.label" default="Body" />
		
	</label>
	<g:textField name="body" value="${templateInstance?.body}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: templateInstance, field: 'dateUpdated', 'error')} required">
	<label for="dateUpdated">
		<g:message code="template.dateUpdated.label" default="Date Updated" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateUpdated" precision="day"  value="${templateInstance?.dateUpdated}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: templateInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="template.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${templateInstance?.name}"/>
</div>

