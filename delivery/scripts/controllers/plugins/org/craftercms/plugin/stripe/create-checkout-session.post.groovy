import plugins.org.craftercms.plugin.stripe.form.DefaultFormHandler

logger.info("New stripe form submission")

def formId = params.formId

def handler = applicationContext."${formId}FormHandler"

if (!handler) {
    logger.info("No form handler found for form $formId")
    handler = new DefaultFormHandler()
}

return handler.handle(params, request, response, pluginConfig, siteItemService)