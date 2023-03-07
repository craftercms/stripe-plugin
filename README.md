# CrafterCMS Stripe Plugin

A Stripe plugin which with recurring to subscribe to a service.

# Installation

1. Install the plugin via Studio's Plugin Management UI under `Site Tools` > `Plugin Management`

   OR You can also install this plugin by cloning this repository and using the Studio API.

    1a. Create a Studio JWT Token.

    1b. Execute the following CURL command a terminal

    ```bash
    curl --location --request POST 'http://SERVER_AND_PORT/studio/api/2/marketplace/copy' \
    --header 'Authorization: Bearer THE_JWT_TOKEN_FOR_STUDIO' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "siteId": "YOUR-PROJECT-ID",
      "path": "THE_ABSOLUTEL_FILE_SYSTEM_PATH_TO_THIS_REPO",
      "parameters": { }
    }
    ```

    OR You can aslo install this plugin by cloning this repository and using [Crafter CLI Commands](https://docs.craftercms.org/en/4.0/new-ia/reference/devcontentops-toolkit/copy-plugin.html)

2. Add your Stripe credentials and account information to `site-config.xml`:

```xml
<site>
    <version>4.0.1</version>
    <stripe>
      <publishableKey>${enc:CCE-V1#bUhsL6BI...}</publishableKey>
      <secretKey>${enc:CCE-V1#z48hAvk...}</secretKey>
      <webhookSecret>${enc:CCE-V1#sO73Bk+b...}</webhookSecret>
      <basicPriceId>price_1Mi...</basicPriceId>
      <proPriceId>price_1Mi...</proPriceId>
      <enterprisePriceId>price_1Mi...</enterprisePriceId>
      <callbackDomain>http://localhost:8080</callbackDomain>
    </stripe>
</site>
```

where:

* publishableKey
* secretKey
* webhookSecret
* basicPriceId
* proPriceId
* enterprisePriceId
* callbackDomain

Values starting with `${enc:...}` are encrypted text using [CrafterCMS Encryption Tool](https://docs.craftercms.org/en/4.0/system-administrators/activities/authoring/main-menu-encryption-tool.html#encryption-tool)