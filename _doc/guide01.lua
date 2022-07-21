


print("aura_env.procStep", aura_env.procStep)
if aura_env.procStep == nil then
    aura_env.procStep = 101
end
print("aura_env.procStep", aura_env.procStep)

function cvnt(s) return "|cffaaffaa" .. s .. "|r " end
function unit(s) return "|cffffaaff[" .. s .. "]|r " end
function skill(s) return "|cffffeb3b[" .. s .. "]|r " end
function noti(s)  return "|cffffeb3b[" .. s .. "]|r " end
function br() return "---------------------------------------------------------\n" end

aura_env.guide = {
    ["핏빛 심연"] = {},
    ["vlt2"] = {},
}

sanguine = aura_env.guide["핏빛 심연"]
sanguine[99] =  "-1\n"
sanguine[100] = "0\n"
sanguine[101] = br() .. "1. 벤티르 령 버프 챙기기\n" 
.. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기\n" .. br()
sanguine[102] = br() .. "2.\n" 
.. unit("제왕의 안개춤꾼") .. noti("메아리 치는 찌르기") .. "피하기, 탱커가 왼쪽 벽으로 유도\n"
.. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기\n"
.. unit("탐욕스러운 투사") .. skill("암영 충돌") .. "바닥 피하기\n" .. br()
sanguine[103] = br() .. "3. PASS 가능하면\n"  .. br()
sanguine[104] = br() .. "4.\n" 
.. unit("걸신들린 진드기") .. "3마리 " .. skill("포식") .. "1명씩 맡아서 차단 or CC기\n" .. br()
sanguine[105] = br() .. "5.\n" 
.. unit("걸신들린 진드기") .. "2마리 " .. skill("포식") .. "1명씩 맡아서 차단 or CC기\n"
.. unit("탐욕스러운 투사") .. noti("암영 충돌") .. "바닥 피하기\n" .. br()
sanguine[106] = br() .. "6. 1넴 탐식자 크릭시스 - 첫번째 블러드\n" 
.. " - " .. noti("포악한 박치기") .. "탱커 생존기 올리고 맞기\n"
.. " - " .. skill("굶주린 흡수") .. "칼차단\n"
.. " - " .. noti("육중한 돌격") .. "파티원 같이 맞기\n"
.. " - " .. noti("절단의 강타") .. "멀리 산개, 파티원 체력 보면서 먹기\n" .. br()
sanguine[107] = br() .. "7. 1넴 위치로 폴링\n" 
.. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단\n"
.. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제\n" .. br()
sanguine[108] = br() .. "8.\n" 
.. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기\n" .. br()
sanguine[109] = br() .. "9. 벤티르 령 쪽으로 폴링\n" 
.. unit("고위 감시자") .. skill("암울한 폭발") .. "차단" .. noti("공포의 구속") .. "멀리 산개(or 자축, 대마보로 무시)\n"
.. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제\n" .. br()
sanguine[110] = br() .. "10.\n"  .. br()
sanguine[111] = br() .. "11. 도비터 투물로 자블린 방까지 패스\n" .. br()
.. unit("수석 관리인 자블린(야스오)") .. noti("휩쓰는 베기(하세기)") .. "머리 방향 회피" .. noti("뭉둑한 강타") .. "탱커 생존기 올리고 맞기\n"
.. unit("꾀죄죄한 흙우걱이") .. noti("동기부여") .. "빨갛고 커지면 격노해제\n" .. br()
sanguine[112] = br() .. "12.\n" 
.. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기\n"
.. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n" .. br()
sanguine[113] = br() .. "13.\n" 
.. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n"
.. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단\n"
.. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단\n"
.. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기\n" .. br()
sanguine[114] = br() .. "14.\n" 
.. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기\n"
.. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n" .. br()
sanguine[115] = br() .. "15.\n" 
.. unit("연구 필경사") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n"
.. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단\n"
.. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단\n" .. br()
sanguine[116] = br() .. "16.\n" 
.. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n"
.. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단\n"
.. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단\n" .. br()
sanguine[117] = br() .. "17. 벤티르 령 버프 챙기기\n" 
.. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n"
.. unit("심연의 감시관") .. skill("날카로운 족좨") .. "차단" .. noti("분쇄의 일격") .. "탱커 생존기 올리고 맞기\n"
.. unit("분노의 잔재") .. skill("폭발적인 분노") .. "차단\n"
.. unit("광포한 구울") .. "탱커 아품 생존기 없으면 드리블, 광란 격노해제\n" .. br()
sanguine[118] = br() .. "18. 2넴 집행관 타르볼드 - 두번째 블러드\n" 
.. " - " .. noti("혹독") .. "대상자 혼자 맞기\n"
.. " - " .. noti("찰나의 헌신") .. "최우선 점사, 죽으면 바닥생기니 뒤로 이동\n"
.. " - " .. "왼쪽, 오늘쪽 구슬\n" .. br()
sanguine[119] = br() .. "19. 74 ~ 75% 맞추고 아래층으로\n" 
.. unit("연구 필경사:2마리") .. noti("폭발성 양피지") .. "바닥 회피, 연구물 던지기 아프니 각자 개인 생존기\n"
.. unit("마력 깃든 깃펜") .. skill("불꽃의 주술") .. "차단\n"
.. unit("광포한 구울") .. "탱커 아품 생존기 없으면 드리블, 광란 격노해제\n" .. br()
sanguine[120] = br() .. "20. 2마리 3마리 나눠서 잡기\n" 
.. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제\n" .. br()
sanguine[121] = br() .. "21. 3넴 대감독관 베릴리아 3번째 블러드\n" 
.. " - " .. noti("우월성의 의례") .. "구슬 먹기\n"
.. " - " .. noti("끈없는 고뇌") .. "바닥 피하기\n"
.. " - " .. noti("강철 쐐기") .. "탱커 생존기 1개 이상 올리기\n" .. br()
sanguine[122] = br() .. "22. 계단 중간으로 폴링, 다잡고 도비터 패스\n" 
.. unit("사악한 탄압자") .. skill("억제의 저주") .. "차단, 세면 빠른 저주 해제\n"
.. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기\n" .. br()
sanguine[123] = br() .. "23.\n"  .. br()
sanguine[124] = br() .. "24. 막넴 장군 카알 복도\n" 
.. unit("장군카알(100-90%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화\n"
.. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단\n"
.. unit("가르곤") .. "탱커 어글 먹기\n" .. br()
sanguine[125] = br() .. "25. 벤티르 령 버프\n" 
.. unit("장군카알(90-80%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화\n"
.. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단\n"
.. unit("가르곤") .. "탱커 어글 먹기\n" .. br()
sanguine[126] = br() .. "26.\n" 
.. unit("장군카알(80-70%)") .. noti("사악한 질주") .. "대상자 혼자 맞기" .. noti("어스름 돌풍") .. "시전시 방패 활성화\n"
.. unit("어둠의 수행사제") .. skill("어두운 화살") .. "차단\n"
.. unit("가르곤") .. "탱커 어글 먹기\n" .. br()
sanguine[127] = br() .. "27.\n" 
.. unit("묘실의 파수병") .. skill("돌가죽") .. "차단 세면 마흠" .. noti("절단의 분쇄") .. "탱커 생존기" .. noti("바위 파열") .. "바닥 피하기\n" .. br()
sanguine[128] = br() .. "28.\n" 
.. unit("공포의 사냥지배자") .. noti("폭발성 덫") .. "밟지 않기\n" .. br()
sanguine[129] = br() .. "29. [장군카알(70-50.3%)]\n" 
.. " - " .. noti("사악한 질주") .. "대상자 2명 산개해서 맞기\n"
.. " - " .. noti("어스름 돌풍") .. "시전시 카알 앞에서 방패 활성화\n"
.. " - " .. noti("관통의 진영") .. "첫번째 바닥 깔리는거 보고 옆에서 있다가 바로 들어가기\n" .. br()

aura_env.msg = sanguine[101] .. sanguine[102]





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
