$(function () {
    // set active menu
    switch (menu){
        case 'About':
            $('#about').addClass('active');
            break;
        case 'Contact':
            $('#contact').addClass('active');
            break;
        default:
            $('#listProducts').addClass('active');
            $('#a_'+menu).addClass('active');
            break;
    }
})