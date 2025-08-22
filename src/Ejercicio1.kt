fun decimalToBinary(n: Long): String {
    if (n == 0L) return "0"
    if (n < 0L) return "-" + decimalToBinary(-n)
    if (n < 2L) return n.toString()
    return decimalToBinary(n / 2) + (n % 2).toString()
}

fun binaryToDecimal(bin: String): Long {
    val s = bin.trim()
    require(Regex("^-?[01]+$").matches(s)) { "Invalid binary string: $bin" }
    if (s.startsWith("-")) return -binaryToDecimal(s.drop(1))
    if (s.length == 1) return (s[0] - '0').toLong()
    val lastBit = (s.last() - '0').toLong()
    return binaryToDecimal(s.dropLast(1)) * 2 + lastBit
}