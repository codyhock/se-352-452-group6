function checkSeats() {

  var checkboxes = document.querySelectorAll('input[type="checkbox"]');
  var checked = Array.prototype.slice.call(checkboxes).some(x => x.checked);

  if (checked) {
    document.querySelectorAll('input[type="submit"]')[0].disabled = false;
  }
  else {
  document.querySelectorAll('input[type="submit"]')[0].disabled = true;
  }

}