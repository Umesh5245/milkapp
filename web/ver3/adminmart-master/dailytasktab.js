console.log(sessionStorage.getItem("email1"));
var email_id=sessionStorage.getItem("email1");
var   email_id_cus=email_id+"_customers"
console.log(email_id_cus);
sessionStorage.setItem("email_id_cus", email_id_cus);

console.log(sessionStorage.getItem("email_id_cus"));
var email_id_cus=sessionStorage.getItem("email_id_cus");
console.log(email_id_cus);
var d = new Date();
var n = d.getDate();

console.log(n);
if(n>"23  ")
{
  console.log("helloooo");

}
else
{
  console.log("noo");
}
                var exRef = db2.collection(email_id_cus);
var allex = exRef
  .get()
  .then(snapshot => {
    snapshot.forEach(doc => {

        const abcd=document.querySelector("#abcd");
       
        var sub_email = doc.data().email;
        var estEndDate = doc.data().estEndDate;
        var address = doc.data().address;
        var phone = doc.data().phone;
        var product = doc.data().product;
        var quantity = doc.data().quantity;
        var startDate = doc.data().startDate;     
        var vac_email=sub_email+"_vacation";
        var EName=doc.data().name
        console.log(vac_email);
        var d = new Date();
        var n = d.getDate();
        var vac_email2=vac_email+"st";
        var vac_email3=vac_email+"en";

temp1(vac_email);
        console.log(sessionStorage.getItem(vac_email2));

var startV= sessionStorage.getItem(vac_email2);
var endV= sessionStorage.getItem(vac_email3);


console.log(startV);
console.log(endV);
console.log(n);
if(n<startV){
        document.getElementById("ename").innerText = EName.toString();
        document.getElementById("email_subs").innerText = sub_email;
        document.getElementById("end_date").innerText = estEndDate;
        document.getElementById("address").innerText = address;
        document.getElementById("phone").innerText = phone;
        document.getElementById("product").innerText = product;
        document.getElementById("quantity").innerText = quantity;
        document.getElementById("startdate").innerText = startDate;
abcd.innerHTML +="<tr><th>"+EName+"</th><th>"+sub_email+"</th><th>"+startDate+"</th><th>"+estEndDate+"</th><th>"+address+"</th><th>"+phone+"</th><th>"+product+"</th><th>"+quantity+"</th></tr>";
}
else if( n>endV){
  document.getElementById("ename").innerText = EName.toString();
  document.getElementById("email_subs").innerText = sub_email;
  document.getElementById("end_date").innerText = estEndDate;
  document.getElementById("address").innerText = address;
  document.getElementById("phone").innerText = phone;
  document.getElementById("product").innerText = product;
  document.getElementById("quantity").innerText = quantity;
  document.getElementById("startdate").innerText = startDate;
abcd.innerHTML +="<tr><th>"+EName+"</th><th>"+sub_email+"</th><th>"+startDate+"</th><th>"+estEndDate+"</th><th>"+address+"</th><th>"+phone+"</th><th>"+product+"</th><th>"+quantity+"</th></tr>";
}
      })})

      function temp1(vac_email){
          var  startV1=0;
          var endV1=0;
            var emaill = db3.collectionGroup(vac_email);
            emaill.get().then(function (querySnapshot) {
          querySnapshot.forEach(function (doc) {
      console.log(doc.id, ' => ', doc.data());
          startV1=doc.data().startV;
          endV1=doc.data().endV;
      console.log(startV1);
      var vac_email2=vac_email+"st";
      var vac_email3=vac_email+"en";

      sessionStorage.setItem(vac_email2,startV1);
      sessionStorage.setItem(vac_email3,endV1);
console.log(sessionStorage.getItem(vac_email3))
      console.log(sessionStorage.getItem(vac_email2));
          });
          });
    console.log(startV1);
          }