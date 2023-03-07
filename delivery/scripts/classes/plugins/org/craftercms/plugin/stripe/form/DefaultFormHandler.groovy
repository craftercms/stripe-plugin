package plugins.org.craftercms.plugin.stripe.form

@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false)
])

import com.stripe.Stripe
import com.stripe.model.Event
import com.stripe.exception.*
import com.stripe.net.Webhook
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams

import groovy.util.logging.Slf4j

@Slf4j
class DefaultFormHandler implements FormHandler {
    def handle(params, request, response, siteConfig, siteItemService) {
        Stripe.apiKey = siteConfig.getString('stripe.secretKey')
        Stripe.setAppInfo(
            'craftercms-plugin-stripe',
            '1.0.0',
            'https://github.com/phuongnq/craftercms-plugin-stripe'
        )

        def domain = siteConfig.getString('stripe.callbackDomain')
        SessionCreateParams sessionParams = new SessionCreateParams.Builder()
            .setSuccessUrl(domain + '/plugins/org/craftercms/plugin/stripe/success.ftl?session_id={CHECKOUT_SESSION_ID}')
            .setCancelUrl(domain + '/plugins/org/craftercms/plugin/stripe/canceled.ftl')
            .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
            .addLineItem(new SessionCreateParams.LineItem.Builder()
                .setQuantity(1L)
                .setPrice(params.priceId)
                .build()
            )
            .build()
        try {
            Session session = Session.create(sessionParams)
            response.setStatus(303)
            response.sendRedirect(session.getUrl())
            return ''
        } catch(Exception e) {
            def responseData = [:]
            responseData.message = e.getMessage()
            println responseData
            return '/templates/plugins/org/craftercms/plugin/stripe/500.ftl'
        }
    }
}