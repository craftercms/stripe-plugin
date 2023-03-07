@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false)
])

import com.stripe.model.checkout.Session

Session checkoutSession = Session.retrieve(request.queryParams('sessionId'))
String customer = checkoutSession.getCustomer()
String domainUrl = siteConfig.getString('stripe.callbackDomain')

com.stripe.param.billingportal.SessionCreateParams params = new com.stripe.param.billingportal.SessionCreateParams.Builder()
    .setReturnUrl(domainUrl)
    .setCustomer(customer)
    .build()
com.stripe.model.billingportal.Session portalSession = com.stripe.model.billingportal.Session.create(params)

response.setStatus(303)
response.sendRedirect(portalSession.getUrl())

return ''