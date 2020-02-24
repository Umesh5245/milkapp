console.log(sessionStorage.getItem("email1"));
var email_id=sessionStorage.getItem("email1");
var   email_id_cus=email_id+"_customers"
console.log(email_id_cus);
sessionStorage.setItem("email_id_cus", email_id_cus);

console.log(sessionStorage.getItem("email_id_cus"));
var email_id_cus=sessionStorage.getItem("email_id_cus");
console.log(email_id_cus);

                var exRef = db2.collection(email_id_cus);
var allex = exRef
  .get()
  .then(snapshot => {
    snapshot.forEach(doc => {
        const abcd=document.querySelector("#abcd");
        var EName = (doc.data().name);
        var sub_email = doc.data().email;
        var estEndDate = doc.data().estEndDate;
        var address = doc.data().address;
        var phone = doc.data().phone;
        var product = doc.data().product;
        var quantity = doc.data().quantity;
        var startDate = doc.data().startDate;     
console.log(EName);
        document.getElementById("ename").innerText = EName.toString();
        document.getElementById("email_subs").innerText = sub_email;
        document.getElementById("end_date").innerText = estEndDate;
        document.getElementById("address").innerText = address;
        document.getElementById("phone").innerText = phone;
        document.getElementById("product").innerText = product;
        document.getElementById("quantity").innerText = quantity;
        document.getElementById("startdate").innerText = startDate;
abcd.innerHTML +="<tr><th>"+EName+"</th><th>"+sub_email+"</th><th>"+startDate+"</th><th>"+estEndDate+"</th><th>"+address+"</th><th>"+phone+"</th><th>"+product+"</th><th>"+quantity+"</th></tr>";
      
      })})

      function search_table(){
        const abcd=document.querySelector("#abcd");
        var add= document.getElementById("subSelect").value ;
        alert(add);
        abcd.innerHTML ="<tr><th</th><th></th><th></th><th></th><th></th><th></th><th></th><th></th></tr>";

        var inputVal = document.getElementById("search_text").value;
console.log(inputVal);
console.log(email_id_cus)
        db2.collection(email_id_cus).where(add, "==", inputVal)
        .get()
        .then(function(querySnapshot) {
            querySnapshot.forEach(function(doc) {
                // doc.data() is never undefined for query doc snapshots
                console.log(doc.id, " => ", doc.data());
                var EName = (doc.data().name);
                var sub_email = doc.data().email;
                var estEndDate = doc.data().estEndDate;
                var address = doc.data().address;
                var phone = doc.data().phone;
                var product = doc.data().product;
                var quantity = doc.data().quantity;
                var startDate = doc.data().startDate;     
        console.log(EName);
                abcd.innerHTML +="<tr><th>"+EName+"</th><th>"+sub_email+"</th><th>"+startDate+"</th><th>"+estEndDate+"</th><th>"+address+"</th><th>"+phone+"</th><th>"+product+"</th><th>"+quantity+"</th></tr>";

            });
        })
        .catch(function(error) {
            console.log("Error getting documents: ", error);
        });
      }