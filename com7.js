
alert("git-1");

$(function () {
    try {
      initLanguage();
      loadNotice();
      $("#phone").click(function () { kmcCertCreate(); });
      $("#ipin").click(function () { ipinCertCreate(); });
      window.addEventListener("message", receiveMessage, false);

      if($.isDebug()) console.log("procSystem = ${procSystem} - ${userAgent}");

      if( "${procSystem}" ) {
          if($.isDebug()) console.log("SET procSystem - ${procSystem} - ${userAgent}");
          sessionStorage.setItem("procSystem", "${procSystem}");
          sessionStorage.setItem("userAgent", "${userAgent}");
      }

      if( localStorage.getItem("SPS") ) {
          if($.isDebug()) console.log("SET SPS procSystem - " + localStorage.getItem("SPS"));
          sessionStorage.setItem("procSystem", localStorage.getItem("SPS"));
      }
    } catch(e) {
        alert(e);
    }
});

<!-- 언어변경 -->
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
<!-- 회원가입유의사항 -->
function loadNotice() {
    $.get("member-join-notice").done((response) => {
        $(".mo-note").html(`<img src="${response.data.appImgPath}"/>`);
        $(".pc-note").html(`<img src="${response.data.webImgPath}"/>`);
    });
}
<!-- 인증결과 수신 -->
function receiveMessage(event) {
    if( $.isDebug() ) { console.log("인증결과수신"); console.log(event) }
    if( event && event.data && event.data.success ) {
        memberJoinAvail();
    } else {
        <!-- 인증 정보가 존재하지 않습니다. -->
        alert('<@spring.message "ITGW0002"/>');
    }
}
<!-- 회원가입 가능여부 체크 -->
async function memberJoinAvail() {
    if( $.isDebug() ) { console.log("회원가입 가능여부 체크");  }
    let response = await $.get("/member-join-avail");
    if($.isDebug()) { console.log(response);  }
    if(!response.success) {
        alert(response.errMessage);
        return;
    }
    if( response.data.status === "NEW" ) {
        location.href = "/member-join-form";
    } else {
        memberJoinNot(response.data);
    }
}
<!--KMC 휴대폰인증 인증데이터 생성 -->
function kmcCertCreate() {
    $.post("/kmc-cert-create").done((response) => {
        if( $.isDebug() ) console.log(response);
        if(response.success) {
            openKmcCertWindow(response.data);
        } else {
            <!-- 인증정보 생성중 일시적 장애가 발생 했습니다. 잠시후 다시 시도해 주세요. -->
            alert('<@spring.message "ITGW0001"/>');
        }
    });
}
<!--KMC 휴대폰인증 화면 호출 -->
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
            <!-- ※ 화면 상단에 있는 팝업 차단 알림줄을 클릭하여 팝업을 허용해 주시기 바랍니다. -->
            alert('<@spring.message "ITGM0010"/>');
            return;
        }
        document.reqKMCISForm.target = "KMCISWindow";
        document.reqKMCISForm.action = "https://www.kmcert.com/kmcis/web/kmcisReq.jsp";
        document.reqKMCISForm.submit();
    }
}
<!--아이핀 인증데이터 생성 -->
function ipinCertCreate() {
    if( $.isDebug() ) console.log("아이핀 인증데이터 생성");
    $.post("/ipin-cert-create").done((response) => {
        if( $.isDebug() ) console.log(response);
        if(response.success) {
            openIPinCertWindow(response.data)
        } else {
            <!-- 인증정보 생성중 일시적 장애가 발생 했습니다. 잠시후 다시 시도해 주세요. -->
            alert('<@spring.message "ITGW0001"/>');
        }
    });
}
<!--아이핀 인증 화면 호출 -->
function openIPinCertWindow(data) {
    $("#enc_data").val(data);
    if( $.isMobile() ) {
        document.form_ipin.target = "_blank";
        document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
        document.form_ipin.submit();
    } else {
        const certWindow = window.open('', 'popupIPIN2', 'width=450, height=550, top=100, left=100, fullscreen=no, menubar=no, status=no, toolbar=no, titlebar=yes, location=no, scrollbar=no');
        if (certWindow == null) {
            <!-- ※ 화면 상단에 있는 팝업 차단 알림줄을 클릭하여 팝업을 허용해 주시기 바랍니다. -->
            alert('<@spring.message "ITGM0010"/>');
            return;
        }
        document.form_ipin.target = "popupIPIN2";
        document.form_ipin.action = "https://cert.vno.co.kr/ipin.cb";
        document.form_ipin.submit();
    }
}
<!-- 회원가입 불가시 안내 레이어 -->
function memberJoinNot({status, cardNo, joinDtFmt, reJoinDtFmt}) {
    $("#member-join-not").remove();
    let title, text, item;
    if( status === "AGE") {
        title = '<@spring.message "ITGM0095"/><#-- 만14세 미만 -->';
        text = '<@spring.message "ITGM0096"/><#-- 고객님께서는<br/>만 14세 미만이므로 가입이 불가합니다.-->';
        item = "";
    } else if( status === "WDRL") {
        title = '<@spring.message "ITGM0097"/><#-- 탈퇴 회원 -->';
        text = '<@spring.message "ITGM0098"/><#-- 고객님께서는<br/>얼마전에 탈퇴하셨군요.<br/>탈퇴후 5일 이후부터 가입 가능 합니다. -->';
        item = `<div class="alert-infor"><div class="form-ipt row">
                <dl class="form-item"><dt class="entry"><@spring.message "ITGM0099"/><#-- 재가입 가능일시 --></dt><dd class="comp">${r"${reJoinDtFmt}"}</dd></dl>
            </div></div>`;
    } else if( status === "DUP") {
        title = '<@spring.message "ITGM0100"/><#-- 기존 회원 -->';
        text = '<@spring.message "ITGM0101"/><#-- 고객님께서는<br/>기존 가입자이므로 신청이 불가합니다. -->';
        item = `<div class="alert-infor"><div class="form-ipt row">
                <dl class="form-item"><dt class="entry"><@spring.message "ITGM0102"/><#-- 멤버십 번호 --></dt><dd class="comp">${r"${cardNo}"}</dd></dl>
                <dl class="form-item"><dt class="entry"><@spring.message "ITGM0045"/><#-- 가입일 --></dt><dd class="comp">${r"${joinDtFmt}"}</dd></dl>
            </div></div>`;
    } else {
        alert("NO");
    }

    let temp = `
        <div id="member-join-not" class="popup sm type1 motion up on">
            <div class="popup-inner">
                <div class="popup-header">
                    <h3 class="popup-title">${r"${title}"}</h3>
                    <span class="btn-popup-close"><button type="button"><span class="hide"><@spring.message "ITGM0033"/><#-- 닫기 --></span></button></span>
                </div>
                <div class="popup-body">
                    <div class="popup-body-inner">
                        <div class="join-alert">
                            <div class="join-alert-inner">
                                <div class="alert-title">
                                    <p class="text">
                                        ${r"${text}"}
                                    </p>
                                </div>
                                ${r"${item}"}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="popup-btn">
                    <div class="popup-btn-inner">
                        <span class="btn btn-popup-close"><button type="button"><@spring.message "ITGM0018"/><#-- 확인 --></button></span>
                    </div>
                </div>
            </div>
        </div>
    `;
    $(document.body).append(temp);
    popup_open("#member-join-not");
    popup_close_event(".btn-popup-close button");
}
