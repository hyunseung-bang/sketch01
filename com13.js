

$(function () {
    try {
      alert("git-10");
      initLanguage();
      loadNotice();
     
    } catch(e) {
        alert(e);
    }
});

<!-- 언어변경 -->
function initLanguage() {
alert("initLanguage");
alert("g_lang = " + g_lang);
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
<!-- 회원가입유의사항 -->
function loadNotice() {
    alert("loadNotice");
    $.get("/member-join-notice").done((response) => {
        alert(22);
        $(".mo-note").html('<img src="' + response.data.appImgPath + '"/>');
        alert(33);
        $(".pc-note").html('<img src="' + response.data.webImgPath + '"/>');
    });
}
