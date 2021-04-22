
const price = document.getElementById("btc-current-price");
const wallet = document.getElementById("btc-wallet-total");

const button = document.getElementById("refresh");

button.onclick=function(){
fetch("wallet/BTC" )
  .then(response => response.json())
  .then(data => {
    price.innerHTML=data.price;
    wallet.innerHTML=data.total * data.price;
  });
}
