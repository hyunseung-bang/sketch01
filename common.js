$.extend({
    isDebug: function() {
        alert(g_profile);
        return g_profile === "local";
    },
    userAgentInfo: new MobileDetect(window.navigator.userAgent),
    isMobile: () => $.userAgentInfo.mobile(),
});
$.fn.extend({
    isBlank: function() {
        if( this.val().trim() ) { return false; }
        return true;
    },
    isNotMobilPhone: function() {
        let regExp = /^01([0|1|6|7|8|9]?)-?(\d{3,4})-?(\d{4})$/;
        let match = this.val().trim().match(regExp);
        if( match ) return false;
        return true;
    },
    isNotEmail: function() {
        let emailVal = this.val();
        let regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        if (emailVal.match(regExp) != null) {
            return false;
        } else {
            return true;
        }
    }
});

$(() => {
    $( document ).ajaxStart(function() {
        $("#loadingBar").addClass('active');
    });
    $( document ).ajaxStop(function() {
        $("#loadingBar").removeClass('active');
    });
    $( document ).ajaxSend(function( event, jqxhr, settings ) {

    });
    $( document ).ajaxSuccess(function( event, xhr, settings ) {

    });
    $( document ).ajaxComplete(function( event, xhr, settings ) {
        if( $.isDebug() ) { console.log("4. ajaxComplete"); console.log(xhr.responseJSON); }
    });
    $( document ).ajaxError(function( event, jqxhr, settings, thrownError ) {
        if( $.isDebug() ) { console.log("ajaxError"); }
    });
});

function popup_close_event(target) {
    $(target).on('click', function () {
        popup_close(this);
    });
}
function popup_close(target) {
    if($(target).closest('.popup').length > 0) {
        $(target).closest('.popup').removeClass('on');
        /* popup - motion */
        if ($(target).closest('.popup').hasClass('motion')) {
            $(target).closest('.motion').find('.popup-dim').fadeOut("100", function() {$(this).remove();});
        }
        /* popup-toast */
        if ($(target).closest('.popup').is('.popup-toast')) return;
        scrollOff();
    }
}

