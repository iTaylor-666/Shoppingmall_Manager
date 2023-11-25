$(function(){
    $("#helloName").text(JSON.parse(localStorage.getItem("user")).realName)
})