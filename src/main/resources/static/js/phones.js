function startPhones(phonesSize) {
    var index = phonesSize;

    $(".add-phone").click(function () {
        $('<div class="form-group">'+
        '<label for="phone' + index + '" class="col-sm-2 control-label"></label>'+
        '<div class="col-sm-10"><input id="phone' + index + '" name="phones[' + index + ']" type="text" class="form-control"/></div>'+
        '</div>')
            .insertBefore($(".form-group").last());
        index++;
    });

};


