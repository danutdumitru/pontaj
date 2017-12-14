
function refreshTable()
{
	$.ajax({
	        url: "http://localhost:8080/pontaj"
	    }).then(function(data) {
	      var table ="";
	      var total = 0;
	      data.forEach ( 
	    	function(item)
	    	{
	    		table += "<tr>";
	    		table +="<td>" + item.day;
	    		table += "</td>";
	    		table +="<td>" + item.dayName;
	    		table += "</td>";
	    		table +="<td>" + item.hourStart;
	    		table += "</td>";
	    		table +="<td>" + item.hourEnd;
	    		table += "</td>";
	    		table +="<td>" + item.differenceMinutes;
	    		table += "</td>";
	    		table +="</tr>";
	    		total += item.differenceMinutes;
	    	}
	      );
	      table += "<tr><td>TOTAL</td><td></td><td></td><td></td><td>" + total + "</td>"
	      $("#tablePontaj > tbody").html(table);
	    });
}

