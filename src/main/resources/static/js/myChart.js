/**
 * common js to show project and employee data
 */
// create a json String from the HTML that is encoded
var prettyChartData = decodeHtml(chartData);
//parses thru the json and creates array
var chartJsonArray = JSON.parse(prettyChartData);
// number of objects in  json array
var arrayLength = chartJsonArray.length;
// arrays to store seperate data from jsonArray
var numericData = [];
var labelData = [];

//loop fills empty data arrays above
for (var i = 0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById('myPieChart'), {
	type: 'pie',
	data:{
		labels: labelData,
		datasets:[{
			label: ['PMA', 'Employee', 'Project'],
			backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
			borderColor:'rgb(255, 250, 245)',
			data: numericData
		}]
	},
		//config options
		options: {
			 plugins: {
      			legend: {
        		position: 'bottom',
     			},
			   title: {
					display: true,
					text: 'Project Statuses'
			}
		}
		}	
});

// [{"value": 1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"}, {...}]
function decodeHtml(html){
	 var txt = document.createElement("textarea");
	 txt.innerHTML = html;
	 return txt.value;
}