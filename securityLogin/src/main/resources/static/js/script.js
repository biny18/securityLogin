$(document).ready(function() {

$("#cardForm").submit(function(event){
    event.preventDefault();
    addCard();
});

function addCard() {
    var question = document.getElementById("question").value;
    var answer = document.getElementById("answer").value;

    console.log(question);
    console.log(answer);

    $.ajax({
        url: '/addCard',
        type: 'POST',
        data: JSON.stringify({ 'question': question, 'answer': answer }),
        cache: false,
        success: function (data) {
            alert(data);
        },
        error: function (error) {
            alert(error);
        }
    });
}

function loadCardbox(){
    $.ajax({
        url: '/loadCardbox',
        type: 'GET',
        success: function onData (data) {
            console.log(data);
        },
        error: function onError (error) {
            console.error(error);
        }
    });
}

});
