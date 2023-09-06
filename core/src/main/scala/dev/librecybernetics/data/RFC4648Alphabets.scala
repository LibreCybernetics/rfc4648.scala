package dev.librecybernetics.data

object RFC4648Alphabets:
  // Base16

  val base16Lowercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 9   => (i + 48).toChar
        case i if 10 <= i && i <= 15 => (i + 87).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if '0' <= c && c <= '9' => (c - 48).toByte
        case c if 'a' <= c && c <= 'f' => (c - 87).toByte
      }: PartialFunction[Char, Byte]
    )

  val base16Uppercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 9   => (i + 48).toChar
        case i if 10 <= i && i <= 15 => (i + 55).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if '0' <= c && c <= '9' => (c - 48).toByte
        case c if 'A' <= c && c <= 'F' => (c - 55).toByte
      }: PartialFunction[Char, Byte]
    )

  // Base32

  val base32HexLowercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 10 <= i && i <= 31 => (i + 87).toChar
        case i if 0 <= i && i <= 9   => (i + 48).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if 'a' <= c && c <= 'v' => (c - 87).toByte
        case c if '0' <= c && c <= '9' => (c - 48).toByte
      }: PartialFunction[Char, Byte]
    )

  val base32HexUppercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 10 <= i && i <= 31 => (i + 55).toChar
        case i if 0 <= i && i <= 9   => (i + 48).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if 'A' <= c && c <= 'V' => (c - 55).toByte
        case c if '0' <= c && c <= '9' => (c - 48).toByte
      }: PartialFunction[Char, Byte]
    )

  val base32Lowercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 25  => (i + 97).toChar
        case i if 26 <= i && i <= 31 => (i + 24).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if 'a' <= c && c <= 'z' => (c - 97).toByte
        case c if '2' <= c && c <= '7' => (c - 24).toByte
      }: PartialFunction[Char, Byte]
    )

  val base32Uppercase: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 25  => (i + 65).toChar
        case i if 26 <= i && i <= 31 => (i + 24).toChar
      }: PartialFunction[Byte, Char],
      {
        case c if 'A' <= c && c <= 'Z' => (c - 65).toByte
        case c if '2' <= c && c <= '7' => (c - 24).toByte
      }: PartialFunction[Char, Byte]
    )

  // Base64

  val base64: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 25  => (i + 65).toChar
        case i if 26 <= i && i <= 51 => (i + 71).toChar
        case i if 52 <= i && i <= 61 => (i - 4).toChar
        case 62                      => '+'
        case 63                      => '/'
      },
      {
        case c if 'A' <= c && c <= 'Z' => (c - 65).toByte
        case c if 'a' <= c && c <= 'z' => (c - 71).toByte
        case c if '0' <= c && c <= '9' => (c + 4).toByte
        case '+'                       => 62
        case '/'                       => 63
      }
    )

  val base64URLSafe: PFnBijection[Byte, Char] =
    Bijection(
      {
        case i if 0 <= i && i <= 25  => (i + 65).toChar
        case i if 26 <= i && i <= 51 => (i + 71).toChar
        case i if 52 <= i && i <= 61 => (i - 4).toChar
        case 62                      => '-'
        case 63                      => '_'
      },
      {
        case c if 'A' <= c && c <= 'Z' => (c - 65).toByte
        case c if 'a' <= c && c <= 'z' => (c - 71).toByte
        case c if '0' <= c && c <= '9' => (c + 4).toByte
        case '-'                       => 62
        case '_'                       => 63
      }
    )
end RFC4648Alphabets
