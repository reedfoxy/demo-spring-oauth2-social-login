# demo-spring-oauth2-social-login

spring boot oauth2 client 를 활용한 소셜 로그인 구현

## 사용방법

${project PATH}/config/AppProperties.java

    public static final String FACEBOOK_CLIENT_ID = "페이스북 클라이언트 ID";
    public static final String FACEBOOK_CLIENT_SECRET = "페이스북 클라이언트 SECRET";

    public static final String GOOGLE_CLIENT_ID = "구 클라이언트 ID";
    public static final String GOOGLE_CLIENT_SECRET = "구글 클라이언트 SECRET";

    public static final String KAKAO_CLIENT_ID = "카카오 클라이언트 ID";
    public static final String KAKAO_CLIENT_SECRET = "카카오 클라이언트 SECRET";

해당 파일에 접근하여 자신의 환경에 맞게 클라이언트 아이디와 클라이언트 시크릿을 삽입한다.

클라이언트 아이디와 시크릿은 각 플랫폼 개발자 센터를 앱 등록을 통해 발급 받을 수 있다. 

그후 Build 한뒤 localhost:8080 으로 접속하면 된다.

그외에 따로 설정할 부분은 없다.