  window.onload = function () {
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
        { x: 1, y: 297571, label: "jan2020"},
        { x: 2, y: 267017,  label: "dec2019 " },
        { x: 3, y: 175200,  label: "nov2019"},
        { x: 4, y: 154580,  label: "oct2019"},
    
        ]
      }
      ]
    });

    chart.render();
  }
  