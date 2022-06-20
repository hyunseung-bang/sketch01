
    $(function () {
        alert("initJoinHeader s");
        initJoinHeader(1);
        alert("initLanguage s");
        initLanguage();
        alert("loadNotice s");
        loadNotice();
        $("#phone").click(function () { kmcCertCreate(); });
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
        if( isDebug() ) { console.log("인증결과수신"); console.log(event) }
        if( event && event.data && event.data.success ) {
            memberJoinAvail();
        } else {
            alert("인증 정보가 존재하지 않습니다.");
        }
    }
    function memberJoinAvail() {
        if( isDebug() ) { console.log("회원가입 가능여부 체크");  }
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
        $.post("/kmc-cert-create").done(function (response) {
            if( isDebug() ) console.log(response);
            if(response.success) {
                openKmcCertWindow(response.data);
            } else {
                alert("인증정보 생성중 일시적 장애가 발생 했습니다. 잠시후 다시 시도해 주세요.");
            }
        });
    }
    function openKmcCertWindow(data) {
        if( isDebug() ) console.log(data);
        $("input[name='tr_cert']").val(data.tr_cert);
        $("input[name='tr_url']").val(data.tr_url);
        $("input[name='tr_add']").val(data.tr_add);

        if( isMobile() ) {
            document.reqKMCISForm.target = "_blank";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        } else {
            const KMCIS_window = window.open("", "KMCISWindow", "width=425, height=550, resizable=0, scrollbars=no, status=0, titlebar=0, toolbar=0, left=435, top=250");
            if (KMCIS_window == null) {
                alert("※ 화면 상단에 있는 팝업 차단 알림줄을 클릭하여 팝업을 허용해 주시기 바랍니다.");
                return;
            }
            document.reqKMCISForm.target = "KMCISWindow";
            document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
            document.reqKMCISForm.submit();
        }
    }
    function ipinCertCreate() {
        if( isDebug() ) console.log("아이핀 인증데이터 생성");
        $.post("/ipin-cert-create").done(function (response) {
            if( isDebug() ) console.log(response);
            if(response.success) {
                openIPinCertWindow(response.data)
            } else {
                alert("인증정보 생성중 일시적 장애가 발생 했습니다. 잠시후 다시 시도해 주세요.");
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
            const certWindow = window.open('', 'popupIPIN2', 'width=450, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
            if (certWindow == null) {
                alert("※ 화면 상단에 있는 팝업 차단 알림줄을 클릭하여 팝업을 허용해 주시기 바랍니다.");
                return;
            }
            document.form_ipin.target = "popupIPIN2";
            document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
            document.form_ipin.submit();
        }
    }
    function memberJoinNot(status, cardNo, joinDtFmt, reJoinDtFmt) {

    }
