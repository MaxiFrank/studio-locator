let locationForm = document.getElementById('additonal-location-form')
let zipCodeField = document.getElementById('zip_code_field')


const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/studios'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let params = {
        zipCode: zip_code_field.value,
    }

    const response = await fetch(`${baseUrl}/locate` + "?" + new URLSearchParams(params))
        .catch(err => console.error(err.message))

    const responseArr = await response.json()


    if (response.status === 200){
        window.localStorage.setItem("studios", responseArr[1]);
        window.location.replace(responseArr[0]);
    }
}
locationForm.addEventListener("submit", handleSubmit)