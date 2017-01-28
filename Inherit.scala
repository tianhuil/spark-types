trait T {
  val str: String
  val int: Int
}

class C1 extends T {
  val str: String = "foo"
  val int: Int = 2
}

class C2 {
  val str: String = "foo"
  val int: Int = 2
}

object D {
  def foo[S <: T](s: S): String = {
    s.int.toString + s.str
  }

  def foo1(s: C1) = foo(s)

  //
  // def foo2(s: C2) = foo(s)
}

