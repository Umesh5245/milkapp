var jan=0;

  window.onload = function () {
    console.log(sessionStorage.getItem("email1"));
    var emailtemp=(sessionStorage.getItem("email1"));
   
    var docRef = db1.collection(emailtemp).doc("monthlyIncome");
var oct=0;
var nov=0;
var dec=0;
var feb=0;
    docRef.get().then(function(doc) {
        if (doc.exists) {
            console.log("Document data:", doc.data());
            oct=doc.data().oct;
            sessionStorage.setItem("oct", doc.data().oct);

            nov=doc.data().nov;
            sessionStorage.setItem("nov", doc.data().nov);

            dec=doc.data().dec;
            sessionStorage.setItem("dec", doc.data().dec);

            jan=doc.data().jan;
            sessionStorage.setItem("jan", doc.data().jan);

            console.log(jan);
            feb=doc.data().feb;
            sessionStorage.setItem("feb", doc.data().feb);


        } else {
            // doc.data() will be undefined in this case
            console.log("No such document!");
        }
    }).catch(function(error) {
        console.log("Error getting document:", error);
    });
    console.log(jan);
    var oct=(sessionStorage.getItem("oct"));
var oct1=parseFloat(oct);

var jan=(sessionStorage.getItem("jan"));
var jan1=parseFloat(jan);
var nov=(sessionStorage.getItem("nov"));
var nov1=parseFloat(nov);
var dec=(sessionStorage.getItem("dec"));
var dec1=parseFloat(dec);
var feb=(sessionStorage.getItem("feb"));
var feb1=parseFloat(feb);
    var chart = new CanvasJS.Chart("chartContainer",
    {
      title:{
        text: "Monthly sales"    
      },
      axisY: {
        title: "Income in Rupees"
      },
      legend: {
        verticalAlign: "bottom",
        horizontalAlign: "center"
      },
      data: [

      {        
        color: "#B0D0B0",
        type: "column",  
        showInLegend: true, 
        legendMarkerType: "none",
        dataPoints: [      
          { x: 5, y: feb1, label: "feb2020"},
        { x: 4, y: jan1, label: "jan2020"},
        { x: 3, y: dec1,  label: "dec2019 " },
        { x: 2, y: nov1,  label: "nov2019"},
        { x: 1, y: oct1,  label: "oct2019"},
    
        ]
      }
      ]
    });

    chart.render();
  }
  