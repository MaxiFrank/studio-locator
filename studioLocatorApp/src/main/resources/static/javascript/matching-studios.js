let studioDetailForm = document.getElementById('studio-detail-form')
let note = document.getElementById('studio-detail')
let isPublic = document.getElementById('is-private')

let studioName = document.getElementById('studio-name').innerHTML

if (isPublic.value == "on"){
isPublicBoolean = true}
let userId;
for (c of document.cookie.split(";")) {
        if (c.includes("username")){
        userId = c.split("=")[1]
        }
}

let rating = document.querySelector("#rating").getAttribute("value")

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/details'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        studioName: studioName,
        note: note.value,
        reviewScore: rating,
        isPublic: isPublicBoolean,
    }

    const response = await fetch(`${baseUrl}/matching-studios/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}
studioDetailForm.addEventListener("submit", handleSubmit)
