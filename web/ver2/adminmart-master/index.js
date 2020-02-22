firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.

   
    var user = firebase.auth().currentUser;
console.log(user);
    if(user != null){

      var email_id = user.email ;
console.log(email_id);
sessionStorage.setItem("email1", email_id);

window.location.href = "index1.html";
var userId = firebase.auth().currentUser.uid;
var docRef = db.collection("admin").doc(email_id);


docRef.get().then(function(doc) {
    if (doc.exists) {
        console.log("Document data:", doc.data());

    } else {
        // doc.data() will be undefined in this case
        console.log("No such document!");
    }
}).catch(function(error) {
    console.log("Error getting document:", error);
});

}

  } else {
    // No user is signed in.
  //  window.location.href = "authentication-login1.html";

    
  }
});

function login(){

  var userEmail = document.getElementById("email_field").value;
  var userPass = document.getElementById("password_field").value;
  var docRef = db.collection("admin").doc(userEmail);
  sessionStorage.setItem("email", userEmail);

  console.log("heello"+docRef);
  docRef.get().then(function(doc) {
    if (doc.exists) {
        console.log("Document data:", doc.data());
        firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
          // Handle Errors here.
          var errorCode = error.code;
          var errorMessage = error.message;
      
          window.alert("Error : " + errorMessage);
      
          // ...
        });
   //     window.location.href = "authentication-login1.html";
    } else {
        // doc.data() will be undefined in this case
        alert("wrong User");
        firebase.auth().signOut();

        console.log("No such document!");
    }
}).catch(function(error) {
    console.log("Error getting document:", error);
});
  

  var user = firebase.auth().currentUser;
console.log("hello");

}
function logout(){
  alert("logout");
  firebase.auth().signOut();
  console.log("logout");
}

