$(function () {
    // set active menu
    switch (menu){
        case 'About':
            $('#about').addClass('active');
            break;
        case 'Contact':
            $('#contact').addClass('active');
            break;
        case 'Home':
            $('#home').addClass('active');
            break;
    }
})