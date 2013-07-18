
<%@ page import="grails.camel.Template" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'template.label', default: 'Template')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-template" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-template" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list template">
			
				<g:if test="${templateInstance?.body}">
				<li class="fieldcontain">
					<span id="body-label" class="property-label"><g:message code="template.body.label" default="Body" /></span>
					
						<span class="property-value" aria-labelledby="body-label"><g:fieldValue bean="${templateInstance}" field="body"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${templateInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="template.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${templateInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${templateInstance?.dateUpdated}">
				<li class="fieldcontain">
					<span id="dateUpdated-label" class="property-label"><g:message code="template.dateUpdated.label" default="Date Updated" /></span>
					
						<span class="property-value" aria-labelledby="dateUpdated-label"><g:formatDate date="${templateInstance?.dateUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${templateInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="template.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${templateInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${templateInstance?.id}" />
					<g:link class="edit" action="edit" id="${templateInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
