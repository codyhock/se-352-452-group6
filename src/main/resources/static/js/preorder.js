function skipPage(){
  var respond = confirm("Are you sure you want to SKIP?\nYou won't be able to come back to preorder food/drink/alcohol for this/these ticket(s)")
  if (respond == false ) {
    window.location = self.location.reload(true);
  }
}

function goBack() {
  window.history.back()
};
