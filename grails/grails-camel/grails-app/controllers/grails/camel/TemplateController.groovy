package grails.camel

import org.springframework.dao.DataIntegrityViolationException

class TemplateController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [templateInstanceList: Template.list(params), templateInstanceTotal: Template.count()]
    }

    def create() {
        [templateInstance: new Template(params)]
    }

    def save() {
        def templateInstance = new Template(params)
        if (!templateInstance.save(flush: true)) {
            render(view: "create", model: [templateInstance: templateInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'template.label', default: 'Template'), templateInstance.id])
        redirect(action: "show", id: templateInstance.id)
    }

    def show(Long id) {
        def templateInstance = Template.get(id)
        if (!templateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "list")
            return
        }

        [templateInstance: templateInstance]
    }

    def edit(Long id) {
        def templateInstance = Template.get(id)
        if (!templateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "list")
            return
        }

        [templateInstance: templateInstance]
    }

    def update(Long id, Long version) {
        def templateInstance = Template.get(id)
        if (!templateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (templateInstance.version > version) {
                templateInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'template.label', default: 'Template')] as Object[],
                          "Another user has updated this Template while you were editing")
                render(view: "edit", model: [templateInstance: templateInstance])
                return
            }
        }

        templateInstance.properties = params

        if (!templateInstance.save(flush: true)) {
            render(view: "edit", model: [templateInstance: templateInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'template.label', default: 'Template'), templateInstance.id])
        redirect(action: "show", id: templateInstance.id)
    }

    def delete(Long id) {
        def templateInstance = Template.get(id)
        if (!templateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "list")
            return
        }

        try {
            templateInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'template.label', default: 'Template'), id])
            redirect(action: "show", id: id)
        }
    }
}
