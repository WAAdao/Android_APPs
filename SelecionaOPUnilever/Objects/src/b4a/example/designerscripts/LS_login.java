package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_login{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panellg").vw.setWidth((int)((100d / 100 * width)));
views.get("panellg").vw.setHeight((int)((100d / 100 * height)));
views.get("panellg").vw.setLeft((int)((0d / 100 * width)));
views.get("panellg").vw.setTop((int)((0d / 100 * height)));
views.get("buttonvoltarlogin").vw.setHeight((int)((60d * scale)));
views.get("buttonvoltarlogin").vw.setWidth((int)((115d * scale)));
views.get("buttonvoltarlogin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(10d * scale)));
views.get("buttonvoltarlogin").vw.setTop((int)((views.get("panellg").vw.getTop())+(10d * scale)));
views.get("labelbacking1").vw.setLeft((int)((20d * scale)));
views.get("labelbacking1").vw.setTop((int)((22d / 100 * height)));
views.get("labelbacking1").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
views.get("labelbacking1").vw.setHeight((int)((13d / 100 * height)+(20d * scale)));
views.get("labelusuariologin").vw.setWidth((int)((150d * scale)));
views.get("labelusuariologin").vw.setHeight((int)((13d / 100 * height)));
views.get("labelusuariologin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(30d * scale)));
views.get("labelusuariologin").vw.setTop((int)((views.get("labelbacking1").vw.getTop())+(10d * scale)));
views.get("edittextusuariologin").vw.setHeight((int)((13d / 100 * height)));
views.get("edittextusuariologin").vw.setWidth((int)(((views.get("panellg").vw.getWidth())-((views.get("labelusuariologin").vw.getLeft() + views.get("labelusuariologin").vw.getWidth())+(20d * scale)))-(20d * scale)));
views.get("edittextusuariologin").vw.setLeft((int)((views.get("labelusuariologin").vw.getLeft() + views.get("labelusuariologin").vw.getWidth())+(10d * scale)));
views.get("edittextusuariologin").vw.setTop((int)((views.get("labelusuariologin").vw.getTop() + views.get("labelusuariologin").vw.getHeight()) - (views.get("edittextusuariologin").vw.getHeight())));
views.get("labelbacking2").vw.setLeft((int)((20d * scale)));
views.get("labelbacking2").vw.setTop((int)((views.get("labelbacking1").vw.getTop() + views.get("labelbacking1").vw.getHeight())+(10d * scale)));
views.get("labelbacking2").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
views.get("labelbacking2").vw.setHeight((int)((13d / 100 * height)+(20d * scale)));
views.get("labelsenhalogin").vw.setWidth((int)((150d * scale)));
views.get("labelsenhalogin").vw.setHeight((int)((13d / 100 * height)));
views.get("labelsenhalogin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(30d * scale)));
views.get("labelsenhalogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop())+(10d * scale)));
views.get("edittextsenhalogin").vw.setHeight((int)((13d / 100 * height)));
views.get("edittextsenhalogin").vw.setWidth((int)(((views.get("panellg").vw.getWidth())-((views.get("labelsenhalogin").vw.getLeft() + views.get("labelsenhalogin").vw.getWidth())+(20d * scale)))-(20d * scale)));
views.get("edittextsenhalogin").vw.setLeft((int)((views.get("labelsenhalogin").vw.getLeft() + views.get("labelsenhalogin").vw.getWidth())+(10d * scale)));
views.get("edittextsenhalogin").vw.setTop((int)((views.get("labelsenhalogin").vw.getTop() + views.get("labelsenhalogin").vw.getHeight()) - (views.get("edittextsenhalogin").vw.getHeight())));
views.get("buttonlogin").vw.setHeight((int)((60d * scale)));
views.get("buttonlogin").vw.setWidth((int)((130d * scale)));
views.get("buttonlogin").vw.setLeft((int)(((views.get("panellg").vw.getWidth())/2d)-(5d * scale) - (views.get("buttonlogin").vw.getWidth())));
views.get("buttonlogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));
views.get("buttonlimparlogin").vw.setHeight((int)((60d * scale)));
views.get("buttonlimparlogin").vw.setWidth((int)((130d * scale)));
views.get("buttonlimparlogin").vw.setLeft((int)(((views.get("panellg").vw.getWidth())/2d)+(5d * scale)));
views.get("buttonlimparlogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));
views.get("labelclocklogin").vw.setHeight((int)((13d / 100 * height)));
views.get("labelclocklogin").vw.setWidth((int)((260d * scale)));
views.get("labelclocklogin").vw.setLeft((int)((views.get("panellg").vw.getLeft() + views.get("panellg").vw.getWidth())-(1d / 100 * height) - (views.get("labelclocklogin").vw.getWidth())));
views.get("labelclocklogin").vw.setTop((int)((views.get("panellg").vw.getTop() + views.get("panellg").vw.getHeight())-(1d / 100 * height) - (views.get("labelclocklogin").vw.getHeight())));

}
}