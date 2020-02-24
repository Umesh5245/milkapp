console.log("hello");
firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
       
        
        var user = firebase.auth().currentUser;
    
        if(user != null){
    
          var email_id = user.email;
          console.log(email_id);
          console.log(user);
  db1.collection("admin").get().then(snap => {
    snap.forEach(doc=>{
      console.log(doc.data().name);
      document.getElementById("demo").innerHTML = doc.data().name;
    document.getElementById("demo1").innerHTML = doc.data().name;
  console.log(doc.data().name);
      console.log(doc.id);
    });
  });
    
      } else {
        // No user is signed in.
       window.location.href = "authentication-login1.html";
    
        
    }}
    });
  
    function addDairyProduct(){
        var user = firebase.auth().currentUser;
var add_name=document.getElementById("add_name").value;
        db2.collection("admin").doc(user.email).set({
            product_name: add_name
        })
        .then(function() {
            console.log("Document successfully written!");
        })
        .catch(function(error) {
            console.error("Error writing document: ", error);
        });
    }
    
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
    