//const cafeList = document.querySelector('#cafe-list');

// create element & render cafe
/*function renderCafe(doc){
    let li = document.createElement('li');
    let name = document.createElement('span');
    let city = document.createElement('span');

    li.setAttribute('data-id', doc.id);
    name.textContent = doc.data().name;
    city.textContent = doc.data().city;

    li.appendChild(name);
    li.appendChild(city);

    cafeList.appendChild(li);
}
*/
// getting data
  var firebaseConfig = {
    apiKey: "AIzaSyBLgAMyz-eN56HATZtBI1rQMEqjihO_f7A",
    authDomain: "milkapp-95a9a.firebaseapp.com",
    databaseURL: "https://milkapp-95a9a.firebaseio.com",
    projectId: "milkapp-95a9a",
    storageBucket: "milkapp-95a9a.appspot.com",
    messagingSenderId: "128517309941",
    appId: "1:128517309941:web:01b5069508e2e6493e4cbc",
    measurementId: "G-QYBEMXRVZE"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  //        firebase.analytics();
  const auth = firebaseApp.auth();
const db = firebaseApp.firestore();

/*db.collection('dairy').get().then(snapshot => {
    snapshot.docs.forEach(doc => {
        console.log(doc.data())
        //renderCafe(doc);
    });
});*/
