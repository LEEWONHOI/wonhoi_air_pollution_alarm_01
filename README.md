# Air Pollution Alarm


## 💻 Use Stack 
<img alt="Android" src ="https://img.shields.io/badge/Android-3DDC84.svg?&style=for-the-badge&logo=Android&logoColor=white"/> <img alt="Android" src ="https://img.shields.io/badge/Kotlin-7F52FF.svg?&style=for-the-badge&logo=Kotlin&logoColor=white"/>

<br/>

## 📖 상세 내용

<div align="center">
  <img src="https://user-images.githubusercontent.com/78194843/169426321-1789dbcf-f4b8-42ee-a7de-7625c9d26216.png" width="35%" >
  
  <img src="https://user-images.githubusercontent.com/78194843/169426331-44a03d99-223f-4219-96d8-c141e8aec5e7.png" width="35%" >
</div>

<div align="center">
  <img src="https://user-images.githubusercontent.com/78194843/169426335-70646017-83d2-45ac-96fd-5e1dd09a658b.png" width="30%" >
  <img src="https://user-images.githubusercontent.com/78194843/169426336-4e9fd46f-4994-47b8-9978-4ea83faadff9.png" width="30%" >
  <img src="https://user-images.githubusercontent.com/78194843/169426337-256af82e-6c88-4918-bd67-fb2b0f656671.png" width="28.5%" >
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

