- 3장 정리 <br>
  문자열을 처리하기 위한 String, StringBuffer, StringBuilder 세 가지 클래스 중에서,<br>
  메모리를 가장 많이 차지하고 응답시간에 많은 영향을 주는 것은 String 클래스이다.<br>
  WAS나 시스템이 JDK5.0이상을 사용한다면 컴파일러에서 자동으로 String Builder로 변환하여 준다.<br>
  하지만 반복 루프를 사용해서 문자열을 더할 때는 객체를 계속 추가한다는 사실은 변함이 없다.<br>
  그러므로 String 클래스 대신 Thread-Safe를 고려하는 경우 StringBuffer를 아니면 String Builder를 사용하는 것을 권장한다.
