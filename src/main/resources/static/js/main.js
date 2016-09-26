/**
 * Created by dimon on 26.09.2016.
 */
$(document).ready(function () {
    $(".bidHref").click(function (e) {
        var block = $(this).parent().parent();
        var element = $(block).find(".bidBooks").toggle();
    });
});