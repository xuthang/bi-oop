package exam.Displayable

abstract class Displayable {
  def x:Int
  def y:Int
  def width:Int
  def height:Int

  def scale(num:Int) : Displayable
}
