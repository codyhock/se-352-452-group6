function setTwoDecimal(event) {
    this.value = parseFloat(this.value).toFixed(2);
}

function skipPage(){
  var respond = confirm("Are you sure you want to SKIP?\nYou won't be able to come back to preorder food/drink/alcohol for this/these ticket(s)")
  // if (respond == true) {
  //   // document.location.href = "cart.html";
  // }
}

function goBack() {
  window.history.back()
};
