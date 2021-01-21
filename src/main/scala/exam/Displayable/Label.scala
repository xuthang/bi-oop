package exam.Displayable

import exam.FontUtils

class Label (val text:String, _x:Int, _y:Int, val fontSize:Int) extends Displayable {
  def x:Int = _x - width/2
  def y:Int = _y - height/2

  val sizes = FontUtils.stringDimension(text, fontSize)
  def width:Int = sizes._1
  def height:Int = sizes._2

  override def scale(num: Int): Displayable = new Label(text, x*num, y*num, fontSize*num)
}
