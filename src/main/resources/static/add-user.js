$(document).ready(function () {

//sub form
    $("#addUserForm").on("submit", function (event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {

        const data = {
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