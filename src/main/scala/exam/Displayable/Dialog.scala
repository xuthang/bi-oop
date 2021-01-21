package exam.Displayable

class Dialog (val title:String, _width:Int, _height:Int, val components: List[Displayable]) extends Displayable {
  override def x:Int = 0
  override def y:Int = 0
  override def width:Int = _width
  override def height:Int = _height

  def getLabel = new Label(title, x, y, 24)

  override def scale(num: Int): Displayable = new Dialog(title, width*num, height * num, components.map((e) => e.scale(num)))
}

