/* Fetch prices and update the form */
fetch("/api/plugins/org/craftercms/plugin/stripe/config.json")
  .then(r => r.json())
  .then(({ basicPrice, proPrice, enterprisePrice }) => {
    const basicPriceInput = document.querySelector('#basicPrice');
    basicPriceInput.value = basicPrice;
    const proPriceInput = document.querySelector('#proPrice');
    proPriceInput.value = proPrice;
    const enterprisePriceInput = document.querySelector('#enterprisePrice');
    enterprisePriceInput.value = enterprisePrice;
  })
