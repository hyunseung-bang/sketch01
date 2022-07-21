
function cvnt(s) return "|cffaaffaa" .. s .. "|r " end
function unit(s) return "|cffffaaff[" .. s .. "]|r " end
function skill(s) return "|cffffeb3b[" .. s .. "]|r " end
function noti(s)  return "|cffffeb3b[" .. s .. "]|r " end


guide = {
    ["핏빛 심연"] = {},
    ["vlt2"] = {},
}

sanguine = guide["핏빛 심연"]

sanguine[1] = "1. 벤티르 령 버프 챙기기"
        .. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기"
sanguine[2] = "2."
        .. unit("제왕의 안개춤꾼") .. noti("메아리 치는 찌르기") .. "피하기, 탱커가 왼쪽 벽으로 유도"
        .. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기"
        .. unit("탐욕스러운 투사") .. skill("암영 충돌") .. "바닥 피하기"
sanguine[3] = "3. PASS 가능하면"
sanguine[4] = "4."
        .. unit("걸신들린 진드기") .. "3마리 " .. skill("포식") .. "1명씩 맡아서 차단 or CC기"
sanguine[5] = "5."
        .. unit("걸신들린 진드기") .. "2마리 " .. skill("포식") .. "1명씩 맡아서 차단 or CC기"
        .. unit("탐욕스러운 투사") .. noti("암영 충돌") .. "바닥 피하기"
sanguine[6] = "6. 1넴 탐식자 크릭시스 - 첫번째 블러드"
        .. " - " .. noti("포악한 박치기") .. "탱커 생존기 올리고 맞기"
        .. " - " .. skill("굶주린 흡수") .. "칼차단"
        .. " - " .. noti("육중한 돌격") .. "파티원 같이 맞기"
        .. " - " .. noti("절단의 강타") .. "멀리 산개, 파티원 체력 보면서 먹기"
sanguine[7] = "7. 1넴 위치로 폴링"
        .. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단"
        .. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제"
sanguine[8] = "8."
        .. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기"
sanguine[9] = "9. 벤티르 령 쪽으로 폴링"
        .. unit("고위 감시자") .. skill("암울한 폭발") .. "차단" .. noti("공포의 구속") .. "멀리 산개(or 자축, 대마보로 무시)"
        .. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제"
sanguine[10] = "10."
sanguine[11] = "11. 도비터 투물로 자블린 방까지 패스"
        .. unit("수석 관리인 자블린(야스오)") .. noti("휩쓰는 베기(하세기)") .. "머리 방향 회피" .. noti("뭉둑한 강타") .. "탱커 생존기 올리고 맞기"
        .. unit("꾀죄죄한 흙우걱이") .. noti("동기부여") .. "빨갛고 커지면 격노해제"
sanguine[12] = "12."
        .. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기"
        .. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
sanguine[13] = "13."
        .. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
        .. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단"
        .. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단"
        .. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기"
sanguine[14] = "14."
        .. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기"
        .. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
sanguine[15] = "15."
        .. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
        .. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단"
        .. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단"
sanguine[16] = "16."
        .. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
        .. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단"
        .. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단"
sanguine[17] = "17. 벤티르 령 버프 챙기기"
        .. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
        .. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기"
        .. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단"
        .. unit("광포한 구울") .. "탱커 아품 생존기 없으면 드리블, 광란 격노해제"
sanguine[18] = "18. 2넴 집행관 타르볼드 - 두번째 블러드"
        .. " - " .. noti("혹독") .. "대상자 혼자 맞기"
        .. " - " .. noti("찰나의 헌신") .. "최우선 점사, 죽으면 바닥생기니 뒤로 이동"
        .. " - " .. "왼쪽, 오늘쪽 구슬"
sanguine[19] = "19. 74 ~ 75% 맞추고 아래층으로"
        .. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기"
        .. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단"
        .. unit("광포한 구울") .. "탱커 아품 생존기 없으면 드리블, 광란 격노해제"
sanguine[20] = "20. 2마리 3마리 나눠서 잡기"
        .. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제"
sanguine[21] = "21. 3넴 대감독관 베릴리아 3번째 블러드"
        .. " - " .. noti("우월성의 의례") .. "구슬 먹기"
        .. " - " .. noti("끈없는 고뇌") .. "바닥 피하기"
        .. " - " .. noti("강철 쐐기") .. "탱커 생존기 1개 이상 올리기"
sanguine[22] = "22. 계단 중간으로 폴링, 다잡고 도비터 패스"
        .. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제"
        .. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기"
sanguine[23] = "23. "
sanguine[24] = "24. 막넴 장군 카알 복도"
        .. unit("장군카알(100-90%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화"
        .. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단"
        .. unit("가르곤") .. "탱커 어글 먹기"
sanguine[25] = "25. 벤티르 령 버프"
        .. unit("장군카알(90-80%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화"
        .. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단"
        .. unit("가르곤") .. "탱커 어글 먹기"
sanguine[26] = "26."
        .. unit("장군카알(80-70%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화"
        .. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단"
        .. unit("가르곤") .. "탱커 어글 먹기"
sanguine[27] = "27."
        .. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기"
sanguine[28] = "28."
        .. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기"
sanguine[29] = "29. [장군카알(70-50.3%)]"
        .. " - " .. noti("사악한 질주") .. "대상자 2명 산개해서 맞기"
        .. " - " .. noti("어스름 돌풍") .. "시전시 카알 앞에서 방패 활성화"
        .. " - " .. noti("관통의 진영") .. "첫번째 바닥 깔리는거 보고 옆에서 있다가 바로 들어가기"



print("aura_env.me.procStep", aura_env.me.procStep)
if aura_env.me.procStep == nil then
    aura_env.me.procStep = 1
end
print("aura_env.me.procStep", aura_env.me.procStep)

currentGuide = guide["핏빛 심연"];

local procStep = ""
local guideMsg

if procStep == "left" and aura_env.me.procStep > 1 then
    guideMsg = currentGuide[aura_env.me.procStep - 1]
    aura_env.me.procStep = aura_env.me.procStep - 1
end

if procStep == "right" then
    guideMsg = currentGuide[aura_env.me.procStep + 1]
    aura_env.me.procStep = aura_env.me.procStep + 1
end

if guideMsg ~= nil then
    return guideMsg
end


-- cocoba
