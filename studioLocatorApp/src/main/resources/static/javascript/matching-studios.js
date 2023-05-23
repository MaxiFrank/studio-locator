//let studioDetailForm = document.getElementById('studio-detail-form')
let detailForms = document.querySelectorAll(".online-form");
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

const handleSubmit = async (e) =>{
    console.log("button activated")

    console.log(e.target.id.split(":")[0])
    console.log(e.target.id.split(":")[1])
    if (!(e.target.id.split(":")[0] === "form-submit")){
        return "3"}
    e.preventDefault()
    let id = e.target.id.split(":")[1]
    let note = document.getElementById('studio-detail'+ "-" +id)
    let isPublic = document.getElementById('is-private'+ "-" +id)
    let submitButtons = document.querySelectorAll(".detail-submit-button")
    let forms = document.querySelectorAll(".online-form")
    let rating = document.querySelector("#rating"+"-"+id).getAttribute("value")


    let studioName = document.getElementById('studio-name'+ "-" +id).innerHTML

    if (isPublic.value == "on"){
    isPublicBoolean = true}


    let bodyObj = {
        studioName: studioName,
        note: note.value,
        reviewScore: rating,
        isPublic: isPublicBoolean,
    }

    console.log(bodyObj);

    const response = await fetch(`${baseUrl}/matching-studios/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))


    try {const responseArr = await response.json()}
     catch(e){}

}
//Array.from(forms).forEach(form => console.log(form.getAttribute("id")));
Array.from(detailForms).forEach(form => form.addEventListener("click", handleSubmit));


//detailForms.addEventListener("click", handleSubmit());
