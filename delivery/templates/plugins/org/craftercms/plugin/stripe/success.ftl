<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Stripe Checkout Sample</title>
    <meta name="description" content="A demo of Stripe Payment Intents" />

    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/normalize.css" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/global.css" />

    <script src="/static-assets/plugins/org/craftercms/plugin/stripe/js/success.js" defer></script>
  </head>

  <body>
    <div class="togethere-background"></div>
    <div class="sr-root">
      <div class="sr-main">
        <div class="sr-payment-summary completed-view">
            <h1>Your payment succeeded</h1>
            <h4>
              View CheckoutSession response:
            </h4>
          </div>
          <div class="completed-view-section">
            <pre>

            </pre>
            <button onclick="window.location.href = '/plans';">Restart demo</button>

            <form action="/plugins/org/craftercms/plugin/stripe/customer-portal" method="POST">
              <!-- In practice, use the Stripe customer ID on the server to redirect to the customer portal. This is for demo: -->
              <input type="hidden" name="sessionId" id="sessionId" />

              <button>Manage Billing</button>
            </form>
          </div>
        </div>
        <div class="sr-content">
        </div>
      </div>
    </div>
  </body>
</html>
