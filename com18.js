
    $(function () {
        alert("initJoinHeader s");
        initJoinHeader(1);
        alert("initLanguage s");
        initLanguage();
        alert("loadNotice s");
        loadNotice();
        

    });
    function initLanguage() {
        if( !g_lang || g_lang === "ko") {
            $("#language-ko").hide();
            $("#language-en").show();
        } else {
            $("#language-ko").show();
            $("#language-en").hide();
        }
        $("#language-ko").click(function() {
            $.get('/language-change/ko').done(function(result) { location.reload(); });
        });
        $('#language-en').click(function() {
            $.get('/language-change/en').done(function(result) { location.reload(); });
        });
    }
    function loadNotice() {
        $.get("member-join-notice").done(function (response) {
            $(".mo-note").html(`<img src="${response.data.appImgPath}"/>`);
            $(".pc-note").html(`<img src="${response.data.webImgPath}"/>`);
        });
    }
   
