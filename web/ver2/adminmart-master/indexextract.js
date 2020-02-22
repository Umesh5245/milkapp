firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
      // User is signed in.
  
     
      var user = firebase.auth().currentUser;
  
      if(user != null){
  
        var email_id = user.email;
  console.log(email_id);
  Window.location.href="index1.html";
      }
  
    } else {
      // No user is signed in.
     window.location.href = "authentication-login1.html";
  
      
    }
  });
  
  function login(){
  
    var userEmail = document.getElementById("email_field").value;
    var userPass = document.getElementById("password_field").value;
  
    firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
  
      window.alert("Error : " + errorMessage);
  
      // ...
    });
    var user = firebase.auth().currentUser;
  console.log(user)
  console.log("hello");
  }
  
  function logout(){
    alert("logout");
    firebase.auth().signOut();
    console.log("logout");
  }
  