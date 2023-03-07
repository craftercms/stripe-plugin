def result = [:]

result.publishableKey = siteConfig.getString('stripe.publishableKey')
result.basicPrice = siteConfig.getString('stripe.basicPriceId')
result.proPrice = siteConfig.getString('stripe.proPriceId')
result.enterprisePrice = siteConfig.getString('stripe.enterprisePriceId')

return result
