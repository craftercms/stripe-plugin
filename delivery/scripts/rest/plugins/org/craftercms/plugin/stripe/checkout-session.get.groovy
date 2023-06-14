@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false),
    @Grab(group='com.google.code.gson', module='gson', version='2.10', initClass=false)
])

import com.stripe.model.checkout.Session
import com.stripe.Stripe
import com.google.gson.Gson

def sessionId = params.sessionId

if (!sessionId) {
    return [:]
}

Stripe.apiKey = pluginConfig.getString('secretKey')
Stripe.setAppInfo(
    'craftercms-plugin-stripe',
    '1.0.0',
    'https://github.com/phuongnq/craftercms-plugin-stripe'
)

Session session = Session.retrieve(sessionId)
Gson gson = new Gson()

return gson.toJson(session)