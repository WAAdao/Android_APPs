package VinculaBomba.Unielver.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_config{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 1;BA.debugLine="PanelConfigTela.Width = 100%x - 20"[Config/General script]
views.get("panelconfigtela").vw.setWidth((int)((100d / 100 * width)-20d));
//BA.debugLineNum = 2;BA.debugLine="PanelConfigTela.Height = 100%y - 20"[Config/General script]
views.get("panelconfigtela").vw.setHeight((int)((100d / 100 * height)-20d));
//BA.debugLineNum = 3;BA.debugLine="PanelConfigTela.Left = 0%x + 10"[Config/General script]
views.get("panelconfigtela").vw.setLeft((int)((0d / 100 * width)+10d));
//BA.debugLineNum = 4;BA.debugLine="PanelConfigTela.Top = 0%y + 10"[Config/General script]
views.get("panelconfigtela").vw.setTop((int)((0d / 100 * height)+10d));
//BA.debugLineNum = 5;BA.debugLine="ButtonVoltarConfig.Width = 100"[Config/General script]
views.get("buttonvoltarconfig").vw.setWidth((int)(100d));
//BA.debugLineNum = 6;BA.debugLine="ButtonVoltarConfig.Height = 50"[Config/General script]
views.get("buttonvoltarconfig").vw.setHeight((int)(50d));
//BA.debugLineNum = 7;BA.debugLine="ButtonVoltarConfig.Left = PanelConfigTela.Left + 10"[Config/General script]
views.get("buttonvoltarconfig").vw.setLeft((int)((views.get("panelconfigtela").vw.getLeft())+10d));
//BA.debugLineNum = 8;BA.debugLine="ButtonVoltarConfig.Top = ButtonVoltarConfig.Top"[Config/General script]
views.get("buttonvoltarconfig").vw.setTop((int)((views.get("buttonvoltarconfig").vw.getTop())));
//BA.debugLineNum = 9;BA.debugLine="LabelNomeTerminal.Width = 140"[Config/General script]
views.get("labelnometerminal").vw.setWidth((int)(140d));
//BA.debugLineNum = 10;BA.debugLine="LabelNomeTerminal.Height = ButtonVoltarConfig.Height"[Config/General script]
views.get("labelnometerminal").vw.setHeight((int)((views.get("buttonvoltarconfig").vw.getHeight())));
//BA.debugLineNum = 11;BA.debugLine="LabelNomeTerminal.Left = PanelConfigTela.Left"[Config/General script]
views.get("labelnometerminal").vw.setLeft((int)((views.get("panelconfigtela").vw.getLeft())));
//BA.debugLineNum = 12;BA.debugLine="LabelNomeTerminal.Top = ButtonVoltarConfig.Bottom"[Config/General script]
views.get("labelnometerminal").vw.setTop((int)((views.get("buttonvoltarconfig").vw.getTop() + views.get("buttonvoltarconfig").vw.getHeight())));
//BA.debugLineNum = 13;BA.debugLine="EditTextNomeTerminal.Width = PanelConfigTela.Width - (LabelNomeTerminal.Width + 30)"[Config/General script]
views.get("edittextnometerminal").vw.setWidth((int)((views.get("panelconfigtela").vw.getWidth())-((views.get("labelnometerminal").vw.getWidth())+30d)));
//BA.debugLineNum = 14;BA.debugLine="EditTextNomeTerminal.Height = LabelNomeTerminal.Height"[Config/General script]
views.get("edittextnometerminal").vw.setHeight((int)((views.get("labelnometerminal").vw.getHeight())));
//BA.debugLineNum = 15;BA.debugLine="EditTextNomeTerminal.Left = LabelNomeTerminal.Right + 15"[Config/General script]
views.get("edittextnometerminal").vw.setLeft((int)((views.get("labelnometerminal").vw.getLeft() + views.get("labelnometerminal").vw.getWidth())+15d));
//BA.debugLineNum = 16;BA.debugLine="EditTextNomeTerminal.Top = LabelNomeTerminal.Top + 10"[Config/General script]
views.get("edittextnometerminal").vw.setTop((int)((views.get("labelnometerminal").vw.getTop())+10d));
//BA.debugLineNum = 17;BA.debugLine="LabelEnderecoWebservice.Width = LabelNomeTerminal.Width"[Config/General script]
views.get("labelenderecowebservice").vw.setWidth((int)((views.get("labelnometerminal").vw.getWidth())));
//BA.debugLineNum = 18;BA.debugLine="LabelEnderecoWebservice.Height = LabelNomeTerminal.Height"[Config/General script]
views.get("labelenderecowebservice").vw.setHeight((int)((views.get("labelnometerminal").vw.getHeight())));
//BA.debugLineNum = 19;BA.debugLine="LabelEnderecoWebservice.Left = LabelNomeTerminal.Left"[Config/General script]
views.get("labelenderecowebservice").vw.setLeft((int)((views.get("labelnometerminal").vw.getLeft())));
//BA.debugLineNum = 20;BA.debugLine="LabelEnderecoWebservice.Top = LabelNomeTerminal.Bottom + 10"[Config/General script]
views.get("labelenderecowebservice").vw.setTop((int)((views.get("labelnometerminal").vw.getTop() + views.get("labelnometerminal").vw.getHeight())+10d));
//BA.debugLineNum = 21;BA.debugLine="EditTextEnderecoWebservice.Width = EditTextNomeTerminal.Width"[Config/General script]
views.get("edittextenderecowebservice").vw.setWidth((int)((views.get("edittextnometerminal").vw.getWidth())));
//BA.debugLineNum = 22;BA.debugLine="EditTextEnderecoWebservice.Height = EditTextNomeTerminal.Height"[Config/General script]
views.get("edittextenderecowebservice").vw.setHeight((int)((views.get("edittextnometerminal").vw.getHeight())));
//BA.debugLineNum = 23;BA.debugLine="EditTextEnderecoWebservice.Left = EditTextNomeTerminal.Left"[Config/General script]
views.get("edittextenderecowebservice").vw.setLeft((int)((views.get("edittextnometerminal").vw.getLeft())));
//BA.debugLineNum = 24;BA.debugLine="EditTextEnderecoWebservice.Top = LabelEnderecoWebservice.Top + 10"[Config/General script]
views.get("edittextenderecowebservice").vw.setTop((int)((views.get("labelenderecowebservice").vw.getTop())+10d));
//BA.debugLineNum = 25;BA.debugLine="LabelNomeImpressora.Width = LabelNomeTerminal.Width"[Config/General script]
views.get("labelnomeimpressora").vw.setWidth((int)((views.get("labelnometerminal").vw.getWidth())));
//BA.debugLineNum = 26;BA.debugLine="LabelNomeImpressora.Height = LabelNomeTerminal.Height"[Config/General script]
views.get("labelnomeimpressora").vw.setHeight((int)((views.get("labelnometerminal").vw.getHeight())));
//BA.debugLineNum = 27;BA.debugLine="LabelNomeImpressora.Left = LabelNomeTerminal.Left"[Config/General script]
views.get("labelnomeimpressora").vw.setLeft((int)((views.get("labelnometerminal").vw.getLeft())));
//BA.debugLineNum = 28;BA.debugLine="LabelNomeImpressora.Top = LabelEnderecoWebservice.Bottom + 10"[Config/General script]
views.get("labelnomeimpressora").vw.setTop((int)((views.get("labelenderecowebservice").vw.getTop() + views.get("labelenderecowebservice").vw.getHeight())+10d));
//BA.debugLineNum = 29;BA.debugLine="EditTextNomeImpressora.Width = EditTextNomeTerminal.Width"[Config/General script]
views.get("edittextnomeimpressora").vw.setWidth((int)((views.get("edittextnometerminal").vw.getWidth())));
//BA.debugLineNum = 30;BA.debugLine="EditTextNomeImpressora.Height = EditTextNomeTerminal.Height"[Config/General script]
views.get("edittextnomeimpressora").vw.setHeight((int)((views.get("edittextnometerminal").vw.getHeight())));
//BA.debugLineNum = 31;BA.debugLine="EditTextNomeImpressora.Left = EditTextNomeTerminal.Left"[Config/General script]
views.get("edittextnomeimpressora").vw.setLeft((int)((views.get("edittextnometerminal").vw.getLeft())));
//BA.debugLineNum = 32;BA.debugLine="EditTextNomeImpressora.Top = LabelNomeImpressora.Top + 10"[Config/General script]
views.get("edittextnomeimpressora").vw.setTop((int)((views.get("labelnomeimpressora").vw.getTop())+10d));
//BA.debugLineNum = 33;BA.debugLine="ButtonUpdateDados.Width = ButtonVoltarConfig.Width"[Config/General script]
views.get("buttonupdatedados").vw.setWidth((int)((views.get("buttonvoltarconfig").vw.getWidth())));
//BA.debugLineNum = 34;BA.debugLine="ButtonUpdateDados.Height = ButtonVoltarConfig.Height"[Config/General script]
views.get("buttonupdatedados").vw.setHeight((int)((views.get("buttonvoltarconfig").vw.getHeight())));
//BA.debugLineNum = 35;BA.debugLine="ButtonUpdateDados.Left = (PanelConfigTela.Width / 2) - (ButtonUpdateDados.Width / 2)"[Config/General script]
views.get("buttonupdatedados").vw.setLeft((int)(((views.get("panelconfigtela").vw.getWidth())/2d)-((views.get("buttonupdatedados").vw.getWidth())/2d)));

}
}