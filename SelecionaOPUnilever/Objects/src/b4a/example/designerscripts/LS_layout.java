package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_layout{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="PanelSelect.Height = 100%y"[layout/General script]
views.get("panelselect").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 3;BA.debugLine="PanelSelect.Width = 100%x"[layout/General script]
views.get("panelselect").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="PanelSelect.Top = 0%y"[layout/General script]
views.get("panelselect").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="PanelSelect.Left = 0%x"[layout/General script]
views.get("panelselect").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="PanelOP.Width = PanelSelect.Width - 20dip"[layout/General script]
views.get("panelop").vw.setWidth((int)((views.get("panelselect").vw.getWidth())-(20d * scale)));
//BA.debugLineNum = 7;BA.debugLine="PanelOP.Height = PanelSelect.Height - 20dip"[layout/General script]
views.get("panelop").vw.setHeight((int)((views.get("panelselect").vw.getHeight())-(20d * scale)));
//BA.debugLineNum = 8;BA.debugLine="PanelOP.Left = PanelSelect.Left + 10dip"[layout/General script]
views.get("panelop").vw.setLeft((int)((views.get("panelselect").vw.getLeft())+(10d * scale)));
//BA.debugLineNum = 9;BA.debugLine="PanelOP.Top = PanelSelect.Top + 10dip"[layout/General script]
views.get("panelop").vw.setTop((int)((views.get("panelselect").vw.getTop())+(10d * scale)));
//BA.debugLineNum = 10;BA.debugLine="ListViewOP.Width = PanelOP.Width -0dip"[layout/General script]
views.get("listviewop").vw.setWidth((int)((views.get("panelop").vw.getWidth())-(0d * scale)));
//BA.debugLineNum = 11;BA.debugLine="ListViewOP.Height = PanelOP.Height - 123dip"[layout/General script]
views.get("listviewop").vw.setHeight((int)((views.get("panelop").vw.getHeight())-(123d * scale)));
//BA.debugLineNum = 12;BA.debugLine="ListViewOP.Top = PanelOP.Top + 53dip"[layout/General script]
views.get("listviewop").vw.setTop((int)((views.get("panelop").vw.getTop())+(53d * scale)));
//BA.debugLineNum = 13;BA.debugLine="ListViewOP.Left = PanelOP.Left"[layout/General script]
views.get("listviewop").vw.setLeft((int)((views.get("panelop").vw.getLeft())));
//BA.debugLineNum = 14;BA.debugLine="ButtonConfig.Height = 50dip"[layout/General script]
views.get("buttonconfig").vw.setHeight((int)((50d * scale)));
//BA.debugLineNum = 15;BA.debugLine="ButtonConfig.Width =  150dip"[layout/General script]
views.get("buttonconfig").vw.setWidth((int)((150d * scale)));
//BA.debugLineNum = 16;BA.debugLine="ButtonConfig.Bottom = PanelOP.Bottom - 20dip"[layout/General script]
views.get("buttonconfig").vw.setTop((int)((views.get("panelop").vw.getTop() + views.get("panelop").vw.getHeight())-(20d * scale) - (views.get("buttonconfig").vw.getHeight())));
//BA.debugLineNum = 17;BA.debugLine="ButtonConfig.Left = PanelOP.Left"[layout/General script]
views.get("buttonconfig").vw.setLeft((int)((views.get("panelop").vw.getLeft())));
//BA.debugLineNum = 18;BA.debugLine="LabelClockMain.Height = ButtonConfig.Height"[layout/General script]
views.get("labelclockmain").vw.setHeight((int)((views.get("buttonconfig").vw.getHeight())));
//BA.debugLineNum = 19;BA.debugLine="LabelClockMain.Width = 110dip"[layout/General script]
views.get("labelclockmain").vw.setWidth((int)((110d * scale)));
//BA.debugLineNum = 20;BA.debugLine="LabelClockMain.Bottom = ButtonConfig.Bottom + 10dip"[layout/General script]
views.get("labelclockmain").vw.setTop((int)((views.get("buttonconfig").vw.getTop() + views.get("buttonconfig").vw.getHeight())+(10d * scale) - (views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 21;BA.debugLine="LabelClockMain.Right = PanelOP.Right - 10dip"[layout/General script]
views.get("labelclockmain").vw.setLeft((int)((views.get("panelop").vw.getLeft() + views.get("panelop").vw.getWidth())-(10d * scale) - (views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 22;BA.debugLine="LabelScan.Height = LabelClockMain.Height"[layout/General script]
views.get("labelscan").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 23;BA.debugLine="LabelScan.Width = LabelClockMain.Width"[layout/General script]
views.get("labelscan").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 24;BA.debugLine="LabelScan.Bottom = LabelClockMain.Bottom"[layout/General script]
views.get("labelscan").vw.setTop((int)((views.get("labelclockmain").vw.getTop() + views.get("labelclockmain").vw.getHeight()) - (views.get("labelscan").vw.getHeight())));
//BA.debugLineNum = 25;BA.debugLine="LabelScan.Right = LabelClockMain.Left - 5dip"[layout/General script]
views.get("labelscan").vw.setLeft((int)((views.get("labelclockmain").vw.getLeft())-(5d * scale) - (views.get("labelscan").vw.getWidth())));
//BA.debugLineNum = 26;BA.debugLine="ButtonLoginOP2.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonloginop2").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 27;BA.debugLine="ButtonLoginOP2.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonloginop2").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 28;BA.debugLine="ButtonLoginOP2.Bottom = LabelClockMain.Bottom -10dip"[layout/General script]
views.get("buttonloginop2").vw.setTop((int)((views.get("labelclockmain").vw.getTop() + views.get("labelclockmain").vw.getHeight())-(10d * scale) - (views.get("buttonloginop2").vw.getHeight())));
//BA.debugLineNum = 29;BA.debugLine="ButtonLoginOP2.Left = PanelOP.Left"[layout/General script]
views.get("buttonloginop2").vw.setLeft((int)((views.get("panelop").vw.getLeft())));
//BA.debugLineNum = 30;BA.debugLine="ButtonOP1.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop1").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 31;BA.debugLine="ButtonOP1.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop1").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 32;BA.debugLine="ButtonOP1.Left = ListViewOP.Left"[layout/General script]
views.get("buttonop1").vw.setLeft((int)((views.get("listviewop").vw.getLeft())));
//BA.debugLineNum = 33;BA.debugLine="ButtonOP1.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop1").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop1").vw.getHeight())));
//BA.debugLineNum = 34;BA.debugLine="ButtonOP2.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop2").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 35;BA.debugLine="ButtonOP2.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop2").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 36;BA.debugLine="ButtonOP2.Left = ButtonOP1.Right + 10dip"[layout/General script]
views.get("buttonop2").vw.setLeft((int)((views.get("buttonop1").vw.getLeft() + views.get("buttonop1").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 37;BA.debugLine="ButtonOP2.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop2").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop2").vw.getHeight())));
//BA.debugLineNum = 38;BA.debugLine="ButtonOP3.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop3").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 39;BA.debugLine="ButtonOP3.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop3").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 40;BA.debugLine="ButtonOP3.Left = ButtonOP2.Right + 10dip"[layout/General script]
views.get("buttonop3").vw.setLeft((int)((views.get("buttonop2").vw.getLeft() + views.get("buttonop2").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 41;BA.debugLine="ButtonOP3.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop3").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop3").vw.getHeight())));
//BA.debugLineNum = 42;BA.debugLine="ButtonOP4.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop4").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 43;BA.debugLine="ButtonOP4.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop4").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 44;BA.debugLine="ButtonOP4.Left = ButtonOP3.Right + 10dip"[layout/General script]
views.get("buttonop4").vw.setLeft((int)((views.get("buttonop3").vw.getLeft() + views.get("buttonop3").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 45;BA.debugLine="ButtonOP4.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop4").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop4").vw.getHeight())));
//BA.debugLineNum = 46;BA.debugLine="ButtonOP5.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop5").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 47;BA.debugLine="ButtonOP5.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop5").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 48;BA.debugLine="ButtonOP5.Left = ButtonOP4.Right + 10dip"[layout/General script]
views.get("buttonop5").vw.setLeft((int)((views.get("buttonop4").vw.getLeft() + views.get("buttonop4").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 49;BA.debugLine="ButtonOP5.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop5").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop5").vw.getHeight())));
//BA.debugLineNum = 50;BA.debugLine="ButtonOP6.Width = LabelClockMain.Width"[layout/General script]
views.get("buttonop6").vw.setWidth((int)((views.get("labelclockmain").vw.getWidth())));
//BA.debugLineNum = 51;BA.debugLine="ButtonOP6.Height = LabelClockMain.Height"[layout/General script]
views.get("buttonop6").vw.setHeight((int)((views.get("labelclockmain").vw.getHeight())));
//BA.debugLineNum = 52;BA.debugLine="ButtonOP6.Left = ButtonOP5 .Right + 10dip"[layout/General script]
views.get("buttonop6").vw.setLeft((int)((views.get("buttonop5").vw.getLeft() + views.get("buttonop5").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 53;BA.debugLine="ButtonOP6.Bottom = ListViewOP.Top - 5dip"[layout/General script]
views.get("buttonop6").vw.setTop((int)((views.get("listviewop").vw.getTop())-(5d * scale) - (views.get("buttonop6").vw.getHeight())));

}
}