package exam.Displayable

class Button ( text: String, x:Int, y:Int, width:Int, height:Int) extends Displayable
{}

object ButtonFactory{
  def get(text: String, x:Int, y:Int, width:Int, height:Int):Button =
    new Button(text, x, y, width, height)
}