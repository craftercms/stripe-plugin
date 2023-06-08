<#import "/templates/system/common/crafter.ftl" as crafter />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Stripe Checkout Sample</title>
    <meta name="description" content="A demo of Stripe Payment Intents" />

    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/normalize.css" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/global.css" />
    <!-- Load Stripe.js on your website. -->
    <script src="https://js.stripe.com/v3/"></script>
    <@crafter.head/>
  </head>

  <body>
    <@crafter.body_top/>
    <div class="togethere-background"></div>
    <div class="sr-root">
      <div class="sr-main">
        <header class="sr-header">
          <div class="sr-header__logo"></div>
        </header>
        <@crafter.h1 $field="heading_t">${contentModel.heading_t}</@crafter.h1>

        <div class="price-table-container">
          <@crafter.renderRepeatGroup
            $field="plans_o"
            $itemTag="section";
            item, index
          >
            <form action="/plugins/org/craftercms/plugin/stripe/create-checkout-session" method="POST">
              <input type="hidden" id="${item.priceId_s}" name="priceId" value="${item.priceId_s}">
              <@crafter.img
                $field="plans_o.thumbnail_s"
                $index="${index}"
                src="${item.thumbnail_s}"
                alt="item.title_s"
                height="120"
              />
              <@crafter.div
                $field="plans_o.title_s"
                $index="${index}"
                class="name"
              >
                ${item.title_s}
              </@crafter.div>
              <@crafter.div
                $field="plans_o.price_s"
                $index="${index}"
                class="name"
              >
                ${item.price_s}
              </@crafter.div>
              <div class="duration">per <@crafter.span $field="plans_o.recurring_s" $index="${index}">${item.recurring_s}</@crafter.span></div>
              <button id="basic-plan-btn">Select</button>
            </form>
          </@crafter.renderRepeatGroup>
        </div>
      </div>
    </div>
    <div id="error-message" class="error-message"></div>
    <@crafter.body_bottom/>
  </body>
</html>
