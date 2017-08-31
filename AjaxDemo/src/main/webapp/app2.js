
function btnListener()
{
    alert("ASDASDA");
    var promise = fetch('PersonServlet');
     promise.then(function (response) {
       return response.json();
     }).then(function (persons) 
     {
         console.log("AAAAAAAAAAAAAAAAAAAAAAA"+persons.length);
         var tableRows = persons.map(function(p)
         {
             return "<tr><td>"+p.fName+"</td><td>"+p.lName+"</td><td>"+p.phone+"</td><tr>";
         }).join("");
        document.getElementById("tbody").innerHTML = tableRows;
     });
}

document.getElementById("btn").addEventListener("click", btnListener);

