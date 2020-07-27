$(document).ready(function() {
    $.ajax({
        url: "/book"
    }).then(function(data) {
        $('.book-title').append(data.title);
        $('.book-author').append(data.author);
    });
});
