package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_settings{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setTop((int)((0d / 100 * height)));
views.get("panel1").vw.setLeft((int)((0d / 100 * width)));
views.get("buttonvoltar").vw.setHeight((int)((9d / 100 * height)));
views.get("buttonvoltar").vw.setWidth((int)((120d * scale)));
views.get("buttonvoltar").vw.setTop((int)((views.get("panel1").vw.getTop())+(10d * scale)));
views.get("buttonvoltar").vw.setLeft((int)((views.get("panel1").vw.getLeft())+(10d * scale)));
views.get("labelbacking1").vw.setLeft((int)((20d * scale)));
views.get("labelbacking1").vw.setTop((int)((views.get("buttonvoltar").vw.getTop() + views.get("buttonvoltar").vw.getHeight())+(10d * scale)));
views.get("labelbacking1").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
views.get("labelbacking1").vw.setHeight((int)((13d / 100 * height)+(20d * scale)));
views.get("labellinha").vw.setWidth((int)((150d * scale)));
views.get("labellinha").vw.setHeight((int)((13d / 100 * height)));
views.get("labellinha").vw.setLeft((int)((views.get("panel1").vw.getLeft())+(30d * scale)));
views.get("labellinha").vw.setTop((int)((views.get("labelbacking1").vw.getTop())+(10d * scale)));
views.get("edittextlinha").vw.setHeight((int)((13d / 100 * height)));
views.get("edittextlinha").vw.setWidth((int)(((views.get("panel1").vw.getWidth())-((views.get("labellinha").vw.getLeft() + views.get("labellinha").vw.getWidth())+(20d * scale)))-(20d * scale)));
views.get("edittextlinha").vw.setLeft((int)((views.get("labellinha").vw.getLeft() + views.get("labellinha").vw.getWidth())+(10d * scale)));
views.get("edittextlinha").vw.setTop((int)((views.get("labellinha").vw.getTop() + views.get("labellinha").vw.getHeight()) - (views.get("edittextlinha").vw.getHeight())));
views.get("labelbacking2").vw.setLeft((int)((20d * scale)));
views.get("labelbacking2").vw.setTop((int)((views.get("labelbacking1").vw.getTop() + views.get("labelbacking1").vw.getHeight())+(10d * scale)));
views.get("labelbacking2").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
views.get("labelbacking2").vw.setHeight((int)((views.get("labellinha").vw.getHeight())+(20d * scale)));
views.get("labelwebservice").vw.setWidth((int)((200d * scale)));
views.get("labelwebservice").vw.setHeight((int)((13d / 100 * height)));
views.get("labelwebservice").vw.setLeft((int)((views.get("panel1").vw.getLeft())+(30d * scale)));
views.get("labelwebservice").vw.setTop((int)((views.get("labelbacking2").vw.getTop())+(10d * scale)));
views.get("edittextwebservice").vw.setHeight((int)((13d / 100 * height)));
views.get("edittextwebservice").vw.setWidth((int)(((views.get("panel1").vw.getWidth())-((views.get("labelwebservice").vw.getLeft() + views.get("labelwebservice").vw.getWidth())+(20d * scale)))-(20d * scale)));
views.get("edittextwebservice").vw.setLeft((int)((views.get("labelwebservice").vw.getLeft() + views.get("labelwebservice").vw.getWidth())+(10d * scale)));
views.get("edittextwebservice").vw.setTop((int)((views.get("labelwebservice").vw.getTop() + views.get("labelwebservice").vw.getHeight()) - (views.get("edittextwebservice").vw.getHeight())));
views.get("buttongravar").vw.setHeight((int)((60d * scale)));
views.get("buttongravar").vw.setWidth((int)((130d * scale)));
views.get("buttongravar").vw.setLeft((int)(((views.get("panel1").vw.getWidth())/2d)-(5d * scale) - (views.get("buttongravar").vw.getWidth())));
views.get("buttongravar").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));
views.get("buttonlimpar").vw.setHeight((int)((60d * scale)));
views.get("buttonlimpar").vw.setWidth((int)((130d * scale)));
views.get("buttonlimpar").vw.setLeft((int)(((views.get("panel1").vw.getWidth())/2d)+(5d * scale)));
views.get("buttonlimpar").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));

}
}