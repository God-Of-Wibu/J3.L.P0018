function readURL(input){
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
            $('#blah').css("display","block");
            $('.img-div').css("height","50%");
            $('.img-div').css("width","50%");
            $('.fa-plus-square').css("display","none");
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#add-img").change(function(){
    readURL(this);
});