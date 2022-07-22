


print("aura_env.procStep", aura_env.procStep)
if aura_env.procStep == nil then
    aura_env.procStep = 101
end
print("aura_env.procStep", aura_env.procStep)

function cvnt(s) return "|cffaaffaa" .. s .. "|r " end

function br()
    return "---------------------------------------------------------\n"
end

function tit(s)
    return "---------------------------------------------------------\n" .. s .. "\n"
end


function unit(n, a)
    local s = "|cffffaaff[" .. n .. "]|r "
    if a ~= nil then s = s .. a end
    return s;
end

function skill(n, a)
    local s = ""
    if n ~= nil then s = "|cffffeb3b[" .. n .. "]|r " end
    if a ~= nil then s = s .. a end
    return s
end

function noti(n, a)
    local s = ""
    if n ~= nil then s = "|cffffeb3b[" .. n .. "]|r " end
    if a ~= nil then s = s .. a end
    return s
end

function life(n, a)
    local s = ""
    if n ~= nil then s = "|cffffeb3b[" .. n .. "]|r " end
    if a ~= nil then s = s .. a end
    return s
end
function pihagi(n, a)
    local s = ""
    if n ~= nil then s = "|cffffeb3b[" .. n .. "]|r " end
    if a ~= nil then s = s .. a end
    return s
end

function brk() return "---------------------------------------------------------\n" end


aura_env.guide = {
    ["A"] = {
        [98] = "",
        [99] = "",
        [100] = "",
        [101] = tit("1.")
                .. unit("관문지기 조마즈") .. life("광희의 고동", "생존기") .. br()
                .. unit("세관 경비원") .. noti("빛경화 지휘봉", "비격 or 마흠") .. noti("분열 수류탄", "바닥 피하기")
                .. brk(),
        [102] = tit("2. 경화주 첫블")
                .. unit("심문 전문가") .. skill("정지 광선", "1순위차단") .. skill("불꽃 화상", "여유되면 차단") .. br()
                .. unit("지원 장교") .. skill("초광속 화살", "차단") .. noti("빛경화 방벽", "비격 or 마흠") .. br()
                .. unit("세관 경비원") .. noti("빛경화 지휘봉", "비격 or 마흠") .. pihagi("분열 수류탄", "바닥 피하기")
                .. brk(),
        [103] = tit("3.")
                .. unit("심문 전문가") .. skill("정지 광선", "1순위차단") .. skill("불꽃 화상", "여유되면 차단") .. br()
                .. unit("지원 장교") .. skill("초광속 화살", "차단") .. noti("빛경화 방벽", "비격 or 마흠") .. br()
                .. unit("세관 경비원") .. noti("빛경화 지휘봉", "비격 or 마흠") .. pihagi("분열 수류탄", "바닥 피하기") .. br()
                .. unit("무장한 감독관") .. pihagi("광선 절삭기", "레이저 바닥 피하기")
                .. brk(),
        [104] = tit("4.")
                .. unit("조다흐")
                    .. life("광희의 고동", "생존기") .. br()
                    .. skill("강화된 구속의 문양", "칼차단") .. br()
                    .. pihagi("균열 폭발", "바닥보고피하기")
                .. brk(),
        [105] = tit("5.")
                .. unit("심문 전문가") .. skill("정지 광선", "1순위차단") .. skill("불꽃 화상", "여유되면 차단") .. br()
                .. unit("지원 장교") .. skill("초광속 화살", "차단") .. noti("빛경화 방벽", "비격 or 마흠") .. br()
                .. unit("세관 경비원") .. noti("빛경화 지휘봉", "비격 또는 마흠") .. pihagi("분열 수류탄", "바닥 피하기")
                .. brk(),
        [106] = tit("6. 1넴 조펙스(폭군 주 첫블 )")
                .. noti("밀수품 압수", "대상자 빠르게 무기 줍기") .. br()
                .. pihagi("무장 보안 회천 칼", "바닥에서 피하기") .. br()
                .. noti("심문 대상자", "넴드에서 멀리 떨어지고 억제장 깨주기, 심문 대상자 한테 다가갈때 넴드 앞에 있으면 안됨")
                .. brk(),
        [107] = tit("7.")
                .. unit("심문 전문가") .. skill("정지 광선", "1순위차단") .. skill("불꽃 화상", "여유되면 차단") .. br()
                .. unit("지원 장교") .. skill("초광속 화살", "차단") .. noti("빛경화 방벽", "비격 or 마흠") .. br()
                .. unit("세관 경비원") .. noti("빛경화 지휘봉", "비격 또는 마흠") .. pihagi("분열 수류탄", "바닥 피하기")
                .. brk(),
        [108] = tit("8.")
                .. unit("무장한 감독관(2마리)") .. pihagi("광선 절삭기", "레이저 바닥 피하기")
                .. brk(),
        [109] = tit("9.")
                .. unit("조코르스") .. skill("광선 절삭기", "레이저 바닥 피하기")
                .. brk(),
        [110] = tit("10.")
                .. unit("고대의 심장부 사냥개") .. skill("고대의 공포", "칼차단") .. skill("용함 숨결", "차단")
                .. brk(),
        [111] = tit("11.")
                .. unit("격노한 공포뿔") .. noti("광포한 돌진", "딜더들 계단 난간 위에서 딜")
                .. brk(),
        [112] = tit("12.")
                .. unit("광포한 밤표법(4마리)") .. skill("광란의 도려내기", "광역 cc")
                .. brk(),
        [113] = tit("13. 2넴")
                .. unit("알크록스") .. pihagi("걸신들린 잔치", "대상자 파티원과 떨어지기") .. pihagi("푸짐한 섭취", "2개의 시간차 원바닥 피하기") .. pihagi("호기의 손아귀", "알크록스에게서 떨어지기") .. br()
                .. unit("아칠라이트 탱커는 * 위치로 파킹") .. noti("정화 프로토콜", "대상자 산개 및 힐러 근딜 해제") .. noti("채찍질 프로토콜", "빠른 마흠 후 차단") .. noti("분툴 프로토콜", "대상자 령 목고 공격력 증가 버프 획득") .. br()
                .. unit("벤자 골드퓨즈 2블") .. noti("저주의 사슬", "대상자 깨기") .. noti("소용돌이치는 파멸", "시전할때 머리 떨어져서 저항")
                .. brk(),
        [114] = tit("14.")
                .. unit("시장 평화감시단(2마리)") .. skill("결사의 방진", "광역 cc기로 끊기")
                .. brk(),
        [115] = tit("15.")
                .. unit("사령관 조파르") .. noti("", "탱커, 근딜 * 위치 원딜, 힐러 @ 위치")
                .. brk(),
        [116] = tit("16.")
                .. unit("불량 분류기") .. skill("우리 열기", "무조건 CC기로 끊기") .. br()
                .. unit("우,정,국, 직원") .. noti("", "탱커 편지칼 디버프 쌓이면 생존기 신경 쓰기") .. br()
                .. unit("과부화된 우편의 정령") .. skill("악성 우편 분류기", "차단")
                .. brk(),
        [117] = tit("17.")
                .. unit("불량 분류기") .. skill("우리 열기", "무조건 CC기로 끊기") .. br()
                .. unit("우,정,국, 직원") .. noti("", "탱커 편지칼 디버프 쌓이면 생존기 신경 쓰기")
                .. brk(),
        [118] = tit("18.")
                .. unit("불량 분류기") .. skill("우리 열기", "무조건 CC기로 끊기") .. br()
                .. unit("우,정,국, 직원") .. noti("", "탱커 편지칼 디버프 쌓이면 생존기 신경 쓰기") .. br()
                .. unit("과부화된 우편의 정령") .. skill("악성 우편 분류기", "차단")
                .. brk(),
        [119] = tit("19.")
                .. unit("우정국장")
                .. noti("위험 용액", "보라색 원 파티원 각자 서서 맞기") .. br()
                .. noti("우편함", "파티원 다같이 맞기") .. br()
                .. noti("얼방, 거북상등", "무적기는 혼자 맞기") .. br()
                .. noti("불안정한 상품", "주워서 소각장에 던지기")
                .. brk(),
        [120] = tit("20.")
                .. unit("악기연주") .. noti("", "3번 연속 성공하여 공속 버프 받기") .. noti("", "난동꾼이 던지는 녹색 음료 던지기 맞지 않기(즉사)") .. br()
                .. unit("오아시스 보안요원") .. skill("위협적인 고함", "차단") .. life("보안 강타", "생존기 1개 이상 ") .. br()
                .. unit("방해꾼 손님") .. skill("초광속 화살", "차단") .. br()
                .. unit("조그론")
                    .. skill("위협적인 고함", "차단")
                    .. pihagi("군중제어 브레스", "피하기(조그론 뒤잡기)")
                    .. skill("억제의 불꽃", "조그론한테 당겨지다가 악기 연주로 벗어나서 공속 버프 유지하기")
                    .. skill("보안 강타", "생존기")
                .. brk(),
        [121] = tit("21. 막넴" .. unit("소아즈미") )
                .. pihagi("쾌검", "개걸음 하면 회피 가능") .. br()
                .. noti("마수", "탱커는 마수 위치 바로 보고 먼저 움직여서 파티원이 빠르게 따라 올 수 있도록 하기") .. br()
                .. skill("이단절기", "첫번째 끝 차단 -> 두번째 칼 차단") .. br()
                .. noti("분단", "분단 너머에선 딜 못하니 빠르게 포탈타고 오기")
                .. brk(),
        [122] = "",
        [123] = "",
        [124] = "",
        [125] = "",
        [126] = "",
        [127] = "",
        [128] = "",
        [129] = "",
        [130] = "",
    },
    ["B"] = {
        [98] = "",
        [99] = "",
        [100] = "",
        [101] = "",
        [102] = "",
        [103] = "",
        [104] = "",
        [105] = "",
        [106] = "",
        [107] = "",
        [108] = "",
        [109] = "",
        [110] = "",
        [111] = "",
        [112] = "",
        [113] = "",
        [114] = "",
        [115] = "",
        [116] = "",
        [117] = "",
        [118] = "",
        [119] = "",
        [120] = "",
        [121] = "",
        [122] = "",
        [123] = "",
        [124] = "",
        [125] = "",
        [126] = "",
        [127] = "",
        [128] = "",
        [129] = "",
        [130] = "",
    }
}



-------------------- 활성 조건


function(event, ...)

    if event == "CHAT_MSG_PARTY_LEADER" then
        if select(1, ...) == "!party" or select(1, ...) == "!파티" then
            local name, realm = UnitName("player")
            local className, classFilename, classId = UnitClass("player")
            SendChatMessage(name.."-"..aura_env.clazz[classId..""], "party")

            for i=1,4 do
                local name, realm = UnitName("party"..i)
                if name == nil then
                    SendChatMessage("파티원 없음", "party")
                else
                    local className, classFilename, classId = UnitClass("party"..i)
                    SendChatMessage(name.."-"..aura_env.clazz[classId..""], "party")
                end
            end
        end
    end

    if event == "PLAYER_REGEN_DISABLED" or event == "PLAYER_REGEN_ENABLED" then
        SendChatMessage("전투-"..event,"party")
        aura_env.marks["ging2"] = 2
        for i = 1,40 do
            local premarked = "nameplate"..i
            if GetRaidTargetIndex(premarked) then
                SendChatMessage(premarked,"party")
                SetRaidTarget(premarked,8)
                SetRaidTarget(premarked,8)
            end
        end
    end

    if event == "UPDATE_MOUSEOVER_UNIT" and GetRaidTargetIndex("mouseover") == nil then
        -- 2 동그라미 3 다이아 4 역삼 5 달
        local guid=UnitGUID("mouseover")
        local unitid=select(6, strsplit("-", guid))

        -- 165076 걸신들린 진드기 - 포식
        -- 162039 사악한 탄압자 - 영혼 파멸
        -- 167956 어둠의 수행사제 - 어두운 화살
        -- 162057 묘실의 파수병 - 돌가죽
        -- 162049 의심의 잔재
        -- 171799 심연의 감시관
        -- 172265 분노의 잔재
        if unitid == "165076" or unitid == "162039" or unitid == "167956" or unitid == "162057" or unitid == "162049" or unitid == "171799" or unitid == "172265" then
            SetRaidTarget("mouseover", aura_env.marks["ging2"])
            aura_env.marks["ging2"] = aura_env.marks["ging2"] + 1
            if aura_env.marks["ging2"] == 8 then aura_env.marks["ging2"] = 2 end
        end
    end
end

---------------------------- 동작
aura_env.marks = {}
aura_env.marks["ging2"] = 2

aura_env.clazz = {}
aura_env.clazz["1"] = "전사 [차단:들이치기(15s)] [버프-전투의외침(전투력5%)]"
aura_env.clazz["2"] = "성기사 [차단:비난(15s)]"
aura_env.clazz["3"] = "사냥꾼 [차단:재갈(15s)반격의사격(24s)]-[블:원초적분노(10m)]"
aura_env.clazz["4"] = "도적 [차단:발차기(15s)]"
aura_env.clazz["5"] = "사제 [차단:침묵(45s)]-[버프-신의권능:인내(체력5%)]"
aura_env.clazz["6"] = "죽기 [차단:정신얼리기(15s)]"
aura_env.clazz["7"] = "주술사 [차단:날카로운바람(12s)]-[블:피의욕망(10m)영웅심(10m)]"
aura_env.clazz["8"] = "법사 [차단:마법차단(24초)] [버프:신비한지능(지능5%)]-[블:시간왜곡(10m)]"
aura_env.clazz["9"] = "흑마 [차단:주문잠금(24s)도끼던지기(30s)]"
aura_env.clazz["10"] = "수도사 [차단:손날찌르기(15s)]"
aura_env.clazz["11"] = "드루 [차단:두개골강타(15s)태양광선(8s지속,60s)]"
aura_env.clazz["12"] = "악사 [차단:분열(15s)]"
