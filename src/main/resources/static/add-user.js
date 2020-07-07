$(document).ready(function () {

//sub form
    $("#addUserBtn").on("click", function () {
        $("#addUserForm").on("submit", function (event) {
            event.preventDefault();
            ajaxPostAdd();
        });
    });

    function ajaxPostAdd() {

        let data = {
            firstName: $("#addFirstName").val(),
            lastName: $("#addLastName").val(),
            age: $("#addAge").val(),
            email: $("#addEmail").val(),
            password: $("#addPassword").val(),
            roles: $("#addRoles").val()
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