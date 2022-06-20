
    $(function () {
        alert("initJoinHeader s");
        initJoinHeader(1);
        alert("initLanguage s");
        initLanguage();
        alert("loadNotice s");
        loadNotice();
         alert("isDebug = " + $.isDebug());
        alert("phone");
        $("#phone").click(function () { kmcCertCreate(); });
        alert("ipin");
        $("#ipin").click(function () { ipinCertCreate(); });
        alert("receiveMessage");
        window.addEventListener("message", receiveMessage, false);
 alert("isDebug = " + $.isDebug());
        if($.isDebug()) console.log("procSystem = APP01 - ");      

       alert("APP01");
       alert(sessionStorage);
       alert(localStorage);
        if( "APP01" ) {
            if($.isDebug()) console.log("SET procSystem - APP01 - ");
            sessionStorage.setItem("procSystem", "APP01");
            sessionStorage.setItem("userAgent", "");
        }

        if( localStorage.getItem("SPS") ) {
            if($.isDebug()) console.log("SET SPS procSystem - " + localStorage.getItem("SPS"));
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
        $.get("member-join-notice").done(function (response) {
            $(".mo-note").html(`<img src="${response.data.appImgPath}"/>`);
            $(".pc-note").html(`<img src="${response.data.webImgPath}"/>`);
        });
    }
    function kmcCertCreate() {
        $.post("/kmc-cert-create").done(function (response) {
            if( $.isDebug() ) console.log(response);
            if(response.success) {
                openKmcCertWindow(response.data);
            } else {
                alert("A temporary failure occurred while generating credentials. Please try again in a moment.");
            }
        });
    }
    function openKmcCertWindow(data) {
        if( $.isDebug() ) console.log(data);
        $("input[name='tr_cert']").val(data.tr_cert);
        $("input[name='tr_url']").val(data.tr_url);
        $("input[name='tr_add']").val(data.tr_add);

        if( $.isMobile() ) {
            document.reqKMCISForm.target = "_blank";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        } else {
            const KMCIS_window = window.open("", "KMCISWindow", "width=425, height=550, resizable=0, scrollbars=no, status=0, titlebar=0, toolbar=0, left=435, top=250");
            if (KMCIS_window == null) {
                alert("※ Click the pop-up blocker notification bar at the top of the screen to allow pop-ups.");
                return;
            }
            document.reqKMCISForm.target = "KMCISWindow";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        }
    }
    function ipinCertCreate() {
        if( $.isDebug() ) console.log("아이핀 인증데이터 생성");
        $.post("/ipin-cert-create").done(function (response) {
            if( $.isDebug() ) console.log(response);
            if(response.success) {
                openIPinCertWindow(response.data)
            } else {
                alert("A temporary failure occurred while generating credentials. Please try again in a moment.");
            }
        });
    }
    function openIPinCertWindow(data) {
        $("#enc_data").val(data);
        if( $.isMobile() ) {
            document.form_ipin.target = "_blank";
            document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
            document.form_ipin.submit();
        } else {
            const certWindow = window.open('', 'popupIPIN2', 'width=450, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
            if (certWindow == null) {
                alert("※ Click the pop-up blocker notification bar at the top of the screen to allow pop-ups.");
                return;
            }
            document.form_ipin.target = "popupIPIN2";
            document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
            document.form_ipin.submit();
        }
    }
    function receiveMessage(event) {
        if( $.isDebug() ) { console.log("인증결과수신"); console.log(event) }
        if( event && event.data && event.data.success ) {
            memberJoinAvail();
        } else {
            alert("The credentials do not exist.");
        }
    }
