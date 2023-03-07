
fun main() {

    while (true) {
        print("Enter the code: ")
        val code: String = readLine().toString()

        println("Decoding: $code -> ${Decode(code, 1)}")
    }
}

fun Decode(code: String, factor: Int): String {
    var decodedStr: String = ""

    var i = 0
    while (i < code.length) {
        var char: Char = code[i]

        if (char.isLetter())
            decodedStr += char

        if (code[i].isDigit()) {
            var start = i + 1
            var end = FindEndIndex(code, start)

            decodedStr += Decode(code.substring(start, end + 1), char.digitToInt())
            i = end
        }
        i++
    }

    var result: String = ""
    var u: Int = 0
    while (u < factor) {
        result += decodedStr
        u++
    }

    return result
}

fun FindEndIndex(code: String, start: Int): Int {
    var skip: Int = 1
    var i: Int = start
    while (i < code.length) {
        val char: Char = code[i]

        if(char.isDigit())
            skip++
        else if(char == ']')
            skip--

        if(skip == 0)
            return i

        i++
    }
    return 0
}
