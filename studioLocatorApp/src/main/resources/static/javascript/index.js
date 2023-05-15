function clearCookies(){
    document.cookie = "username=; max-age=-1; path=/;";
    document.cookie = "password=; max-age=-1; path=/;";
}

document.getElementById("signOut").addEventListener("click", clearCookies);