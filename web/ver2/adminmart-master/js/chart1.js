
    var chart2 = new CanvasJS.Chart("chartContainer1", {
    animationEnabled: true,  
    title:{
        text: "Music Album Sales by Year"
    },
    axisY: {
        title: "Units Sold",
        valueFormatString: "#0,,.",
        suffix: "mn",
        stripLines: [{
            value: 3366500,
            label: "Average"
        }]
    },
    data: [{
        yValueFormatString: "#,### Units",
        xValueFormatString: "YYYY",
        type: "spline",
        dataPoints: [
            {x: new Date(2002, 0), y: 6944000},
            {x: new Date(2003, 0), y: 6944000},
            {x: new Date(2004, 0), y: 6944000},
            {x: new Date(2005, 0), y: 6944000},
            {x: new Date(2006, 0), y: 6026000},
            {x: new Date(2007, 0), y: 6944000},
            {x: new Date(2008, 0), y: 6944000},
            {x: new Date(2009, 0), y: 6944000},
            {x: new Date(2010, 0), y: 6944000},
            {x: new Date(2011, 0), y: 4830000},
            {x: new Date(2012, 0), y: 2009000},
            {x: new Date(2013, 0), y: 6944000},
            {x: new Date(2014, 0), y: 6944000},
            {x: new Date(2015, 0), y: 6944000},
            {x: new Date(2016, 0), y: 6944000},
            {x: new Date(2017, 0), y: 6944000}
        ]
    }]
});
chart2.render();
