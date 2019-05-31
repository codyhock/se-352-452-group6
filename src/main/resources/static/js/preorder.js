function skipPage(){
  var respond = confirm("Are you sure you want to SKIP?\nYou won't be able to come back to preorder food/drink/alcohol for this/these ticket(s)")
  if (respond == false) {
    // window.location = self.location.reload(true);
    // window.location.reload();
    window.location = "preorderForm.html";
  }
}

function goBack() {
  window.history.back()
};
