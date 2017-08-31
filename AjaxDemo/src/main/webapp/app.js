var makeTableRow = function (data) {
  return "<tr><td>" + data + "</td></tr>";
};

var filterValue = "";
var filterCallback = function (val) {
  if (filterValue === "") {
    return true;
  }
  return Number(val) < Number(filterValue);
};

var btnListener = function()
{
  var promise = fetch("Number")
   promise.then(function (response) 
   {
       return response.json();
   }).then(function (numbers)
        {
            filterValue = document.getElementById("filter").value;
            var rowsArray = numbers.filter(filterCallback).map(makeTableRow);
            var rows = rowsArray.join("");
            document.getElementById("tbody").innerHTML = rows;
        });
  
 filterValue = document.getElementById("filter").value;
  var rowsArray = textItems.filter(filterCallback).map(makeTableRow);
  var rows = rowsArray.join("");
  document.getElementById("tbody").innerHTML = rows;
  
};

document.getElementById("btn").addEventListener("click", btnListener);
document.getElementById("filter").addEventListener("keyup", btnListener);