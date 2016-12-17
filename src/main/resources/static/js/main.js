/**
 * Created by dimon on 26.09.2016.
 */
var authorsCount = 1;

$(document).ready(function () {


    authorsCount = $(".author").length + 1;
    $("#addAuthor").click(function () {
        var authorsBlock="";
        authorsBlock += "<div id=author" + authorsCount + " class=\"author row\">";
        authorsBlock += "                    <div class=\"input-field col s4\">";
        authorsBlock += "                        <input class=\"validate\" id=\"first_name\" placeholder=\"Ім'я\" type=\"text\" name=\"authors[{0}].name\" value=\"\">";
        authorsBlock += "                        <label for=\"first_name\" class=\"active\">Автор<\/label>";
        authorsBlock += "                    <\/div>";
        authorsBlock += "                    <div class=\"input-field col s4\">";
        authorsBlock += "                        <input class=\"validate\" id=\"last_name\" type=\"text\" name=\"authors[{0}].lastName\" value=\"\">";
        authorsBlock += "                        <label for=\"last_name\">Прізвище<\/label>";
        authorsBlock += "                    <\/div>";
        authorsBlock += "                    <div class=\"input-field col s3\">";
        authorsBlock += "                        <input class=\"validate\" id=\"last_name\" type=\"text\" name=\"authors[{0}].middleName\" value=\"\">";
        authorsBlock += "                        <label for=\"last_name\">По-батькові<\/label>";
        authorsBlock += "                    <\/div>";
        authorsBlock += "                <\/div>";
        authorsBlock += "";
        authorsBlock = authorsBlock.format(authorsCount);
        $("#authors_block").append(authorsBlock);
        authorsCount++;
    });


    $("#deleteAuthor").click(function deleteAuthor(authorNumber) {
        if (authorsCount > 1) {
            authorsCount--;
            $("#author" + authorsCount).remove();
        }
    });

    // $("#authors_block").append("hello");
});



String.prototype.format = String.prototype.f = function(){
    var args = arguments;
    return this.replace(/\{(\d+)\}/g, function(m,n){
        return args[n] ? args[n] : m;
    });
};



