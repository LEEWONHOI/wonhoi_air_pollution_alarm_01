# Air Pollution Alarm


## 💻 Use Stack 
<img alt="Android" src ="https://img.shields.io/badge/Android-3DDC84.svg?&style=for-the-badge&logo=Android&logoColor=white"/> <img alt="Android" src ="https://img.shields.io/badge/Kotlin-7F52FF.svg?&style=for-the-badge&logo=Kotlin&logoColor=white"/>

<br/>

## 📖 상세 내용

<div align="center">
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7a50a60e-24b8-4630-8d98-cb56455188e4/Screenshot_1624865498.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T020308Z&X-Amz-Expires=86400&X-Amz-Signature=e0e4f814202227c76f96ad42f0ee6ae19810d9225a874227fa52c33025801aec&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624865498.png%22&x-id=GetObject" width="35%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1ca3ce41-a7c9-4b0d-b525-96885381f58a/Screenshot_1624865806.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T020400Z&X-Amz-Expires=86400&X-Amz-Signature=50d534ef8bdffa666a62d6d752776310126174c1e4a7b462694aae190b6b50b8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624865806.png%22&x-id=GetObject" width="35%" >
</div>

<div align="center">
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/49c555f9-1ae5-4789-a334-05f88af4b94b/Screenshot_1624865697.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T020411Z&X-Amz-Expires=86400&X-Amz-Signature=c29a32098cb465cdc759ae01c48914e3a71ca5cfb465c457f170a98503aa405d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624865697.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/dbc6bbe8-cddc-4e74-9cce-ef4a62145c73/Screenshot_1624868544.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T020429Z&X-Amz-Expires=86400&X-Amz-Signature=242b8bc887d4630cbc112dec2d2711c42afe86f969b28678ba0b629ee4edae61&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624868544.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/42eb8be7-f9ea-4805-9341-dbf7cb064dde/Screenshot_1624869755.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T020449Z&X-Amz-Expires=86400&X-Amz-Signature=138168ad9e3af6dc0ad5e58a1f6cb8a11f4c176a4b17d9ff5c5237e8623f93c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624869755.png%22&x-id=GetObject" width="28.5%" >
</div>

<br/>

> 🍽️ 해당 프로젝트는 **Fastcampus 의  Android with Kotlin - Upper Intermediate (part 3) - Ch06 우리 동네 미세먼지 강의**를 보며 진행한 프로젝트입니다.

<br/>
<br/>


## 🛠️ 사용 라이브러리

- Retrofit2
- okhttp3
- Coroutines
- Swipe Refresh Layout
- Fused Location Provider Client

<br/>
<br/>


## 📱 구현한 기능

- 내 위치 정보 가져오기
- 오픈 API로 부터 한시간 단위로 미세먼지 정보를 가져오기
- 가져온 미세먼지 정보를 view 에 뿌려준다.
- 홈 스크린에 미세먼지 위젯을 추가하기

<br/>
<br/>


## 🙏 요청 API

- 한국환경공단_에어코리아_대기오염정보 [ [URL](https://data.go.kr/en/data/15073861/openapi.do) ]
- 한국환경공단_에어코리아_측정소정보 [ [URL](https://data.go.kr/en/data/15073877/openapi.do) ]
- 카카오톡 좌표계 변환 [ [URL](https://developers.kakao.com/docs/latest/en/local/dev-guide#trans-coord) ]

<br/>
<br/>


## 💡 참고한 문서

- foreground 에서 위치 정보 엑세스 권한 요청 방법   [ [URL](https://developer.android.com/training/location/permissions#foreground) ]
- foreground service 의 구현 방법과 필요조건 (Notification) [ [URL](https://developer.android.com/guide/components/foreground-services) ]
- Android 11 에서 Forgound 와 Background 를 동시에 요청할 수 없음 [ [URL](https://developer.android.com/about/versions/11/privacy/location) ]
- AppWidgetProvider 를 사용한 AppWidget 구현 방법  [ [URL](https://developer.android.com/guide/topics/appwidgets) ]
- Static BroadcastReceiver 를 등록하고 appwidget.provider 를 등록하기 [ [URL](https://codechacha.com/ko/android-broadcast-receiver/) ]
- 위젯의 업데이트 부분을 위해 서비스의 생명주기 오버라이딩 stopSelf() [ [URL](https://developer.android.com/guide/components/services#Lifecycle) ]
- LocationRequest을 사용하여 위치 업데이트를 위한 서비스 품질 요청 [ [URL](https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest) ]
- 코틀린 코루틴 - 기초 [ [URL](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4%EC%9D%98-%EA%B8%B0%EC%B4%88-cac60d4d621b) ]
- 코틀린 코루틴 - 제어 [ [URL](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EC%A0%9C%EC%96%B4-5132380dad7f#) ]
- 코틀린 코루틴 - 취소 [ [URL](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EC%9E%91%EC%97%85-%EC%B7%A8%EC%86%8C-7e51a393d2ea) ]
- lifecycleScope 을 이용하여 Lifecycle이 적용된 코루틴 구현하기 [ [URL](https://developer.android.com/topic/libraries/architecture/coroutines) ]

<br/>
<br/>

