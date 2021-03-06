
function isDebug2() {
    alert(g_profile);
    return g_profile == "local";
}

function isDebug() {
    alert("isDebug");
    return g_profile == "local";
}


    $(function () {
        alert("initJoinHeader s");
      
      alert(g_profile);
      alert(isDebug());
      
        initJoinHeader(1);
        alert("initLanguage s");
        initLanguage();
        alert("loadNotice s");
        loadNotice();
        $("#phone").click(function () { 
          alert("phone click");
          kmcCertCreate(); 
        });
        $("#ipin").click(function () { ipinCertCreate(); });
        window.addEventListener("message", receiveMessage, false);

        if(isDebug()) console.log("procSystem = APP01 - ");

        if( "APP01" ) {
            if(isDebug()) console.log("SET procSystem - APP01 - ");
            sessionStorage.setItem("procSystem", "APP01");
            sessionStorage.setItem("userAgent", "");
        }

        if( localStorage.getItem("SPS") ) {
            if(isDebug()) console.log("SET SPS procSystem - " + localStorage.getItem("SPS"));
            sessionStorage.setItem("procSystem", localStorage.getItem("SPS"));
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
    function loadNotice() {
        $.get("/member-join-notice").done(function (response) {
            $(".mo-note").html(`<img src="${response.data.appImgPath}"/>`);
            $(".pc-note").html(`<img src="${response.data.webImgPath}"/>`);
        });
    }
    function receiveMessage(event) {
        if( isDebug() ) { console.log("??????????????????"); console.log(event) }
        if( event && event.data && event.data.success ) {
            memberJoinAvail();
        } else {
            alert("?????? ????????? ???????????? ????????????.");
        }
    }
    function memberJoinAvail() {
        if( isDebug() ) { console.log("???????????? ???????????? ??????");  }
        $.get("/member-join-avail").done(function(response) {
            if(isDebug()) { console.log(response);  }
            if(!response.success) {
                alert(response.errMessage);
                return;
            }
            if( response.data.status === "NEW" ) {
                location.href = "/member-join-form";
            } else {
                memberJoinNot(response.data.status, response.data.cardNo, response.data.joinDtFmt, response.data.reJoinDtFmt);
            }
        });
    }
    function kmcCertCreate() {
      alert("kmcCertCreate 1");
        $.post("/kmc-cert-create").done(function (response) {
          alert("kmcCertCreate 2");
          
          alert("kmcCertCreate 2 = " + isDebug());
          alert("kmcCertCreate 2 = " + response);
          
            if( isDebug() ) console.log(response);
          alert("kmcCertCreate 3");
            if(response.success) {
              alert("kmcCertCreate 4");
                openKmcCertWindow(response.data);
            } else {
                alert("???????????? ????????? ????????? ????????? ?????? ????????????. ????????? ?????? ????????? ?????????.");
            }
        });
    }
    function openKmcCertWindow(data) {
      alert("openKmcCertWindow 1");
        if( isDebug() ) console.log(data);
        $("input[name='tr_cert']").val(data.tr_cert);
        $("input[name='tr_url']").val(data.tr_url);
        $("input[name='tr_add']").val(data.tr_add);
alert("openKmcCertWindow 2");
        if( isMobile() ) {
            document.reqKMCISForm.target = "_blank";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        } else {
          alert("openKmcCertWindow 3");
            var KMCIS_window = window.open("", "KMCISWindow", "width=425, height=550, resizable=0, scrollbars=no, status=0, titlebar=0, toolbar=0, left=435, top=250");
            if (KMCIS_window == null) {
                alert("??? ?????? ????????? ?????? ?????? ?????? ???????????? ???????????? ????????? ????????? ????????? ????????????.");
                return;
            }
            document.reqKMCISForm.target = "KMCISWindow";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        }
    }
    function ipinCertCreate() {
        if( isDebug() ) console.log("????????? ??????????????? ??????");
        $.post("/ipin-cert-create").done(function (response) {
            if( isDebug() ) console.log(response);
            if(response.success) {
                openIPinCertWindow(response.data)
            } else {
                alert("???????????? ????????? ????????? ????????? ?????? ????????????. ????????? ?????? ????????? ?????????.");
            }
        });
    }
    function openIPinCertWindow(data) {
        $("#enc_data").val(data);
        if( isMobile() ) {
            document.form_ipin.target = "_blank";
            document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
            document.form_ipin.submit();
        } else {
            var certWindow = window.open('', 'popupIPIN2', 'width=450, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
            if (certWindow == null) {
                alert("??? ?????? ????????? ?????? ?????? ?????? ???????????? ???????????? ????????? ????????? ????????? ????????????.");
                return;
            }
            document.form_ipin.target = "popupIPIN2";
            document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
            document.form_ipin.submit();
        }
    }
    function memberJoinNot(status, cardNo, joinDtFmt, reJoinDtFmt) {
        $("#member-join-not").remove();
        var title, text, item;
        if( status === "AGE") {
            title = "???14??? ??????";
            text = "??????????????????<br/>??? 14??? ??????????????? ????????? ???????????????.";
            item = "";
        } else if( status === "WDRL") {
            title = "?????? ??????";
            text = "??????????????????<br/>???????????? ??????????????????.<br/>????????? 5??? ???????????? ?????? ?????? ?????????.";
            item = "<div class='alert-infor'><div class='form-ipt row'>"
                 + "    <dl class='form-item'><dt class='entry'>????????? ????????????</dt>"
                 + "    <dd class='comp'>" + reJoinDtFmt + "</dd></dl>"
                 +"</div></div>";
        } else if( status === "DUP") {
            title = "?????? ??????";
            text = "??????????????????<br/>?????? ?????????????????? ????????? ???????????????.";
            item = "<div class='alert-infor'><div class='form-ipt row'>"
                 + "    <dl class='form-item'><dt class='entry'>????????? ??????</dt><dd class='comp'>" + cardNo + "</dd></dl>"
                 + "    <dl class='form-item'><dt class='entry'>?????????</dt><dd class='comp'>" + joinDtFmt + "</dd></dl>"
                 + "</div></div>";
        } else {
            alert("NO");
        }

        var temp = ''
        + '<div id="member-join-not" class="popup sm type1 motion up on">'
        + '    <div class="popup-inner">'
        + '        <div class="popup-header">'
        + '            <h3 class="popup-title">' + title + '</h3>'
        + '            <span class="btn-popup-close"><button type="button"><span class="hide">??????</span></button></span>'
        + '        </div>'
        + '        <div class="popup-body">'
        + '            <div class="popup-body-inner">'
        + '                <div class="join-alert">'
        + '                    <div class="join-alert-inner">'
        + '                        <div class="alert-title">'
        + '                            <p class="text">' + text + '</p>'
        + '                        </div>'
        +                          item
        + '                    </div>'
        + '                </div>'
        + '            </div>'
        + '        </div>'
        + '        <div class="popup-btn">'
        + '            <div class="popup-btn-inner">'
        + '                <span class="btn btn-popup-close"><button type="button">??????</button></span>'
        + '            </div>'
        + '        </div>'
        + '    </div>'
        + '</div>';
        $(document.body).append(temp);
        popup_open("#member-join-not");
        popup_close_event(".btn-popup-close button");
    }
