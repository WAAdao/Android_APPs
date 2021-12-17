package unileverSU.pesagem.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_login{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[login/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="PanelLg.Width = 100%x"[login/General script]
views.get("panellg").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="PanelLg.Height = 100%y"[login/General script]
views.get("panellg").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="PanelLg.Left = 0%x"[login/General script]
views.get("panellg").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="PanelLg.Top = 0%y"[login/General script]
views.get("panellg").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 7;BA.debugLine="ButtonVoltarLogin.Height = 60dip"[login/General script]
views.get("buttonvoltarlogin").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 8;BA.debugLine="ButtonVoltarLogin.Width = 115dip"[login/General script]
views.get("buttonvoltarlogin").vw.setWidth((int)((115d * scale)));
//BA.debugLineNum = 9;BA.debugLine="ButtonVoltarLogin.Left = PanelLg.Left + 10dip"[login/General script]
views.get("buttonvoltarlogin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(10d * scale)));
//BA.debugLineNum = 10;BA.debugLine="ButtonVoltarLogin.Top = PanelLg.Top + 10dip"[login/General script]
views.get("buttonvoltarlogin").vw.setTop((int)((views.get("panellg").vw.getTop())+(10d * scale)));
//BA.debugLineNum = 11;BA.debugLine="LabelBacking1.Left = 20dip"[login/General script]
views.get("labelbacking1").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 12;BA.debugLine="LabelBacking1.Top = 22%y"[login/General script]
views.get("labelbacking1").vw.setTop((int)((22d / 100 * height)));
//BA.debugLineNum = 13;BA.debugLine="LabelBacking1.Width = 100%x-40dip"[login/General script]
views.get("labelbacking1").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 14;BA.debugLine="LabelBacking1.Height = 13%y + 20dip"[login/General script]
views.get("labelbacking1").vw.setHeight((int)((13d / 100 * height)+(20d * scale)));
//BA.debugLineNum = 15;BA.debugLine="LabelUsuarioLogin.Width = 150dip"[login/General script]
views.get("labelusuariologin").vw.setWidth((int)((150d * scale)));
//BA.debugLineNum = 16;BA.debugLine="LabelUsuarioLogin.Height = 13%y"[login/General script]
views.get("labelusuariologin").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 17;BA.debugLine="LabelUsuarioLogin.Left =  PanelLg.Left + 30dip"[login/General script]
views.get("labelusuariologin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(30d * scale)));
//BA.debugLineNum = 18;BA.debugLine="LabelUsuarioLogin.Top = LabelBacking1.Top + 10dip"[login/General script]
views.get("labelusuariologin").vw.setTop((int)((views.get("labelbacking1").vw.getTop())+(10d * scale)));
//BA.debugLineNum = 19;BA.debugLine="EditTextUsuarioLogin.Height = 13%y"[login/General script]
views.get("edittextusuariologin").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="EditTextUsuarioLogin.Width = (PanelLg.Width - (LabelUsuarioLogin.Right +20dip)) - 20dip"[login/General script]
views.get("edittextusuariologin").vw.setWidth((int)(((views.get("panellg").vw.getWidth())-((views.get("labelusuariologin").vw.getLeft() + views.get("labelusuariologin").vw.getWidth())+(20d * scale)))-(20d * scale)));
//BA.debugLineNum = 21;BA.debugLine="EditTextUsuarioLogin.Left = LabelUsuarioLogin.Right + 10dip"[login/General script]
views.get("edittextusuariologin").vw.setLeft((int)((views.get("labelusuariologin").vw.getLeft() + views.get("labelusuariologin").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 22;BA.debugLine="EditTextUsuarioLogin.Bottom = LabelUsuarioLogin.Bottom"[login/General script]
views.get("edittextusuariologin").vw.setTop((int)((views.get("labelusuariologin").vw.getTop() + views.get("labelusuariologin").vw.getHeight()) - (views.get("edittextusuariologin").vw.getHeight())));
//BA.debugLineNum = 23;BA.debugLine="LabelBacking2.Left = 20dip"[login/General script]
views.get("labelbacking2").vw.setLeft((int)((20d * scale)));
//BA.debugLineNum = 24;BA.debugLine="LabelBacking2.Top = LabelBacking1.Bottom + 10dip"[login/General script]
views.get("labelbacking2").vw.setTop((int)((views.get("labelbacking1").vw.getTop() + views.get("labelbacking1").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 25;BA.debugLine="LabelBacking2.Width = 100%x-40dip"[login/General script]
views.get("labelbacking2").vw.setWidth((int)((100d / 100 * width)-(40d * scale)));
//BA.debugLineNum = 26;BA.debugLine="LabelBacking2.Height = 13%y + 20dip"[login/General script]
views.get("labelbacking2").vw.setHeight((int)((13d / 100 * height)+(20d * scale)));
//BA.debugLineNum = 27;BA.debugLine="LabelSenhaLogin.Width = 150dip"[login/General script]
views.get("labelsenhalogin").vw.setWidth((int)((150d * scale)));
//BA.debugLineNum = 28;BA.debugLine="LabelSenhaLogin.Height = 13%y"[login/General script]
views.get("labelsenhalogin").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 29;BA.debugLine="LabelSenhaLogin.Left =  PanelLg.Left + 30dip"[login/General script]
views.get("labelsenhalogin").vw.setLeft((int)((views.get("panellg").vw.getLeft())+(30d * scale)));
//BA.debugLineNum = 30;BA.debugLine="LabelSenhaLogin.Top = LabelBacking2.Top + 10dip"[login/General script]
views.get("labelsenhalogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop())+(10d * scale)));
//BA.debugLineNum = 31;BA.debugLine="EditTextSenhaLogin.Height = 13%y"[login/General script]
views.get("edittextsenhalogin").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 32;BA.debugLine="EditTextSenhaLogin.Width = (PanelLg.Width - (LabelSenhaLogin.Right +20dip)) - 20dip"[login/General script]
views.get("edittextsenhalogin").vw.setWidth((int)(((views.get("panellg").vw.getWidth())-((views.get("labelsenhalogin").vw.getLeft() + views.get("labelsenhalogin").vw.getWidth())+(20d * scale)))-(20d * scale)));
//BA.debugLineNum = 33;BA.debugLine="EditTextSenhaLogin.Left = LabelSenhaLogin.Right + 10dip"[login/General script]
views.get("edittextsenhalogin").vw.setLeft((int)((views.get("labelsenhalogin").vw.getLeft() + views.get("labelsenhalogin").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 34;BA.debugLine="EditTextSenhaLogin.Bottom = LabelSenhaLogin.Bottom"[login/General script]
views.get("edittextsenhalogin").vw.setTop((int)((views.get("labelsenhalogin").vw.getTop() + views.get("labelsenhalogin").vw.getHeight()) - (views.get("edittextsenhalogin").vw.getHeight())));
//BA.debugLineNum = 35;BA.debugLine="ButtonLogin.Height = 60dip"[login/General script]
views.get("buttonlogin").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 36;BA.debugLine="ButtonLogin.Width = 130dip"[login/General script]
views.get("buttonlogin").vw.setWidth((int)((130d * scale)));
//BA.debugLineNum = 37;BA.debugLine="ButtonLogin.Right = (PanelLg.Width /2) - 5dip"[login/General script]
views.get("buttonlogin").vw.setLeft((int)(((views.get("panellg").vw.getWidth())/2d)-(5d * scale) - (views.get("buttonlogin").vw.getWidth())));
//BA.debugLineNum = 38;BA.debugLine="ButtonLogin.Top = LabelBacking2.Bottom + 10dip"[login/General script]
views.get("buttonlogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 39;BA.debugLine="ButtonLimparLogin.Height = 60dip"[login/General script]
views.get("buttonlimparlogin").vw.setHeight((int)((60d * scale)));
//BA.debugLineNum = 40;BA.debugLine="ButtonLimparLogin.Width = 130dip"[login/General script]
views.get("buttonlimparlogin").vw.setWidth((int)((130d * scale)));
//BA.debugLineNum = 41;BA.debugLine="ButtonLimparLogin.Left = (PanelLg.Width /2) + 5dip"[login/General script]
views.get("buttonlimparlogin").vw.setLeft((int)(((views.get("panellg").vw.getWidth())/2d)+(5d * scale)));
//BA.debugLineNum = 42;BA.debugLine="ButtonLimparLogin.Top = LabelBacking2.Bottom + 10dip"[login/General script]
views.get("buttonlimparlogin").vw.setTop((int)((views.get("labelbacking2").vw.getTop() + views.get("labelbacking2").vw.getHeight())+(10d * scale)));
//BA.debugLineNum = 43;BA.debugLine="LabelClockLogin.Height = 13%y"[login/General script]
views.get("labelclocklogin").vw.setHeight((int)((13d / 100 * height)));
//BA.debugLineNum = 44;BA.debugLine="LabelClockLogin.Width = 260dip"[login/General script]
views.get("labelclocklogin").vw.setWidth((int)((260d * scale)));
//BA.debugLineNum = 45;BA.debugLine="LabelClockLogin.Right = PanelLg.Right-1%y"[login/General script]
views.get("labelclocklogin").vw.setLeft((int)((views.get("panellg").vw.getLeft() + views.get("panellg").vw.getWidth())-(1d / 100 * height) - (views.get("labelclocklogin").vw.getWidth())));
//BA.debugLineNum = 46;BA.debugLine="LabelClockLogin.Bottom = PanelLg.Bottom-1%y"[login/General script]
views.get("labelclocklogin").vw.setTop((int)((views.get("panellg").vw.getTop() + views.get("panellg").vw.getHeight())-(1d / 100 * height) - (views.get("labelclocklogin").vw.getHeight())));

}
}