
  function reset_pass(){
    var userEm = document.getElementById("email_res").value;
auth.sendPasswordResetEmail(userEm).then(function(){
window.alert("emailsent");
})
.catch(function(error){
var ee=error.code;
console.log(ee);
});
}  