package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_pesagem{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panelbarcode").vw.setWidth((int)((100d / 100 * width)-(20d * scale)));
views.get("panelbarcode").vw.setHeight((int)((100d / 100 * height)-(20d * scale)));
views.get("panelbarcode").vw.setLeft((int)((0d / 100 * width)+(10d * scale)));
views.get("panelbarcode").vw.setTop((int)((0d / 100 * height)+(10d * scale)));
views.get("labelbarcode").vw.setWidth((int)((80d * scale)));
views.get("labelbarcode").vw.setHeight((int)((45d * scale)));
views.get("labelbarcode").vw.setTop((int)((views.get("panelbarcode").vw.getTop())));
views.get("labelbarcode").vw.setLeft((int)((views.get("panelbarcode").vw.getLeft())));
views.get("edittextbarcode").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
views.get("edittextbarcode").vw.setWidth((int)(((68d / 100 * width)-(views.get("labelbarcode").vw.getWidth()))-(20d * scale)));
views.get("edittextbarcode").vw.setLeft((int)((views.get("labelbarcode").vw.getLeft() + views.get("labelbarcode").vw.getWidth())));
views.get("edittextbarcode").vw.setTop((int)((views.get("labelbarcode").vw.getTop())));
views.get("labelbarcode1").vw.setWidth((int)((90d * scale)));
views.get("labelbarcode1").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
views.get("labelbarcode1").vw.setTop((int)((views.get("labelbarcode").vw.getTop() + views.get("labelbarcode").vw.getHeight())+(5d * scale)));
views.get("labelbarcode1").vw.setLeft((int)((views.get("labelbarcode").vw.getLeft())));
views.get("edittextbarcode1").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
views.get("edittextbarcode1").vw.setWidth((int)(((68d / 100 * width)-(views.get("labelbarcode1").vw.getWidth()))-(20d * scale)));
views.get("edittextbarcode1").vw.setLeft((int)((views.get("labelbarcode1").vw.getLeft() + views.get("labelbarcode1").vw.getWidth())));
views.get("edittextbarcode1").vw.setTop((int)((views.get("labelbarcode1").vw.getTop() + views.get("labelbarcode1").vw.getHeight()) - (views.get("edittextbarcode1").vw.getHeight())));
views.get("labelbarcode2").vw.setWidth((int)((views.get("labelbarcode1").vw.getWidth())));
views.get("labelbarcode2").vw.setHeight((int)((views.get("labelbarcode1").vw.getHeight())));
views.get("labelbarcode2").vw.setTop((int)((views.get("labelbarcode1").vw.getTop() + views.get("labelbarcode1").vw.getHeight())+(5d * scale)));
views.get("labelbarcode2").vw.setLeft((int)((views.get("labelbarcode1").vw.getLeft())));
views.get("edittextbarcode2").vw.setWidth((int)((views.get("edittextbarcode1").vw.getWidth())));
views.get("edittextbarcode2").vw.setLeft((int)((views.get("edittextbarcode1").vw.getLeft())));
views.get("edittextbarcode2").vw.setTop((int)((views.get("labelbarcode2").vw.getTop() + views.get("labelbarcode2").vw.getHeight()) - (views.get("edittextbarcode2").vw.getHeight())));
views.get("labelbarcodesscc").vw.setHeight((int)((views.get("labelbarcode2").vw.getHeight())));
views.get("labelbarcodesscc").vw.setWidth((int)((60d * scale)));
views.get("labelbarcodesscc").vw.setLeft((int)((views.get("labelbarcode2").vw.getLeft())));
views.get("labelbarcodesscc").vw.setTop((int)((views.get("labelbarcode2").vw.getTop() + views.get("labelbarcode2").vw.getHeight())+(5d * scale)));
views.get("edittextbarcodesscc").vw.setWidth((int)(((68d / 100 * width)-(views.get("labelbarcodesscc").vw.getWidth()))-(20d * scale)));
views.get("edittextbarcodesscc").vw.setHeight((int)((views.get("labelbarcodesscc").vw.getHeight())));
views.get("edittextbarcodesscc").vw.setTop((int)((views.get("labelbarcodesscc").vw.getTop() + views.get("labelbarcodesscc").vw.getHeight()) - (views.get("edittextbarcodesscc").vw.getHeight())));
views.get("edittextbarcodesscc").vw.setLeft((int)((views.get("labelbarcodesscc").vw.getLeft() + views.get("labelbarcodesscc").vw.getWidth())));
views.get("labelproduto").vw.setWidth((int)((50d * scale)));
views.get("labelproduto").vw.setHeight((int)((35d * scale)));
views.get("labelproduto").vw.setLeft((int)((views.get("edittextbarcode").vw.getLeft() + views.get("edittextbarcode").vw.getWidth())+(5d * scale)));
views.get("labelproduto").vw.setTop((int)((20.5d / 100 * height)));
views.get("edittextproduto").vw.setWidth((int)((views.get("panelbarcode").vw.getWidth())-((views.get("edittextbarcode").vw.getWidth())+(views.get("labelbarcode").vw.getWidth())+(views.get("labelproduto").vw.getWidth())+(20d * scale))));
views.get("edittextproduto").vw.setHeight((int)((views.get("labelproduto").vw.getHeight())));
views.get("edittextproduto").vw.setLeft((int)((views.get("labelproduto").vw.getLeft() + views.get("labelproduto").vw.getWidth())));
views.get("edittextproduto").vw.setTop((int)((views.get("labelproduto").vw.getTop() + views.get("labelproduto").vw.getHeight()) - (views.get("edittextproduto").vw.getHeight())));
views.get("labelvalidade").vw.setWidth((int)((views.get("labelproduto").vw.getWidth())));
views.get("labelvalidade").vw.setHeight((int)((views.get("labelproduto").vw.getHeight())));
views.get("labelvalidade").vw.setLeft((int)((views.get("labelproduto").vw.getLeft())));
views.get("labelvalidade").vw.setTop((int)((views.get("labelproduto").vw.getTop() + views.get("labelproduto").vw.getHeight())));
views.get("edittextvalidade").vw.setHeight((int)((views.get("edittextproduto").vw.getHeight())));
views.get("edittextvalidade").vw.setWidth((int)((views.get("edittextproduto").vw.getWidth())));
views.get("edittextvalidade").vw.setLeft((int)((views.get("edittextproduto").vw.getLeft())));
views.get("edittextvalidade").vw.setTop((int)((views.get("labelvalidade").vw.getTop() + views.get("labelvalidade").vw.getHeight()) - (views.get("edittextvalidade").vw.getHeight())));
//BA.debugLineNum = 53;BA.debugLine="LabelLote.Width = 30dip"[pesagem/General script]
views.get("labellote").vw.setWidth((int)((30d * scale)));
//BA.debugLineNum = 54;BA.debugLine="LabelLote.Height = LabelProduto.Height"[pesagem/General script]
views.get("labellote").vw.setHeight((int)((views.get("labelproduto").vw.getHeight())));
//BA.debugLineNum = 55;BA.debugLine="LabelLote.Left = LabelProduto.Left"[pesagem/General script]
views.get("labellote").vw.setLeft((int)((views.get("labelproduto").vw.getLeft())));
//BA.debugLineNum = 56;BA.debugLine="LabelLote.Top = LabelValidade.Bottom"[pesagem/General script]
views.get("labellote").vw.setTop((int)((views.get("labelvalidade").vw.getTop() + views.get("labelvalidade").vw.getHeight())));
//BA.debugLineNum = 57;BA.debugLine="EditTextLote.Width = PanelBarcode.Width - (EditTextBarcode.Width + LabelBarcode.Width + LabelLote.Width +20dip)"[pesagem/General script]
views.get("edittextlote").vw.setWidth((int)((views.get("panelbarcode").vw.getWidth())-((views.get("edittextbarcode").vw.getWidth())+(views.get("labelbarcode").vw.getWidth())+(views.get("labellote").vw.getWidth())+(20d * scale))));
//BA.debugLineNum = 58;BA.debugLine="EditTextLote.Height = LabelLote.Height"[pesagem/General script]
views.get("edittextlote").vw.setHeight((int)((views.get("labellote").vw.getHeight())));
//BA.debugLineNum = 59;BA.debugLine="EditTextLote.Left = LabelLote.Right"[pesagem/General script]
views.get("edittextlote").vw.setLeft((int)((views.get("labellote").vw.getLeft() + views.get("labellote").vw.getWidth())));
//BA.debugLineNum = 60;BA.debugLine="EditTextLote.Bottom = LabelLote.Bottom"[pesagem/General script]
views.get("edittextlote").vw.setTop((int)((views.get("labellote").vw.getTop() + views.get("labellote").vw.getHeight()) - (views.get("edittextlote").vw.getHeight())));
//BA.debugLineNum = 61;BA.debugLine="LabelQuantidade.Height = LabelLote.Height"[pesagem/General script]
views.get("labelquantidade").vw.setHeight((int)((views.get("labellote").vw.getHeight())));
//BA.debugLineNum = 62;BA.debugLine="LabelQuantidade.Width = 70dip"[pesagem/General script]
views.get("labelquantidade").vw.setWidth((int)((70d * scale)));
//BA.debugLineNum = 63;BA.debugLine="LabelQuantidade.Left = LabelLote.Left"[pesagem/General script]
views.get("labelquantidade").vw.setLeft((int)((views.get("labellote").vw.getLeft())));
//BA.debugLineNum = 64;BA.debugLine="LabelQuantidade.Top = LabelLote.Bottom"[pesagem/General script]
views.get("labelquantidade").vw.setTop((int)((views.get("labellote").vw.getTop() + views.get("labellote").vw.getHeight())));
//BA.debugLineNum = 65;BA.debugLine="EditTextQuantidade.Height = LabelQuantidade.Height"[pesagem/General script]
views.get("edittextquantidade").vw.setHeight((int)((views.get("labelquantidade").vw.getHeight())));
//BA.debugLineNum = 66;BA.debugLine="EditTextQuantidade.Width = PanelBarcode.Width - (EditTextBarcode.Width + LabelBarcode.Width + LabelQuantidade.Width +20dip)"[pesagem/General script]
views.get("edittextquantidade").vw.setWidth((int)((views.get("panelbarcode").vw.getWidth())-((views.get("edittextbarcode").vw.getWidth())+(views.get("labelbarcode").vw.getWidth())+(views.get("labelquantidade").vw.getWidth())+(20d * scale))));
//BA.debugLineNum = 67;BA.debugLine="EditTextQuantidade.Left = LabelQuantidade.Right"[pesagem/General script]
views.get("edittextquantidade").vw.setLeft((int)((views.get("labelquantidade").vw.getLeft() + views.get("labelquantidade").vw.getWidth())));
//BA.debugLineNum = 68;BA.debugLine="EditTextQuantidade.Bottom = LabelQuantidade.Bottom"[pesagem/General script]
views.get("edittextquantidade").vw.setTop((int)((views.get("labelquantidade").vw.getTop() + views.get("labelquantidade").vw.getHeight()) - (views.get("edittextquantidade").vw.getHeight())));
//BA.debugLineNum = 69;BA.debugLine="LabelFabricacao.Height = LabelQuantidade.Height"[pesagem/General script]
views.get("labelfabricacao").vw.setHeight((int)((views.get("labelquantidade").vw.getHeight())));
//BA.debugLineNum = 70;BA.debugLine="LabelFabricacao.Width = 70dip"[pesagem/General script]
views.get("labelfabricacao").vw.setWidth((int)((70d * scale)));
//BA.debugLineNum = 71;BA.debugLine="LabelFabricacao.Left = LabelQuantidade.Left"[pesagem/General script]
views.get("labelfabricacao").vw.setLeft((int)((views.get("labelquantidade").vw.getLeft())));
//BA.debugLineNum = 72;BA.debugLine="LabelFabricacao.Top = LabelQuantidade.Bottom"[pesagem/General script]
views.get("labelfabricacao").vw.setTop((int)((views.get("labelquantidade").vw.getTop() + views.get("labelquantidade").vw.getHeight())));
//BA.debugLineNum = 73;BA.debugLine="EditTextFabricacao.Height = LabelFabricacao.Height"[pesagem/General script]
views.get("edittextfabricacao").vw.setHeight((int)((views.get("labelfabricacao").vw.getHeight())));
//BA.debugLineNum = 74;BA.debugLine="EditTextFabricacao.Width = PanelBarcode.Width - (EditTextBarcode.Width + LabelBarcode.Width + LabelFabricacao.Width +20dip)"[pesagem/General script]
views.get("edittextfabricacao").vw.setWidth((int)((views.get("panelbarcode").vw.getWidth())-((views.get("edittextbarcode").vw.getWidth())+(views.get("labelbarcode").vw.getWidth())+(views.get("labelfabricacao").vw.getWidth())+(20d * scale))));
//BA.debugLineNum = 75;BA.debugLine="EditTextFabricacao.Left = LabelFabricacao.Right"[pesagem/General script]
views.get("edittextfabricacao").vw.setLeft((int)((views.get("labelfabricacao").vw.getLeft() + views.get("labelfabricacao").vw.getWidth())));
//BA.debugLineNum = 76;BA.debugLine="EditTextFabricacao.Bottom = LabelFabricacao.Bottom"[pesagem/General script]
views.get("edittextfabricacao").vw.setTop((int)((views.get("labelfabricacao").vw.getTop() + views.get("labelfabricacao").vw.getHeight()) - (views.get("edittextfabricacao").vw.getHeight())));
//BA.debugLineNum = 77;BA.debugLine="PanelBackingDados.Width = LabelProduto.Width + EditTextProduto.Width + 6dip"[pesagem/General script]
views.get("panelbackingdados").vw.setWidth((int)((views.get("labelproduto").vw.getWidth())+(views.get("edittextproduto").vw.getWidth())+(6d * scale)));
//BA.debugLineNum = 78;BA.debugLine="PanelBackingDados.Height = LabelProduto.Height + LabelValidade.Height + LabelLote.Height + LabelQuantidade.Height + LabelFabricacao.Height +6dip"[pesagem/General script]
views.get("panelbackingdados").vw.setHeight((int)((views.get("labelproduto").vw.getHeight())+(views.get("labelvalidade").vw.getHeight())+(views.get("labellote").vw.getHeight())+(views.get("labelquantidade").vw.getHeight())+(views.get("labelfabricacao").vw.getHeight())+(6d * scale)));
//BA.debugLineNum = 79;BA.debugLine="PanelBackingDados.Top = LabelProduto.Top -3dip"[pesagem/General script]
views.get("panelbackingdados").vw.setTop((int)((views.get("labelproduto").vw.getTop())-(3d * scale)));
//BA.debugLineNum = 80;BA.debugLine="PanelBackingDados.Left = LabelProduto.Left - 3dip"[pesagem/General script]
views.get("panelbackingdados").vw.setLeft((int)((views.get("labelproduto").vw.getLeft())-(3d * scale)));
//BA.debugLineNum = 82;BA.debugLine="ButtonVoltarPesagem.Height = LabelBarcode.Height"[pesagem/General script]
views.get("buttonvoltarpesagem").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 83;BA.debugLine="ButtonVoltarPesagem.Width = LabelBarcode.Height"[pesagem/General script]
views.get("buttonvoltarpesagem").vw.setWidth((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 84;BA.debugLine="ButtonVoltarPesagem.Left = PanelBarcode.Left"[pesagem/General script]
views.get("buttonvoltarpesagem").vw.setLeft((int)((views.get("panelbarcode").vw.getLeft())));
//BA.debugLineNum = 85;BA.debugLine="ButtonVoltarPesagem.Bottom = PanelBarcode.Bottom -20dip"[pesagem/General script]
views.get("buttonvoltarpesagem").vw.setTop((int)((views.get("panelbarcode").vw.getTop() + views.get("panelbarcode").vw.getHeight())-(20d * scale) - (views.get("buttonvoltarpesagem").vw.getHeight())));
//BA.debugLineNum = 86;BA.debugLine="ButtonValidate.Right = 100%x + 20dip"[pesagem/General script]
views.get("buttonvalidate").vw.setLeft((int)((100d / 100 * width)+(20d * scale) - (views.get("buttonvalidate").vw.getWidth())));
//BA.debugLineNum = 87;BA.debugLine="ButtonValidate.Height = LabelBarcode.Height"[pesagem/General script]
views.get("buttonvalidate").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 88;BA.debugLine="ButtonValidate.Width = LabelBarcode.Height"[pesagem/General script]
views.get("buttonvalidate").vw.setWidth((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 89;BA.debugLine="ButtonValidate.Bottom = ButtonVoltarPesagem.Bottom"[pesagem/General script]
views.get("buttonvalidate").vw.setTop((int)((views.get("buttonvoltarpesagem").vw.getTop() + views.get("buttonvoltarpesagem").vw.getHeight()) - (views.get("buttonvalidate").vw.getHeight())));
//BA.debugLineNum = 90;BA.debugLine="ButtonLimparBarcode.Left = ButtonVoltarPesagem.Right + 10dip"[pesagem/General script]
views.get("buttonlimparbarcode").vw.setLeft((int)((views.get("buttonvoltarpesagem").vw.getLeft() + views.get("buttonvoltarpesagem").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 91;BA.debugLine="ButtonLimparBarcode.Height = LabelBarcode.Height"[pesagem/General script]
views.get("buttonlimparbarcode").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 92;BA.debugLine="ButtonLimparBarcode.Width = LabelBarcode.Height"[pesagem/General script]
views.get("buttonlimparbarcode").vw.setWidth((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 93;BA.debugLine="ButtonLimparBarcode.Bottom = ButtonValidate.Bottom"[pesagem/General script]
views.get("buttonlimparbarcode").vw.setTop((int)((views.get("buttonvalidate").vw.getTop() + views.get("buttonvalidate").vw.getHeight()) - (views.get("buttonlimparbarcode").vw.getHeight())));
//BA.debugLineNum = 94;BA.debugLine="ButtonScan.Right = PanelBarcode.Right + 20dip"[pesagem/General script]
views.get("buttonscan").vw.setLeft((int)((views.get("panelbarcode").vw.getLeft() + views.get("panelbarcode").vw.getWidth())+(20d * scale) - (views.get("buttonscan").vw.getWidth())));
//BA.debugLineNum = 95;BA.debugLine="ButtonScan.Height = LabelBarcode.Height"[pesagem/General script]
views.get("buttonscan").vw.setHeight((int)((views.get("labelbarcode").vw.getHeight())));
//BA.debugLineNum = 96;BA.debugLine="ButtonScan.Width = 60dip"[pesagem/General script]
views.get("buttonscan").vw.setWidth((int)((60d * scale)));
//BA.debugLineNum = 97;BA.debugLine="ButtonScan.Top = 0%y + 10dip"[pesagem/General script]
views.get("buttonscan").vw.setTop((int)((0d / 100 * height)+(10d * scale)));
//BA.debugLineNum = 98;BA.debugLine="ImageViewApliack.Height = ButtonVoltarPesagem.Height"[pesagem/General script]
views.get("imageviewapliack").vw.setHeight((int)((views.get("buttonvoltarpesagem").vw.getHeight())));
//BA.debugLineNum = 99;BA.debugLine="ImageViewApliack.Width = 190dip"[pesagem/General script]
views.get("imageviewapliack").vw.setWidth((int)((190d * scale)));
//BA.debugLineNum = 100;BA.debugLine="ImageViewUnilever.Height = ImageViewApliack.Height"[pesagem/General script]
views.get("imageviewunilever").vw.setHeight((int)((views.get("imageviewapliack").vw.getHeight())));
//BA.debugLineNum = 101;BA.debugLine="ImageViewUnilever.Width = ImageViewApliack.Height"[pesagem/General script]
views.get("imageviewunilever").vw.setWidth((int)((views.get("imageviewapliack").vw.getHeight())));
//BA.debugLineNum = 102;BA.debugLine="ImageViewUnilever.Left=  ButtonLimparBarcode.Right + 10dip"[pesagem/General script]
views.get("imageviewunilever").vw.setLeft((int)((views.get("buttonlimparbarcode").vw.getLeft() + views.get("buttonlimparbarcode").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 103;BA.debugLine="ImageViewUnilever.Bottom = ButtonLimparBarcode.Bottom"[pesagem/General script]
views.get("imageviewunilever").vw.setTop((int)((views.get("buttonlimparbarcode").vw.getTop() + views.get("buttonlimparbarcode").vw.getHeight()) - (views.get("imageviewunilever").vw.getHeight())));
//BA.debugLineNum = 104;BA.debugLine="ImageViewApliack.Left=  ImageViewUnilever.Right + 10dip"[pesagem/General script]
views.get("imageviewapliack").vw.setLeft((int)((views.get("imageviewunilever").vw.getLeft() + views.get("imageviewunilever").vw.getWidth())+(10d * scale)));
//BA.debugLineNum = 105;BA.debugLine="ImageViewApliack.Bottom = ButtonLimparBarcode.Bottom"[pesagem/General script]
views.get("imageviewapliack").vw.setTop((int)((views.get("buttonlimparbarcode").vw.getTop() + views.get("buttonlimparbarcode").vw.getHeight()) - (views.get("imageviewapliack").vw.getHeight())));

}
}