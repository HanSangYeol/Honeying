package kr.ac.doowon.honeying.Util;

import java.util.ArrayList;
import java.util.List;

import kr.ac.doowon.honeying.Data.Restaurant;
import kr.ac.doowon.honeying.Data.Review;

public class GlobalUtil {


    public static final List<Restaurant> RESTAURANT_LIST = new ArrayList<>();
    public static final List<Review> REVIEW_LIST = new ArrayList<>();

    public static void RESTAURANT_DATA(){
        RESTAURANT_LIST.clear();
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/002/h118552a.jpg","할매보쌈",4,5,"서울 중랑구 면목3동 458-29 12/5",10.5f,0));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/008/zzmenuimg/h30230811_z.jpg","25시삼계탕",4,9,"충북 청주시 상당구 중앙로 49",8.2f,0));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/h4925596_z.jpg","대대손손묵집",3,12,"경기 포천시 소흘읍 죽엽산로447번길 11-3",5.1f,0));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/000/zzmenuimg/h4923404_z.jpg","고산떡갈비",5,6,"경기 의정부시 의정부1동 202-15",34.2f,0));
        //분식
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/b1022934_z.jpg","고수떡볶이",3,4,"서울 은평구 갈현로33길 5",15.1f,1));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/h4937768_z.jpg","고봉민김밥 수원인계점",2,5,"경기 수원시 팔달구 권광로 184",16.8f,1));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/t6001191_z.jpg","웨이브",4,2,"제주 서귀포시 표선면 표선당포로 10-4 3층",18.2f,1));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/b6000294_z.jpg","고래라면",3,5,"제주 서귀포시 성산읍 삼달로 104",25.8f,1));
        //중식
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/007/zzmenuimg/c40256732_z.jpg","아리원",4,5,"경기 안산시 단원구 광덕대로 251",13,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c102474181_z.jpg","첸수이",5,2,"서울 서초구 남부순환로 2614 한솔로이젠트 2층 215~7호",12,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/c40250524_z.jpg","씽차이",3,3,"경기 용인시 처인구 이동면 경기동로 663",32.7f,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c102554150_z.jpg","만강홍",2,4,"서울 서초구 서초동 1669-8 선인빌딩 1층",25.1f,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c10246420_z.jpg","공리",4,5,"서울 강남구 대치동 946-15 2F",26.9f,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/c1030354_z.jpg","일품향",5,6,"서울 종로구 종로 195 1층",27.9f,2));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c1030344_z.jpg","천희양꼬치",4,5,"서울 관악구 남부순환로230길 18",56.1f,2));

        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/j10423922_z.jpg","겐로쿠우동 건대직영점",4,5,"서울 광진구 능동로 111",23.2f,3));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/j10423922_z.jpg","하루 여의도점",3,2,"서울 영등포구 국제금융로2길 17 씨티프라자 3층",50.7f,3));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/j4033036_z.jpg","맛있는초밥집",3,3,"경기 성남시 분당구 양현로310번길 25",32.1f,3));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/j10422460_z.jpg","오후정 건대점",2,4,"서울 광진구 능동로13길 11 2,3층",43.4f,3));
        RESTAURANT_LIST.add(new Restaurant(1, "http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j4034215_z.jpg","감스시",3,4,"경기 수원시 장안구 서부로2123번길 17",23.5f,3));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j1037115_z.jpg","겐돈소바",4,5,"전북 전주시 덕진구 동가재미3길 50",12.2f,3));
        //파스타
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/r1074394_z.jpg","3MK",4,2,"서울 강남구 강남대로106길 29 1층",32.4f,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r1074439_z.jpg","블루브릿지",4,3,"서울 용산구 이태원로 208 3층",22.8f,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r7003034_z.jpg","04위로 엉클포크",4,4,"울산 남구 대학로84번길 16 4층 04위로",21.2f,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/007/zzmenuimg/r1066775_z.jpg","10꼬르소꼬모카페",5,5,"서울 강남구 압구정로 416 더트리티니플레이스 B1F",51.1f,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/007/zzmenuimg/r5001878_z.jpg","1977비스트로(1977BISTRO)",4,5,"전남 여수시 예울마루로 37-53",11.7f,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r60029312_z.jpg","거닐다",2,5,"제주 서귀포시 안덕면 태평감산로 9",11,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/r1070264_z.jpg","그랑씨엘",3,5,"서울 강남구 도산대로 45 16-6",11,4));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/008/zzmenuimg/r50015856_z.jpg","그리씨니비엔날레",3,5,"광주 서구 상무연하로 29 보라미빌딩",10,4));
        //돈까스
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j10424136_z.jpg","오후정 강남점",4,5,"서울 강남구 봉은사로6길 39 지상 1층",17.2f,5));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/000/zzmenuimg/r20011058_z.jpg","가을동화앤틱카페",3,4,"강원 강릉시 유죽길 455-12",18.2f,5));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/002/zzmenuimg/b1023225_z.jpg","강남옛날돈까스",3,6,"서울 강남구 강남대로84길 28 2층",22.f,5));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/r20008511_z.jpg","갤러리밥스(Gallery BOB'S)",4,5,"강원 강릉시 난설헌로 144",105.2f,5));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/j40330641_z.jpg","광명동굴카페",2,5,"경기 광명시 가학동85번길 142",17.2f,5));
        RESTAURANT_LIST.add(new Restaurant(1, "http://www.menupan.com/restaurant/restimg/007/zzmenuimg/d6007574_z.jpg","골방요리연구소",4,8,"제주 제주시 신성로13길 13-1 3층",21.f,5));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/j1040765_z.jpg","긴자바이",4,5,"서울 종로구 율곡로1길 37",72.2f,5));
        //족발보쌈
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/h4933034_z.jpg","족발삼촌",4,5,"경기 구리시 이문안로99번길 19",42.2f,6));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/003/zzmenuimg/h1197434_z.jpg","가장맛있는족발 선릉역점",4,5,"서울 강남구 테헤란로64길 27",52.2f,6));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/h49296411_z.jpg","감인족발",3,2,"경기 안양시 만안구 만안로 179",10.72f,6));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/h1208654_z.jpg","그날그날족발",4,2,"서울 영등포구 여의대방로 379 제일빌딩 204호",11.23f,6));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/001/zzmenuimg/h1201814_z.jpg","가보자굴보쌈",2,3,"서울 종로구 수표로20길 16-17",7.2f,6));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/009/zzmenuimg/h4926993_z.jpg","김정수할머니보쌈막국수",4,2,"경기 부천시 원미구 길주로560번길 48",5.4f,6));
        //카페디저트
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/008/zzmenuimg/d30095832_z.jpg","#BACKSTAGE",4,11,"충남 천안시 동남구 청수15길 5-18",3.2f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/d10376411_z.jpg","1984",3,8,"서울 마포구 동교로 194",4.2f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/004/zzmenuimg/d40216477_z.jpg","65디그리(65 Degrees)",4,5,"1234",10.7f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/d10296639_z.jpg","8b DOLCE",2,7,"경기 안양시 만안구 만안로 222-1 2층",30,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/d4022454_z.jpg","가비양 의왕호수점",4,5,"서울 강남구 압구정로14길 35",17,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/000/zzmenuimg/d60073045_z.jpg","941헤르츠(941Hz)",3,2,"경기 의왕시 학현로 170-47",9,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/006/zzmenuimg/d1026668_z.jpg","가라지107(GARAGE 107)",4,3,"제주 제주시 원노형로 37",7.2f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/r20008511_z.jpg","갤러리밥스(Gallery BOB'S)",2,5,"서울 종로구 북촌로 53",5.4f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/005/zzmenuimg/d20037568_z.jpg","강릉커피공원",4,4,"강원 강릉시 회산로385번길 91-9",7.2f,7));
        RESTAURANT_LIST.add(new Restaurant(1,"http://www.menupan.com/restaurant/restimg/000/zzmenuimg/d50098027_z.jpg","갤러리카페M",5,5,"전남 담양군 담양읍 죽향대로 1121",8.2f,7));







    }

    public static void REVIEW_DATA(){

        REVIEW_LIST.clear();
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/000/zzmenuimg/d50098040_z.jpg","http://www.menupan.com/restaurant/restimg/000/zzmenuimg/d5009801_z.jpg","http://www.menupan.com/restaurant/restimg/000/zzmenuimg/d5009802_z.jpg","blue118x",4,3,"커피 한 잔 하면서 그림도 구경하니 너무 좋네요~~","갤러리카페M","전남 담양군 담양읍 죽향대로 1121"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j10424138_z.jpg","http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j1042411_z.jpg","http://www.menupan.com/restaurant/restimg/001/zzmenuimg/j1042412_z.jpg","시우아빠",3,2,"가족들과함께 오후정강남점을 갔는데 도심 복잡함속에서 분위기가 아늑한 곳에서 여유롭게 일본 가정식 백반 참 맛있게잘먹었네요","오후정 강남점","서울 강남구 봉은사로6길 39 지상 1층"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/005/zzmenuimg/r20008515_z.jpg","http://www.menupan.com/restaurant/restimg/005/zzimg/r200085a_z.jpg","http://www.menupan.com/restaurant/restimg/005/zzmenuimg/r2000851_z.jpg","백일몽꿈",2,4,"돈까스랑 튀김이 눅눅하지 않고 맛있네요. 가끔씩 맥주 한 잔 하고 가는데 조용하고 한적해서 좋아요.","갤러리밥스(Gallery BOB'S)","서울 종로구 북촌로 53"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c1030341_z.jpg","http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c1030342_z.jpg","http://www.menupan.com/restaurant/restimg/004/zzmenuimg/c1030343_z.jpg","부산항8",6,2,"양꼬치에 칭따오!!!","천희양꼬치","서울 관악구 남부순환로230길 18"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/005/zzmenuimg/c1030357_z.jpg","http://www.menupan.com/restaurant/restimg/005/zzmenuimg/c1030358_z.jpg","http://www.menupan.com/restaurant/restimg/005/zzmenuimg/c1030352_z.jpg","삶의순간들",7,11,"탕수육이 정말 맛있어요","일품향","서울 종로구 종로 195 1층"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/003/zzmenuimg/j40330325_z.jpg","http://www.menupan.com/restaurant/restimg/003/zzmenuimg/j4033033_z.jpg","http://www.menupan.com/restaurant/restimg/003/zzmenuimg/j40330319_z.jpg","요불소아",5,15,"가족들과함께 오후정강남점을 갔는데 도심 복잡함속에서 분위기가 아늑한 곳에서 여유롭게 일본 가정식 백반 참 맛있게잘먹었네요","맛있는초밥집","경기 성남시 분당구 양현로310번길 25"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/009/zzmenuimg/j10423950_z.jpg","http://www.menupan.com/restaurant/restimg/009/zzmenuimg/j10423958_z.jpg","http://www.menupan.com/restaurant/restimg/009/zzmenuimg/j10423950_z.jpg","ja칼",2,4,"일식의/신선함과 식감이 좋아요~~","하루 여의도점","서울 영등포구 국제금융로2길 17 씨티프라자 3층"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/009/zzmenuimg/r10743914_z.jpg","http://www.menupan.com/restaurant/restimg/009/zzmenuimg/r10743949_z.jpg","http://www.menupan.com/restaurant/restimg/009/zzmenuimg/r1074397_z.jpg","참새",10,5,"외부를 바라보며 맛있는 스시를 즐길 수 있는 그곳! 룸이 많아서 조용하게 먹을 수 잇었어요! 소개팅 장소로도 좋았던~~","3MK"," 서울 강남구 강남대로106길 29 1층"));
        REVIEW_LIST.add(new Review("http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r10744342_z.jpg","http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r1074433_z.jpg","http://www.menupan.com/restaurant/restimg/003/zzmenuimg/r10744336_z.jpg","나그네라고나할까",11,2,"맛있고 새로운 서양의 음식이네요!!!","블루브릿지"," 서울 용산구 이태원로 208 3층"));
    }

}
