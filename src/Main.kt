import kotlin.reflect.KClass

/*
String
 - Kotlin 은 문자열을 배열 형태로 관리합니다.
 - 문자열의 글자를 0부터 시작하는 Index 번호로 관리할 수 있어 Java 보다 편리하게 사용할 수 있습니다.
 - 문자열은 불변형으로 호출만 가능합니다. 수정은 불가능 합니다.

String Method
 - subString() : 지정된 범위의 문자열을 반환합니다.
 - compareTo() : 문자열을 비교합니다.
                문자열이 같으면 0 을 반환합니다.
                다르다면 0 이외의 정수를 반환합니다.
                두 번째 값으로 true 를 입력하면 대소문자 구분을 무시하고 비교합니다.
 - split() : 문자열을 지정된 구분자를 이용해 잘라내어 출력합니다.

String Buffer
 - 문자열은 불변형입니다. + 연산자를 통해서 문자열을 합치면 문자열 객체는 계속 생성됩니다.
 - String Buffer 를 사용하면 관리하는 문자열을 직접 조작할 수 있습니다.
 - String 은 지속적인 문자열 연산을 수행하면 Memory 를 많이 사용하지만 원본이 유지됩니다.
 - String Buffer 는 Memory 를 절약할 수 있지만 원본을 유지할 수 없습니다.
 */
fun main() {
    val str1 = "안녕하세요."
    println("str1[0] : ${str1[0]}") // 결괏값 : 안

    // 값 호출 가능
    // index 마다 접근하여 값 변경 불가능
    // str1[0] = 'A'

    println("----- String Method - substring() -----")

    val str2 = str1.substring(1..3)
    val str21 = str1.substring(1, 3)
    val str22 = str1.substring(1)
    println("str2 : $str2")
    println("str21 : $str21")
    println("str22 : $str22")

    println("----- String Method - substring() -----")

    val str31 = "Hello World"
    val str3 = "Hello World"
    val str4 = "hello world"
    val str30 = "world hello"
    val array = arrayOf(str3, str4, str30)

    println("----- Test 1 -----")
    println(array[0])
    println("----- Test 1 -----")

    println(str3.compareTo(str4)) // => -32
    println(str3.compareTo(str4, true)) // => 0
    println(str3.compareTo(str4, false)) // => -32
    println(str3.contentEquals(str4)) // => : false

    println("----- Test 2 -----")

    println("기준 String : $str31")

    for (item in array) {

        var count = 1
        println("$count : $item")

        if (str31.compareTo(item) == 0) {
            println("동일")
        }
        if (str31.compareTo(item, true) == 0 && str31.compareTo(item) != 0) {
            println("동일, 대소문자 다름")
        }
        if (str31.compareTo(item) != 0 && str3.compareTo(item, true) != 0) {
            println("다름")
        }
        count++
    }

    println("----- Test 2 -----")


    val str5 = "ab cd ef gh"
    val r1 = str5.split(" ") // 문자열을 구분자 공백을 통해서 구분하여 배열 r1 에 초기화합니다. (r1 은 배열로 생성되었습니다.)
    println("r1 : $r1")

    println("----- Type Test -----")

    var test1:KClass<*> = r1::class
    var test2:Class<*> = r1::class.java
    println("r1 Kotlin Type : $test1")
    println("r1 Java Type : $test2")

    println("----- Type Test -----")

    println("----- String Buffer -----")

    val str6 = "abc"
    val str7 = str6 + "def"
    println("str6 : $str6")
    println("str7 : $str7")

    val buffer1 = StringBuffer()
    test1 = buffer1::class
    println("buffer1 Type : $test1") // => buffer1 Type : class java.lang.StringBuffer
    buffer1.append("abc")
    buffer1.append(100)
    buffer1.append(11.11)
    println("buffer1 : $buffer1")

    buffer1.insert(3, "테스트") // 세번째 index 에 "테스트" 문자열을 삽입합니다.
    println("buffer1 : $buffer1")

    buffer1.delete(3, 6) // 세번째 index 부터 여섯번째 index 의 바로 앞 까지 삭제합니다. (index 3~5 삭제)
    println("buffer1 : $buffer1")


}








