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



//how do I get the response out? I'd like to see the details dto here and set it in window.localStroage
// with name "studios-visited". Not finding an easy way to do it

//reason that it just goes in a loop isn't the fact that I am not logged in.
        if (response.status === 200){
            const detailDtoList = [];
            responseDetail.forEach(dto => {console.log(dto)})
            window.localStorage.setItem("studios-visited", responseDetail);
        }
}
// when I execute the function when the script is loaded, I shouldn't have to do anything else, right?
getStudiosVisited();