package fp_red.red09.playground

import fp_red.red09.{Location, ParseError, Parsers}

object Playground2 {

  type Parser[+A] = String => Either[ParseError,A]

  trait Idea001 extends Parsers[Parser] {

    override implicit def string(s: String): Parser[String] =
    (input: String) =>
      if (input.startsWith(s)) Right(s)
      else Left(Location(input).toError("Expected: " + s))

  }

}
