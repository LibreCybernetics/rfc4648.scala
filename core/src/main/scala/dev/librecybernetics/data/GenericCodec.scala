package dev.librecybernetics.data

import java.nio.charset.{Charset, StandardCharsets}

private val defaultCharset = Charset.defaultCharset()

case class GenericCodec(
    alphabet: PFnBijection[Byte, Char],
    basePower: BasePower,
    padding: Char
):
  def encode(bytes: Array[Byte]): String =
    toBase(bytes, basePower)
      .flatMap(alphabet.apply(_))
      .mkString

  def encode(string: String, charset: Charset): String =
    encode(string.getBytes(charset))

  def encode(string: String): String =
    encode(string, defaultCharset)

  def decode(string: String): Array[Byte] =
    fromBase(
      string.takeWhile(_ != padding).flatMap(alphabet.reverse(_)).toArray,
      basePower
    )

  def decode(string: String, charset: Charset): String =
    String(decode(string), charset)

  def decodeUTF8(string: String): String =
    decode(string, StandardCharsets.UTF_8)
end GenericCodec

object GenericCodec:
  def apply(
      alphabet: PFnBijection[Byte, Char],
      basePower: BasePower
  ): GenericCodec = GenericCodec(alphabet, basePower, '=')
end GenericCodec
