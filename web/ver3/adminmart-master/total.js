firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
       
        
        var user = firebase.auth().currentUser;
    
        if(user != null){
    
          var email_id = user.email;
          sessionStorage.setItem("email", user.email);
          // Retrieve
          console.log(sessionStorage.getItem("email"));
          console.log(email_id);
      var   email_id_cus=email_id+"_customers"
          console.log(email_id_cus);
          sessionStorage.setItem("email_id_cus", email_id_cus);

          var docRef = db2.collection("admin").doc(email_id);
console.log("hello"+email_id)
          
          docRef.get().then(function(doc) {
              if (doc.exists) {
                  console.log("Document data:", doc.data());
                  console.log(doc.data());
                  console.log(doc.data().name)
                  document.getElementById("demo").innerHTML = doc.data().name;
                  document.getElementById("demo11").innerHTML = doc.data().name;
                  console.log(document.getElementById("demo11").innerHTML = doc.data().name);
                            } else {
                  // doc.data() will be undefined in this case
                  console.log("No such document!");
              }
          }).catch(function(error) {
              console.log("Error getting document:", error);
          });  
      } }
    else{
           window.location.href = "authentication-login1.html";
  
    }
    
    
    });
  
    if(sessionStorage.getItem("email")==null)
    {
      sessionStorage.clear();
      console.log(sessionStorage.getItem("email"));
      firebase.auth().signOut();
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
      sessionStorage.clear();
      console.log(sessionStorage.getItem("email"));
      firebase.auth().signOut();
      console.log("logout");
    }
    