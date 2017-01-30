class Bag

trait AComponent { this: BComponent =>
  val a: A

  class A {
    def aFunc(i: Int): Int = {
      if (i == 0) {
        0
      } else {
        b.bFunc(i - 1) + 1
      }
    }
  }
}

trait BComponent { this: AComponent =>
  val b: B

  class B {
    def bFunc(i: Int): Int = {
      if (i == 0) {
        0
      } else {
        a.aFunc(i - 1) + 1
      }
    }
  }
}

object ComponentRegistry extends
  AComponent with
  BComponent {
    val a = new A
    val b = new B
  }


object Foo {
  def main() {
    println(ComponentRegistry.a.aFunc(5))
    println(ComponentRegistry.b.bFunc(5))
  }
}
