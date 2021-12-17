package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_qrcode2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panelselect2").vw.setHeight((int)((100d / 100 * height)));
views.get("panelselect2").vw.setWidth((int)((100d / 100 * width)));
views.get("panelselect2").vw.setTop((int)((0d / 100 * height)));
views.get("panelselect2").vw.setLeft((int)((0d / 100 * width)));
views.get("panelop2").vw.setWidth((int)((views.get("panelselect2").vw.getWidth())-(20d * scale)));
views.get("panelop2").vw.setHeight((int)((views.get("panelselect2").vw.getHeight())-(20d * scale)));
views.get("panelop2").vw.setLeft((int)((views.get("panelselect2").vw.getLeft())+(10d * scale)));
views.get("panelop2").vw.setTop((int)((views.get("panelselect2").vw.getTop())+(10d * scale)));
views.get("buttonconfig2").vw.setHeight((int)((40d * scale)));
views.get("buttonconfig2").vw.setWidth((int)((150d * scale)));
views.get("buttonconfig2").vw.setTop((int)((views.get("panelop2").vw.getTop() + views.get("panelop2").vw.getHeight())-(20d * scale) - (views.get("buttonconfig2").vw.getHeight())));
views.get("buttonconfig2").vw.setLeft((int)((views.get("panelop2").vw.getLeft())));
views.get("btscan2").vw.setLeft((int)((views.get("panelop2").vw.getLeft() + views.get("panelop2").vw.getWidth())-(170d * scale)));
views.get("btscan2").vw.setHeight((int)((50d * scale)));
views.get("btscan2").vw.setTop((int)((views.get("panelop2").vw.getTop())+(5d * scale)));
views.get("btscan2").vw.setWidth((int)((150d * scale)));
views.get("buttonvoltarop").vw.setLeft((int)((views.get("panelop2").vw.getLeft() + views.get("panelop2").vw.getWidth())-(170d * scale)));
views.get("buttonvoltarop").vw.setHeight((int)((50d * scale)));
views.get("buttonvoltarop").vw.setTop((int)((views.get("panelop2").vw.getTop() + views.get("panelop2").vw.getHeight())-(20d * scale) - (views.get("buttonvoltarop").vw.getHeight())));
views.get("buttonvoltarop").vw.setWidth((int)((150d * scale)));

}
}