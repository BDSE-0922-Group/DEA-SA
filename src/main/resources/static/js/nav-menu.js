   const toggleNavMenu = () => {
        var navMenu = document.getElementById("navMenu");
        var navMenuBtn = document.getElementById("headerMenuBtn");
        navMenuBtn.classList.toggle("opened");
        navMenu.classList.toggle("opened");
    };

    //  FORM ERROR 
    if ($('.error-text').is(':empty')) {
        // ERROR TEXT HIDDEN BY DEFAULT 
        $(".error-popup").css("visibility", "hidden");
    } else {
        $(".error-popup").css("visibility", "visible");
        $(".error-popup").fadeIn("fast");
        setTimeout(function () {
            $(".error-popup").fadeOut("fast");
        }, 15000);
    }
    function closeFormError() {
        $(".error-popup").fadeOut("fast");
    }
    
//  LOGIN POPUP
    if ($('.login-text').is(':empty')) {
        // LOGIN TEXT HIDDEN BY DEFAULT 
    	$('.login-text').css("visibility", "hidden");
    } else {
        $(".login-popup").css("visibility", "visible");
    	$(".error-popup").fadeIn("fast");
    }