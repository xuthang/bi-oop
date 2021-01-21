package exam.Displayable

class InputBox(_x:Int, _y:Int, _width:Int, _height:Int) extends Displayable {
  override def x:Int = _x
  override def y:Int = _y
  override def width:Int = _width
  override def height:Int = _height

  override def scale(num: Int): Displayable = new InputBox(x*num, y*num, width * num, height*num)
}
