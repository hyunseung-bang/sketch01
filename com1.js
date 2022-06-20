alert("git-1");

$(function () {
    try {
      initLanguage();

    } catch(e) {
        alert(e);
    }
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
