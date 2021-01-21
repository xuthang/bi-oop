package exam.Displayable

class Button (val label: String, _x:Int, _y:Int, _width:Int, _height:Int) extends Displayable
{
  override def x:Int = _x
  override def y:Int = _y
  override def width:Int = _width
  override def height:Int = _height

  def getLabel = new Label(label, _x + width/2, _y + height/2, 24)

  override def scale(num:Int) = ButtonFactory.get(label, x*num, y*num, width*num, height*num)
}

object ButtonFactory{
  def get(text: String, x:Int, y:Int, width:Int, height:Int):Button =
    new Button(text, x, y, width, height)
}