async function getStudiosVisited(){
let userId;
for (c of document.cookie.split(";")) {
        if (c.includes("username")){
        userId = c.split("=")[1]
        }
}

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/details'

const response = await fetch(`${baseUrl}/visited/user/${userId}`, {
        method: "GET",
        headers: headers}
        )
        .catch(err => console.error(err.message))

        const responseDetail = await response.json()

        if (response.status === 200){
            let details = JSON.stringify(responseDetail);
            window.localStorage.setItem("studios-visited", details);
            loadVisitedStudios();
    }
}

async function deleteDetails(userId, studioId) {


        const headers = {
            'Content-Type':'application/json'
        }

        const baseUrl = 'http://localhost:8080/api/v1/details'

        const response = await fetch(`${baseUrl}/${userId}/${studioId}`, {
                method: "DELETE",
                headers: headers}
                )
                .catch(err => console.error(err.message))

                const responseDetail = await response.json();

                if (response.status === 200){
                console.log("note deleted");
            }
          }



function deleteRow() {
    let userId;
    for (c of document.cookie.split(";")) {
            if (c.includes("username")){
            userId = c.split("=")[1];
            }
    }
    let objects = JSON.parse(window.localStorage.getItem("studios-visited"));


    document.querySelectorAll('#table .select:checked').forEach(e => {
            let studioId = document.querySelectorAll('#table .select:checked')[0].id;
            deleteDetails(userId, studioId);
            e.parentNode.parentNode.remove();

            Object.keys(objects).forEach(function(key){
              if (objects[key] === studioId) {
                delete objects[key];
              }
            });
            window.localStorage.setItem,("studios-visited", objects);
          });
}

function loadVisitedStudios(){
                let node = document.getElementById("studios-visited");
                let objects = JSON.parse(window.localStorage.getItem("studios-visited"));
                console.log(objects);
                let htmlInsert = "<table id='table'><tr><th></th><th>Studio Name</th><th>Your Notes</th><th>Review Score</th><th>Public</th></tr>";
                for (let i = 0; i < objects.length; i++){
                    htmlInsert = htmlInsert + "<tr><td><input type='checkbox' class='select'>" + "</td><td>" + `${objects[i].studioName}` + "</td><td>" + `${objects[i].note}` + "</td><td>" + `${objects[i].reviewScore}` + "</td><td>" + `${objects[i].isPublic}` + "</td></tr>";
                };

                htmlInsert = htmlInsert + "</table>" + "<button class='btn btn-light col-2' type='button' onclick='deleteRow();'>Remove</button>";
                node.insertAdjacentHTML('afterend', htmlInsert);
}

getStudiosVisited();