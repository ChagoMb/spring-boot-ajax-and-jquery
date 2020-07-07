$(document).ready(function () {

    $('#updateModal').on('show.bs.modal', function (event) {
        let button = $(event.relatedTarget) // Button that triggered the modal
        let id = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        let modal = $(this)
        modal.find($('#ident')).val(id)
    });

    $("#updateUserBtn").on("click", function () {
        $("#updateUserForm").on("submit", function (event) {
            event.preventDefault();
            ajaxPost();
        }).submit();
        return false
    });



    function ajaxPost() {

        let data = {
            id: $("#ident").val(),
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