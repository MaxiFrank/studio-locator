
//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("detail-form")
const detailContainer = document.getElementById("detail-container")

//Modal Elements
let detailBody = document.getElementById(`detail-body`)
let updateDetailBtn = document.getElementById('update-detail-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/details/"

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: document.getElementById("detail-input").value
    }
    await addDetail(bodyObj);
    document.getElementById("detail-input").value = ''
}

async function addDetail(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getDetails(userId);
    }
}

async function getDetails(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createDetailCards(data))
        .catch(err => console.error(err))
}

async function handleDelete(detailId){
    await fetch(baseUrl + detail, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getDetails(userId);
}

async function getDetailById(detailId){
    await fetch(baseUrl + detailId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}

async function handleDetailEdit(detail){
    let bodyObj = {
        id: detailId,
        body: detailBody.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getDetails(userId);
}

const createDetailCards = (array) => {
    detailContainer.innerHTML = ''
    array.forEach(obj => {
        let detailCard = document.createElement("div")
        detailCard.classList.add("m-2")
        detailCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.body}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                        <button onclick="getDetailById(${obj.id})" type="button" class="btn btn-primary" 
                        data-bs-toggle="modal" data-bs-target="#detail-edit-modal">
                        Edit
                        </button>
                    </div>
                </div>
            </div>
        `
        detailContainer.append(detailCard);
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateModal = (obj) =>{
    detailBody.innerText = ''
    detailBody.innerText = obj.body
    updateDetailBtn.setAttribute('data-detail-id', obj.id)
}

getDetails(userId);

submitForm.addEventListener("submit", handleSubmit)

updateDetailBtn.addEventListener("click", (e)=>{
    let detailId = e.target.getAttribute('data-detail-id')
    handleDetailEdit(detailId);
})