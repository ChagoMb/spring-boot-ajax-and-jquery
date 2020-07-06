$(document).ready(function () {

    $("#updateUserBtn").on("click", function () {
        $("#updateUserForm" + $("#tableBtn").attr("value")).on("submit", function (event) {
            event.preventDefault();
            ajaxPost();
        }).submit();
        return false
    });

    function ajaxPost() {

        let data = {
            id: $("#ident").attr("value"),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            age: $("#age").val(),
            email: $("#email").val(),
            password: $("#password").val(),
            roles: $("#roles").val()
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/admin/save",
            data: JSON.stringify(data),
            dataType: 'json',
            async: false,
            success: $(window).attr("location", "/admin")
        });

        location.reload()
    }
});